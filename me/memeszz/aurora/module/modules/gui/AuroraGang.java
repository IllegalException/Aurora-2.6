//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.module.modules.gui;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;
import me.memeszz.aurora.*;
import com.mojang.realmsclient.gui.*;
import me.memeszz.aurora.util.*;
import net.minecraft.entity.player.*;
import me.memeszz.aurora.util.friends.*;
import java.util.*;

public class AuroraGang extends Module
{
    public Setting.b customFont;
    private Setting.i x;
    private Setting.i y;
    public static String friends;
    private String str;
    private Setting.mode mode;
    
    public AuroraGang() {
        super("FriendsList", Module.Category.GUI, "Displays Friends Names When In Range");
        this.setDrawn(false);
    }
    
    public void setup() {
        this.x = this.registerI("X", 100, 0, 1000);
        this.y = this.registerI("Y", 100, 0, 1000);
        final ArrayList<String> modes = new ArrayList<String>();
        modes.add("AuroraGang");
        modes.add("GoonSquad");
        this.mode = this.registerMode("Mode", (List)modes, "AuroraGang");
    }
    
    public void onRender() {
        int y = 2;
        if (ClickGuiModule.customFont.getValue()) {
            Aurora.fontRenderer.drawStringWithShadow(ChatFormatting.BOLD + this.mode.getValue(), this.x.getValue(), this.y.getValue() - 10, 16777215);
        }
        else {
            Wrapper.getMinecraft().fontRenderer.drawStringWithShadow(ChatFormatting.BOLD + this.mode.getValue(), (float)this.x.getValue(), (float)(this.y.getValue() - 10), 16777215);
        }
        for (final Object o : AuroraGang.mc.world.getLoadedEntityList()) {
            if (o instanceof EntityPlayer && ((EntityPlayer)o).getName() != AuroraGang.mc.player.getName() && Friends.isFriend(((EntityPlayer)o).getName())) {
                AuroraGang.friends = ((EntityPlayer)o).getGameProfile().getName();
                this.str = " " + AuroraGang.friends;
                if (ClickGuiModule.customFont.getValue()) {
                    Aurora.fontRenderer.drawStringWithShadow(this.str, this.x.getValue(), y + this.y.getValue(), 16755200);
                }
                else {
                    Wrapper.getMinecraft().fontRenderer.drawStringWithShadow(this.str, (float)this.x.getValue(), (float)(y + this.y.getValue()), 16755200);
                }
                y += 12;
            }
        }
    }
}
