//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.module.modules.movement;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;
import me.memeszz.aurora.event.events.*;
import net.minecraft.init.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;

public class IceSpeed extends Module
{
    Setting.d speed;
    
    public IceSpeed() {
        super("IceSpeed", Module.Category.MOVEMENT, "SPEED");
    }
    
    public void setup() {
        this.speed = this.registerD("Speed", 0.4, 0.0, 1.0);
    }
    
    @Listener
    public void onUpdate(final UpdateEvent event) {
        Blocks.ICE.slipperiness = (float)this.speed.getValue();
        Blocks.PACKED_ICE.slipperiness = (float)this.speed.getValue();
        Blocks.FROSTED_ICE.slipperiness = (float)this.speed.getValue();
    }
    
    public void onDisable() {
        Blocks.ICE.slipperiness = 0.98f;
        Blocks.PACKED_ICE.slipperiness = 0.98f;
        Blocks.FROSTED_ICE.slipperiness = 0.98f;
    }
}
