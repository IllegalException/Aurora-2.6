//Decomped By XeonLyfe
package me.memeszz.aurora.module.modules.movement;

import me.memeszz.aurora.module.*;
import net.minecraftforge.client.event.*;
import net.minecraft.util.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;

public class NoSlow extends Module
{
    public NoSlow() {
        super("NoSlow", Module.Category.MOVEMENT, "Prevents item use form slowing you down");
    }
    
    @Listener
    public void onUpdate(final InputUpdateEvent event) {
        if (NoSlow.mc.player.isHandActive() && !NoSlow.mc.player.isRiding()) {
            final MovementInput movementInput = event.getMovementInput();
            movementInput.moveStrafe *= 5.0f;
            final MovementInput movementInput2 = event.getMovementInput();
            movementInput2.moveForward *= 5.0f;
        }
    }
}
