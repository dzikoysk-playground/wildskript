package net.dzikoysk.wildskript.objects.scoreboard.objective;

import net.dzikoysk.wildskript.objects.scoreboard.Scoreboards;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class Objectives {

    static DisplaySlot SIDEBAR = DisplaySlot.SIDEBAR;
    static DisplaySlot PLAYER_LIST = DisplaySlot.PLAYER_LIST;
    static DisplaySlot BELOW_NAME = DisplaySlot.BELOW_NAME;

    public static Objective get(String id, String criteria) {
        Scoreboard sb = Scoreboards.getScoreboard();
        Objective o = sb.getObjective(id);
        if (o == null) o = sb.registerNewObjective(id, criteria);
        return o;
    }

    public static void setDisplaySlot(Objective o, String slot) {
        if (slot.equalsIgnoreCase("sidebar")) o.setDisplaySlot(SIDEBAR);
        else if (slot.equalsIgnoreCase("player list")) o.setDisplaySlot(PLAYER_LIST);
        else if (slot.equalsIgnoreCase("below name")) o.setDisplaySlot(BELOW_NAME);
    }
}
