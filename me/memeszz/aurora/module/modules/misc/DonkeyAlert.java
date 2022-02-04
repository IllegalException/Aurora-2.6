//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.module.modules.misc;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;
import me.memeszz.aurora.event.events.*;
import net.minecraft.client.*;
import net.minecraft.entity.*;
import me.memeszz.aurora.util.*;
import net.minecraft.entity.passive.*;
import java.util.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;

public class DonkeyAlert extends Module
{
    Setting.b donkeyAlert;
    Setting.b muleAlert;
    Setting.b llamaAlert;
    Setting.b horseAlert;
    Setting.mode mode;
    private int antiSpam;
    
    public DonkeyAlert() {
        super("DonkeyAlert", Module.Category.MISC, "Announces the location of any donkeys in the players render distance");
    }
    
    public void setup() {
        this.donkeyAlert = this.registerB("DonkeyAlert", true);
        this.muleAlert = this.registerB("MuleAlert", true);
        this.llamaAlert = this.registerB("LlamaAlert", true);
        this.horseAlert = this.registerB("HorseAlert", false);
        final ArrayList<String> modes = new ArrayList<String>();
        modes.add("BLACK");
        modes.add("RED");
        modes.add("AQUA");
        modes.add("BLUE");
        modes.add("GOLD");
        modes.add("GRAY");
        modes.add("WHITE");
        modes.add("GREEN");
        modes.add("YELLOW");
        modes.add("DARK_RED");
        modes.add("DARK_AQUA");
        modes.add("DARK_BLUE");
        modes.add("DARK_GRAY");
        modes.add("DARK_GREEN");
        modes.add("DARK_PURPLE");
        modes.add("LIGHT_PURPLE");
        this.mode = this.registerMode("Mode", (List)modes, "DARK_RED");
    }
    
    @Listener
    public void onUpdate(final UpdateEvent event) {
        ++this.antiSpam;
        for (final Entity e : Minecraft.getMinecraft().world.loadedEntityList) {
            if (e instanceof EntityDonkey && this.donkeyAlert.getValue() && this.antiSpam >= 100) {
                Wrapper.sendClientMessage(this.colorchoice() + " Found Donkey! X:" + (int)e.posX + " Z:" + (int)e.posZ);
                this.antiSpam = -600;
            }
            if (e instanceof EntityMule && this.muleAlert.getValue() && this.antiSpam >= 100) {
                Wrapper.sendClientMessage(this.colorchoice() + " Found Mule! X:" + (int)e.posX + " Z:" + (int)e.posZ);
                this.antiSpam = -600;
            }
            if (e instanceof EntityLlama && this.llamaAlert.getValue() && this.antiSpam >= 100) {
                Wrapper.sendClientMessage(this.colorchoice() + " Found Llama! X:" + (int)e.posX + " Z:" + (int)e.posZ);
                this.antiSpam = -600;
            }
            if (e instanceof EntityHorse && this.horseAlert.getValue() && this.antiSpam >= 100) {
                Wrapper.sendClientMessage(this.colorchoice() + " Found Horse! X:" + (int)e.posX + " Z:" + (int)e.posZ);
                this.antiSpam = -600;
            }
        }
    }
    
    private String colorchoice() {
        final String value = this.mode.getValue();
        switch (value) {
            case "BLACK": {
                return "�0";
            }
            case "RED": {
                return "�c";
            }
            case "AQUA": {
                return "�b";
            }
            case "BLUE": {
                return "�9";
            }
            case "GOLD": {
                return "�6";
            }
            case "GRAY": {
                return "�7";
            }
            case "WHITE": {
                return "�f";
            }
            case "GREEN": {
                return "�a";
            }
            case "YELLOW": {
                return "�e";
            }
            case "DARK_RED": {
                return "�4";
            }
            case "DARK_AQUA": {
                return "�3";
            }
            case "DARK_BLUE": {
                return "�1";
            }
            case "DARK_GRAY": {
                return "�8";
            }
            case "DARK_GREEN": {
                return "�2";
            }
            case "DARK_PURPLE": {
                return "�5";
            }
            case "LIGHT_PURPLE": {
                return "�d";
            }
            default: {
                return "";
            }
        }
    }
}
