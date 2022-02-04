//Decomped By XeonLyfe
package me.memeszz.aurora.module.modules.world;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;
import com.mojang.realmsclient.gui.*;
import net.minecraftforge.client.event.*;
import java.text.*;
import java.util.*;
import net.minecraft.util.text.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;

public class ChatTimeStamps extends Module
{
    Setting.mode format;
    Setting.mode color;
    Setting.mode decoration;
    Setting.b space;
    
    public ChatTimeStamps() {
        super("ChatTimeStamps", Module.Category.WORLD);
        final ArrayList<String> formats = new ArrayList<String>();
        formats.add("H24:mm");
        formats.add("H12:mm");
        formats.add("H12:mm a");
        formats.add("H24:mm:ss");
        formats.add("H12:mm:ss");
        formats.add("H12:mm:ss a");
        final ArrayList<String> deco = new ArrayList<String>();
        deco.add("< >");
        deco.add("[ ]");
        deco.add("{ }");
        deco.add(" ");
        final ArrayList<String> colors = new ArrayList<String>();
        for (final ChatFormatting cf : ChatFormatting.values()) {
            colors.add(cf.getName());
        }
        this.format = this.registerMode("Format", (List)formats, "H12:mm");
        this.color = this.registerMode("Color", (List)colors, ChatFormatting.AQUA.getName());
        this.decoration = this.registerMode("Deco", (List)deco, "< >");
        this.space = this.registerB("Space", true);
    }
    
    @Listener
    public void chat(final ClientChatReceivedEvent event) {
        final String decoLeft = this.decoration.getValue().equalsIgnoreCase(" ") ? "" : this.decoration.getValue().split(" ")[0];
        String decoRight = this.decoration.getValue().equalsIgnoreCase(" ") ? "" : this.decoration.getValue().split(" ")[1];
        if (this.space.getValue()) {
            decoRight += " ";
        }
        final String dateFormat = this.format.getValue().replace("H24", "k").replace("H12", "h");
        final String date = new SimpleDateFormat(dateFormat).format(new Date());
        final TextComponentString time = new TextComponentString(ChatFormatting.getByName(this.color.getValue()) + decoLeft + date + decoRight + ChatFormatting.RESET);
        event.setMessage(time.appendSibling(event.getMessage()));
    }
}
