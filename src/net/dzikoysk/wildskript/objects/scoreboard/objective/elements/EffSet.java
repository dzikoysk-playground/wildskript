package net.dzikoysk.wildskript.objects.scoreboard.objective.elements;

import net.dzikoysk.wildskript.objects.scoreboard.objective.Objectives;
import net.dzikoysk.wildskript.objects.scoreboard.objective.Scores;

import org.bukkit.event.Event;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffSet extends Effect {
	
	private Expression<String> id;
	private Expression<String> s;
	private Expression<Number> i;
	
	protected void execute (Event event) {
		
		String id = this.id.getSingle(event);
		String s = this.s.getSingle(event);
		Integer i = this.i.getSingle(event).intValue();
		if(id == null || s == null || i == null) return;
		
		Scores.set(Scores.get(Objectives.get(id, "dummy"), s), i);
	}
	
	
	public String toString(Event e, boolean bool) { return ""; }
	
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult){
		this.id = (Expression<String>) expressions[0];
		this.s = (Expression<String>) expressions[1];
		this.i = (Expression<Number>) expressions[2];
	    return true;
	 }

}


