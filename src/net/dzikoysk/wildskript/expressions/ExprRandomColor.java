package net.dzikoysk.wildskript.expressions;

import java.util.Random;

import org.bukkit.event.Event;

import ch.njol.skript.doc.NoDoc;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

@NoDoc
public class ExprRandomColor extends SimpleExpression<String>{

	public static String[] c = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	
	protected String[] get(Event event) {
		Random random = new Random();
		String rc = "&" + c[random.nextInt(c.length)];
		return new String[] { rc };
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

	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {    
		return true;
	}
}


