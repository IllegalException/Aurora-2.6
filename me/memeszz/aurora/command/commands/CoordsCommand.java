//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.command.commands;

import me.memeszz.aurora.command.*;
import java.text.*;
import net.minecraft.client.*;
import java.awt.*;
import me.memeszz.aurora.util.*;
import java.awt.datatransfer.*;

public class CoordsCommand extends Command
{
    public String[] getAlias() {
        return new String[] { "Coord", "Coordinate", "Coords", "Coordinates" };
    }
    
    public String getSyntax() {
        return "coords";
    }
    
    public void onCommand(final String command, final String[] args) throws Exception {
        final DecimalFormat format = new DecimalFormat("#");
        final StringSelection contents = new StringSelection(format.format(Minecraft.getMinecraft().player.posX) + ", " + format.format(Minecraft.getMinecraft().player.posY) + ", " + format.format(Minecraft.getMinecraft().player.posZ));
        final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(contents, null);
        Wrapper.sendClientMessage("Saved Coordinates To Clipboard");
    }
}
