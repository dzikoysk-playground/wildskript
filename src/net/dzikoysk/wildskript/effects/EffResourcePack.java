package net.dzikoysk.wildskript.effects;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffResourcePack extends Effect {
	
	private Expression<Player> p;
	private Expression<String> url;
	
	protected void execute (Event event) {
		Player p = this.p.getSingle(event);
		String url = this.url.getSingle(event);
		if(p == null || url == null) return;
		p.setResourcePack(url);
	}
	
	public String toString(Event event, boolean bool) { 
		return this.getClass().getName();
	}
	
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult){
	    this.url = (Expression<String>) expressions[0];
	    this.p = (Expression<Player>) expressions[1];
	    return true; 
	}
}



