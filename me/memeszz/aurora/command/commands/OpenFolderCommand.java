//Decomped By XeonLyfe
package me.memeszz.aurora.command.commands;

import me.memeszz.aurora.command.*;
import java.awt.*;
import java.io.*;

public class OpenFolderCommand extends Command
{
    public String[] getAlias() {
        return new String[] { "openfolder", "folder" };
    }
    
    public String getSyntax() {
        return "openfolder";
    }
    
    public void onCommand(final String command, final String[] args) throws Exception {
        try {
            Desktop.getDesktop().open(new File("Aurora"));
        }
        catch (Exception e) {
            sendClientMessage("Error: " + e.getMessage());
        }
    }
}
