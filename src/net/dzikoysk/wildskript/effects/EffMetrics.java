package net.dzikoysk.wildskript.effects;

import net.dzikoysk.wildskript.util.MetricsLite;

import org.bukkit.event.Event;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffMetrics extends Effect {

	private Expression<String> sk;
	private Expression<String> ver;

	protected void execute(Event event) {
		String sk = this.sk.getSingle(event);
		String ver = this.ver.getSingle(event);
		if(sk == null || ver == null) return;
		
		MetricsLite mcs = MetricsLite.get(sk);
		mcs.version(ver);
		mcs.start();
	}

	public String toString(Event event, boolean bool) {
		return this.getClass().getName();
	}

	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
		this.sk = (Expression<String>) expressions[0];
		this.ver = (Expression<String>) expressions[1];
		return true;
	}
}
