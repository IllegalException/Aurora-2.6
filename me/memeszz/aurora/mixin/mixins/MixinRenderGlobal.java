//Decomped By XeonLyfe
package me.memeszz.aurora.mixin.mixins;

import net.minecraft.client.renderer.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.entity.player.*;
import me.memeszz.aurora.module.*;
import me.memeszz.aurora.util.render.*;
import org.lwjgl.opengl.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import me.memeszz.aurora.module.modules.render.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ RenderGlobal.class })
public abstract class MixinRenderGlobal
{
    @Shadow
    private WorldClient world;
    
    @Overwrite
    public void drawSelectionBox(final EntityPlayer player, final RayTraceResult movingObjectPositionIn, final int execute, final float partialTicks) {
        if (ModuleManager.isModuleEnabled("BlockHighlight") && execute == 0 && movingObjectPositionIn.typeOfHit == RayTraceResult.Type.BLOCK) {
            RenderUtil.prepare(7);
            GL11.glEnable(2848);
            final BlockPos blockpos = movingObjectPositionIn.getBlockPos();
            final IBlockState iblockstate = this.world.getBlockState(blockpos);
            if (iblockstate.getMaterial() != Material.AIR && this.world.getWorldBorder().contains(blockpos)) {
                final double d3 = player.lastTickPosX + (player.posX - player.lastTickPosX) * partialTicks;
                final double d4 = player.lastTickPosY + (player.posY - player.lastTickPosY) * partialTicks;
                final double d5 = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * partialTicks;
                RenderGlobal.drawSelectionBoundingBox(iblockstate.getSelectedBoundingBox((World)this.world, blockpos).grow(0.0020000000949949026).offset(-d3, -d4, -d5), BlockHighlight.red.getValue() / 255.0f, BlockHighlight.green.getValue() / 255.0f, BlockHighlight.blue.getValue() / 255.0f, BlockHighlight.alpha.getValue() / 255.0f);
            }
            RenderUtil.release();
            GL11.glDisable(2848);
        }
    }
}
