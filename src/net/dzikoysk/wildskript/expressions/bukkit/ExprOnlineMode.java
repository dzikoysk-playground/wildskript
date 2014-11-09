package net.dzikoysk.wildskript.expressions.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

public class ExprOnlineMode extends SimpleExpression<Boolean>{

	protected Boolean[] get(Event event) {
		return new Boolean[] { Bukkit.getOnlineMode() };
	}

	public boolean isSingle() { 
		return true;
	}

	public Class<? extends Boolean> getReturnType() { 
		return Boolean.class;
	}

	public String toString(Event event, boolean b) { 
		return this.getClass().getName();
	}

	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {    
		return true;
	}
}


	

