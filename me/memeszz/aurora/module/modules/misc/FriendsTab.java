//Decomped By XeonLyfe
package me.memeszz.aurora.module.modules.misc;

import me.memeszz.aurora.module.*;
import me.memeszz.aurora.setting.*;
import net.minecraft.client.network.*;
import net.minecraft.scoreboard.*;
import me.memeszz.aurora.util.friends.*;
import me.memeszz.aurora.command.*;

public class FriendsTab extends Module
{
    public static FriendsTab INSTANCE;
    public Setting.i tabsize;
    
    public FriendsTab() {
        super("FriendsTab", Module.Category.MISC);
        this.tabsize = this.registerI("Tabsize", 255, 1, 255);
        FriendsTab.INSTANCE = this;
    }
    
    public static String getPlayerName(final NetworkPlayerInfo networkPlayerInfoIn) {
        final String dname = (networkPlayerInfoIn.getDisplayName() != null) ? networkPlayerInfoIn.getDisplayName().getFormattedText() : ScorePlayerTeam.formatPlayerName((Team)networkPlayerInfoIn.getPlayerTeam(), networkPlayerInfoIn.getGameProfile().getName());
        if (Friends.isFriend(dname)) {
            return String.format("%sa%s", Command.SECTIONSIGN(), dname);
        }
        return dname;
    }
}
