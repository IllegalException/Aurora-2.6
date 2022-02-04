//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.module.modules.render;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.util.colour.*;
import me.memeszz.aurora.event.events.*;
import me.memeszz.aurora.util.math.*;
import org.lwjgl.opengl.*;
import me.memeszz.aurora.util.render.*;
import me.memeszz.aurora.mixin.accessor.*;
import net.minecraft.util.math.*;
import java.util.*;
import net.minecraft.entity.*;

public class Trajectories extends Module
{
    ArrayList<Vec3d> positions;
    HueCycler cycler;
    
    public Trajectories() {
        super("Trajectories", Module.Category.RENDER);
        this.positions = new ArrayList<Vec3d>();
        this.cycler = new HueCycler(100);
    }
    
    public void onWorldRender(final RenderEvent event) {
        try {
            final TrajectoryCalculator.ThrowingType tt;
            TrajectoryCalculator.FlightPath flightPath;
            BlockPos hit;
            Vec3d a;
            final Iterator<Vec3d> iterator;
            Vec3d v;
            Trajectories.mc.world.loadedEntityList.stream().filter(entity -> entity instanceof EntityLivingBase).map(entity -> entity).forEach(entity -> {
                this.positions.clear();
                tt = TrajectoryCalculator.getThrowType(entity);
                if (tt != TrajectoryCalculator.ThrowingType.NONE) {
                    flightPath = new TrajectoryCalculator.FlightPath(entity, tt);
                    while (!flightPath.isCollided()) {
                        flightPath.onUpdate();
                        this.positions.add(flightPath.position);
                    }
                    hit = null;
                    if (flightPath.getCollidingTarget() != null) {
                        hit = flightPath.getCollidingTarget().getBlockPos();
                    }
                    GL11.glEnable(3042);
                    GL11.glDisable(3553);
                    GL11.glDisable(2896);
                    GL11.glDisable(2929);
                    if (hit != null) {
                        RenderUtil.prepare(7);
                        GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.3f);
                        RenderUtil.drawBox(hit, 872415231, GeometryMasks.FACEMAP.get(flightPath.getCollidingTarget().sideHit));
                        RenderUtil.release();
                    }
                    if (!this.positions.isEmpty()) {
                        GL11.glDisable(3042);
                        GL11.glDisable(3553);
                        GL11.glDisable(2896);
                        GL11.glLineWidth(2.0f);
                        if (hit != null) {
                            GL11.glColor3f(1.0f, 1.0f, 1.0f);
                        }
                        else {
                            this.cycler.setNext();
                        }
                        GL11.glBegin(1);
                        a = this.positions.get(0);
                        GL11.glVertex3d(a.x - ((IRenderManager)Trajectories.mc.getRenderManager()).getRenderPosX(), a.y - ((IRenderManager)Trajectories.mc.getRenderManager()).getRenderPosY(), a.z - ((IRenderManager)Trajectories.mc.getRenderManager()).getRenderPosZ());
                        this.positions.iterator();
                        while (iterator.hasNext()) {
                            v = iterator.next();
                            GL11.glVertex3d(v.x - ((IRenderManager)Trajectories.mc.getRenderManager()).getRenderPosX(), v.y - ((IRenderManager)Trajectories.mc.getRenderManager()).getRenderPosY(), v.z - ((IRenderManager)Trajectories.mc.getRenderManager()).getRenderPosZ());
                            GL11.glVertex3d(v.x - ((IRenderManager)Trajectories.mc.getRenderManager()).getRenderPosX(), v.y - ((IRenderManager)Trajectories.mc.getRenderManager()).getRenderPosY(), v.z - ((IRenderManager)Trajectories.mc.getRenderManager()).getRenderPosZ());
                            if (hit == null) {
                                this.cycler.setNext();
                            }
                        }
                        GL11.glEnd();
                        GL11.glEnable(3042);
                        GL11.glEnable(3553);
                        this.cycler.reset();
                    }
                }
            });
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
