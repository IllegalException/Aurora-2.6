//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.module.modules.gui;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;
import java.text.*;
import com.mojang.realmsclient.gui.*;
import net.minecraft.entity.*;
import me.memeszz.aurora.util.friends.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import me.memeszz.aurora.*;

public class TextRadar extends Module
{
    private Setting.b right;
    private Setting.b customFont;
    Setting.i x;
    Setting.i y;
    Setting.i red;
    Setting.i green;
    Setting.i blue;
    Setting.b distance;
    String s;
    int count;
    DecimalFormat decimalFormat;
    ChatFormatting cf;
    
    public TextRadar() {
        super("PlayerRadar", Module.Category.GUI, "Attacks nearby players");
        this.s = "";
        this.decimalFormat = new DecimalFormat("00.0");
    }
    
    public void setup() {
        this.customFont = this.registerB("CustomFont", true);
        this.right = this.registerB("RightSide", true);
        this.x = this.registerI("X", 255, 0, 960);
        this.y = this.registerI("Y", 255, 0, 530);
        this.red = this.registerI("Red", 255, 0, 255);
        this.green = this.registerI("Green", 255, 0, 255);
        this.blue = this.registerI("Blue", 255, 0, 255);
        this.distance = this.registerB("Distance", true);
    }
    
    public void onRender() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        me/memeszz/aurora/module/modules/gui/TextRadar.customFont:Lme/memeszz/aurora/setting/Setting$b;
        //     4: invokevirtual   me/memeszz/aurora/setting/Setting$b.getValue:()Z
        //     7: istore_1        /* font */
        //     8: aload_0         /* this */
        //     9: iconst_0       
        //    10: putfield        me/memeszz/aurora/module/modules/gui/TextRadar.count:I
        //    13: getstatic       me/memeszz/aurora/module/modules/gui/TextRadar.mc:Lnet/minecraft/client/Minecraft;
        //    16: getfield        net/minecraft/client/Minecraft.world:Lnet/minecraft/client/multiplayer/WorldClient;
        //    19: getfield        net/minecraft/client/multiplayer/WorldClient.loadedEntityList:Ljava/util/List;
        //    22: invokeinterface java/util/List.stream:()Ljava/util/stream/Stream;
        //    27: invokedynamic   BootstrapMethod #0, test:()Ljava/util/function/Predicate;
        //    32: invokeinterface java/util/stream/Stream.filter:(Ljava/util/function/Predicate;)Ljava/util/stream/Stream;
        //    37: invokedynamic   BootstrapMethod #1, test:()Ljava/util/function/Predicate;
        //    42: invokeinterface java/util/stream/Stream.filter:(Ljava/util/function/Predicate;)Ljava/util/stream/Stream;
        //    47: aload_0         /* this */
        //    48: iload_1         /* font */
        //    49: invokedynamic   BootstrapMethod #2, accept:(Lme/memeszz/aurora/module/modules/gui/TextRadar;Z)Ljava/util/function/Consumer;
        //    54: invokeinterface java/util/stream/Stream.forEach:(Ljava/util/function/Consumer;)V
        //    59: return         
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.languages.java.ast.NameVariables.generateNameForVariable(NameVariables.java:264)
        //     at com.strobel.decompiler.languages.java.ast.NameVariables.assignNamesToVariables(NameVariables.java:198)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:276)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.Decompiler.decompile(Decompiler.java:70)
        //     at org.ugp.mc.deobfuscator.Deobfuscator3000.decompile(Deobfuscator3000.java:538)
        //     at org.ugp.mc.deobfuscator.Deobfuscator3000.decompileAndDeobfuscate(Deobfuscator3000.java:552)
        //     at org.ugp.mc.deobfuscator.Deobfuscator3000.processMod(Deobfuscator3000.java:510)
        //     at org.ugp.mc.deobfuscator.Deobfuscator3000.lambda$21(Deobfuscator3000.java:329)
        //     at java.lang.Thread.run(Unknown Source)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
