//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.module.modules.render;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.event.events.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;

public class Brightness extends Module
{
    float old;
    
    public Brightness() {
        super("Brightness", Module.Category.RENDER, "Lets you see shit when it's dark");
    }
    
    public void onEnable() {
        this.old = Brightness.mc.gameSettings.gammaSetting;
    }
    
    @Listener
    public void onUpdate(final UpdateEvent event) {
        Brightness.mc.gameSettings.gammaSetting = 666.0f;
    }
    
    public void onDisable() {
        Brightness.mc.gameSettings.gammaSetting = this.old;
    }
}
