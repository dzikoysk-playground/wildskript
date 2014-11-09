package net.dzikoysk.wildskript.expressions;

import org.bukkit.event.Event;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;


public class ExprNull extends SimpleExpression<Object>{

	protected Object[] get(Event event) {
	   return null;	 
	}
	
	public boolean isSingle() { 
		return true;
	}

	public Class<? extends Object> getReturnType() { 
		return Object.class;
	}

	public String toString(Event event, boolean b) { 
		return this.getClass().getName();
	}

	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {    
		return true;
	}
}


	

