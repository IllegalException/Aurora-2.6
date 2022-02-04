//Decomped By XeonLyfe
package me.memeszz.aurora.command.commands;

import me.memeszz.aurora.command.*;
import me.memeszz.aurora.util.*;

public class PrefixCommand extends Command
{
    public String[] getAlias() {
        return new String[] { "prefix", "setprefix" };
    }
    
    public String getSyntax() {
        return "prefix <character>";
    }
    
    public void onCommand(final String command, final String[] args) throws Exception {
        Command.setPrefix(args[0]);
        Wrapper.sendClientMessage("Command prefix set to " + Command.getPrefix());
    }
}
