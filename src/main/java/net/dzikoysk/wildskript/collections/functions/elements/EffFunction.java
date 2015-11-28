package net.dzikoysk.wildskript.collections.functions.elements;

import net.dzikoysk.wildskript.collections.functions.Function;
import org.bukkit.event.Event;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffFunction extends Effect {
	
	private Expression<String> function;
	private Expression<Object> arguments;
	
	protected void execute (Event event) {
		String function = this.function.getSingle(event);
		Object[] args = null;
		if(this.arguments != null) args = this.arguments.getAll(event);
		if(function == null) return;
		Function.call(function, args);
	}
	
	public String toString(Event event, boolean bool) { 
		return this.getClass().getName();
	}
	
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult){
		this.function = (Expression<String>) expressions[0];
		this.arguments = (Expression<Object>) expressions[1];
	    return true;
	}
}








