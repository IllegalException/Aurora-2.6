//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.module.modules.world;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;
import java.util.concurrent.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;
import net.minecraftforge.event.entity.living.*;
import net.minecraft.entity.*;
import me.memeszz.aurora.event.events.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import java.util.*;

public class AutoGG extends Module
{
    public static AutoGG INSTANCE;
    Setting.mode mode;
    static List<String> AutoGgMessages;
    private ConcurrentHashMap targetedPlayers;
    int index;
    
    public AutoGG() {
        super("AutoGG", Module.Category.WORLD, "Sends a message in chat when you kill someone");
        this.targetedPlayers = null;
        this.index = -1;
        AutoGG.INSTANCE = this;
    }
    
    public void setup() {
        final ArrayList<String> modes = new ArrayList<String>();
        modes.add("Get fuck by aurora");
        modes.add("Get fuck by nutgod");
        modes.add("GG, {name}");
        this.mode = this.registerMode("Mode", (List)modes, "GG, {name}");
    }
    
    @Listener
    public void send(final PacketEvent.Send event) {
        if (AutoGG.mc.player != null) {
            if (this.targetedPlayers == null) {
                this.targetedPlayers = new ConcurrentHashMap();
            }
            if (event.getPacket() instanceof CPacketUseEntity) {
                final CPacketUseEntity cPacketUseEntity = (CPacketUseEntity)event.getPacket();
                if (cPacketUseEntity.getAction().equals((Object)CPacketUseEntity.Action.ATTACK)) {
                    final Entity targetEntity = cPacketUseEntity.getEntityFromWorld((World)AutoGG.mc.world);
                    if (targetEntity instanceof EntityPlayer) {
                        this.addTargetedPlayer(targetEntity.getName());
                    }
                }
            }
        }
    }
    
    @Listener
    public void e(final LivingDeathEvent event) {
        if (AutoGG.mc.player != null) {
            if (this.targetedPlayers == null) {
                this.targetedPlayers = new ConcurrentHashMap();
            }
            final EntityLivingBase entity = event.getEntityLiving();
            if (entity != null && entity instanceof EntityPlayer) {
                final EntityPlayer player = (EntityPlayer)entity;
                if (player.getHealth() <= 0.0f) {
                    final String name = player.getName();
                    if (this.shouldAnnounce(name)) {
                        this.doAnnounce(name);
                    }
                }
            }
        }
    }
    
    public void onEnable() {
        this.targetedPlayers = new ConcurrentHashMap();
    }
    
    public void onDisable() {
        this.targetedPlayers = null;
    }
    
    @Listener
    public void onUpdate(final UpdateEvent event) {
        if (this.targetedPlayers == null) {
            this.targetedPlayers = new ConcurrentHashMap();
        }
        for (final Entity entity : AutoGG.mc.world.getLoadedEntityList()) {
            if (entity instanceof EntityPlayer) {
                final EntityPlayer player = (EntityPlayer)entity;
                if (player.getHealth() > 0.0f) {
                    continue;
                }
                final String name = player.getName();
                if (this.shouldAnnounce(name)) {
                    this.doAnnounce(name);
                    break;
                }
                continue;
            }
        }
        this.targetedPlayers.forEach((namex, timeout) -> {
            if (timeout <= 0) {
                this.targetedPlayers.remove(namex);
            }
            else {
                this.targetedPlayers.put(namex, timeout - 1);
            }
        });
    }
    
    private boolean shouldAnnounce(final String name) {
        return this.targetedPlayers.containsKey(name);
    }
    
    private void doAnnounce(final String name) {
        this.targetedPlayers.remove(name);
        if (this.index >= AutoGG.AutoGgMessages.size() - 1) {
            this.index = -1;
        }
        ++this.index;
        if (AutoGG.AutoGgMessages.size() > 0) {
            final String s = AutoGG.AutoGgMessages.get(this.index);
        }
        if (this.mode.getValue().equals("Get fuck by aurora")) {}
        String message;
        if (this.mode.getValue().equals("Get fuck by nutgod")) {
            message = "GET FUCK BY NUTGOD PUSSY!!!";
        }
        else {
            message = "GG, " + name + " :^)";
        }
        String messageSanitized = message.replaceAll("\u00e0��\u00e0�\u2021", "").replace("{name}", name);
        if (messageSanitized.length() > 255) {
            messageSanitized = messageSanitized.substring(0, 255);
        }
        AutoGG.mc.player.connection.sendPacket((Packet)new CPacketChatMessage(messageSanitized));
    }
    
    public void addTargetedPlayer(final String name) {
        if (!Objects.equals(name, AutoGG.mc.player.getName())) {
            if (this.targetedPlayers == null) {
                this.targetedPlayers = new ConcurrentHashMap();
            }
            this.targetedPlayers.put(name, 20);
        }
    }
    
    public static void addAutoGgMessage(final String s) {
        AutoGG.AutoGgMessages.add(s);
    }
    
    public static List<String> getAutoGgMessages() {
        return AutoGG.AutoGgMessages;
    }
    
    static {
        AutoGG.AutoGgMessages = new ArrayList<String>();
    }
}
