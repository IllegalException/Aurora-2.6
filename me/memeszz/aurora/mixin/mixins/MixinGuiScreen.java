//Decomped By XeonLyfe
package me.memeszz.aurora.mixin.mixins;

import net.minecraft.client.gui.*;
import net.minecraft.client.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import me.memeszz.aurora.module.*;
import net.minecraft.item.*;
import me.memeszz.aurora.module.modules.render.*;
import org.lwjgl.input.*;
import net.minecraft.nbt.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(value = { GuiScreen.class }, priority = 9999)
public abstract class MixinGuiScreen
{
    @Shadow
    public Minecraft mc;
    
    @Inject(method = { "renderToolTip" }, at = { @At("HEAD") }, cancellable = true)
    public void renderToolTip(final ItemStack is, final int x, final int y, final CallbackInfo ci) {
        if (ModuleManager.isModuleEnabled("ShulkerPreview") && is.getItem() instanceof ItemShulkerBox) {
            final NBTTagCompound tagCompound = is.getTagCompound();
            if (tagCompound != null && tagCompound.hasKey("BlockEntityTag", 10)) {
                final NBTTagCompound blockEntityTag = tagCompound.getCompoundTag("BlockEntityTag");
                if (blockEntityTag.hasKey("Items", 9)) {
                    ci.cancel();
                    ShulkerPreview.nbt = blockEntityTag;
                    ShulkerPreview.itemStack = is;
                    ShulkerPreview.active = true;
                    if (!(ShulkerPreview.pinned = Keyboard.isKeyDown(42))) {
                        ShulkerPreview.drawX = x;
                        ShulkerPreview.drawY = y;
                    }
                }
            }
        }
    }
}
