//Decomped By XeonLyfe
package me.memeszz.aurora.command.commands;

import me.memeszz.aurora.command.*;
import me.memeszz.aurora.event.*;
import me.memeszz.aurora.util.*;
import com.mojang.realmsclient.gui.*;

public class RainbowSpeedCommand extends Command
{
    public String[] getAlias() {
        return new String[] { "rainbowspeed", "rainbow" };
    }
    
    public String getSyntax() {
        return "rainbowspeed <speed>";
    }
    
    public void onCommand(final String command, final String[] args) throws Exception {
        if (args.length == 1) {
            final int i = Integer.parseInt(args[0]);
            if (i <= 0) {
                EventProcessor.INSTANCE.setRainbowSpeed(0);
            }
            else {
                EventProcessor.INSTANCE.setRainbowSpeed(i);
            }
            Wrapper.sendClientMessage("Rainbow speed set to " + i);
        }
        else {
            Wrapper.sendClientMessage(ChatFormatting.RED + this.getSyntax());
        }
    }
}
