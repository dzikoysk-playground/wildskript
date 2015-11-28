package net.dzikoysk.wildskript.objects.region.elements;

import net.dzikoysk.wildskript.objects.region.RegionsUtils;

import org.bukkit.World;
import org.bukkit.event.Event;

import ch.njol.skript.doc.NoDoc;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

@NoDoc
public class ExprWorld extends SimpleExpression<World>{
	
	private Expression<String> id;
	
	protected World[] get(Event event) {
	   
		  String id = this.id.getSingle(event);
		  
		  World world = RegionsUtils.get(id).getWorld();
		  return new World[] { world };
		 
	  }

	
	public boolean isSingle() { return true; }

	public Class<? extends World> getReturnType() { return World.class; }

	public String toString(Event event, boolean b) { return ""; }

	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] e, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {    
		this.id = (Expression<String>) e[0];
		return true;
	  }
	}


	

