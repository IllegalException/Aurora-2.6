//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.module.modules.movement;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.event.events.*;
import net.minecraft.client.entity.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;

public class ReverseStep extends Module
{
    public ReverseStep() {
        super("ReverseStep", Module.Category.MOVEMENT, "Makes you fall down into holes faster");
    }
    
    @Listener
    public void onUpdate(final UpdateEvent event) {
        if (ReverseStep.mc.player == null || ReverseStep.mc.world == null || ReverseStep.mc.player.isInWater() || ReverseStep.mc.player.isInLava()) {
            return;
        }
        if (ReverseStep.mc.player.onGround) {
            final EntityPlayerSP player = ReverseStep.mc.player;
            --player.motionY;
        }
    }
}
