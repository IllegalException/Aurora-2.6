//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.module.modules.player;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;
import java.util.*;
import me.memeszz.aurora.event.events.*;
import me.memeszz.aurora.mixin.accessor.*;
import net.minecraft.client.entity.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;

public class FastWebFall extends Module
{
    Setting.mode mode;
    Setting.d speedDown;
    
    public FastWebFall() {
        super("FastFallWeb", Module.Category.PLAYER);
    }
    
    public void setup() {
        final ArrayList<String> modes = new ArrayList<String>();
        modes.add("2b");
        modes.add("Non2b");
        this.mode = this.registerMode("Mode", (List)modes, "2b");
    }
    
    @Listener
    public void onUpdate(final UpdateEvent event) {
        if (((IEntity)FastWebFall.mc.player).getIsInWeb()) {
            if (this.mode.getValue().equalsIgnoreCase("non2b")) {
                for (int i = 0; i < 15; ++i) {
                    final EntityPlayerSP player = FastWebFall.mc.player;
                    --player.motionY;
                }
            }
            if (this.mode.getValue().equalsIgnoreCase("2b")) {
                FastWebFall.mc.player.motionY = -0.22000000000000003;
            }
        }
    }
}
