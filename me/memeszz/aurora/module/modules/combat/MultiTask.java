//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.module.modules.combat;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.event.events.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.util.math.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;

public class MultiTask extends Module
{
    public MultiTask() {
        super("MultiTask", Module.Category.COMBAT);
    }
    
    @Listener
    public void onUpdate(final UpdateEvent event) {
        if (MultiTask.mc.gameSettings.keyBindUseItem.isKeyDown() && MultiTask.mc.player.getActiveHand() == EnumHand.MAIN_HAND) {
            if (!(MultiTask.mc.player.getHeldItemOffhand().getItem() instanceof ItemBlock) && MultiTask.mc.player.getHeldItemOffhand().getItem() != Items.END_CRYSTAL) {
                if (MultiTask.mc.player.getHeldItemOffhand().getItem() instanceof ItemFood && MultiTask.mc.gameSettings.keyBindUseItem.isKeyDown() && MultiTask.mc.gameSettings.keyBindAttack.isKeyDown()) {
                    MultiTask.mc.player.setActiveHand(EnumHand.OFF_HAND);
                    final RayTraceResult r = MultiTask.mc.player.rayTrace(6.0, MultiTask.mc.getRenderPartialTicks());
                    MultiTask.mc.player.swingArm(EnumHand.MAIN_HAND);
                }
            }
            else {
                final RayTraceResult r = MultiTask.mc.player.rayTrace(6.0, MultiTask.mc.getRenderPartialTicks());
                MultiTask.mc.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(r.getBlockPos(), r.sideHit, EnumHand.OFF_HAND, 0.0f, 0.0f, 0.0f));
            }
        }
    }
}
