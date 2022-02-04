//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.module.modules.gui;

import me.memeszz.aurora.setting.*;
import java.awt.*;
import me.memeszz.aurora.module.*;
import me.memeszz.aurora.util.font.*;
import net.minecraft.item.*;
import me.memeszz.aurora.util.*;

public class DurabiltyWarning extends Module
{
    private Setting.b rainbow;
    Setting.i x;
    Setting.i y;
    Setting.i red;
    Setting.i green;
    Setting.i blue;
    Setting.i threshold;
    ClickGuiModule mod;
    Color c;
    
    public DurabiltyWarning() {
        super("DurabiltyWarning", Module.Category.GUI, "Attacks nearby players");
        this.mod = (ClickGuiModule)ModuleManager.getModuleByName("ClickGuiModule");
        this.setDrawn(false);
    }
    
    public void setup() {
        this.threshold = this.registerI("Percent", 50, 0, 100);
        this.x = this.registerI("X", 255, 0, 960);
        this.y = this.registerI("Y", 255, 0, 530);
        this.red = this.registerI("Red", 255, 0, 255);
        this.green = this.registerI("Green", 255, 0, 255);
        this.blue = this.registerI("Blue", 255, 0, 255);
        this.rainbow = this.registerB("Rainbow", false);
    }
    
    public void onRender() {
        final float[] hue = { System.currentTimeMillis() % 11520L / 11520.0f };
        final int rgb = Color.HSBtoRGB(hue[0], 1.0f, 1.0f);
        final int r = rgb >> 16 & 0xFF;
        final int g = rgb >> 8 & 0xFF;
        final int b = rgb & 0xFF;
        if (this.shouldMend(0) || this.shouldMend(1) || this.shouldMend(2) || this.shouldMend(3)) {
            final String text = "Armor Durability Is Below " + this.threshold.getValue() + "%";
            final int divider = getScale();
            if (this.rainbow.getValue()) {
                FontUtils.drawStringWithShadow(ClickGuiModule.customFont.getValue(), text, this.x.getValue(), this.y.getValue(), new Color(r, g, b).getRGB());
            }
            else {
                FontUtils.drawStringWithShadow(ClickGuiModule.customFont.getValue(), text, this.x.getValue(), this.y.getValue(), new Color(this.red.getValue(), this.green.getValue(), this.blue.getValue()).getRGB());
            }
        }
    }
    
    private boolean shouldMend(final int i) {
        return ((ItemStack)DurabiltyWarning.mc.player.inventory.armorInventory.get(i)).getMaxDamage() != 0 && 100 * ((ItemStack)DurabiltyWarning.mc.player.inventory.armorInventory.get(i)).getItemDamage() / ((ItemStack)DurabiltyWarning.mc.player.inventory.armorInventory.get(i)).getMaxDamage() > reverseNumber(this.threshold.getValue(), 1, 100);
    }
    
    public static int reverseNumber(final int num, final int min, final int max) {
        return max + min - num;
    }
    
    public static int getScale() {
        int scaleFactor = 0;
        int scale = Wrapper.getMinecraft().gameSettings.guiScale;
        if (scale == 0) {
            scale = 1000;
        }
        while (scaleFactor < scale && Wrapper.getMinecraft().displayWidth / (scaleFactor + 1) >= 320 && Wrapper.getMinecraft().displayHeight / (scaleFactor + 1) >= 240) {
            ++scaleFactor;
        }
        if (scaleFactor == 0) {
            scaleFactor = 1;
        }
        return scaleFactor;
    }
}
