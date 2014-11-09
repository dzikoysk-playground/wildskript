package net.dzikoysk.wildskript.objects.hashmap.elements;

import net.dzikoysk.wildskript.objects.hashmap.SkriptHashMap;

import org.bukkit.event.Event;

import ch.njol.skript.doc.NoDoc;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

@NoDoc
public class ExprKeys extends SimpleExpression<Object>{
	
	private Expression<String> id;
	
	protected Object[] get(Event event) {
		String id = this.id.getSingle(event);
		if(id == null) return null;
		Object[] o = SkriptHashMap.get(id).getHashMap().keySet().toArray();
		return new Object[] { o };	 
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
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {    
		this.id = (Expression<String>) expressions[0];
		return true;
	}
}


	

