//Decomped By XeonLyfe
package me.memeszz.aurora.module.modules.combat;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.event.events.*;
import net.minecraft.network.play.client.*;
import net.minecraft.item.*;
import me.memeszz.aurora.mixin.accessor.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;

public class FootXp extends Module
{
    public FootXp() {
        super("FootXp", Module.Category.COMBAT, "Increases chance for a critical hit");
    }
    
    @Listener
    public void onUpdate(final PacketEvent.Send event) {
        if (event.getPacket() instanceof CPacketPlayer && FootXp.mc.player.getHeldItemMainhand().getItem() instanceof ItemExpBottle) {
            final CPacketPlayer packet = (CPacketPlayer)event.getPacket();
            ((ICPacketPlayer)packet).setPitch(90.0f);
        }
    }
}
