package net.dzikoysk.wildskript.objects.mysql.elements;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.dzikoysk.wildskript.objects.mysql.MySQL;

import org.bukkit.event.Event;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

public class ExprQuery extends SimpleExpression<Object> {
	
	private Expression<String> id;
	private Expression<String> q;
	private Expression<String> c;
	
	protected Object[] get(Event event) {
		String id = this.id.getSingle(event);
		String q = this.q.getSingle(event);
		String c = this.c.getSingle(event);
		if(id == null || q == null || c == null) return null;
		
		MySQL sql = MySQL.get(id);
		if(sql == null) return null;
		
		ResultSet rs = sql.querySQL(q);
		Object res = null;
		try {
			res = rs.getObject(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return new Object[] { res };
	}
	
	public boolean isSingle() { 
		return true;
	}

	public Class<? extends Object> getReturnType() { 
		return Object.class;
	}

	public String toString(Event event, boolean b) { 
		return this.getClass().getName();
	}

	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] e, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {    
		this.id = (Expression<String>) e[0];
		this.q = (Expression<String>) e[1];
		this.c = (Expression<String>) e[2];
		return true;
	}
}








