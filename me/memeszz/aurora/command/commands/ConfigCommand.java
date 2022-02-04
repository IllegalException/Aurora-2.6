//Decomped By XeonLyfe
package me.memeszz.aurora.command.commands;

import me.memeszz.aurora.command.*;
import me.memeszz.aurora.*;
import me.memeszz.aurora.util.*;

public class ConfigCommand extends Command
{
    public String[] getAlias() {
        return new String[] { "saveconfig", "savecfg" };
    }
    
    public String getSyntax() {
        return "saveconfig";
    }
    
    public void onCommand(final String command, final String[] args) throws Exception {
        Aurora.saveConfig();
        Wrapper.sendClientMessage("Saved Aurora config!");
    }
}
