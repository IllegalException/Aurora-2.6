//Decomped By XeonLyfe
package me.memeszz.aurora.module.modules.player;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;
import me.memeszz.aurora.event.events.*;
import net.minecraft.init.*;
import me.memeszz.aurora.mixin.accessor.*;
import net.minecraft.item.*;
import net.minecraft.util.math.*;
import net.minecraft.network.*;
import net.minecraft.network.play.client.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;

public class FastUse extends Module
{
    Setting.b xp;
    Setting.b crystals;
    Setting.b all;
    Setting.b breakS;
    Setting.b fastBow;
    
    public FastUse() {
        super("FastUse", Module.Category.PLAYER, "Sets right click / block break delay to 0");
    }
    
    public void setup() {
        this.xp = this.registerB("EXP", true);
        this.crystals = this.registerB("Crystals", false);
        this.all = this.registerB("Everything", false);
        this.breakS = this.registerB("FastBreak", true);
        this.fastBow = this.registerB("FastBow", false);
    }
    
    @Listener
    public void onUpdate(final UpdateEvent event) {
        if (this.xp.getValue() && FastUse.mc.player != null && (FastUse.mc.player.getHeldItemMainhand().getItem() == Items.EXPERIENCE_BOTTLE || FastUse.mc.player.getHeldItemOffhand().getItem() == Items.EXPERIENCE_BOTTLE)) {
            ((IMinecraft)FastUse.mc).setRightClickDelayTimer(0);
        }
        if (this.crystals.getValue() && FastUse.mc.player != null && (FastUse.mc.player.getHeldItemMainhand().getItem() == Items.END_CRYSTAL || FastUse.mc.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL)) {
            ((IMinecraft)FastUse.mc).setRightClickDelayTimer(0);
        }
        if (this.all.getValue()) {
            ((IMinecraft)FastUse.mc).setRightClickDelayTimer(0);
        }
        if (this.breakS.getValue()) {
            ((IPlayerControllerMP)FastUse.mc.playerController).setBlockHitDelay(0);
        }
        if (this.fastBow.getValue() && FastUse.mc.player.inventory.getCurrentItem().getItem() instanceof ItemBow && FastUse.mc.player.isHandActive() && FastUse.mc.player.getItemInUseMaxCount() >= 3) {
            FastUse.mc.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, FastUse.mc.player.getHorizontalFacing()));
            FastUse.mc.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItem(FastUse.mc.player.getActiveHand()));
            FastUse.mc.player.stopActiveHand();
        }
    }
}
