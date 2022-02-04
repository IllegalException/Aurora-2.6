//Decomped By XeonLyfe
package me.memeszz.aurora.module.modules.player;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;

public class Reach extends Module
{
    public Setting.d distance;
    
    public Reach() {
        super("Reach", Module.Category.PLAYER, "Discord Rich Presence");
    }
    
    public void setup() {
        this.distance = this.registerD("Distance", 6.0, 0.0, 10.0);
    }
    
    public String getHudInfo() {
        return "�7[�f" + this.distance.getValue() + "�7]";
    }
}
