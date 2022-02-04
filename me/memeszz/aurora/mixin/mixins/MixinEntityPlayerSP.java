//Decomped By XeonLyfe
package me.memeszz.aurora.mixin.mixins;

import org.spongepowered.asm.mixin.*;
import net.minecraft.client.entity.*;
import net.minecraft.world.*;
import com.mojang.authlib.*;
import net.minecraft.entity.*;
import me.memeszz.aurora.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import me.memeszz.aurora.event.*;
import me.memeszz.aurora.event.events.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(value = { EntityPlayerSP.class }, priority = 998)
public abstract class MixinEntityPlayerSP extends AbstractClientPlayer
{
    public MixinEntityPlayerSP() {
        super((World)null, (GameProfile)null);
    }
    
    @Redirect(method = { "move" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/entity/AbstractClientPlayer;move(Lnet/minecraft/entity/MoverType;DDD)V"))
    public void move(final AbstractClientPlayer player, final MoverType type, final double x, final double y, final double z) {
        final PlayerMoveEvent moveEvent = new PlayerMoveEvent(type, x, y, z);
        Aurora.getInstance().getEventManager().dispatchEvent((Object)moveEvent);
        super.move(type, moveEvent.x, moveEvent.y, moveEvent.z);
    }
    
    @Inject(method = { "onUpdate()V" }, at = { @At(value = "FIELD", target = "net/minecraft/client/entity/EntityPlayerSP.connection:Lnet/minecraft/client/network/NetHandlerPlayClient;", ordinal = 0, shift = At.Shift.BEFORE) })
    public void onUpdatePre(final CallbackInfo ci) {
        final UpdateEvent event = new UpdateEvent(EventStageable.EventStage.PRE, this.rotationYaw, this.rotationPitch, this.posX, this.getEntityBoundingBox().minY, this.posZ, this.onGround);
        Aurora.getInstance().getEventManager().dispatchEvent((Object)event);
        if (event.isCanceled()) {
            ci.cancel();
        }
    }
    
    @Inject(method = { "onUpdate()V" }, at = { @At(value = "INVOKE", target = "net/minecraft/client/network/NetHandlerPlayClient.sendPacket(Lnet/minecraft/network/Packet;)V", ordinal = 0, shift = At.Shift.AFTER) })
    public void onUpdatePost(final CallbackInfo ci) {
        final UpdateEvent event = new UpdateEvent(EventStageable.EventStage.POST, this.rotationYaw, this.rotationPitch, this.posX, this.getEntityBoundingBox().minY, this.posZ, this.onGround);
        Aurora.getInstance().getEventManager().dispatchEvent((Object)event);
    }
    
    @Inject(method = { "onUpdate()V" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/client/entity/EntityPlayerSP;onUpdateWalkingPlayer()V", ordinal = 0, shift = At.Shift.AFTER) })
    public void onUpdateElse(final CallbackInfo ci) {
        final UpdateEvent event = new UpdateEvent(EventStageable.EventStage.POST, this.rotationYaw, this.rotationPitch, this.posX, this.getEntityBoundingBox().minY, this.posZ, this.onGround);
        Aurora.getInstance().getEventManager().dispatchEvent((Object)event);
    }
}
