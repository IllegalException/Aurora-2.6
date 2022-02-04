//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.module.modules.combat;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;
import me.memeszz.aurora.util.friends.*;
import com.mojang.realmsclient.gui.*;
import me.memeszz.aurora.command.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;
import net.minecraft.entity.player.*;
import java.util.*;
import me.memeszz.aurora.event.events.*;
import net.minecraft.network.play.server.*;
import net.minecraft.world.*;
import me.memeszz.aurora.*;
import net.minecraft.entity.*;

public class TotemPopCounter extends Module
{
    private final Setting.b friend;
    private HashMap<String, Integer> popList;
    
    public TotemPopCounter() {
        super("PopCounter", Module.Category.COMBAT, "Alerts When A Player Pops A Totem");
        this.popList = new HashMap<String, Integer>();
        this.friend = this.registerB("AlertFriends", true);
    }
    
    @Listener
    public void onUpdate(final TotemPopEvent event) {
        if (TotemPopCounter.mc.player == null || TotemPopCounter.mc.world == null) {
            return;
        }
        if (this.popList == null) {
            this.popList = new HashMap<String, Integer>();
        }
        if (!this.friend.getValue()) {
            if (!Friends.isFriend(event.getEntity().getName())) {
                if (this.popList.get(event.getEntity().getName()) == null) {
                    this.popList.put(event.getEntity().getName(), 1);
                    Command.sendClientMessage(ChatFormatting.RED + event.getEntity().getName() + " popped " + ChatFormatting.YELLOW + 1 + ChatFormatting.RED + " totem!");
                }
            }
            else if (this.popList.get(event.getEntity().getName()) != null) {
                int popCounter = this.popList.get(event.getEntity().getName());
                final int newPopCounter = ++popCounter;
                this.popList.put(event.getEntity().getName(), newPopCounter);
                Command.sendClientMessage(ChatFormatting.RED + event.getEntity().getName() + ChatFormatting.RED + " popped " + ChatFormatting.YELLOW + newPopCounter + ChatFormatting.RED + " totems!");
            }
        }
        if (this.friend.getValue()) {
            if (this.popList.get(event.getEntity().getName()) == null) {
                this.popList.put(event.getEntity().getName(), 1);
                Command.sendClientMessage(ChatFormatting.RED + event.getEntity().getName() + ChatFormatting.RED + " popped " + ChatFormatting.YELLOW + 1 + ChatFormatting.RED + " totem!");
            }
            else if (this.popList.get(event.getEntity().getName()) != null) {
                int popCounter = this.popList.get(event.getEntity().getName());
                final int newPopCounter = ++popCounter;
                this.popList.put(event.getEntity().getName(), newPopCounter);
                Command.sendClientMessage(ChatFormatting.RED + event.getEntity().getName() + ChatFormatting.RED + " popped " + ChatFormatting.YELLOW + newPopCounter + ChatFormatting.RED + " totems!");
            }
        }
    }
    
    @Listener
    public void onUpdate() {
        for (final EntityPlayer player : TotemPopCounter.mc.world.playerEntities) {
            if (player.getHealth() <= 0.0f && this.popList.containsKey(player.getName())) {
                Command.sendClientMessage(ChatFormatting.RED + player.getName() + " died after popping " + ChatFormatting.GREEN + this.popList.get(player.getName()) + ChatFormatting.RED + " totems!");
                this.popList.remove(player.getName(), this.popList.get(player.getName()));
            }
        }
    }
    
    @Listener
    public void onUpdate(final PacketEvent.Receive event) {
        if (TotemPopCounter.mc.world == null || TotemPopCounter.mc.player == null) {
            return;
        }
        if (event.getPacket() instanceof SPacketEntityStatus) {
            final SPacketEntityStatus packet = (SPacketEntityStatus)event.getPacket();
            if (packet.getOpCode() == 35) {
                final Entity entity = packet.getEntity((World)TotemPopCounter.mc.world);
                Aurora.getInstance().getEventManager().dispatchEvent((Object)new TotemPopEvent(entity));
            }
        }
    }
}
