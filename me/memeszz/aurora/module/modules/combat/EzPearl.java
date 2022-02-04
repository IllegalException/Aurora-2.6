//Decomped By XeonLyfe
package me.memeszz.aurora.module.modules.combat;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.event.events.*;
import me.memeszz.aurora.mixin.accessor.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;
import me.memeszz.aurora.util.*;
import net.minecraft.item.*;

public class EzPearl extends Module
{
    private int playerHotbarSlot;
    private int lastHotbarSlot;
    private int delay;
    
    public EzPearl() {
        super("EasyPearl", Module.Category.COMBAT, "Throws a pearl");
        this.playerHotbarSlot = -1;
        this.lastHotbarSlot = -1;
    }
    
    public void onEnable() {
        this.playerHotbarSlot = EzPearl.mc.player.inventory.currentItem;
        this.lastHotbarSlot = -1;
    }
    
    public void onDisable() {
        if (this.lastHotbarSlot != this.playerHotbarSlot && this.playerHotbarSlot != -1) {
            AutoTrap.mc.player.inventory.currentItem = this.playerHotbarSlot;
        }
        this.playerHotbarSlot = -1;
        this.lastHotbarSlot = -1;
        this.delay = 0;
    }
    
    @Listener
    public void onUpdate(final UpdateEvent event) {
        ++this.delay;
        final int pearlSlot = this.findPearlInHotbar();
        if (pearlSlot == -1) {
            this.disable();
        }
        if (this.lastHotbarSlot != pearlSlot) {
            EzPearl.mc.player.inventory.currentItem = pearlSlot;
            this.lastHotbarSlot = pearlSlot;
        }
        if (this.delay > 1) {
            ((IMinecraft)EzPearl.mc).clickMouse();
            this.delay = 0;
            this.toggle();
        }
    }
    
    private int findPearlInHotbar() {
        int slot = -1;
        for (int i = 0; i < 9; ++i) {
            final ItemStack stack = Wrapper.getPlayer().inventory.getStackInSlot(i);
            final Item item;
            if (stack != ItemStack.EMPTY && (item = stack.getItem()) instanceof ItemEnderPearl) {
                slot = i;
                break;
            }
        }
        return slot;
    }
}
