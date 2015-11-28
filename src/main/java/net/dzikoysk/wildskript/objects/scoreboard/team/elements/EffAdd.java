package net.dzikoysk.wildskript.objects.scoreboard.team.elements;

import net.dzikoysk.wildskript.objects.scoreboard.team.Teams;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffAdd extends Effect {
	
	private Expression<String> id;
	private Expression<Player> p;
	
	protected void execute (Event event) {
		
		String id = this.id.getSingle(event);
		Player p = this.p.getSingle(event);
		if(id == null || p == null) return;
		
		Teams.get(id).getTeam().addPlayer(p);
	}
	
	
	public String toString(Event e, boolean bool) { return ""; }
	
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult){
		this.id = (Expression<String>) expressions[0];
		this.p = (Expression<Player>) expressions[1];

	    return true;
	 }

}


