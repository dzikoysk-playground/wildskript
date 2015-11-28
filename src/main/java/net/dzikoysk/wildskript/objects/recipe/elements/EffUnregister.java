package net.dzikoysk.wildskript.objects.recipe.elements;

import net.dzikoysk.wildskript.objects.recipe.Recipes;

import org.bukkit.event.Event;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffUnregister extends Effect {
	
	private Expression<String> id;
	
	protected void execute (Event event) {
		String id = this.id.getSingle(event);
		if(id == null) return;
		Recipes.get(id).unregister();
	}
	
	public String toString(Event event, boolean bool) {
		return this.getClass().getName();
	}
	
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult){
		this.id = (Expression<String>) expressions[0];
	    return true;
	}
}









