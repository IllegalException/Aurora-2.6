//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.command.commands;

import me.memeszz.aurora.command.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import me.memeszz.aurora.util.*;

public class MiddleXCommand extends Command
{
    public String[] getAlias() {
        return new String[] { "getmiddlex", "middlex", "getmiddle" };
    }
    
    public String getSyntax() {
        return this.getAlias()[0];
    }
    
    public void onCommand(final String command, final String[] args) throws Exception {
        Wrapper.sendClientMessage(new ScaledResolution(Minecraft.getMinecraft()).getScaledWidth() / 2 + "");
    }
}
