//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.module.modules.gui;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;
import net.minecraft.client.gui.*;
import java.awt.*;
import me.memeszz.aurora.util.font.*;
import me.memeszz.aurora.util.*;
import net.minecraft.util.math.*;

public class Compass extends Module
{
    Setting.d scale;
    private static final double HALF_PI = 1.5707963267948966;
    ScaledResolution resolution;
    
    public Compass() {
        super("Compass", Module.Category.RENDER, "Draws A Compass On Ur Screen Thanks ForgeHax");
        this.resolution = new ScaledResolution(Compass.mc);
    }
    
    public void setup() {
        this.scale = this.registerD("Radius", 3.0, 1.0, 5.0);
    }
    
    public void onRender() {
        final double centerX = this.resolution.getScaledWidth() * 1.11;
        final double centerY = this.resolution.getScaledHeight_double() * 1.8;
        for (final Direction dir : Direction.values()) {
            final double rad = getPosOnCompass(dir);
            FontUtils.drawStringWithShadow(ClickGuiModule.customFont.getValue(), dir.name(), (int)(centerX + this.getX(rad)), (int)(centerY + this.getY(rad)), (dir == Direction.N) ? new Color(255, 0, 0, 255).getRGB() : new Color(255, 255, 255, 255).getRGB());
        }
    }
    
    private double getX(final double rad) {
        return Math.sin(rad) * (this.scale.getValue() * 10.0);
    }
    
    private double getY(final double rad) {
        final double epicPitch = MathHelper.clamp(Wrapper.getRenderEntity().rotationPitch + 30.0f, -90.0f, 90.0f);
        final double pitchRadians = Math.toRadians(epicPitch);
        return Math.cos(rad) * Math.sin(pitchRadians) * (this.scale.getValue() * 10.0);
    }
    
    private static double getPosOnCompass(final Direction dir) {
        final double yaw = Math.toRadians(MathHelper.wrapDegrees(Wrapper.getRenderEntity().rotationYaw));
        final int index = dir.ordinal();
        return yaw + index * 1.5707963267948966;
    }
    
    private enum Direction
    {
        N, 
        W, 
        S, 
        E;
    }
}
