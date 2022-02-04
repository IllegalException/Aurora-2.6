//Decomped By XeonLyfe
package team.stiff.pomelo.impl.annotated.handler.annotation;

import java.lang.annotation.*;
import team.stiff.pomelo.filter.*;
import team.stiff.pomelo.handler.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface Listener {
    Class<? extends EventFilter>[] filters() default {};
    
    ListenerPriority priority() default ListenerPriority.NORMAL;
}
