//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.command;

import net.minecraft.client.*;
import com.mojang.realmsclient.gui.*;
import net.minecraft.util.text.*;

public abstract class Command
{
    static Minecraft mc;
    public static String prefix;
    public static boolean MsgWaterMark;
    public static ChatFormatting cf;
    
    public abstract String[] getAlias();
    
    public abstract String getSyntax();
    
    public abstract void onCommand(final String p0, final String[] p1) throws Exception;
    
    public static void sendClientMessage(final String message) {
        if (Command.MsgWaterMark) {
            Command.mc.player.sendMessage((ITextComponent)new TextComponentString(ChatFormatting.DARK_AQUA + "[" + ChatFormatting.AQUA + "Aurora" + ChatFormatting.DARK_AQUA + "] " + message));
        }
        else {
            Command.mc.player.sendMessage((ITextComponent)new TextComponentString(Command.cf + message));
        }
    }
    
    public static char SECTIONSIGN() {
        return '�';
    }
    
    public static void sendRawMessage(final String message) {
        Command.mc.player.sendMessage((ITextComponent)new TextComponentString(message));
    }
    
    public static String getPrefix() {
        return Command.prefix;
    }
    
    public static void setPrefix(final String p) {
        Command.prefix = p;
    }
    
    static {
        Command.mc = Minecraft.getMinecraft();
        Command.prefix = ".";
        Command.MsgWaterMark = true;
        Command.cf = ChatFormatting.AQUA;
    }
}
