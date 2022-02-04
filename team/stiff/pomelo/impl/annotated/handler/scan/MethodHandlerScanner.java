//Decomped By XeonLyfe
package team.stiff.pomelo.impl.annotated.handler.scan;

import team.stiff.pomelo.handler.scan.*;
import team.stiff.pomelo.filter.*;
import java.lang.reflect.*;
import team.stiff.pomelo.impl.annotated.filter.*;
import team.stiff.pomelo.handler.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.*;
import team.stiff.pomelo.impl.annotated.handler.*;

public final class MethodHandlerScanner implements EventHandlerScanner
{
    private final AnnotatedListenerPredicate annotatedListenerPredicate;
    private final EventFilterScanner<Method> filterScanner;
    
    public MethodHandlerScanner() {
        this.annotatedListenerPredicate = new AnnotatedListenerPredicate();
        this.filterScanner = (EventFilterScanner<Method>)new MethodFilterScanner();
    }
    
    public Map<Class<?>, Set<EventHandler>> locate(final Object listenerContainer) {
        final Map<Class<?>, Set<EventHandler>> eventHandlers = new HashMap<Class<?>, Set<EventHandler>>();
        Stream.of(listenerContainer.getClass().getDeclaredMethods()).filter((Predicate<? super Method>)this.annotatedListenerPredicate).forEach(method -> eventHandlers.computeIfAbsent(method.getParameterTypes()[0], obj -> new TreeSet()).add((EventHandler)new MethodEventHandler(listenerContainer, method, this.filterScanner.scan((Object)method))));
        return eventHandlers;
    }
}
