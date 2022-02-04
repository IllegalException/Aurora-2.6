//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.module.modules.world;

import me.memeszz.aurora.module.*;
import net.minecraft.entity.*;
import me.memeszz.aurora.event.events.*;
import net.minecraft.entity.player.*;
import java.util.stream.*;
import com.mojang.realmsclient.gui.*;
import me.memeszz.aurora.command.*;
import java.util.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;

public class VisualRange extends Module
{
    List<Entity> knownPlayers;
    List<Entity> players;
    
    public VisualRange() {
        super("VisualRange", Module.Category.WORLD, "Sends a client side message when someone enters your render distance");
        this.knownPlayers = new ArrayList<Entity>();
    }
    
    @Listener
    public void onUpdate(final UpdateEvent event) {
        if (VisualRange.mc.player == null) {
            return;
        }
        this.players = (List<Entity>)VisualRange.mc.world.loadedEntityList.stream().filter(e -> e instanceof EntityPlayer).collect(Collectors.toList());
        try {
            for (final Entity e2 : this.players) {
                if (e2 instanceof EntityPlayer && !e2.getName().equalsIgnoreCase(VisualRange.mc.player.getName()) && !this.knownPlayers.contains(e2)) {
                    this.knownPlayers.add(e2);
                    Command.sendClientMessage(ChatFormatting.GREEN + e2.getName() + ChatFormatting.RED + " entered visual range.");
                }
            }
        }
        catch (Exception ex) {}
        try {
            for (final Entity e2 : this.knownPlayers) {
                if (e2 instanceof EntityPlayer && !e2.getName().equalsIgnoreCase(VisualRange.mc.player.getName()) && !this.players.contains(e2)) {
                    this.knownPlayers.remove(e2);
                }
            }
        }
        catch (Exception ex2) {}
    }
    
    public void onDisable() {
        this.knownPlayers.clear();
    }
}
