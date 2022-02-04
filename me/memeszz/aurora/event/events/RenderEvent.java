//Decomped By XeonLyfe
package me.memeszz.aurora.event.events;

import net.minecraft.util.math.*;
import net.minecraft.client.renderer.*;

public class RenderEvent
{
    private final Tessellator tessellator;
    private final Vec3d renderPos;
    
    public RenderEvent(final Tessellator tessellator, final Vec3d renderPos, final float ticks) {
        this.tessellator = tessellator;
        this.renderPos = renderPos;
    }
    
    public BufferBuilder getBuffer() {
        return this.tessellator.getBuffer();
    }
    
    public void setTranslation(final Vec3d translation) {
        this.getBuffer().setTranslation(-translation.x, -translation.y, -translation.z);
    }
    
    public void resetTranslation() {
        this.setTranslation(this.renderPos);
    }
}
