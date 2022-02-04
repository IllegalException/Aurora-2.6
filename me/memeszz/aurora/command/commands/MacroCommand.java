//Decomped By XeonLyfe
package me.memeszz.aurora.command.commands;

import me.memeszz.aurora.command.*;
import me.memeszz.aurora.*;
import org.lwjgl.input.*;
import me.memeszz.aurora.util.macro.*;
import com.mojang.realmsclient.gui.*;
import me.memeszz.aurora.util.*;

public class MacroCommand extends Command
{
    public String[] getAlias() {
        return new String[] { "macro", "macros" };
    }
    
    public String getSyntax() {
        return "macro <add | del> <key> <value>";
    }
    
    public void onCommand(final String command, final String[] args) throws Exception {
        if (args[0].equalsIgnoreCase("add")) {
            Aurora.getInstance().macroManager.delMacro(Aurora.getInstance().macroManager.getMacroByKey(Keyboard.getKeyIndex(args[1])));
            Aurora.getInstance().macroManager.addMacro(new Macro(Keyboard.getKeyIndex(args[1].toUpperCase()), args[2].replace("_", " ")));
            Wrapper.sendClientMessage(ChatFormatting.GREEN + "Added" + ChatFormatting.GREEN + " macro for key \"" + args[1].toUpperCase() + "\" with value \"" + args[2].replace("_", " ") + "\".");
        }
        if (args[0].equalsIgnoreCase("del")) {
            if (Aurora.getInstance().macroManager.getMacros().contains(Aurora.getInstance().macroManager.getMacroByKey(Keyboard.getKeyIndex(args[1].toUpperCase())))) {
                Aurora.getInstance().macroManager.delMacro(Aurora.getInstance().macroManager.getMacroByKey(Keyboard.getKeyIndex(args[1].toUpperCase())));
                Wrapper.sendClientMessage(ChatFormatting.RED + "Removed " + ChatFormatting.RED + "macro for key \"" + args[1].toUpperCase() + "\".");
            }
            else {
                Wrapper.sendClientMessage(ChatFormatting.RED + "That macro doesn't exist!");
            }
        }
    }
}
