package net.dzikoysk.wildskript.objects.region.elements;

import net.dzikoysk.wildskript.objects.region.RegionsUtils;

import org.bukkit.Location;
import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffCenter extends Effect {
	
	private Expression<String> id;
	private Expression<Location> c;
	
	protected void execute (Event event) {
		
		String id = this.id.getSingle(event);
		Location c = this.c.getSingle(event);
		
		if(id == null || c == null) return;

		RegionsUtils.get(id).setCenter(c);	
	}
	
	public String toString(Event event, boolean bool) { return ""; }
	
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] e, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult)
	 {
		this.id = (Expression<String>) e[0];
		this.c = (Expression<Location>) e[1];
	    return true;
	 }

}




