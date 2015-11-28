package net.dzikoysk.wildskript.util;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class IndividualPrefix {
	
	public static void see(User[] us, User[] bs, String prefix, String suffix){
		for(User u : us){
			Scoreboard sb = u.getScoreboard();
			for(User b : bs){
				Player p = b.getPlayer();
				Team team = sb.getPlayerTeam(p);
				if(team == null){
					String[] n = p.getName().split("(?<=\\G..............)");
					team = sb.getTeam("ws"+n[0]);
					if(team == null) team = sb.registerNewTeam("ws"+n[0]);
					team.addPlayer(p);
				}
				if(prefix != null) team.setPrefix(prefix);
				if(suffix != null) team.setSuffix(suffix);
			}
			u.setScoreboard(sb);
		}
	}
}
