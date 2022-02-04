//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package team.stiff.pomelo.impl.annotated.dispatch;

import team.stiff.pomelo.dispatch.*;
import team.stiff.pomelo.handler.*;
import java.util.*;

public final class MethodEventDispatcher implements EventDispatcher
{
    private final Map<Class<?>, Set<EventHandler>> eventHandlers;
    
    public MethodEventDispatcher(final Map<Class<?>, Set<EventHandler>> eventHandlers) {
        this.eventHandlers = eventHandlers;
    }
    
    public <E> void dispatch(final E event) {
        for (final EventHandler eventHandler : this.eventHandlers.getOrDefault(event.getClass(), Collections.emptySet())) {
            eventHandler.handle((Object)event);
        }
    }
}
