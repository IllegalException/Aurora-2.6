//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.command.commands;

import me.memeszz.aurora.command.*;
import me.memeszz.aurora.util.friends.*;
import me.memeszz.aurora.util.*;
import me.memeszz.aurora.*;

public class FriendCommand extends Command
{
    public String[] getAlias() {
        return new String[] { "friend", "friends", "f" };
    }
    
    public String getSyntax() {
        return "friend <add | del> <Name>";
    }
    
    public void onCommand(final String command, final String[] args) throws Exception {
        if (args[0].equalsIgnoreCase("add")) {
            if (Friends.isFriend(args[1])) {
                Wrapper.sendClientMessage(args[1] + " is already a friend!");
                return;
            }
            if (!Friends.isFriend(args[1])) {
                Aurora.getInstance().friends.addFriend(args[1]);
                Wrapper.sendClientMessage("Added " + args[1] + " to friends list");
            }
        }
        if (args[0].equalsIgnoreCase("del") || args[0].equalsIgnoreCase("remove")) {
            if (!Friends.isFriend(args[1])) {
                Wrapper.sendClientMessage(args[1] + " is not a friend!");
                return;
            }
            if (Friends.isFriend(args[1])) {
                Aurora.getInstance().friends.delFriend(args[1]);
                Wrapper.sendClientMessage("Removed " + args[1] + " from friends list");
            }
        }
    }
}
