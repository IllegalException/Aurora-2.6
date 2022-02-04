//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.mixin.mixins;

import me.memeszz.aurora.mixin.accessor.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.client.renderer.entity.*;
import org.spongepowered.asm.mixin.gen.*;

@Mixin({ RenderManager.class })
public abstract class MixinRenderManager implements IRenderManager
{
    @Accessor
    public abstract double getRenderPosX();
    
    @Accessor
    public abstract double getRenderPosY();
    
    @Accessor
    public abstract double getRenderPosZ();
}
