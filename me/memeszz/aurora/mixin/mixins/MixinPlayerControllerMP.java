//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.mixin.mixins;

import me.memeszz.aurora.mixin.accessor.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.client.multiplayer.*;
import org.spongepowered.asm.mixin.gen.*;
import net.minecraft.util.math.*;
import me.memeszz.aurora.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import me.memeszz.aurora.module.*;
import net.minecraft.util.*;
import me.memeszz.aurora.event.events.*;

@Mixin({ PlayerControllerMP.class })
public abstract class MixinPlayerControllerMP implements IPlayerControllerMP
{
    @Accessor
    public abstract void setBlockHitDelay(final int p0);
    
    @Accessor
    public abstract void setIsHittingBlock(final boolean p0);
    
    @Accessor
    public abstract float getCurBlockDamageMP();
    
    @Accessor
    public abstract void setCurBlockDamageMP(final float p0);
    
    @Inject(method = { "onPlayerDestroyBlock" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/world/World;playEvent(ILnet/minecraft/util/math/BlockPos;I)V") }, cancellable = true)
    private void onPlayerDestroyBlock(final BlockPos pos, final CallbackInfoReturnable<Boolean> info) {
        Aurora.getInstance().getEventManager().dispatchEvent((Object)new DestroyBlockEvent(pos));
    }
    
    @Inject(method = { "resetBlockRemoving" }, at = { @At("HEAD") }, cancellable = true)
    public void resetBlockRemoving(final CallbackInfo p_Info) {
        final EventPlayerResetBlockRemoving l_Event = new EventPlayerResetBlockRemoving();
        Aurora.getInstance().getEventManager().dispatchEvent((Object)l_Event);
        if (l_Event.isCanceled() || ModuleManager.isModuleEnabled("MultiTask")) {
            p_Info.cancel();
        }
    }
    
    @Inject(method = { "clickBlock" }, at = { @At("HEAD") }, cancellable = true)
    public void clickBlock(final BlockPos loc, final EnumFacing face, final CallbackInfoReturnable<Boolean> callback) {
        final EventPlayerClickBlock l_Event = new EventPlayerClickBlock(loc, face);
        Aurora.getInstance().getEventManager().dispatchEvent((Object)l_Event);
        if (l_Event.isCanceled()) {
            callback.setReturnValue((Object)false);
            callback.cancel();
        }
    }
    
    @Inject(method = { "onPlayerDamageBlock" }, at = { @At("HEAD") }, cancellable = true)
    public void onPlayerDamageBlock(final BlockPos posBlock, final EnumFacing directionFacing, final CallbackInfoReturnable<Boolean> p_Info) {
        final EventPlayerDamageBlock l_Event = new EventPlayerDamageBlock(posBlock, directionFacing);
        Aurora.getInstance().getEventManager().dispatchEvent((Object)l_Event);
        if (l_Event.isCanceled()) {
            p_Info.setReturnValue((Object)false);
            p_Info.cancel();
        }
    }
}
