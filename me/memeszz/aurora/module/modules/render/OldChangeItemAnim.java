//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.module.modules.render;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.event.events.*;
import me.memeszz.aurora.mixin.accessor.*;
import net.minecraft.util.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;

public class OldChangeItemAnim extends Module
{
    public OldChangeItemAnim() {
        super("ItemAnim", Module.Category.RENDER);
    }
    
    @Listener
    public void onUpdate(final UpdateEvent event) {
        if (((IItemRenderer)OldChangeItemAnim.mc.entityRenderer.itemRenderer).getPrevEquippedProgressMainHand() >= 0.9) {
            ((IItemRenderer)OldChangeItemAnim.mc.entityRenderer.itemRenderer).setEquippedProgressMainHand(1.0f);
            ((IItemRenderer)OldChangeItemAnim.mc.entityRenderer.itemRenderer).setItemStackMainHand(OldChangeItemAnim.mc.player.getHeldItem(EnumHand.MAIN_HAND));
        }
        if (((IItemRenderer)OldChangeItemAnim.mc.entityRenderer.itemRenderer).getPrevEquippedProgressOffHand() >= 0.9) {
            ((IItemRenderer)OldChangeItemAnim.mc.entityRenderer.itemRenderer).setEquippedProgressOffHand(1.0f);
            ((IItemRenderer)OldChangeItemAnim.mc.entityRenderer.itemRenderer).setItemStackOffHand(OldChangeItemAnim.mc.player.getHeldItem(EnumHand.OFF_HAND));
        }
    }
}
