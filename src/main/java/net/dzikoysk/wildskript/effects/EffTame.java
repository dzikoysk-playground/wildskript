package net.dzikoysk.wildskript.effects;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Tameable;
import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffTame extends Effect {

	private Expression<Player> p;
	private Expression<Entity> e;

	protected void execute(Event event) {
		Player p = this.p.getSingle(event);
		Entity[] es = this.e.getAll(event);
		if (p == null || es == null) return;
		for(Entity e : es)
			if(e instanceof Tameable) ((Tameable) e).setOwner(p);
	}

	public String toString(Event event, boolean bool) {
		return this.getClass().getName();
	}

	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
		this.p = (Expression<Player>) expressions[1];
		this.e = (Expression<Entity>) expressions[0];
		return true;
	}
}

