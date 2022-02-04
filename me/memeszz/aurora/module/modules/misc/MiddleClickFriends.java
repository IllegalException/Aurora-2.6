//Decomped By XeonLyfe
package me.memeszz.aurora.module.modules.misc;

import me.memeszz.aurora.module.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.player.*;
import org.lwjgl.input.*;
import me.memeszz.aurora.util.friends.*;
import me.memeszz.aurora.*;
import com.mojang.realmsclient.gui.*;
import me.memeszz.aurora.util.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;

public class MiddleClickFriends extends Module
{
    public MiddleClickFriends() {
        super("MCF", Module.Category.MISC, "Middle click players to add / remove them as a friend");
    }
    
    @Listener
    public void mouseInputEvent(final InputEvent.MouseInputEvent event) {
        if (MiddleClickFriends.mc.objectMouseOver.typeOfHit.equals((Object)RayTraceResult.Type.ENTITY) && MiddleClickFriends.mc.objectMouseOver.entityHit instanceof EntityPlayer && Mouse.getEventButton() == 2) {
            if (!MiddleClickFriends.mc.player.isOnLadder() && Friends.isFriend(MiddleClickFriends.mc.objectMouseOver.entityHit.getName())) {
                Aurora.getInstance().friends.delFriend(MiddleClickFriends.mc.objectMouseOver.entityHit.getName());
                Wrapper.sendClientMessage(ChatFormatting.RED + "Removed " + MiddleClickFriends.mc.objectMouseOver.entityHit.getName() + " from friends list");
            }
            else {
                Aurora.getInstance().friends.addFriend(MiddleClickFriends.mc.objectMouseOver.entityHit.getName());
                Wrapper.sendClientMessage(ChatFormatting.AQUA + "Added " + MiddleClickFriends.mc.objectMouseOver.entityHit.getName() + " to friends list");
            }
        }
    }
}
