//Decomped By XeonLyfe
package me.memeszz.aurora.event.events;

import net.minecraft.entity.*;

public class TotemPopEvent
{
    private final Entity entity;
    
    public TotemPopEvent(final Entity entity) {
        this.entity = entity;
    }
    
    public Entity getEntity() {
        return this.entity;
    }
}
