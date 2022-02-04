//Decomped By XeonLyfe
package me.memeszz.aurora.module.modules.misc;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;
import me.memeszz.aurora.event.events.*;
import me.memeszz.aurora.util.*;
import net.minecraft.client.gui.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;

public class AutoRespawn extends Module
{
    Setting.b coords;
    
    public AutoRespawn() {
        super("AutoRespawn", Module.Category.MISC, "Respawn when you die");
    }
    
    public void setup() {
        this.coords = this.registerB("DeathCoords", true);
    }
    
    @Listener
    public void onUpdate(final GuiScreenDisplayedEvent event) {
        if (event.getScreen() instanceof GuiGameOver) {
            if (this.coords.getValue()) {
                Wrapper.sendClientMessage(String.format("You died at x%d y%d z%d", (int)AutoRespawn.mc.player.posX, (int)AutoRespawn.mc.player.posY, (int)AutoRespawn.mc.player.posZ));
            }
            if (AutoRespawn.mc.player != null) {
                AutoRespawn.mc.player.respawnPlayer();
            }
            AutoRespawn.mc.displayGuiScreen((GuiScreen)null);
        }
    }
}
