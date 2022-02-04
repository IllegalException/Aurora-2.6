//Decomped By XeonLyfe
package me.memeszz.aurora.mixin.mixins;

import org.spongepowered.asm.mixin.*;
import net.minecraft.network.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import me.memeszz.aurora.event.events.*;
import me.memeszz.aurora.*;
import org.spongepowered.asm.mixin.injection.*;
import io.netty.channel.*;
import me.memeszz.aurora.util.misc.*;
import net.minecraft.util.text.*;

@Mixin({ NetworkManager.class })
public abstract class MixinNetworkManager
{
    @Inject(method = { "sendPacket(Lnet/minecraft/network/Packet;)V" }, at = { @At("HEAD") }, cancellable = true)
    private void onSendPacket(final Packet<?> packet, final CallbackInfo callbackInfo) {
        final PacketEvent.Send event = new PacketEvent.Send((Packet)packet);
        Aurora.getInstance().getEventManager().dispatchEvent((Object)event);
        if (event.isCanceled()) {
            callbackInfo.cancel();
        }
    }
    
    @Inject(method = { "channelRead0" }, at = { @At("HEAD") }, cancellable = true)
    private void onChannelRead(final ChannelHandlerContext context, final Packet<?> packet, final CallbackInfo callbackInfo) {
        TickRate.update(packet);
        final PacketEvent.Receive event = new PacketEvent.Receive((Packet)packet);
        Aurora.getInstance().getEventManager().dispatchEvent((Object)event);
        if (event.isCanceled()) {
            callbackInfo.cancel();
        }
    }
    
    @Inject(method = { "closeChannel" }, at = { @At("HEAD") })
    public void preCloseChannel(final ITextComponent message, final CallbackInfo callbackInfo) {
        TickRate.reset();
    }
}
