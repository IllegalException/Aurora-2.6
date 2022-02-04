//Decomped By XeonLyfe
package team.stiff.pomelo.impl.annotated.handler;

import team.stiff.pomelo.filter.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;
import java.lang.reflect.*;
import java.util.*;
import team.stiff.pomelo.handler.*;

public final class MethodEventHandler implements EventHandler
{
    private final Object listenerParent;
    private final Method method;
    private final Set<EventFilter> eventFilters;
    private final Listener listenerAnnotation;
    
    public MethodEventHandler(final Object listenerParent, final Method method, final Set<EventFilter> eventFilters) {
        this.listenerParent = listenerParent;
        if (!method.isAccessible()) {
            method.setAccessible(true);
        }
        this.method = method;
        this.eventFilters = eventFilters;
        this.listenerAnnotation = method.getAnnotation(Listener.class);
    }
    
    public <E> void handle(final E event) {
        for (final EventFilter filter : this.eventFilters) {
            if (!filter.test((EventHandler)this, (Object)event)) {
                return;
            }
        }
        try {
            this.method.invoke(this.listenerParent, event);
        }
        catch (IllegalAccessException | InvocationTargetException ex2) {
            final ReflectiveOperationException ex;
            final ReflectiveOperationException exception = ex;
            exception.printStackTrace();
        }
    }
    
    public Object getListener() {
        return this.method;
    }
    
    public ListenerPriority getPriority() {
        return this.listenerAnnotation.priority();
    }
    
    public Iterable<EventFilter> getFilters() {
        return this.eventFilters;
    }
    
    public int compareTo(final EventHandler eventHandler) {
        return Integer.compare(eventHandler.getPriority().getPriorityLevel(), this.getPriority().getPriorityLevel());
    }
}
