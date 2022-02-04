//Decomped By XeonLyfe
package me.memeszz.aurora.command.commands;

import me.memeszz.aurora.command.*;
import me.memeszz.aurora.*;
import org.lwjgl.opengl.*;

public class ClientnameCommand extends Command
{
    public String[] getAlias() {
        return new String[] { "name", "modname", "clientname", "suffix", "watermark" };
    }
    
    public String getSyntax() {
        return "name <new name>";
    }
    
    public void onCommand(final String command, final String[] args) throws Exception {
        if (!args[0].replace("__", " ").equalsIgnoreCase("")) {
            Aurora.MODNAME = args[0].replace("__", " ");
            Display.setTitle(Aurora.MODNAME + " " + "2.6");
            sendClientMessage("set client name to " + args[0].replace("__", " "));
        }
        else {
            sendClientMessage(this.getSyntax());
        }
    }
}
