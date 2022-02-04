//Decomped By XeonLyfe
package team.stiff.pomelo.filter;

import team.stiff.pomelo.handler.*;

public interface EventFilter<E>
{
    boolean test(final EventHandler p0, final E p1);
}
