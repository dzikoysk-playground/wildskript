package net.dzikoysk.wildskript.objects.scoreboard.team;

import net.dzikoysk.wildskript.objects.scoreboard.Scoreboards;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;

public class Teams {

    public static ArrayList<Teams> list = new ArrayList<>();
    public static ArrayList<String> names;

    String id;
    Team team;

    public Teams(String id) {
        Scoreboard sb = Scoreboards.getScoreboard();
        Team t = sb.getTeam(id);
        if (t == null) {
            t = sb.registerNewTeam(id);
        }
        this.id = id;
        this.team = t;
        list.add(this);
    }

    public String getID() {
        return this.id;
    }

    public Team getTeam() {
        return this.team;
    }

    public static Teams get(String id) {
        for (Teams team : list) {
            if (team.getID().equals(id)) {
                return team;
            }
        }
        return new Teams(id);
    }
}
