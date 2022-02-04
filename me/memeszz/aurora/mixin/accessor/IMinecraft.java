//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.mixin.accessor;

import net.minecraft.util.*;
import net.minecraft.client.multiplayer.*;

public interface IMinecraft
{
    Timer getTimer();
    
    void setSession(final Session p0);
    
    Session getSession();
    
    void setRightClickDelayTimer(final int p0);
    
    void clickMouse();
    
    ServerData getCurrentServerData();
}
