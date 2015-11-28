package net.dzikoysk.wildskript.effects;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffRecipes extends Effect {
	
	protected void execute (Event event) {
		Bukkit.clearRecipes();
	}
	
	public String toString(Event event, boolean bool) { 
		return this.getClass().getName();
	}
	
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult){
	    return true;
	}
}









