//Decomped By XeonLyfe
package team.stiff.pomelo.impl.annotated.handler.scan;

import java.util.function.*;
import java.lang.reflect.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;
import java.lang.annotation.*;

public final class AnnotatedListenerPredicate implements Predicate<Method>
{
    @Override
    public boolean test(final Method method) {
        return method.isAnnotationPresent((Class<? extends Annotation>)Listener.class) && method.getParameterCount() == 1;
    }
}
