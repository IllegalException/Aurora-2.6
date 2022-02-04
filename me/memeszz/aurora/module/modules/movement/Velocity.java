//Decomped By XeonLyfe
package me.memeszz.aurora.module.modules.movement;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.event.events.*;
import net.minecraft.network.play.server.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;

public class Velocity extends Module
{
    public Velocity() {
        super("Velocity", Module.Category.MOVEMENT, "Prevents you from taking knockback");
    }
    
    @Listener
    public void listener(final PacketEvent.Receive event) {
        if (event.getPacket() instanceof SPacketEntityVelocity && ((SPacketEntityVelocity)event.getPacket()).getEntityID() == Velocity.mc.player.getEntityId()) {
            event.setCanceled(true);
        }
        if (event.getPacket() instanceof SPacketExplosion) {
            event.setCanceled(true);
        }
    }
}
