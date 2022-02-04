//Decomped By XeonLyfe
package team.stiff.pomelo.handler;

import team.stiff.pomelo.filter.*;

public interface EventHandler extends Comparable<EventHandler>
{
     <E> void handle(final E p0);
    
    Object getListener();
    
    ListenerPriority getPriority();
    
    Iterable<EventFilter> getFilters();
}
