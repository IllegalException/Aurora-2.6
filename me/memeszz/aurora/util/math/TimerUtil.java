//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.util.math;

public final class TimerUtil
{
    private long time;
    
    public TimerUtil() {
        this.time = -1L;
    }
    
    public boolean passed(final double ms) {
        return System.currentTimeMillis() - this.time >= ms;
    }
    
    public void reset() {
        this.time = System.currentTimeMillis();
    }
    
    public long getTime() {
        return this.time;
    }
    
    public void setTime(final long time) {
        this.time = time;
    }
}
