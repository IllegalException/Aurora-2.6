//Decomped By XeonLyfe
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
