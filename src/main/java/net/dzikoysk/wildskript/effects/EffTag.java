package net.dzikoysk.wildskript.effects;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffTag extends Effect {

	private Expression<Player> player;
	private Expression<String> tag;

	protected void execute(Event event) {
		Player p = this.player.getSingle(event);
		String s = this.tag.getSingle(event);
		if (p == null || s == null) return;
		if(s.length() > 16){
			Bukkit.getLogger().severe("String to edit tag name is too long! Max length is 16");
			return;
		}
		Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();
		Team team = sb.getPlayerTeam(p);
		if(team == null){
			team = sb.getTeam(p.getName());
			if(team == null) team = sb.registerNewTeam(p.getName());
			team.addPlayer(p);
		}
		team.setPrefix(s);
		p.setScoreboard(sb);
	}

	public String toString(Event event, boolean bool) { 
		return this.getClass().getName();
	}

	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
		this.player = (Expression<Player>) expressions[0];
		this.tag = (Expression<String>) expressions[1];
		return true;
	}
}

