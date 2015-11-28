package net.dzikoysk.wildskript.objects.scoreboard.objective;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class Scores {

    public static Score get(Objective o, String s) {
        s = ChatColor.translateAlternateColorCodes('&', s);
        @SuppressWarnings("deprecation")
        Score score = o.getScore(Bukkit.getOfflinePlayer(s));
        return score;
    }

    @SuppressWarnings("deprecation")
    public static void reset(Scoreboard sb, String s) {
        s = ChatColor.translateAlternateColorCodes('&', s);
        sb.resetScores(Bukkit.getOfflinePlayer(s));
    }

    public static void set(Score s, int i) {
        s.setScore(i);
    }

}
