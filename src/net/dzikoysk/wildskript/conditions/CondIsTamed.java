package net.dzikoysk.wildskript.conditions;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Tameable;
import org.bukkit.event.Event;
import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class CondIsTamed extends Condition{
  
	private int matchedPattern;
	private Expression<Entity> e;

	public boolean check(Event event){
		Entity e = this.e.getSingle(event);
		if (e == null) return false;
		if(e instanceof Tameable){
			if (((Tameable) e).isTamed()) {
				if(matchedPattern == 1) return false;
				return true;
			}
		}
		if(matchedPattern == 1) return true;
		return false;
  }

  public String toString(Event event, boolean b){
	  return this.getClass().getName();
  }

  @SuppressWarnings("unchecked")
  public boolean init(Expression<?>[] expressions, int matchedPattern, Kleenean kleenean, SkriptParser.ParseResult parseResult){
	this.matchedPattern = matchedPattern;
    this.e = (Expression<Entity>) expressions[0];
    return true;
  }
}
