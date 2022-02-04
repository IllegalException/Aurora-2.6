//Decomped By XeonLyfe
package me.memeszz.aurora.module.modules.world;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;
import me.memeszz.aurora.command.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;
import me.memeszz.aurora.event.events.*;

public class Welcomer extends Module
{
    Setting.b publicS;
    
    public Welcomer() {
        super("Welcomer", Module.Category.WORLD, "Sends a message when someone joins the server");
        this.publicS = this.registerB("Public", false);
    }
    
    @Listener
    public void join(final PlayerJoinEvent event) {
        if (this.publicS.getValue()) {
            Welcomer.mc.player.sendChatMessage(event.getName() + " joined the game");
        }
        else {
            Command.sendClientMessage(event.getName() + " joined the game");
        }
    }
    
    @Listener
    public void leave(final PlayerLeaveEvent event) {
        if (this.publicS.getValue()) {
            Welcomer.mc.player.sendChatMessage(event.getName() + " left the game");
        }
        else {
            Command.sendClientMessage(event.getName() + " left the game");
        }
    }
}
