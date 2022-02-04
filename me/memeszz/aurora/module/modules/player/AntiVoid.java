//Decomped By XeonLyfe
package me.memeszz.aurora.module.modules.player;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;
import java.util.*;
import me.memeszz.aurora.event.events.*;
import com.mojang.realmsclient.gui.*;
import me.memeszz.aurora.util.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;

public class AntiVoid extends Module
{
    Setting.mode mode;
    
    public AntiVoid() {
        super("AntiVoid", Module.Category.PLAYER, "Attacks nearby players");
    }
    
    public void setup() {
        final ArrayList<String> modes = new ArrayList<String>();
        modes.add("Bounce");
        modes.add("Mini");
        modes.add("Dolphin");
        this.mode = this.registerMode("Mode", (List)modes, "Bounce");
    }
    
    @Listener
    public void onUpdate(final UpdateEvent event) {
        final Double yLevel = AntiVoid.mc.player.posY;
        if (yLevel <= 0.5) {
            Wrapper.sendClientMessage("�aAttempting To Get " + ChatFormatting.RED + AntiVoid.mc.player.getName() + ChatFormatting.GREEN + " Out Of The void!");
            if (this.mode.getValue().equals("Bounce")) {
                AntiVoid.mc.player.moveVertical = 10.0f;
                AntiVoid.mc.player.jump();
            }
            if (this.mode.getValue().equals("Mini")) {
                AntiVoid.mc.player.moveVertical = 5.0f;
                AntiVoid.mc.player.jump();
            }
            if (this.mode.getValue().equals("Dolphin")) {
                AntiVoid.mc.player.moveVertical = 2.0f;
                AntiVoid.mc.player.jump();
            }
        }
        if (yLevel >= 0.6) {
            AntiVoid.mc.player.moveVertical = 0.0f;
        }
    }
    
    public void onDisable() {
        AntiVoid.mc.player.moveVertical = 0.0f;
    }
    
    public String getHudInfo() {
        return "�7[�f" + this.mode.getValue() + "�7]";
    }
}
