//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.setting;

import java.util.*;
import me.memeszz.aurora.module.*;
import java.util.stream.*;

public class SettingManager
{
    private final List<Setting> settings;
    
    public SettingManager() {
        this.settings = new ArrayList<Setting>();
    }
    
    public List<Setting> getSettings() {
        return this.settings;
    }
    
    public void addSetting(final Setting setting) {
        this.settings.add(setting);
    }
    
    public Setting getSettingByNameAndMod(final String name, final Module parent) {
        return this.settings.stream().filter(s -> s.getParent().equals(parent)).filter(s -> s.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
    
    public List<Setting> getSettingsForMod(final Module parent) {
        return this.settings.stream().filter(s -> s.getParent().equals(parent)).collect((Collector<? super Object, ?, List<Setting>>)Collectors.toList());
    }
}
