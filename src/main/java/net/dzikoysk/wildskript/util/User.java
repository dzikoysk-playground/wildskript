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
        users.add(this);
    }

    public static User get(Player player) {
        for (User user : users) {
            if (user.getPlayer().equals(player)) {
                return user;
            }
        }
        return new User(player);
    }

    public void setScoreboard(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
        this.player.setScoreboard(scoreboard);
    }

    public Scoreboard getScoreboard() {
        if (scoreboard == null) {
            this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            this.player.setScoreboard(scoreboard);
        }
        return scoreboard;
    }

    public Player getPlayer() {
        return player;
    }
}
