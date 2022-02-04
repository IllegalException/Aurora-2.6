//Decomped By XeonLyfe
package me.memeszz.aurora.module.modules.world;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;
import net.minecraftforge.client.event.*;
import com.mojang.realmsclient.gui.*;
import net.minecraft.util.text.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;
import me.memeszz.aurora.util.friends.*;

public class BetterChat extends Module
{
    public Setting.b clearBkg;
    Setting.b nameHighlight;
    Setting.b friendHighlight;
    
    public BetterChat() {
        super("BetterChat", Module.Category.WORLD);
    }
    
    public void setup() {
        this.clearBkg = this.registerB("Clear", true);
        this.nameHighlight = this.registerB("NameHighlight", false);
        this.friendHighlight = this.registerB("FriendHighlight", false);
    }
    
    @Listener
    public void chat(final ClientChatReceivedEvent event) {
        if (BetterChat.mc.player == null) {
            return;
        }
        final String name = BetterChat.mc.player.getName().toLowerCase();
        if (this.friendHighlight.getValue() && !event.getMessage().getUnformattedText().startsWith("<" + BetterChat.mc.player.getName() + ">")) {
            Friends.getFriends().forEach(f -> {
                if (event.getMessage().getUnformattedText().contains(f.getName())) {
                    event.getMessage().setStyle(event.getMessage().getStyle().setColor(TextFormatting.LIGHT_PURPLE));
                }
                return;
            });
        }
        if (this.nameHighlight.getValue()) {
            final String s = ChatFormatting.GOLD + "" + ChatFormatting.BOLD + BetterChat.mc.player.getName() + ChatFormatting.RESET;
            final Style style = event.getMessage().getStyle();
            if (!event.getMessage().getUnformattedText().startsWith("<" + BetterChat.mc.player.getName() + ">") && event.getMessage().getUnformattedText().toLowerCase().contains(name)) {
                event.getMessage().getStyle().setParentStyle(style.setBold(Boolean.valueOf(true)).setColor(TextFormatting.GOLD));
            }
        }
    }
}
