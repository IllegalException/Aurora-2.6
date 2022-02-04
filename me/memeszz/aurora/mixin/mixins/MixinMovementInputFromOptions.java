//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.mixin.mixins;

import net.minecraft.util.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.client.settings.*;
import me.memeszz.aurora.module.*;
import me.memeszz.aurora.util.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.input.*;
import net.minecraft.client.gui.*;
import me.memeszz.aurora.gui.*;

@Mixin(value = { MovementInputFromOptions.class }, priority = 10000)
public abstract class MixinMovementInputFromOptions extends MovementInput
{
    @Shadow
    @Final
    private GameSettings gameSettings;
    
    @Overwrite
    public void updatePlayerMoveState() {
        this.moveStrafe = 0.0f;
        this.moveForward = 0.0f;
        if (this.isKeyHeld(this.gameSettings.keyBindForward)) {
            ++this.moveForward;
            this.forwardKeyDown = true;
        }
        else {
            this.forwardKeyDown = false;
        }
        if (this.isKeyHeld(this.gameSettings.keyBindBack)) {
            --this.moveForward;
            this.backKeyDown = true;
        }
        else {
            this.backKeyDown = false;
        }
        if (this.isKeyHeld(this.gameSettings.keyBindLeft)) {
            ++this.moveStrafe;
            this.leftKeyDown = true;
        }
        else {
            this.leftKeyDown = false;
        }
        if (this.isKeyHeld(this.gameSettings.keyBindRight)) {
            --this.moveStrafe;
            this.rightKeyDown = true;
        }
        else {
            this.rightKeyDown = false;
        }
        this.jump = this.isKeyHeld(this.gameSettings.keyBindJump);
        this.sneak = this.isKeyHeld(this.gameSettings.keyBindSneak);
        if (this.sneak) {
            this.moveStrafe *= (float)0.3;
            this.moveForward *= (float)0.3;
        }
    }
    
    public boolean isKeyHeld(final KeyBinding keyBinding) {
        if (ModuleManager.isModuleEnabled("GuiMove") && Wrapper.getMinecraft().currentScreen != null) {
            if (Wrapper.getMinecraft().currentScreen instanceof InventoryEffectRenderer) {
                return Keyboard.isKeyDown(keyBinding.getKeyCode());
            }
            if (Wrapper.getMinecraft().world.isRemote && Wrapper.getMinecraft().currentScreen instanceof GuiIngameMenu) {
                return Keyboard.isKeyDown(keyBinding.getKeyCode());
            }
            if (Wrapper.getMinecraft().currentScreen instanceof ClickGUI) {
                return Keyboard.isKeyDown(keyBinding.getKeyCode());
            }
        }
        return keyBinding.isKeyDown();
    }
}
