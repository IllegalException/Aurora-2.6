//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.command;

import java.util.*;
import me.memeszz.aurora.command.commands.*;
import com.mojang.realmsclient.gui.*;
import me.memeszz.aurora.util.*;

public class CommandManager
{
    private static ArrayList<Command> commands;
    boolean b;
    
    public static void initCommands() {
        CommandManager.commands = new ArrayList<Command>();
        addCommand(new CoordsCommand());
        addCommand(new BindCommand());
        addCommand(new ToggleCommand());
        addCommand(new DrawnCommand());
        addCommand(new SetCommand());
        addCommand(new CmdsCommand());
        addCommand(new ModsCommand());
        addCommand(new PrefixCommand());
        addCommand(new FriendCommand());
        addCommand(new RainbowSpeedCommand());
        addCommand(new MacroCommand());
        addCommand(new ConfigCommand());
        addCommand(new OpenFolderCommand());
        addCommand(new MiddleXCommand());
        addCommand(new LoadAnnouncerCommand());
        addCommand(new EnemyCommand());
        addCommand(new ClientnameCommand());
    }
    
    public static void addCommand(final Command c) {
        CommandManager.commands.add(c);
    }
    
    public static ArrayList<Command> getCommands() {
        return CommandManager.commands;
    }
    
    public void callCommand(final String input) {
        final String[] split = input.split(" (?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        final String command = split[0];
        final String args = input.substring(command.length()).trim();
        this.b = false;
        final String[] array;
        int length;
        int i = 0;
        String s;
        final String s2;
        final String s3;
        CommandManager.commands.forEach(c -> {
            c.getAlias();
            for (length = array.length; i < length; ++i) {
                s = array[i];
                if (s.equalsIgnoreCase(s2)) {
                    this.b = true;
                    try {
                        c.onCommand(s3, s3.split(" (?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"));
                    }
                    catch (Exception e) {
                        Wrapper.sendClientMessage(ChatFormatting.RED + c.getSyntax());
                    }
                }
            }
            return;
        });
        if (!this.b) {
            Wrapper.sendClientMessage(ChatFormatting.RED + "Unknown command!");
        }
    }
}
