//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.module.modules.movement;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;
import me.memeszz.aurora.event.events.*;
import me.memeszz.aurora.mixin.accessor.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;

public class FastSwim extends Module
{
    private Setting.b up;
    private Setting.b forward;
    private Setting.b sprint;
    private Setting.b only2b;
    private Setting.b down;
    int divider;
    
    public FastSwim() {
        super("FastSwim", Module.Category.MOVEMENT, "Allows The Player To Swim Faster Horizontally and Vertically");
        this.divider = 5;
    }
    
    public void setup() {
        this.up = this.registerB("FastSwimUp", true);
        this.down = this.registerB("FastSwimDown", true);
        this.forward = this.registerB("FastSwimForward", true);
        this.sprint = this.registerB("AutoSprintInLiquid", true);
        this.only2b = this.registerB("Only2b", true);
    }
    
    @Listener
    public void onUpdate(final UpdateEvent event) {
        if (this.only2b.getValue() && !FastSwim.mc.isSingleplayer() && ((IMinecraft)FastSwim.mc).getCurrentServerData().serverIP.equalsIgnoreCase("2b2t.org")) {
            if (this.sprint.getValue() && (FastSwim.mc.player.isInLava() || FastSwim.mc.player.isInWater())) {
                FastSwim.mc.player.setSprinting(true);
            }
            if ((FastSwim.mc.player.isInWater() || FastSwim.mc.player.isInLava()) && FastSwim.mc.gameSettings.keyBindJump.isKeyDown() && this.up.getValue()) {
                FastSwim.mc.player.motionY = 0.725 / this.divider;
            }
            if (FastSwim.mc.player.isInWater() || FastSwim.mc.player.isInLava()) {
                if ((this.forward.getValue() && FastSwim.mc.gameSettings.keyBindForward.isKeyDown()) || FastSwim.mc.gameSettings.keyBindLeft.isKeyDown() || FastSwim.mc.gameSettings.keyBindRight.isKeyDown() || FastSwim.mc.gameSettings.keyBindBack.isKeyDown()) {
                    FastSwim.mc.player.jumpMovementFactor = 0.34f / this.divider;
                }
                else {
                    FastSwim.mc.player.jumpMovementFactor = 0.0f;
                }
            }
            if (FastSwim.mc.player.isInWater() && this.down.getValue() && FastSwim.mc.gameSettings.keyBindSneak.isKeyDown()) {
                final int divider2 = this.divider * -1;
                FastSwim.mc.player.motionY = 2.2 / divider2;
            }
            if (FastSwim.mc.player.isInLava() && this.down.getValue() && FastSwim.mc.gameSettings.keyBindSneak.isKeyDown()) {
                final int divider2 = this.divider * -1;
                FastSwim.mc.player.motionY = 0.91 / divider2;
            }
        }
        if (!this.only2b.getValue()) {
            if (this.sprint.getValue() && (FastSwim.mc.player.isInLava() || FastSwim.mc.player.isInWater())) {
                FastSwim.mc.player.setSprinting(true);
            }
            if ((FastSwim.mc.player.isInWater() || FastSwim.mc.player.isInLava()) && FastSwim.mc.gameSettings.keyBindJump.isKeyDown() && this.up.getValue()) {
                FastSwim.mc.player.motionY = 0.725 / this.divider;
            }
            if (FastSwim.mc.player.isInWater() || FastSwim.mc.player.isInLava()) {
                if ((this.forward.getValue() && FastSwim.mc.gameSettings.keyBindForward.isKeyDown()) || FastSwim.mc.gameSettings.keyBindLeft.isKeyDown() || FastSwim.mc.gameSettings.keyBindRight.isKeyDown() || FastSwim.mc.gameSettings.keyBindBack.isKeyDown()) {
                    FastSwim.mc.player.jumpMovementFactor = 0.34f / this.divider;
                }
                else {
                    FastSwim.mc.player.jumpMovementFactor = 0.0f;
                }
            }
            if (FastSwim.mc.player.isInWater() && this.down.getValue() && FastSwim.mc.gameSettings.keyBindSneak.isKeyDown()) {
                final int divider2 = this.divider * -1;
                FastSwim.mc.player.motionY = 2.2 / divider2;
            }
            if (FastSwim.mc.player.isInLava() && this.down.getValue() && FastSwim.mc.gameSettings.keyBindSneak.isKeyDown()) {
                final int divider2 = this.divider * -1;
                FastSwim.mc.player.motionY = 0.91 / divider2;
            }
        }
    }
}
