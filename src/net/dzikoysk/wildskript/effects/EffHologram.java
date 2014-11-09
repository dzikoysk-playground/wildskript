package net.dzikoysk.wildskript.effects;

import net.dzikoysk.wildskript.objects.hologram.Hologram;

import org.bukkit.Location;
import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffHologram extends Effect {

	private Expression<String> s;
	private Expression<Location> l;
	private Expression<Number> n;

	protected void execute(Event event) {
		String[] s = this.s.getAll(event);
		Location l = this.l.getSingle(event);
		Number n = this.n.getSingle(event);
		if (s == null || l == null || n== null) return;
		Hologram h = new Hologram(s[0]);
		h.change(s);
		h.show(l, n.intValue());
	}

	public String toString(Event event, boolean bool) {
		return this.getClass().getName();
	}

	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
		this.s = (Expression<String>) expressions[0];
		this.l = (Expression<Location>) expressions[1];
		this.n = (Expression<Number>) expressions[2];
		return true;
	}
}