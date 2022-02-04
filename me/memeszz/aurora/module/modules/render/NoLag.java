//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.module.modules.render;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.event.events.*;
import me.memeszz.aurora.event.*;
import net.minecraft.network.play.server.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;

public class NoLag extends Module
{
    public NoLag() {
        super("NoLag", Module.Category.MISC);
    }
    
    @Listener
    public void onUpdate(final PacketEvent.Receive event) {
        if (event.getStage() == EventStageable.EventStage.PRE) {
            if (event.getPacket() instanceof SPacketParticles || event.getPacket() instanceof SPacketEffect) {
                event.setCanceled(true);
            }
            if (event.getPacket() instanceof SPacketSoundEffect) {
                final SPacketSoundEffect packet = (SPacketSoundEffect)event.getPacket();
                if (packet.getCategory() == SoundCategory.PLAYERS && packet.getSound() == SoundEvents.ITEM_ARMOR_EQUIP_GENERIC) {
                    event.setCanceled(true);
                }
            }
        }
    }
}
