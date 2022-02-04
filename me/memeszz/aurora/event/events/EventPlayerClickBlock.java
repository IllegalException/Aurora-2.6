//Decomped By XeonLyfe
package me.memeszz.aurora.event.events;

import me.memeszz.aurora.event.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;

public class EventPlayerClickBlock extends EventCancellable
{
    public BlockPos Location;
    public EnumFacing Facing;
    
    public EventPlayerClickBlock(final BlockPos loc, final EnumFacing face) {
        this.Location = loc;
        this.Facing = face;
    }
}
