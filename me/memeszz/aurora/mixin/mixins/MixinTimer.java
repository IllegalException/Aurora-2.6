//Decomped By XeonLyfe
package me.memeszz.aurora.mixin.mixins;

import me.memeszz.aurora.mixin.accessor.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.util.*;
import org.spongepowered.asm.mixin.gen.*;

@Mixin({ Timer.class })
public abstract class MixinTimer implements ITimer
{
    @Accessor
    public abstract void setTickLength(final float p0);
    
    @Accessor
    public abstract float getTickLength();
}
