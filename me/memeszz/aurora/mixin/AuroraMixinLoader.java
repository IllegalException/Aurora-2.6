//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.mixin;

import net.minecraftforge.fml.relauncher.*;
import me.memeszz.aurora.*;
import org.spongepowered.asm.launch.*;
import org.spongepowered.asm.mixin.*;
import javax.annotation.*;
import java.util.*;

public class AuroraMixinLoader implements IFMLLoadingPlugin
{
    private static boolean isObfuscatedEnvironment;
    
    public AuroraMixinLoader() {
        Aurora.log.info("Aurora mixins initialized");
        MixinBootstrap.init();
        Mixins.addConfiguration("mixins.aurora.json");
        MixinEnvironment.getDefaultEnvironment().setObfuscationContext("searge");
        Aurora.log.info(MixinEnvironment.getDefaultEnvironment().getObfuscationContext());
    }
    
    public String[] getASMTransformerClass() {
        return new String[0];
    }
    
    public String getModContainerClass() {
        return null;
    }
    
    @Nullable
    public String getSetupClass() {
        return null;
    }
    
    public void injectData(final Map<String, Object> data) {
        AuroraMixinLoader.isObfuscatedEnvironment = data.get("runtimeDeobfuscationEnabled");
    }
    
    public String getAccessTransformerClass() {
        return null;
    }
    
    static {
        AuroraMixinLoader.isObfuscatedEnvironment = false;
    }
}
