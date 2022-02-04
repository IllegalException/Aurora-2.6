//Decomped By XeonLyfe
package team.stiff.pomelo.impl.annotated.filter;

import java.lang.reflect.*;
import team.stiff.pomelo.filter.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;
import java.lang.annotation.*;
import java.util.*;

public final class MethodFilterScanner implements EventFilterScanner<Method>
{
    public Set<EventFilter> scan(final Method listener) {
        if (!listener.isAnnotationPresent(Listener.class)) {
            return Collections.emptySet();
        }
        final Set<EventFilter> filters = new HashSet<EventFilter>();
        for (final Class<? extends EventFilter> filter : listener.getDeclaredAnnotation(Listener.class).filters()) {
            try {
                filters.add((EventFilter)filter.newInstance());
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return filters;
    }
}
