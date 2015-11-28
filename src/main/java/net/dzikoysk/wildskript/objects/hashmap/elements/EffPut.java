package net.dzikoysk.wildskript.objects.hashmap.elements;

import net.dzikoysk.wildskript.objects.hashmap.SkriptHashMap;

import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffPut extends Effect {
	
	private Expression<String> name;
	private Expression<Object> key;
	private Expression<Object> value;
	
	protected void execute (Event event) {
		String name = (String)this.name.getSingle(event);
		Object key = (Object)this.key.getSingle(event);
		Object value = (Object)this.value.getSingle(event);
		if(name == null || key == null || value == null) return;
		SkriptHashMap.get(name).getHashMap().put(key, value);	
	}
	
	public String toString(Event event, boolean bool) { 
		return this.getClass().getName();
	}
	
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult){
		this.name = (Expression<String>) expressions[0];
		this.key = (Expression<Object>) expressions[1];
		this.value = (Expression<Object>) expressions[2];
	    return true;
	}
}









