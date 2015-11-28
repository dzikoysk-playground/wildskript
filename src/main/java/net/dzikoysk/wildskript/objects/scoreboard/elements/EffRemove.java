package net.dzikoysk.wildskript.objects.scoreboard.elements;

import net.dzikoysk.wildskript.objects.scoreboard.Scoreboards;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffRemove extends Effect {
	
	private Expression<Player> p;
	
	protected void execute (Event event) {
		
		Player p = this.p.getSingle(event);
		if(p == null) return;
		p.setScoreboard(Scoreboards.getScoreboardManager().getNewScoreboard());
	}
	
	
	public String toString(Event e, boolean bool) { return ""; }
	
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult){
		this.p = (Expression<Player>) expressions[0];

	    return true;
	 }

}


