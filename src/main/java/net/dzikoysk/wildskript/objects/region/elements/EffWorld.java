package net.dzikoysk.wildskript.objects.region.elements;

import net.dzikoysk.wildskript.objects.region.RegionsUtils;

import org.bukkit.World;
import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffWorld extends Effect {
	
	private Expression<String> id;
	private Expression<World> w;
	
	protected void execute (Event event) {
		
		String id = this.id.getSingle(event);
		World w = this.w.getSingle(event);
		
		if(id == null || w == null) return;

		RegionsUtils.get(id).setWorld(w);	
	}
	
	public String toString(Event event, boolean bool) { return ""; }
	
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] e, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult)
	 {
		this.id = (Expression<String>) e[0];
		this.w = (Expression<World>) e[1];
	    return true;
	 }

}




