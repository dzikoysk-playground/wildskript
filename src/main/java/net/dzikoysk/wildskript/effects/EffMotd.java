package net.dzikoysk.wildskript.effects;

import net.dzikoysk.wildskript.util.data.Data;
import org.bukkit.event.Event;
import org.bukkit.event.server.ServerListPingEvent;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffMotd extends Effect {
	
	private Expression<String> s;
	
	protected void execute (Event event) {
		String m = this.s.getSingle(event);
		if(m == null) return;
		m = m.replaceAll(";", System.getProperty("line.separator"));
		if(event instanceof ServerListPingEvent) ((ServerListPingEvent) event).setMotd(m);
        Data.motd = m;
	}
	
	public String toString(Event e, boolean bool) {
		return this.getClass().getName();
	}
	
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult){
	    this.s = (Expression<String>) expressions[0];
	    return true;
	}
}

