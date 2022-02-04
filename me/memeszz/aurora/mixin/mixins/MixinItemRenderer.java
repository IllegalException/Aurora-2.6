//Decomped By XeonLyfe
package me.memeszz.aurora.mixin.mixins;

import me.memeszz.aurora.mixin.accessor.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.client.renderer.*;
import org.spongepowered.asm.mixin.gen.*;
import net.minecraft.item.*;

@Mixin({ ItemRenderer.class })
public abstract class MixinItemRenderer implements IItemRenderer
{
    @Accessor
    public abstract float getPrevEquippedProgressMainHand();
    
    @Accessor
    public abstract void setEquippedProgressMainHand(final float p0);
    
    @Accessor
    public abstract float getPrevEquippedProgressOffHand();
    
    @Accessor
    public abstract void setEquippedProgressOffHand(final float p0);
    
    @Accessor
    public abstract void setItemStackMainHand(final ItemStack p0);
    
    @Accessor
    public abstract void setItemStackOffHand(final ItemStack p0);
}
