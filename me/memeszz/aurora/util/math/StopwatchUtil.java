//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.util.math;

public class StopwatchUtil
{
    private static long previousMS;
    
    public StopwatchUtil() {
        this.reset();
    }
    
    public static boolean hasCompleted(final long milliseconds) {
        return getCurrentMS() - StopwatchUtil.previousMS >= milliseconds;
    }
    
    public void reset() {
        StopwatchUtil.previousMS = getCurrentMS();
    }
    
    public long getPreviousMS() {
        return StopwatchUtil.previousMS;
    }
    
    public static long getCurrentMS() {
        return System.nanoTime() / 1000000L;
    }
}
