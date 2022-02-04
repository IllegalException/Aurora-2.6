//Decomped By XeonLyfe
package me.memeszz.aurora.module.modules.misc;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;
import java.util.*;
import me.memeszz.aurora.event.events.*;
import net.minecraft.network.play.client.*;
import me.memeszz.aurora.command.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;

public class ChatSuffix extends Module
{
    Setting.b blue;
    Setting.mode mode;
    
    public ChatSuffix() {
        super("ChatSuffix", Module.Category.MISC, "Adds a suffix to your messages");
    }
    
    public void setup() {
        final ArrayList<String> modes = new ArrayList<String>();
        modes.add("Green");
        modes.add("Blue");
        this.mode = this.registerMode("Color", (List)modes, "Green");
        this.blue = this.registerB("Blue", false);
    }
    
    @Listener
    public void packet(final PacketEvent.Send event) {
        if (event.getPacket() instanceof CPacketChatMessage) {
            if (((CPacketChatMessage)event.getPacket()).getMessage().startsWith("/") || ((CPacketChatMessage)event.getPacket()).getMessage().startsWith(Command.getPrefix())) {
                return;
            }
            final String old = ((CPacketChatMessage)event.getPacket()).getMessage();
            final String suffix = " \u23d0 ";
            String s = old + suffix;
            if (this.blue.getValue()) {
                s = old + "`" + suffix;
            }
            if (s.length() > 255) {
                return;
            }
        }
    }
}
