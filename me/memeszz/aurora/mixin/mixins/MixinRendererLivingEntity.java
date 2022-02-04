//Decomped By XeonLyfe
package me.memeszz.aurora.mixin.mixins;

import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import me.memeszz.aurora.module.*;
import org.lwjgl.opengl.*;
import me.memeszz.aurora.module.modules.render.*;
import net.minecraft.client.renderer.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ RenderLivingBase.class })
public abstract class MixinRendererLivingEntity<T extends EntityLivingBase> extends Render<T>
{
    @Shadow
    protected ModelBase mainModel;
    
    protected MixinRendererLivingEntity() {
        super((RenderManager)null);
    }
    
    @Shadow
    protected abstract boolean isVisible(final EntityLivingBase p0);
    
    @Overwrite
    protected void renderModel(final EntityLivingBase entitylivingbaseIn, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scaleFactor) {
        final boolean flag = this.isVisible(entitylivingbaseIn);
        final boolean flag2 = !flag && !entitylivingbaseIn.isInvisibleToPlayer((EntityPlayer)Minecraft.getMinecraft().player);
        if (flag || flag2) {
            if (!this.bindEntityTexture((Entity)entitylivingbaseIn)) {
                return;
            }
            if (flag2) {
                GlStateManager.enableBlendProfile(GlStateManager.Profile.TRANSPARENT_MODEL);
            }
            if (ModuleManager.isModuleEnabled("Chams") && entitylivingbaseIn != Minecraft.getMinecraft().player) {
                GL11.glEnable(2848);
                GL11.glPushAttrib(1048575);
                GL11.glDisable(3008);
                GL11.glDisable(3553);
                GL11.glDisable(2896);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                GL11.glDepthMask(false);
                GL11.glLineWidth((float)Chams.width.getValue());
                GL11.glEnable(2960);
                GL11.glClear(1024);
                GL11.glClearStencil(15);
                GL11.glStencilFunc(512, 1, 15);
                GL11.glStencilOp(7681, 7681, 7681);
                GL11.glPolygonMode(1028, 6913);
                GL11.glStencilFunc(512, 0, 15);
                GL11.glStencilOp(7681, 7681, 7681);
                GL11.glPolygonMode(1028, 6914);
                GL11.glStencilFunc(514, 1, 15);
                GL11.glStencilOp(7680, 7680, 7680);
                GL11.glPolygonMode(1028, 6913);
                GL11.glDisable(2929);
                GL11.glDepthMask(false);
                GL11.glEnable(10754);
                OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
                GL11.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
                GL11.glColor4d((double)(Chams.red.getValue() / 255.0f), (double)(Chams.green.getValue() / 255.0f), (double)(Chams.blue.getValue() / 255.0f), (double)(Chams.alpha.getValue() / 255.0f));
                this.mainModel.render((Entity)entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
                GL11.glEnable(2929);
                GL11.glDepthMask(true);
                GL11.glColor4d((double)(Chams.invisRed.getValue() / 255.0f), (double)(Chams.invisGreen.getValue() / 255.0f), (double)(Chams.invisBlue.getValue() / 255.0f), (double)(Chams.invisAlpha.getValue() / 255.0f));
                this.mainModel.render((Entity)entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
                GL11.glEnable(3042);
                GL11.glEnable(2896);
                GL11.glEnable(3553);
                GL11.glEnable(3008);
                GL11.glPopAttrib();
                GL11.glDisable(2848);
            }
            else {
                this.mainModel.render((Entity)entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
            }
            if (flag2) {
                GlStateManager.disableBlendProfile(GlStateManager.Profile.TRANSPARENT_MODEL);
            }
        }
    }
}
