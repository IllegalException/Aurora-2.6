//Decomped By XeonLyfe
package me.memeszz.aurora.command.commands;

import me.memeszz.aurora.command.*;
import me.memeszz.aurora.*;

public class LoadAnnouncerCommand extends Command
{
    public String[] getAlias() {
        return new String[] { "loadannouncer" };
    }
    
    public String getSyntax() {
        return "loadannouncer";
    }
    
    public void onCommand(final String command, final String[] args) throws Exception {
        Aurora.getInstance().configUtils.loadAnnouncer();
        sendClientMessage("Loaded Announcer file");
    }
}
