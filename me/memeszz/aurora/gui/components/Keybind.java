//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XeonLyfeGPC\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package me.memeszz.aurora.gui.components;

import me.memeszz.aurora.gui.*;
import java.awt.*;
import net.minecraft.client.gui.*;
import me.memeszz.aurora.module.modules.gui.*;
import me.memeszz.aurora.module.*;
import com.mojang.realmsclient.gui.*;
import org.lwjgl.input.*;
import me.memeszz.aurora.util.font.*;

public class Keybind extends Component
{
    private boolean hovered;
    private boolean binding;
    private final Button parent;
    private int offset;
    private int x;
    private int y;
    
    public Keybind(final Button button, final int offset) {
        this.parent = button;
        this.x = button.parent.getX() + button.parent.getWidth();
        this.y = button.parent.getY() + button.offset;
        this.offset = offset;
    }
    
    public void setOff(final int newOff) {
        this.offset = newOff;
    }
    
    public void renderComponent() {
        Gui.drawRect(this.parent.parent.getX(), this.parent.parent.getY() + this.offset + 1, this.parent.parent.getX() + this.parent.parent.getWidth(), this.parent.parent.getY() + this.offset + 15, this.hovered ? new Color(0, 0, 0, 150).darker().darker().getRGB() : new Color(0, 0, 0, 150).getRGB());
        Gui.drawRect(this.parent.parent.getX(), this.parent.parent.getY() + this.offset, this.parent.parent.getX() + this.parent.parent.getWidth(), this.parent.parent.getY() + this.offset + 1, new Color(0, 0, 0, 255).getRGB());
        Gui.drawRect(this.parent.parent.getX(), this.parent.parent.getY() + this.offset + 15, this.parent.parent.getX() + this.parent.parent.getWidth(), this.parent.parent.getY() + this.offset + 16, new Color(0, 0, 0, 150).getRGB());
        final ClickGuiModule clickGuiModule = (ClickGuiModule)ModuleManager.getModuleByName("ClickGui");
        FontUtils.drawStringWithShadow(ClickGuiModule.customFont.getValue(), this.binding ? "Press a key..." : ("Key: " + ChatFormatting.GRAY + Keyboard.getKeyName(this.parent.mod.getBind())), this.parent.parent.getX() + 2, this.parent.parent.getY() + this.offset + 4, -1);
    }
    
    public void updateComponent(final int mouseX, final int mouseY) {
        this.hovered = this.isMouseOnButton(mouseX, mouseY);
        this.y = this.parent.parent.getY() + this.offset;
        this.x = this.parent.parent.getX();
    }
    
    public void mouseClicked(final int mouseX, final int mouseY, final int button) {
        if (this.isMouseOnButton(mouseX, mouseY) && button == 0 && this.parent.open) {
            this.binding = !this.binding;
        }
    }
    
    public void keyTyped(final char typedChar, final int key) {
        if (this.binding) {
            if (key == 211) {
                this.parent.mod.setBind(0);
            }
            else {
                this.parent.mod.setBind(key);
            }
            this.binding = false;
        }
    }
    
    public boolean isMouseOnButton(final int x, final int y) {
        return x > this.x && x < this.x + 88 && y > this.y && y < this.y + 16;
    }
}
