//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.util.colour;

import me.memeszz.aurora.event.*;
import java.awt.*;

public class Rainbow
{
    public static int getInt() {
        return EventProcessor.INSTANCE.getRgb();
    }
    
    public static Color getColor() {
        return EventProcessor.INSTANCE.getC();
    }
    
    public static Color getColorWithOpacity(final int opacity) {
        return new Color(getColor().getRed(), getColor().getGreen(), getColor().getBlue(), opacity);
    }
    
    public static int getIntWithOpacity(final int opacity) {
        return getColorWithOpacity(opacity).getRGB();
    }
    
    public static int getRainbow(final int speed, final int offset, final float s) {
        float hue = (float)((System.currentTimeMillis() + offset) % speed);
        hue /= speed;
        return Color.getHSBColor(hue, s, 1.0f).getRGB();
    }
}
