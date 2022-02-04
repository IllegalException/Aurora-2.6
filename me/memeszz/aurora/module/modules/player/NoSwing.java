//Decomped By XeonLyfe
package me.memeszz.aurora.module.modules.player;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.event.events.*;
import net.minecraft.network.play.client.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;

public class NoSwing extends Module
{
    public NoSwing() {
        super("NoSwing", Module.Category.PLAYER, "Prevents swinging animation server side");
    }
    
    @Listener
    public void onUpdate(final PacketEvent.Send event) {
        if (event.getPacket() instanceof CPacketAnimation) {
            event.setCanceled(true);
        }
    }
}
