//Decomped By XeonLyfe
package me.memeszz.aurora.mixin.mixins;

import net.minecraft.client.gui.inventory.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import me.memeszz.aurora.module.modules.render.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ GuiContainer.class })
public abstract class MixinGuiContainer
{
    @Shadow
    public int guiLeft;
    @Shadow
    public int guiTop;
    
    @Inject(method = { "drawScreen" }, at = { @At("HEAD") }, cancellable = true)
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks, final CallbackInfo ci) {
        ShulkerPreview.mouseX = mouseX;
        ShulkerPreview.mouseY = mouseY;
        ShulkerPreview.guiLeft = this.guiLeft;
        ShulkerPreview.guiTop = this.guiTop;
    }
}
