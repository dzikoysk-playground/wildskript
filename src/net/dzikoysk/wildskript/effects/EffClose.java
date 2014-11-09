package net.dzikoysk.wildskript.effects;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffClose extends Effect {
	
	private Expression<Player> player;
	
	protected void execute (Event event) {
		Player p = this.player.getSingle(event);
		if (p == null) return;
        p.closeInventory();
	}
	
	public String toString(Event event, boolean bool) {
		return this.getClass().getName();
	}
	
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult){
	    this.player = (Expression<Player>) expressions[0];
	    return true;
	}
}



