//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.module.modules.player;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;
import java.util.*;
import me.memeszz.aurora.mixin.accessor.*;
import net.minecraft.client.*;
import net.minecraft.item.*;
import net.minecraft.client.entity.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;
import me.memeszz.aurora.event.events.*;
import net.minecraft.util.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;

public class SpeedMine extends Module
{
    Setting.mode mode;
    Setting.b reset;
    Setting.b FastFall;
    Setting.b doubleBreak;
    
    public SpeedMine() {
        super("SpeedMine", Module.Category.PLAYER, "Mine blocks faster");
    }
    
    public String getHudInfo() {
        return "§7[§f" + this.mode.getValue() + "§7]";
    }
    
    public void setup() {
        this.reset = this.registerB("Reset", false);
        this.FastFall = this.registerB("FastFall", false);
        this.doubleBreak = this.registerB("DoubleBreak", false);
        final ArrayList<String> modes = new ArrayList<String>();
        modes.add("Packet");
        modes.add("Damage");
        modes.add("Instant");
        this.mode = this.registerMode("Mode", (List)modes, "Packet");
    }
    
    @Listener
    public void onUpdate(final UpdateEvent event) {
        ((IPlayerControllerMP)SpeedMine.mc.playerController).setBlockHitDelay(0);
        if (this.reset.getValue() && Minecraft.getMinecraft().gameSettings.keyBindUseItem.isKeyDown()) {
            ((IPlayerControllerMP)SpeedMine.mc.playerController).setIsHittingBlock(false);
        }
        if (SpeedMine.mc.player.getHeldItemMainhand().getItem() instanceof ItemPickaxe && this.FastFall.getValue() && SpeedMine.mc.player.onGround) {
            final EntityPlayerSP player = SpeedMine.mc.player;
            --player.motionY;
        }
    }
    
    @Listener
    public void setReset(final EventPlayerResetBlockRemoving event) {
        if (SpeedMine.mc.player.getHeldItemMainhand().getItem() instanceof ItemPickaxe && this.reset.getValue()) {
            event.setCanceled(true);
        }
    }
    
    @Listener
    public void clickBlock(final EventPlayerClickBlock event) {
        if (SpeedMine.mc.player.getHeldItemMainhand().getItem() instanceof ItemPickaxe && this.reset.getValue() && ((IPlayerControllerMP)SpeedMine.mc.playerController).getCurBlockDamageMP() > 0.1f) {
            ((IPlayerControllerMP)SpeedMine.mc.playerController).setIsHittingBlock(true);
        }
    }
    
    @Listener
    public void damageBlock(final EventPlayerDamageBlock event) {
        if (this.canBreak(event.getPos())) {
            if (this.reset.getValue()) {
                ((IPlayerControllerMP)SpeedMine.mc.playerController).setIsHittingBlock(false);
            }
            if (this.mode.getValue().equalsIgnoreCase("Instant")) {
                SpeedMine.mc.player.swingArm(EnumHand.MAIN_HAND);
                SpeedMine.mc.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, event.getPos(), event.getDirection()));
                SpeedMine.mc.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, event.getPos(), event.getDirection()));
                SpeedMine.mc.playerController.onPlayerDestroyBlock(event.getPos());
                SpeedMine.mc.world.setBlockToAir(event.getPos());
            }
            if (SpeedMine.mc.player.getHeldItemMainhand().getItem() instanceof ItemPickaxe) {
                if (this.mode.getValue().equalsIgnoreCase("Packet")) {
                    SpeedMine.mc.player.swingArm(EnumHand.MAIN_HAND);
                    SpeedMine.mc.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, event.getPos(), event.getDirection()));
                    SpeedMine.mc.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, event.getPos(), event.getDirection()));
                    event.setCanceled(true);
                }
                if (this.mode.getValue().equalsIgnoreCase("Damage") && ((IPlayerControllerMP)SpeedMine.mc.playerController).getCurBlockDamageMP() >= 0.7f) {
                    ((IPlayerControllerMP)SpeedMine.mc.playerController).setCurBlockDamageMP(1.0f);
                }
            }
            if (this.doubleBreak.getValue()) {
                final BlockPos above = event.getPos().add(0, 1, 0);
                if (this.canBreak(above) && SpeedMine.mc.player.getDistance((double)above.getX(), (double)above.getY(), (double)above.getZ()) <= 5.0) {
                    SpeedMine.mc.player.swingArm(EnumHand.MAIN_HAND);
                    SpeedMine.mc.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, above, event.getDirection()));
                    SpeedMine.mc.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, above, event.getDirection()));
                    SpeedMine.mc.playerController.onPlayerDestroyBlock(above);
                    SpeedMine.mc.world.setBlockToAir(above);
                }
            }
        }
    }
    
    private boolean canBreak(final BlockPos pos) {
        final IBlockState blockState = SpeedMine.mc.world.getBlockState(pos);
        final Block block = blockState.getBlock();
        return block.getBlockHardness(blockState, (World)Minecraft.getMinecraft().world, pos) != -1.0f;
    }
}
