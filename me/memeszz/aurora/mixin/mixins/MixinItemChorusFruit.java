//Decomped By XeonLyfe
package me.memeszz.aurora.mixin.mixins;

import org.spongepowered.asm.mixin.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import me.memeszz.aurora.event.events.*;
import me.memeszz.aurora.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(value = { ItemChorusFruit.class }, priority = 29999)
public abstract class MixinItemChorusFruit
{
    @Inject(method = { "onItemUseFinish" }, at = { @At("HEAD") }, cancellable = true)
    public void onUpdate(final ItemStack stack, final World worldIn, final EntityLivingBase entityLiving, final CallbackInfoReturnable<ItemStack> cir) {
        final EventChorusTeleport event = new EventChorusTeleport();
        Aurora.getInstance().getEventManager().dispatchEvent((Object)event);
    }
}
