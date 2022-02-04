//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.module.modules.combat;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;
import net.minecraft.entity.*;
import me.memeszz.aurora.event.events.*;
import me.memeszz.aurora.util.friends.*;
import java.util.*;
import java.util.function.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;
import net.minecraft.item.*;
import me.memeszz.aurora.util.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;

public class KillAura extends Module
{
    private Setting.d range;
    private boolean swordOnly;
    private boolean caCheck;
    private Setting.b criticals;
    private Setting.b rotate;
    private boolean tpsSync;
    private boolean isAttacking;
    public static Entity target;
    
    public KillAura() {
        super("KillAura", Module.Category.COMBAT, "Attacks nearby players");
    }
    
    public void setup() {
        this.swordOnly = true;
        this.caCheck = true;
        this.tpsSync = false;
        this.isAttacking = false;
        this.range = this.registerD("Range", 4.5, 0.0, 10.0);
        this.criticals = this.registerB("Criticals", true);
        this.rotate = this.registerB("Rotate", true);
    }
    
    @Listener
    public void onUpdate(final UpdateEvent event) {
        if (KillAura.mc.player.isDead || KillAura.mc.player.getHealth() <= 0.0f) {
            return;
        }
        KillAura.mc.world.playerEntities.stream().filter(entity -> entity != KillAura.mc.player).filter(entity -> KillAura.mc.player.getDistance(entity) <= this.range.getValue()).filter(e -> e.getHealth() > 0.0f).filter(e -> !e.isDead).filter(e -> !Friends.isFriend(e.getName())).sorted(Comparator.comparing(e -> KillAura.mc.player.getDistance(e))).forEach(this::attack);
    }
    
    private void attack(final Entity e) {
        if (this.swordOnly && !(KillAura.mc.player.getHeldItemMainhand().getItem() instanceof ItemSword)) {
            return;
        }
        final float i = 1.0f;
        KillAura.target = e;
        if (KillAura.mc.player.getCooledAttackStrength(0.0f) >= 1.0f) {
            this.isAttacking = true;
            final boolean rotatee = this.rotate.getValue();
            if (rotatee) {
                RotationManager.lookAt(e, (EntityPlayer)KillAura.mc.player);
            }
            KillAura.mc.playerController.attackEntity((EntityPlayer)KillAura.mc.player, e);
            KillAura.mc.player.swingArm(EnumHand.MAIN_HAND);
            if (rotatee) {
                RotationManager.resetRotation();
            }
            this.isAttacking = false;
        }
    }
}
