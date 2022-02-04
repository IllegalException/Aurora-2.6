//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.module.modules.render;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;
import me.memeszz.aurora.event.events.*;
import net.minecraft.init.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;
import net.minecraftforge.client.event.*;

public class NoRender extends Module
{
    public Setting.b armor;
    Setting.b fire;
    Setting.b blind;
    Setting.b nausea;
    public Setting.b hurtCam;
    
    public NoRender() {
        super("NoRender", Module.Category.RENDER, "Prevents rendering some things");
    }
    
    public void setup() {
        this.armor = this.registerB("Armor", false);
        this.fire = this.registerB("Fire", false);
        this.blind = this.registerB("Blindness", false);
        this.nausea = this.registerB("Nausea", false);
        this.hurtCam = this.registerB("HurtCam", false);
    }
    
    @Listener
    public void onUpdate(final UpdateEvent event) {
        if (this.blind.getValue() && NoRender.mc.player.isPotionActive(MobEffects.BLINDNESS)) {
            NoRender.mc.player.removePotionEffect(MobEffects.BLINDNESS);
        }
        if (this.nausea.getValue() && NoRender.mc.player.isPotionActive(MobEffects.NAUSEA)) {
            NoRender.mc.player.removePotionEffect(MobEffects.NAUSEA);
        }
    }
    
    @Listener
    public void kek(final RenderBlockOverlayEvent event) {
        if (this.fire.getValue() && event.getOverlayType() == RenderBlockOverlayEvent.OverlayType.FIRE) {
            event.setCanceled(true);
        }
    }
}
