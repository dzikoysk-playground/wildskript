package net.dzikoysk.wildskript.objects.scoreboard.objective.elements;

import net.dzikoysk.wildskript.objects.scoreboard.objective.Objectives;

import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffDisplaySlot extends Effect {
	
	private Expression<String> id;
	private Expression<String> slot;
	
	protected void execute (Event event) {
		
		String id = this.id.getSingle(event);
		String s = this.slot.getSingle(event);
		if(id == null || s == null) return;
		
		Objectives.setDisplaySlot(Objectives.get(id, "dummy"), s);
		
	}
	
	
	public String toString(Event e, boolean bool) { return ""; }
	
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult){
		this.id = (Expression<String>) expressions[0];
		this.slot = (Expression<String>) expressions[1];

	    return true;
	 }

}


