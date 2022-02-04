//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora;

import net.minecraftforge.fml.common.*;
import me.memeszz.aurora.gui.*;
import me.memeszz.aurora.setting.*;
import me.memeszz.aurora.util.friends.*;
import me.memeszz.aurora.module.*;
import me.memeszz.aurora.util.*;
import me.memeszz.aurora.util.macro.*;
import me.memeszz.aurora.event.*;
import me.memeszz.aurora.util.font.*;
import me.memeszz.aurora.util.enemy.*;
import team.stiff.pomelo.*;
import net.minecraftforge.fml.common.event.*;
import java.awt.*;
import me.memeszz.aurora.command.*;
import org.lwjgl.opengl.*;
import team.stiff.pomelo.impl.annotated.*;
import org.apache.logging.log4j.*;

@Mod(modid = "aurora", name = "Aurora", version = "2.6", clientSideOnly = true)
public class Aurora
{
    public static final String MODID = "aurora";
    public static String MODNAME;
    public static final String MODVER = "2.6";
    public static final String FORGENAME = "Aurora";
    public static final Logger log;
    public ClickGUI clickGui;
    public SettingManager settingsManager;
    public Friends friends;
    public ModuleManager moduleManager;
    public ConfigUtils configUtils;
    public MacroManager macroManager;
    EventProcessor eventProcessor;
    public static CFontRenderer fontRenderer;
    public static CFontRenderer skeetFont;
    public static CFontRenderer caviarFont;
    public static Enemies enemies;
    private EventManager eventManager;
    @Mod.Instance
    public static Aurora INSTANCE;
    
    public Aurora() {
        Aurora.INSTANCE = this;
    }
    
    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        (this.eventProcessor = new EventProcessor()).init();
        Aurora.fontRenderer = new CFontRenderer(new Font("Verdana", 0, 18), true, true);
        Aurora.skeetFont = new CFontRenderer(new Font("Verdana", 0, 18), true, true);
        Aurora.caviarFont = new CFontRenderer(new Font("Caviar Dreams", 0, 18), true, true);
        this.settingsManager = new SettingManager();
        Aurora.log.info("Settings initialized!");
        this.friends = new Friends();
        Aurora.enemies = new Enemies();
        Aurora.log.info("Friends and enemies initialized!");
        this.moduleManager = new ModuleManager();
        Aurora.log.info("Modules initialized!");
        this.clickGui = new ClickGUI();
        Aurora.log.info("ClickGUI initialized!");
        this.macroManager = new MacroManager();
        Aurora.log.info("Macros initialized!");
        this.configUtils = new ConfigUtils();
        Aurora.log.info("Config loaded!");
        CommandManager.initCommands();
        Aurora.log.info("Commands initialized!");
        Display.setTitle(Aurora.MODNAME + " " + "2.6");
        Aurora.log.info("Initialization complete!\n");
    }
    
    public EventManager getEventManager() {
        if (this.eventManager == null) {
            this.eventManager = (EventManager)new AnnotatedEventManager();
        }
        return this.eventManager;
    }
    
    public static Aurora getInstance() {
        return Aurora.INSTANCE;
    }
    
    public static void saveConfig() {
        getInstance().configUtils.saveMods();
        getInstance().configUtils.saveSettingsList();
        getInstance().configUtils.saveBinds();
        getInstance().configUtils.saveDrawn();
        getInstance().configUtils.saveFriends();
        getInstance().configUtils.savePrefix();
        getInstance().configUtils.saveRainbow();
        getInstance().configUtils.saveMacros();
        getInstance().configUtils.saveMsgs();
        getInstance().configUtils.saveAutoGG();
        getInstance().configUtils.saveAnnouncer();
        getInstance().configUtils.saveEnemies();
        getInstance().configUtils.saveClientname();
    }
    
    static {
        Aurora.MODNAME = "Aurora";
        log = LogManager.getLogger(Aurora.MODNAME);
    }
}
