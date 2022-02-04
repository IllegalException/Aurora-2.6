//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.mixin.mixins;

import me.memeszz.aurora.mixin.accessor.*;
import net.minecraft.client.*;
import net.minecraft.client.entity.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.*;
import net.minecraft.util.*;
import net.minecraft.client.multiplayer.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import me.memeszz.aurora.*;
import net.minecraft.client.gui.*;
import me.memeszz.aurora.event.events.*;
import me.memeszz.aurora.module.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ Minecraft.class })
public abstract class MixinMinecraft implements IMinecraft
{
    @Shadow
    public EntityPlayerSP player;
    @Shadow
    public PlayerControllerMP playerController;
    
    @Accessor
    public abstract Timer getTimer();
    
    @Accessor
    public abstract void setSession(final Session p0);
    
    @Accessor
    public abstract void setRightClickDelayTimer(final int p0);
    
    @Accessor
    public abstract Session getSession();
    
    @Accessor
    public abstract ServerData getCurrentServerData();
    
    @Inject(method = { "shutdown()V" }, at = { @At("HEAD") })
    public void saveSettingsOnShutdown(final CallbackInfo ci) {
        Aurora.saveConfig();
        System.out.println("Saved Aurora config!");
    }
    
    @Inject(method = { "displayGuiScreen" }, at = { @At("HEAD") })
    private void displayGuiScreen(final GuiScreen guiScreenIn, final CallbackInfo info) {
        final GuiScreenDisplayedEvent screenEvent = new GuiScreenDisplayedEvent(guiScreenIn);
        Aurora.getInstance().getEventManager().dispatchEvent((Object)screenEvent);
    }
    
    @Redirect(method = { "sendClickBlockToController" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/entity/EntityPlayerSP;isHandActive()Z"))
    private boolean isHandActive(final EntityPlayerSP player) {
        return !ModuleManager.isModuleEnabled("MultiTask") && this.player.isHandActive();
    }
    
    @Redirect(method = { "rightClickMouse" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/PlayerControllerMP;getIsHittingBlock()Z"))
    private boolean isHittingBlock(final PlayerControllerMP playerControllerMP) {
        return !ModuleManager.isModuleEnabled("MultiTask") && this.playerController.getIsHittingBlock();
    }
}
