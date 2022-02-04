//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.module.modules.combat;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;
import me.memeszz.aurora.util.math.*;
import me.memeszz.aurora.event.events.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.inventory.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.enchantment.*;

public class AutoArmour extends Module
{
    Setting.b curse;
    Setting.i delay;
    private final TimerUtil timer;
    
    public AutoArmour() {
        super("AutoArmour", Module.Category.COMBAT, "Puts on armor");
        this.timer = new TimerUtil();
    }
    
    public void setup() {
        this.delay = this.registerI("Delay", 50, 0, 1000);
        this.curse = this.registerB("Cursed", false);
    }
    
    @Listener
    public void onUpdate(final UpdateEvent event) {
        final Minecraft mc = Minecraft.getMinecraft();
        if (mc.currentScreen instanceof GuiInventory) {
            return;
        }
        final ItemStack helm = mc.player.inventoryContainer.getSlot(5).getStack();
        if (helm.getItem() == Items.AIR) {
            final int slot = this.findArmorSlot(EntityEquipmentSlot.HEAD);
            if (slot != -1) {
                this.clickSlot(slot);
            }
        }
        final ItemStack chest = mc.player.inventoryContainer.getSlot(6).getStack();
        if (chest.getItem() == Items.AIR) {
            final int slot2 = this.findArmorSlot(EntityEquipmentSlot.CHEST);
            if (slot2 != -1) {
                this.clickSlot(slot2);
            }
        }
        final ItemStack legging = mc.player.inventoryContainer.getSlot(7).getStack();
        if (legging.getItem() == Items.AIR) {
            final int slot3 = this.findArmorSlot(EntityEquipmentSlot.LEGS);
            if (slot3 != -1) {
                this.clickSlot(slot3);
            }
        }
        final ItemStack feet = mc.player.inventoryContainer.getSlot(8).getStack();
        if (feet.getItem() == Items.AIR) {
            final int slot4 = this.findArmorSlot(EntityEquipmentSlot.FEET);
            if (slot4 != -1) {
                this.clickSlot(slot4);
            }
        }
    }
    
    private void clickSlot(final int slot) {
        if (this.timer.passed(this.delay.getValue())) {
            Minecraft.getMinecraft().playerController.windowClick(Minecraft.getMinecraft().player.inventoryContainer.windowId, slot, 0, ClickType.QUICK_MOVE, (EntityPlayer)Minecraft.getMinecraft().player);
            this.timer.reset();
        }
    }
    
    private int findArmorSlot(final EntityEquipmentSlot type) {
        int slot = -1;
        float damage = 0.0f;
        for (int i = 9; i < 45; ++i) {
            final ItemStack s = Minecraft.getMinecraft().player.inventoryContainer.getSlot(i).getStack();
            if (s.getItem() != Items.AIR && s.getItem() instanceof ItemArmor) {
                final ItemArmor armor = (ItemArmor)s.getItem();
                if (armor.armorType == type) {
                    final float currentDamage = (float)(armor.damageReduceAmount + EnchantmentHelper.getEnchantmentLevel(Enchantments.PROTECTION, s));
                    final boolean cursed = this.curse.getValue() && EnchantmentHelper.hasBindingCurse(s);
                    if (currentDamage > damage && !cursed) {
                        damage = currentDamage;
                        slot = i;
                    }
                }
            }
        }
        return slot;
    }
}
