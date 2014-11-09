package net.dzikoysk.wildskript.collections.functions.elements;

import net.dzikoysk.wildskript.collections.functions.FunctionEvent;
import org.bukkit.event.Event;
import ch.njol.skript.ScriptLoader;
import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.skript.log.ErrorQuality;
import ch.njol.util.Kleenean;

public class ExprArguments extends SimpleExpression<Object>{
	
	protected Object[] get(Event event) {
		if(event instanceof FunctionEvent) return new Object[] { ((FunctionEvent) event).getArgs() };
		return null;
	}
	
	public boolean isSingle() { 
		return true;
	}

	public Class<? extends Object> getReturnType() { 
		return Object.class;
	}
	
	public String toString(Event event, boolean bool) { 
		return this.getClass().getName();
	}
	
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult){
		if (ScriptLoader.isCurrentEvent(FunctionEvent.class)) return true;	
		Skript.error("Cannot use function argument outside of a function!", ErrorQuality.SEMANTIC_ERROR);
		return false;
	}
}


