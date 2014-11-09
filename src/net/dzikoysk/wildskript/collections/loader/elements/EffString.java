package net.dzikoysk.wildskript.collections.loader.elements;
import net.dzikoysk.wildskript.collections.loader.Loader;

import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffString extends Effect {
	
	private Expression<String> s;
	
	protected void execute (Event event) {
		String s = this.s.getSingle(event);
		if (s == null) return;
		Loader.loadString(s);
	}
	
	public String toString(Event event, boolean bool) {
		return this.getClass().getName();
	}
	
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult){ 
	    this.s = (Expression<String>) expressions[0];
	    return true;
	}
}



