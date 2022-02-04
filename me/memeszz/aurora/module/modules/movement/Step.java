//Decomped By XeonLyfe
package me.memeszz.aurora.module.modules.movement;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;
import java.util.*;
import me.memeszz.aurora.event.events.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;

public class Step extends Module
{
    Setting.d height;
    Setting.mode mode;
    
    public Step() {
        super("Step", Module.Category.MOVEMENT);
    }
    
    public void onDisable() {
        Step.mc.player.stepHeight = 0.5f;
    }
    
    public void setup() {
        final ArrayList<String> modes = new ArrayList<String>();
        modes.add("Vanilla");
        this.mode = this.registerMode("Mode", (List)modes, "Vanilla");
        this.height = this.registerD("Height", 2.0, 0.0, 6.0);
    }
    
    @Listener
    public void onUpdate(final UpdateEvent event) {
        if ((Step.mc.player != null || Step.mc.world != null) && this.mode.getValue().equals("Vanilla")) {
            Step.mc.player.stepHeight = (float)this.height.getValue();
        }
    }
}
