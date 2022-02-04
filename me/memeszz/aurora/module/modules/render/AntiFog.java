//Decomped By XeonLyfe
package me.memeszz.aurora.module.modules.render;

import me.memeszz.aurora.module.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.common.*;

public class AntiFog extends Module
{
    public AntiFog() {
        super("AntiFog", Module.Category.RENDER);
    }
    
    @SubscribeEvent
    public void fogDensity(final EntityViewRenderEvent.FogDensity event) {
        event.setDensity(0.0f);
        event.setCanceled(true);
    }
    
    public void onEnable() {
        MinecraftForge.EVENT_BUS.register((Object)this);
    }
    
    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister((Object)this);
    }
}
