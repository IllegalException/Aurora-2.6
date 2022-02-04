//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.module.modules.render;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;
import java.awt.*;
import me.memeszz.aurora.event.events.*;
import net.minecraftforge.common.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class SkyColor extends Module
{
    Setting.i r;
    Setting.i g;
    Setting.i b;
    
    public SkyColor() {
        super("SkyColor", Module.Category.RENDER, "Draws a box around entities");
        this.r = this.registerI("Red", 255, 0, 255);
        this.g = this.registerI("Green", 0, 0, 255);
        this.b = this.registerI("Blue", 255, 0, 255);
    }
    
    public int getSkyColorByTemp(final float par1) {
        return Color.red.getRGB();
    }
    
    @Listener
    public void onUpdate(final UpdateEvent event) {
        if (this.isEnabled()) {
            MinecraftForge.EVENT_BUS.register((Object)this);
        }
        else {
            MinecraftForge.EVENT_BUS.unregister((Object)this);
        }
    }
    
    @SubscribeEvent
    public void fogColors(final EntityViewRenderEvent.FogColors event) {
        event.setRed(this.r.getValue() / 255.0f);
        event.setGreen(this.g.getValue() / 255.0f);
        event.setBlue(this.b.getValue() / 255.0f);
    }
    
    @SubscribeEvent
    public void fogDensity(final EntityViewRenderEvent.FogDensity event) {
        event.setDensity(0.0f);
        event.setCanceled(true);
    }
    
    public void onEnable() {
        MinecraftForge.EVENT_BUS.register((Object)this);
    }
    
    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister((Object)this);
    }
}
