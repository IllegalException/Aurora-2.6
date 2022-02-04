//Decomped By XeonLyfe
package me.memeszz.aurora.module.modules.player;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;
import com.mojang.authlib.*;
import net.minecraft.client.entity.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import me.memeszz.aurora.event.events.*;
import team.stiff.pomelo.impl.annotated.handler.annotation.*;
import java.util.*;

public class FakePlayer extends Module
{
    private List<Integer> fakePlayerIdList;
    Setting.mode mode;
    private static final String[][] fakePlayerInfo;
    
    public FakePlayer() {
        super("FakePlayer", Module.Category.PLAYER, "Attacks nearby players");
        this.fakePlayerIdList = null;
    }
    
    public void setup() {
        final ArrayList<String> modes = new ArrayList<String>();
        modes.add("Single");
        modes.add("Multi");
        this.mode = this.registerMode("Mode", (List)modes, "Single");
    }
    
    protected void onEnable() {
        if (FakePlayer.mc.player == null || FakePlayer.mc.world == null) {
            this.disable();
            return;
        }
        this.fakePlayerIdList = new ArrayList<Integer>();
        int entityId = -101;
        for (final String[] data : FakePlayer.fakePlayerInfo) {
            if (this.mode.getValue().equals("Single")) {
                this.addFakePlayer(data[0], data[1], entityId, 0, 0);
            }
            if (this.mode.getValue().equals("Multi")) {
                this.addFakePlayer(data[0], data[1], entityId, Integer.parseInt(data[2]), Integer.parseInt(data[3]));
            }
            --entityId;
        }
    }
    
    private void addFakePlayer(final String uuid, final String name, final int entityId, final int offsetX, final int offsetZ) {
        final EntityOtherPlayerMP fakePlayer = new EntityOtherPlayerMP((World)FakePlayer.mc.world, new GameProfile(UUID.fromString(uuid), name));
        fakePlayer.copyLocationAndAnglesFrom((Entity)FakePlayer.mc.player);
        fakePlayer.posX += offsetX;
        fakePlayer.posZ += offsetZ;
        FakePlayer.mc.world.addEntityToWorld(entityId, (Entity)fakePlayer);
        this.fakePlayerIdList.add(entityId);
    }
    
    @Listener
    public void onUpdate(final UpdateEvent event) {
        if (this.fakePlayerIdList == null || this.fakePlayerIdList.isEmpty()) {
            this.disable();
        }
    }
    
    protected void onDisable() {
        if (FakePlayer.mc.player == null || FakePlayer.mc.world == null) {
            return;
        }
        if (this.fakePlayerIdList != null) {
            for (final int id : this.fakePlayerIdList) {
                FakePlayer.mc.world.removeEntityFromWorld(id);
            }
        }
    }
    
    static {
        fakePlayerInfo = new String[][] { { "66666666-6666-6666-6666-666666666600", "nigga0", "-3", "0" } };
    }
}
