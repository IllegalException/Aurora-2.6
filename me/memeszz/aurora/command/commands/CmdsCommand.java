//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.command.commands;

import me.memeszz.aurora.command.*;
import net.minecraft.util.text.event.*;
import net.minecraft.util.text.*;
import net.minecraft.client.*;

public class CmdsCommand extends Command
{
    public String[] getAlias() {
        return new String[] { "commands", "cmds" };
    }
    
    public String getSyntax() {
        return "commands";
    }
    
    public void onCommand(final String command, final String[] args) throws Exception {
        final int size = CommandManager.getCommands().size();
        final TextComponentString msg = new TextComponentString("�7Commands: ");
        for (int i = 0; i < size; ++i) {
            final Command c = CommandManager.getCommands().get(i);
            if (c != null) {
                msg.appendSibling(new TextComponentString(c.getAlias()[0] + ((i == size - 1) ? "" : ", ")).setStyle(new Style().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (ITextComponent)new TextComponentString(c.getSyntax())))));
            }
        }
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage((ITextComponent)msg);
    }
}
