package net.dzikoysk.wildskript.objects.inventory.elements;

import net.dzikoysk.wildskript.objects.inventory.Inventories;

import org.bukkit.event.Event;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

public class ExprRow extends SimpleExpression<Integer>{

	private Expression<String> name;

	protected Integer[] get(Event event) {
		String name = (String)this.name.getSingle(event);
		if(name == null) return null;
		return new Integer[] { Inventories.get(name).getRow() };
	}

	public boolean isSingle() { 
		return true;
	}

	public Class<? extends Integer> getReturnType() { 
		return Integer.class;
	}

	public String toString(Event event, boolean b) { 
		return "[Inventory] Get Row";
	}

	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {    
		
		this.name = (Expression<String>) expressions[0];
		return true;
	  }
	}


	

