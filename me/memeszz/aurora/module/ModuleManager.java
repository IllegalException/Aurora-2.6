//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.module;

import java.util.*;
import me.memeszz.aurora.module.modules.combat.*;
import me.memeszz.aurora.module.modules.player.*;
import me.memeszz.aurora.module.modules.movement.*;
import me.memeszz.aurora.module.modules.misc.*;
import me.memeszz.aurora.module.modules.world.*;
import me.memeszz.aurora.module.modules.render.*;
import me.memeszz.aurora.module.modules.gui.*;
import net.minecraftforge.client.event.*;
import net.minecraft.client.*;
import me.memeszz.aurora.util.render.*;
import net.minecraft.entity.*;
import me.memeszz.aurora.event.events.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.math.*;
import java.util.stream.*;

public class ModuleManager
{
    public static ArrayList<Module> modules;
    
    public ModuleManager() {
        ModuleManager.modules = new ArrayList<Module>();
        addMod(new AutoCrystal());
        addMod(new AutoTrap());
        addMod(new AutoTotem());
        addMod(new AutoArmour());
        addMod(new KillAura());
        addMod(new OffHandCrystal());
        addMod(new AutoEchest());
        addMod(new OffHandGap());
        addMod(new TotemPopCounter());
        addMod(new Criticals());
        addMod(new MultiTask());
        addMod(new Surround());
        addMod(new HoleFill());
        addMod(new AutoWeb());
        addMod(new EzPearl());
        addMod(new FootXp());
        addMod(new AutoBedCraft());
        addMod(new AntiVoid());
        addMod(new AutoReplanish());
        addMod(new Blink());
        addMod(new FakePlayer());
        addMod(new FastUse());
        addMod(new NoMiningTrace());
        addMod(new NoSwing());
        addMod(new PortalGodMode());
        addMod(new Reach());
        addMod(new SpeedMine());
        addMod(new FastSwim());
        addMod(new IceSpeed());
        addMod(new NoSlow());
        addMod(new Step());
        addMod(new ReverseStep());
        addMod(new Sprint());
        addMod(new Speed());
        addMod(new FastWebFall());
        addMod(new Velocity());
        addMod(new AutoRespawn());
        addMod(new FriendsTab());
        addMod(new ChatSuffix());
        addMod(new DonkeyAlert());
        addMod(new GuiMove());
        addMod(new MiddleClickFriends());
        addMod(new Announcer());
        addMod(new AutoGG());
        addMod(new BetterChat());
        addMod(new ChatTimeStamps());
        addMod(new str2detect());
        addMod(new ToggleMsgs());
        addMod(new VisualRange());
        addMod(new Welcomer());
        addMod(new AntiFog());
        addMod(new BlockHighlight());
        addMod(new Brightness());
        addMod(new CameraClip());
        addMod(new Fov());
        addMod(new HoleESP());
        addMod(new MobOwner());
        addMod(new NameTags());
        addMod(new NoLag());
        addMod(new NoRender());
        addMod(new ShulkerPreview());
        addMod(new SkyColor());
        addMod(new Trajectories());
        addMod(new OldChangeItemAnim());
        addMod(new AuroraGang());
        addMod(new ClickGuiModule());
        addMod(new DurabiltyWarning());
        addMod(new Hud());
        addMod(new Compass());
        addMod(new Chams());
        addMod(new Pvpinfo());
        addMod(new TextRadar());
        addMod(new PotionEffects());
    }
    
    public static void addMod(final Module m) {
        ModuleManager.modules.add(m);
    }
    
    public static void onUpdate() {
        ModuleManager.modules.stream().filter(Module::isEnabled).forEach(Module::onUpdate);
    }
    
    public static void onRender() {
        ModuleManager.modules.stream().filter(Module::isEnabled).forEach(Module::onRender);
    }
    
    public static void onWorldRender(final RenderWorldLastEvent event) {
        Minecraft.getMinecraft().profiler.startSection("aurora");
        Minecraft.getMinecraft().profiler.startSection("setup");
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.shadeModel(7425);
        GlStateManager.disableDepth();
        GlStateManager.glLineWidth(1.0f);
        final Vec3d renderPos = RenderUtil.getInterpolatedPos((Entity)Minecraft.getMinecraft().player, event.getPartialTicks());
        final RenderEvent e = new RenderEvent((Tessellator)RenderUtil.INSTANCE, renderPos, event.getPartialTicks());
        e.resetTranslation();
        Minecraft.getMinecraft().profiler.endSection();
        final RenderEvent renderEvent;
        ModuleManager.modules.stream().filter(Module::isEnabled).forEach(module -> {
            Minecraft.getMinecraft().profiler.startSection(module.getName());
            module.onWorldRender(renderEvent);
            Minecraft.getMinecraft().profiler.endSection();
            return;
        });
        Minecraft.getMinecraft().profiler.startSection("release");
        GlStateManager.glLineWidth(1.0f);
        GlStateManager.shadeModel(7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
        GlStateManager.enableDepth();
        GlStateManager.enableCull();
        RenderUtil.releaseGL();
        Minecraft.getMinecraft().profiler.endSection();
        Minecraft.getMinecraft().profiler.endSection();
    }
    
    public static ArrayList<Module> getModules() {
        return ModuleManager.modules;
    }
    
    public static ArrayList<Module> getModulesInCategory(final Module.Category c) {
        return getModules().stream().filter(m -> m.getCategory().equals((Object)c)).collect((Collector<? super Object, ?, ArrayList<Module>>)Collectors.toList());
    }
    
    public static void onBind(final int key) {
        if (key == 0) {
            return;
        }
        ModuleManager.modules.forEach(module -> {
            if (module.getBind() == key) {
                module.toggle();
            }
        });
    }
    
    public static Module getModuleByName(final String name) {
        return getModules().stream().filter(mm -> mm.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
    
    public static boolean isModuleEnabled(final String name) {
        final Module m = getModules().stream().filter(mm -> mm.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
        assert m != null;
        return m.isEnabled();
    }
    
    public static boolean isModuleEnabled(final Module m) {
        return m.isEnabled();
    }
}
