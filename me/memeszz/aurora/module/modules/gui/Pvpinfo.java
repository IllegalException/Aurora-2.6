//Decomped By XeonLyfe
package me.memeszz.aurora.module.modules.gui;

import me.memeszz.aurora.setting.*;
import net.minecraft.item.*;
import java.util.function.*;
import net.minecraft.init.*;
import me.memeszz.aurora.util.colour.*;
import me.memeszz.aurora.util.font.*;
import me.memeszz.aurora.*;
import me.memeszz.aurora.module.*;

public class Pvpinfo extends Module
{
    int c;
    Setting.i x;
    Setting.i y;
    Setting.b totems;
    
    public Pvpinfo() {
        super("PvPInfo", Module.Category.GUI);
        this.setDrawn(false);
    }
    
    public void setup() {
        this.x = this.registerI("X", 900, 0, 1920);
        this.y = this.registerI("Y", 500, 0, 1080);
        this.totems = this.registerB("Totems", true);
    }
    
    public static int getItems(final Item i) {
        return Pvpinfo.mc.player.inventory.mainInventory.stream().filter(itemStack -> itemStack.getItem() == i).mapToInt(ItemStack::getCount).sum() + Pvpinfo.mc.player.inventory.offHandInventory.stream().filter(itemStack -> itemStack.getItem() == i).mapToInt(ItemStack::getCount).sum();
    }
    
    public String getTotemsStr() {
        return String.valueOf(getItems(Items.TOTEM_OF_UNDYING));
    }
    
    public int getTotems() {
        return getItems(Items.TOTEM_OF_UNDYING);
    }
    
    public void onRender() {
        if (Pvpinfo.mc.player == null || Pvpinfo.mc.world == null) {
            return;
        }
        this.c = Rainbow.getRainbow(3000, 1000, 0.75f);
        FontUtils.drawString(true, "aurora", this.x.getValue(), this.y.getValue() - 30, this.c);
        int totemColor;
        if (this.getTotems() < 1) {
            totemColor = 16711680;
        }
        else {
            totemColor = 65280;
        }
        if (this.totems.getValue()) {
            Aurora.skeetFont.drawStringWithShadow(this.getTotemsStr(), this.x.getValue(), this.y.getValue(), totemColor);
        }
        final int enabledC = 65280;
        final int disabledC = 16711680;
        if (ModuleManager.getModuleByName("CrystalAura").isEnabled()) {
            Aurora.skeetFont.drawStringWithShadow("CA", this.x.getValue(), this.y.getValue() + 10, enabledC);
        }
        else {
            Aurora.skeetFont.drawStringWithShadow("CA", this.x.getValue(), this.y.getValue() + 10, disabledC);
        }
        if (ModuleManager.getModuleByName("AutoTrap").isEnabled()) {
            Aurora.skeetFont.drawStringWithShadow("AT", this.x.getValue(), this.y.getValue() + 20, enabledC);
        }
        else {
            Aurora.skeetFont.drawStringWithShadow("AT", this.x.getValue(), this.y.getValue() + 20, disabledC);
        }
        if (ModuleManager.getModuleByName("Surround").isEnabled()) {
            Aurora.skeetFont.drawStringWithShadow("SD", this.x.getValue(), this.y.getValue() - 10, enabledC);
        }
        else {
            Aurora.skeetFont.drawStringWithShadow("SD", this.x.getValue(), this.y.getValue() - 10, disabledC);
        }
        if (ModuleManager.getModuleByName("KillAura").isEnabled()) {
            Aurora.skeetFont.drawStringWithShadow("KA", this.x.getValue(), this.y.getValue() - 20, enabledC);
        }
        else {
            Aurora.skeetFont.drawStringWithShadow("KA", this.x.getValue(), this.y.getValue() - 20, disabledC);
        }
    }
}
