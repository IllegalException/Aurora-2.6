//Decomped By XeonLyfe
package me.memeszz.aurora.mixin.mixins;

import net.minecraft.entity.player.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.world.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.client.*;
import me.memeszz.aurora.*;
import org.spongepowered.asm.mixin.injection.*;
import me.memeszz.aurora.event.events.*;
import net.minecraft.entity.*;

@Mixin({ EntityPlayer.class })
public abstract class MixinEntityPlayer extends EntityLivingBase
{
    @Shadow
    public abstract String getName();
    
    public MixinEntityPlayer(final World worldIn) {
        super(worldIn);
    }
    
    @Inject(method = { "jump" }, at = { @At("HEAD") }, cancellable = true)
    public void onJump(final CallbackInfo ci) {
        if (Minecraft.getMinecraft().player.getName() == this.getName()) {
            Aurora.getInstance().getEventManager().dispatchEvent((Object)new PlayerJumpEvent());
        }
    }
    
    @Inject(method = { "travel" }, at = { @At("HEAD") }, cancellable = true)
    public void travel(final float strafe, final float vertical, final float forward, final CallbackInfo info) {
        final EventPlayerTravel event = new EventPlayerTravel(strafe, vertical, forward);
        Aurora.getInstance().getEventManager().dispatchEvent((Object)new EventPlayerTravel(strafe, vertical, forward));
        if (event.isCanceled()) {
            this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
            info.cancel();
        }
    }
}
