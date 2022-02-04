//Decomped By XeonLyfe
package me.memeszz.aurora.module.modules.combat;

import me.memeszz.aurora.setting.*;
import me.memeszz.aurora.module.*;
import me.memeszz.aurora.util.*;
import me.memeszz.aurora.event.events.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import java.util.function.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.entity.player.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;
import me.memeszz.aurora.util.friends.*;
import net.minecraft.entity.*;
import net.minecraft.inventory.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.item.*;

public class OffHandCrystal extends Module
{
    Setting.b crystalCheck;
    Setting.b totemdisable;
    Setting.d health;
    Setting.b announceUsage2;
    Setting.d enemyRange;
    Setting.b smart;
    public int crystals;
    
    public OffHandCrystal() {
        super("OffHandCrystal", Module.Category.COMBAT, "Attacks nearby players");
    }
    
    public void setup() {
        this.announceUsage2 = this.registerB("Chat", true);
        this.totemdisable = this.registerB("TotemDisable", true);
        this.health = this.registerD("Health", 13.0, 1.0, 36.0);
        this.crystalCheck = this.registerB("CrystalCheck", false);
        this.enemyRange = this.registerD("EnemyRange", 10.0, 1.0, 50.0);
        this.smart = this.registerB("Smart", false);
    }
    
    public void onEnable() {
        if (this.totemdisable.getValue()) {
            ModuleManager.getModuleByName("AutoTotem").disable();
        }
        if (this.announceUsage2.getValue()) {
            Wrapper.sendClientMessage("�aOffHandCrystal Enabled");
        }
    }
    
    public void onDisable() {
        if (this.totemdisable.getValue()) {
            ModuleManager.getModuleByName("AutoTotem").enable();
        }
        if (this.announceUsage2.getValue()) {
            Wrapper.sendClientMessage("�cOffHandCrystal Disabled");
        }
    }
    
    @Listener
    public void onUpdate(final UpdateEvent event) {
        this.crystals = OffHandCrystal.mc.player.inventory.mainInventory.stream().filter(itemStack -> itemStack.getItem() == Items.END_CRYSTAL).mapToInt(ItemStack::getCount).sum();
        if (OffHandCrystal.mc.currentScreen instanceof GuiContainer || OffHandCrystal.mc.world == null || OffHandCrystal.mc.player == null) {
            return;
        }
        if (!this.shouldTotem()) {
            if (OffHandCrystal.mc.player.getHeldItemOffhand() == ItemStack.EMPTY || OffHandCrystal.mc.player.getHeldItemOffhand().getItem() != Items.END_CRYSTAL) {
                final int slot = (this.getCrystalSlot() < 9) ? (this.getCrystalSlot() + 36) : this.getCrystalSlot();
                if (this.getCrystalSlot() != -1) {
                    OffHandCrystal.mc.playerController.windowClick(0, slot, 0, ClickType.PICKUP, (EntityPlayer)OffHandCrystal.mc.player);
                    OffHandCrystal.mc.playerController.windowClick(0, 45, 0, ClickType.PICKUP, (EntityPlayer)OffHandCrystal.mc.player);
                    OffHandCrystal.mc.playerController.windowClick(0, slot, 0, ClickType.PICKUP, (EntityPlayer)OffHandCrystal.mc.player);
                }
            }
        }
        else if (OffHandCrystal.mc.player.getHeldItemOffhand() == ItemStack.EMPTY || OffHandCrystal.mc.player.getHeldItemOffhand().getItem() != Items.TOTEM_OF_UNDYING) {
            final int slot = (this.getTotemSlot() < 9) ? (this.getTotemSlot() + 36) : this.getTotemSlot();
            if (this.getTotemSlot() != -1) {
                OffHandCrystal.mc.playerController.windowClick(0, slot, 0, ClickType.PICKUP, (EntityPlayer)OffHandCrystal.mc.player);
                OffHandCrystal.mc.playerController.windowClick(0, 45, 0, ClickType.PICKUP, (EntityPlayer)OffHandCrystal.mc.player);
                OffHandCrystal.mc.playerController.windowClick(0, slot, 0, ClickType.PICKUP, (EntityPlayer)OffHandCrystal.mc.player);
            }
        }
    }
    
    private boolean nearPlayers() {
        return OffHandCrystal.mc.world.playerEntities.stream().anyMatch(e -> e != OffHandCrystal.mc.player && ((EntityPlayer)e).getEntityId() != -1488 && !Friends.isFriend(((EntityPlayer)e).getName()) && OffHandCrystal.mc.player.getDistance((Entity)e) <= this.enemyRange.getValue());
    }
    
    private boolean shouldTotem() {
        if (OffHandCrystal.mc.player != null) {
            return OffHandCrystal.mc.player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == Items.ELYTRA || !this.nearPlayers() || OffHandCrystal.mc.player.getHealth() + OffHandCrystal.mc.player.getAbsorptionAmount() <= this.health.getValue() || (this.crystalCheck.getValue() && !this.isCrystalsAABBEmpty()) || (this.smart.getValue() && AutoCrystal.target == null);
        }
        return OffHandCrystal.mc.player.getHealth() + OffHandCrystal.mc.player.getAbsorptionAmount() <= this.health.getValue() || OffHandCrystal.mc.player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == Items.ELYTRA || !this.nearPlayers() || (this.crystalCheck.getValue() && !this.isCrystalsAABBEmpty()) || (this.smart.getValue() && AutoCrystal.target == null);
    }
    
    private boolean isEmpty(final BlockPos pos) {
        return OffHandCrystal.mc.world.getEntitiesWithinAABBExcludingEntity((Entity)null, new AxisAlignedBB(pos)).stream().filter(e -> e instanceof EntityEnderCrystal).count() == 0L;
    }
    
    private boolean isCrystalsAABBEmpty() {
        return this.isEmpty(OffHandCrystal.mc.player.getPosition().add(1, 0, 0)) && this.isEmpty(OffHandCrystal.mc.player.getPosition().add(-1, 0, 0)) && this.isEmpty(OffHandCrystal.mc.player.getPosition().add(0, 0, 1)) && this.isEmpty(OffHandCrystal.mc.player.getPosition().add(0, 0, -1)) && this.isEmpty(OffHandCrystal.mc.player.getPosition());
    }
    
    int getCrystalSlot() {
        int crystalSlot = -1;
        for (int i = 45; i > 0; --i) {
            if (OffHandCrystal.mc.player.inventory.getStackInSlot(i).getItem() == Items.END_CRYSTAL) {
                crystalSlot = i;
                break;
            }
        }
        return crystalSlot;
    }
    
    int getTotemSlot() {
        int totemSlot = -1;
        for (int i = 45; i > 0; --i) {
            if (OffHandCrystal.mc.player.inventory.getStackInSlot(i).getItem() == Items.TOTEM_OF_UNDYING) {
                totemSlot = i;
                break;
            }
        }
        return totemSlot;
    }
    
    public String getHudInfo() {
        return "�7[�f" + this.crystals + "�7]";
    }
}
