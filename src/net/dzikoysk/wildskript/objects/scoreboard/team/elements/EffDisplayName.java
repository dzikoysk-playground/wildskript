package net.dzikoysk.wildskript.objects.scoreboard.team.elements;

import net.dzikoysk.wildskript.objects.scoreboard.team.Teams;

import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffDisplayName extends Effect {
	
	private Expression<String> id;
	private Expression<String> s;
	
	protected void execute (Event event) {
		
		String id = this.id.getSingle(event);
		String s = this.s.getSingle(event);
		if(id == null || s == null) return;
		
		Teams.get(id).getTeam().setDisplayName(s);
		
	}
	
	
	public String toString(Event e, boolean bool) { return ""; }
	
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult){
		this.id = (Expression<String>) expressions[0];
		this.s = (Expression<String>) expressions[1];

	    return true;
	 }

}


