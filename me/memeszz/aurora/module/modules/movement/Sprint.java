//Decomped By XeonLyfe
package me.memeszz.aurora.module.modules.movement;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;
import java.util.*;
import me.memeszz.aurora.event.events.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;

public class Sprint extends Module
{
    Setting.mode mode;
    
    public Sprint() {
        super("Sprint", Module.Category.MOVEMENT, "Automatically sprint");
    }
    
    public void setup() {
        final ArrayList<String> modes = new ArrayList<String>();
        modes.add("Legit");
        modes.add("Rage");
        this.mode = this.registerMode("Mode", (List)modes, "Rage");
    }
    
    public void onDisable() {
        super.onDisable();
        if (Sprint.mc.world != null) {
            Sprint.mc.player.setSprinting(false);
        }
    }
    
    @Listener
    public void onUpdate(final UpdateEvent event) {
        if (this.mode.getValue().equals("Rage")) {
            if ((Sprint.mc.gameSettings.keyBindForward.isKeyDown() || Sprint.mc.gameSettings.keyBindBack.isKeyDown() || Sprint.mc.gameSettings.keyBindLeft.isKeyDown() || Sprint.mc.gameSettings.keyBindRight.isKeyDown()) && !Sprint.mc.player.isSneaking() && !Sprint.mc.player.collidedHorizontally && Sprint.mc.player.getFoodStats().getFoodLevel() > 6.0f) {
                Sprint.mc.player.setSprinting(true);
            }
            if (this.mode.getValue().equals("Legit") && Sprint.mc.gameSettings.keyBindForward.isKeyDown() && !Sprint.mc.player.isSneaking() && !Sprint.mc.player.isHandActive() && !Sprint.mc.player.collidedHorizontally && Sprint.mc.currentScreen == null && Sprint.mc.player.getFoodStats().getFoodLevel() > 6.0f) {
                Sprint.mc.player.setSprinting(true);
            }
        }
    }
}
