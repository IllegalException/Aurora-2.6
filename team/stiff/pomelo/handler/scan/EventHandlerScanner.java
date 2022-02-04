//Decomped By XeonLyfe
package team.stiff.pomelo.handler.scan;

import java.util.*;
import team.stiff.pomelo.handler.*;

public interface EventHandlerScanner
{
    Map<Class<?>, Set<EventHandler>> locate(final Object p0);
}
