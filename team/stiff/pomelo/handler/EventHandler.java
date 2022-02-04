//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package team.stiff.pomelo.handler;

import team.stiff.pomelo.filter.*;

public interface EventHandler extends Comparable<EventHandler>
{
     <E> void handle(final E p0);
    
    Object getListener();
    
    ListenerPriority getPriority();
    
    Iterable<EventFilter> getFilters();
}
