//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.module.modules.world;

import me.memeszz.aurora.module.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.*;
import me.memeszz.aurora.event.events.*;
import net.minecraft.init.*;
import me.memeszz.aurora.util.*;
import java.util.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;

public class str2detect extends Module
{
    private final Set<EntityPlayer> str;
    public static final Minecraft mc;
    
    public str2detect() {
        super("StrengthDetect", Module.Category.WORLD, "Tells you in chat when someone has str 2/1");
        this.str = Collections.newSetFromMap(new WeakHashMap<EntityPlayer, Boolean>());
    }
    
    @Listener
    public void onUpdate(final UpdateEvent event) {
        for (final EntityPlayer player : str2detect.mc.world.playerEntities) {
            if (player.equals((Object)str2detect.mc.player)) {
                continue;
            }
            if (player.isPotionActive(MobEffects.STRENGTH) && !this.str.contains(player)) {
                Wrapper.sendClientMessage(player.getDisplayNameString() + " Has Strength");
                this.str.add(player);
            }
            if (!this.str.contains(player)) {
                continue;
            }
            if (player.isPotionActive(MobEffects.STRENGTH)) {
                continue;
            }
            Wrapper.sendClientMessage(player.getDisplayNameString() + " Has Ran Out Of Strength");
            this.str.remove(player);
        }
    }
    
    static {
        mc = Minecraft.getMinecraft();
    }
}
