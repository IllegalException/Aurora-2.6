//Decomped By XeonLyfe
package me.memeszz.aurora.command.commands;

import me.memeszz.aurora.command.*;
import me.memeszz.aurora.module.*;
import java.util.*;

public class SetCommand extends Command
{
    public String[] getAlias() {
        return new String[] { "set" };
    }
    
    public String getSyntax() {
        return "set <Module> <Setting> <Value>";
    }
    
    public void onCommand(final String command, final String[] args) throws Exception {
        for (final Module m : ModuleManager.getModules()) {
            if (m.getName().equalsIgnoreCase(args[0])) {
                System.out.println("no");
            }
        }
    }
}
