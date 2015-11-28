package net.dzikoysk.wildskript.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static List<User> users = new ArrayList<>();

    private final Player player;
    private Scoreboard scoreboard;

    private User(Player player) {
        this.player = player;
        this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        users.add(this);
    }

    public static User get(Player player) {
        for (User u : users) if (u.getPlayer().equals(player)) return u;
        return new User(player);
    }

    public void setScoreboard(Scoreboard sb) {
        scoreboard = sb;
        player.setScoreboard(scoreboard);
    }

    public Scoreboard getScoreboard() {
        if (scoreboard == null) scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        return scoreboard;
    }

    public Player getPlayer() {
        return player;
    }
}
