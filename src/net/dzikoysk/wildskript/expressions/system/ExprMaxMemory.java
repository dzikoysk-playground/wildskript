package net.dzikoysk.wildskript.expressions.system;

import org.bukkit.event.Event;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

public class ExprMaxMemory extends SimpleExpression<Integer>{

	protected Integer[] get(Event event) {
		long l = Runtime.getRuntime().maxMemory();
		int i = 0;
		if (!(l < Integer.MIN_VALUE || l > Integer.MAX_VALUE)) i = (int)l;
		return new Integer[] { i };
    }

	public boolean isSingle() { 
		return true;
	}

    public Class<? extends Integer> getReturnType() {
    	return Integer.class;
    }

	public String toString(Event event, boolean b) { 
		return this.getClass().getName();
	}

	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {    
		return true;
	}
}	
