//Decomped By XeonLyfe
package me.memeszz.aurora.command.commands;

import me.memeszz.aurora.command.*;
import com.mojang.realmsclient.gui.*;
import me.memeszz.aurora.util.*;
import me.memeszz.aurora.module.*;

public class DrawnCommand extends Command
{
    boolean found;
    
    public String[] getAlias() {
        return new String[] { "drawn", "visible", "d" };
    }
    
    public String getSyntax() {
        return "drawn <Module>";
    }
    
    public void onCommand(final String command, final String[] args) throws Exception {
        this.found = false;
        ModuleManager.getModules().forEach(m -> {
            if (m.getName().equalsIgnoreCase(args[0])) {
                if (m.isDrawn()) {
                    m.setDrawn(false);
                    this.found = true;
                    Wrapper.sendClientMessage(m.getName() + ChatFormatting.RED + " drawn false");
                }
                else if (!m.isDrawn()) {
                    m.setDrawn(true);
                    this.found = true;
                    Wrapper.sendClientMessage(m.getName() + ChatFormatting.GREEN + " drawn true");
                }
            }
            return;
        });
        if (!this.found && args.length == 1) {
            Wrapper.sendClientMessage(ChatFormatting.DARK_RED + "Module not found!");
        }
    }
}
