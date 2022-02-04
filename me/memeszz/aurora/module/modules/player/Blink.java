//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.module.modules.player;

import me.memeszz.aurora.module.*;
import net.minecraft.client.entity.*;
import net.minecraft.network.*;
import java.util.concurrent.*;
import me.memeszz.aurora.event.events.*;
import net.minecraft.network.play.client.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import java.util.*;

public class Blink extends Module
{
    EntityOtherPlayerMP entity;
    private final Queue<Packet> packets;
    
    public Blink() {
        super("Blink", Module.Category.PLAYER, "Cancels most packets");
        this.packets = new ConcurrentLinkedQueue<Packet>();
    }
    
    @Listener
    public void onUpdate(final PacketEvent.Send event) {
        final Packet packet = event.getPacket();
        if (packet instanceof CPacketChatMessage || packet instanceof CPacketConfirmTeleport || packet instanceof CPacketKeepAlive || packet instanceof CPacketTabComplete || packet instanceof CPacketClientStatus) {
            return;
        }
        this.packets.add(packet);
        event.setCanceled(true);
    }
    
    public void onEnable() {
        (this.entity = new EntityOtherPlayerMP((World)Blink.mc.world, Blink.mc.getSession().getProfile())).copyLocationAndAnglesFrom((Entity)Blink.mc.player);
        this.entity.rotationYaw = Blink.mc.player.rotationYaw;
        this.entity.rotationYawHead = Blink.mc.player.rotationYawHead;
        Blink.mc.world.addEntityToWorld(666, (Entity)this.entity);
    }
    
    public void onDisable() {
        if (this.entity != null) {
            Blink.mc.world.removeEntity((Entity)this.entity);
        }
        if (this.packets.size() > 0) {
            for (final Packet packet : this.packets) {
                Blink.mc.player.connection.sendPacket(packet);
            }
            this.packets.clear();
        }
    }
    
    public String getHudInfo() {
        return "§7[§f" + this.packets.size() + "§7]";
    }
}
