//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.module.modules.render;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;
import java.util.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.fml.common.eventhandler.*;
import me.memeszz.aurora.event.events.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;
import net.minecraftforge.common.*;

public class Fov extends Module
{
    Setting.i fovSlider;
    Setting.mode mode;
    public float defaultFov;
    
    public Fov() {
        super("FOV", Module.Category.RENDER, "Change Fov and Make it lower/higher than vanilla");
        this.fovSlider = this.registerI("Fov", 120, 0, 180);
        final ArrayList<String> modes = new ArrayList<String>();
        modes.add("ViewModelChanger");
        modes.add("FovChanger");
        this.mode = this.registerMode("Mode", (List)modes, "ViewModelChanger");
    }
    
    @SubscribeEvent
    public void fovOn(final EntityViewRenderEvent.FOVModifier e) {
        if (this.mode.getValue().equals("ViewModelChanger")) {
            e.setFOV((float)this.fovSlider.getValue());
        }
    }
    
    @Listener
    public void gui(final GuiScreenDisplayedEvent event) {
        if (this.mode.getValue().equals("FovChanger")) {
            Fov.mc.gameSettings.fovSetting = (float)this.fovSlider.getValue();
        }
    }
    
    public void onEnable() {
        MinecraftForge.EVENT_BUS.register((Object)this);
        this.defaultFov = Fov.mc.gameSettings.fovSetting;
    }
    
    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister((Object)this);
        Fov.mc.gameSettings.fovSetting = this.defaultFov;
    }
}
