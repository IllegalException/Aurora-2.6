//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.command.commands;

import me.memeszz.aurora.command.*;
import com.mojang.realmsclient.gui.*;
import me.memeszz.aurora.module.*;

public class ToggleCommand extends Command
{
    boolean found;
    
    public String[] getAlias() {
        return new String[] { "toggle", "t" };
    }
    
    public String getSyntax() {
        return "toggle <Module>";
    }
    
    public void onCommand(final String command, final String[] args) {
        this.found = false;
        ModuleManager.getModules().forEach(m -> {
            if (m.getName().equalsIgnoreCase(args[0])) {
                if (m.isEnabled()) {
                    m.disable();
                    this.found = true;
                }
                else if (!m.isEnabled()) {
                    m.enable();
                    this.found = true;
                }
            }
            return;
        });
        if (!this.found && args.length == 1) {
            Command.sendClientMessage(ChatFormatting.DARK_RED + "Module not found!");
        }
    }
}
