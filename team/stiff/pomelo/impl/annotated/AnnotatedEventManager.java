//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package team.stiff.pomelo.impl.annotated;

import team.stiff.pomelo.*;
import team.stiff.pomelo.handler.scan.*;
import team.stiff.pomelo.dispatch.*;
import team.stiff.pomelo.impl.annotated.handler.scan.*;
import java.util.concurrent.*;
import team.stiff.pomelo.impl.annotated.dispatch.*;
import java.util.*;
import team.stiff.pomelo.handler.*;

public final class AnnotatedEventManager implements EventManager
{
    private final EventHandlerScanner eventHandlerScanner;
    private final Map<Object, EventDispatcher> listenerDispatchers;
    
    public AnnotatedEventManager() {
        this.eventHandlerScanner = (EventHandlerScanner)new MethodHandlerScanner();
        this.listenerDispatchers = new ConcurrentHashMap<Object, EventDispatcher>();
    }
    
    public <E> E dispatchEvent(final E event) {
        for (final EventDispatcher dispatcher : this.listenerDispatchers.values()) {
            dispatcher.dispatch((Object)event);
        }
        return event;
    }
    
    public boolean isRegisteredListener(final Object listener) {
        return this.listenerDispatchers.containsKey(listener);
    }
    
    public boolean addEventListener(final Object listenerContainer) {
        if (this.listenerDispatchers.containsKey(listenerContainer)) {
            return false;
        }
        final Map<Class<?>, Set<EventHandler>> eventHandlers = (Map<Class<?>, Set<EventHandler>>)this.eventHandlerScanner.locate(listenerContainer);
        return !eventHandlers.isEmpty() && this.listenerDispatchers.put(listenerContainer, (EventDispatcher)new MethodEventDispatcher(eventHandlers)) == null;
    }
    
    public boolean removeEventListener(final Object listenerContainer) {
        return this.listenerDispatchers.remove(listenerContainer) != null;
    }
}
