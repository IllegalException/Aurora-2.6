//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.event.events;

import net.minecraft.client.gui.*;

public class GuiScreenDisplayedEvent
{
    private GuiScreen screen;
    
    public GuiScreenDisplayedEvent(final GuiScreen screen) {
        this.screen = screen;
    }
    
    public GuiScreen getScreen() {
        return this.screen;
    }
}
