package net.dzikoysk.wildskript.effects;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffVisibility extends Effect {

	private int matchedPattern;
	private Expression<Player> hidden;
	private Expression<Player> to;

	protected void execute(Event event) {
		Player hide = this.hidden.getSingle(event);
		Player[] tos = this.to.getAll(event);
		if (hide == null || to == null) return;
		if(this.matchedPattern == 0) for(Player to : tos) to.hidePlayer(hide);
		else for(Player to : tos) to.showPlayer(hide);
	}

	public String toString(Event event, boolean bool) {
		return this.getClass().getName();
	}

	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
		this.matchedPattern = i;
		this.hidden = (Expression<Player>) expressions[0];
		this.to = (Expression<Player>) expressions[1];
		return true;
	}
}

