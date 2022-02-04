//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.mixin.accessor;

import net.minecraft.item.*;

public interface IItemRenderer
{
    float getPrevEquippedProgressMainHand();
    
    void setEquippedProgressMainHand(final float p0);
    
    float getPrevEquippedProgressOffHand();
    
    void setEquippedProgressOffHand(final float p0);
    
    void setItemStackMainHand(final ItemStack p0);
    
    void setItemStackOffHand(final ItemStack p0);
}
