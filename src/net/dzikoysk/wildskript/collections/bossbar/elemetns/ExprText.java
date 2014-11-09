package net.dzikoysk.wildskript.collections.bossbar.elemetns;

import net.dzikoysk.wildskript.collections.bossbar.BossHealthBar;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

public class ExprText extends SimpleExpression<String>{

	private Expression<Player> p;
	
	protected String[] get(Event event) {
		Player p = this.p.getSingle(event);
		return new String[] { BossHealthBar.texts.get(p) };
	}

	public boolean isSingle() { 
		return true;
	}

	public Class<? extends String> getReturnType() { 
		return String.class;
	}

	public String toString(Event event, boolean b) { 
		return this.getClass().getName();
	}

	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {    
		this.p = (Expression<Player>) expressions[0];
		return true;
	}
}


	

