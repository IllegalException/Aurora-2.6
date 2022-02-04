//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.util.font;

import net.minecraft.client.*;
import me.memeszz.aurora.*;

public class FontUtils
{
    private static final Minecraft mc;
    
    public static float drawStringWithShadow(final boolean customFont, final String text, final int x, final int y, final int color) {
        if (customFont) {
            return Aurora.fontRenderer.drawStringWithShadow(text, (double)x, (double)y, color);
        }
        return (float)FontUtils.mc.fontRenderer.drawStringWithShadow(text, (float)x, (float)y, color);
    }
    
    public static float drawString(final boolean customFont, final String text, final int x, final int y, final int color) {
        if (customFont) {
            return Aurora.fontRenderer.drawString(text, (float)x, (float)y, color);
        }
        return (float)FontUtils.mc.fontRenderer.drawString(text, x, y, color);
    }
    
    public static int getStringWidth(final boolean customFont, final String str) {
        if (customFont) {
            return Aurora.fontRenderer.getStringWidth(str);
        }
        return FontUtils.mc.fontRenderer.getStringWidth(str);
    }
    
    public static int getFontHeight(final boolean customFont) {
        if (customFont) {
            return Aurora.fontRenderer.getHeight();
        }
        return FontUtils.mc.fontRenderer.FONT_HEIGHT;
    }
    
    static {
        mc = Minecraft.getMinecraft();
    }
}
