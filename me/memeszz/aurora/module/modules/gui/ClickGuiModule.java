//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.module.modules.gui;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;
import me.memeszz.aurora.*;
import net.minecraft.client.gui.*;

public class ClickGuiModule extends Module
{
    public ClickGuiModule INSTANCE;
    public static Setting.mode design;
    public static Setting.b rainbow;
    public static Setting.i red;
    public static Setting.i green;
    public static Setting.i blue;
    public static Setting.i alpha;
    public static Setting.b customFont;
    public static Setting.b desc;
    
    public ClickGuiModule() {
        super("ClickGUI", Module.Category.GUI, "Opens the ClickGUI");
        this.setBind(25);
        this.INSTANCE = this;
        ClickGuiModule.red = this.registerI("Red", 255, 0, 255);
        ClickGuiModule.green = this.registerI("Green", 255, 0, 255);
        ClickGuiModule.blue = this.registerI("Blue", 255, 0, 255);
        ClickGuiModule.alpha = this.registerI("Alpha", 255, 0, 255);
        ClickGuiModule.desc = this.registerB("Desc", true);
        ClickGuiModule.customFont = this.registerB("CustomFont", false);
    }
    
    public void setup() {
    }
    
    public void onEnable() {
        ClickGuiModule.mc.displayGuiScreen((GuiScreen)Aurora.getInstance().clickGui);
        this.disable();
    }
    
    private void drawStringWithShadow(final String text, final int x, final int y, final int color) {
        if (ClickGuiModule.customFont.getValue()) {
            Aurora.fontRenderer.drawStringWithShadow(text, x, y, color);
        }
        else {
            ClickGuiModule.mc.fontRenderer.drawStringWithShadow(text, (float)x, (float)y, color);
        }
    }
}
