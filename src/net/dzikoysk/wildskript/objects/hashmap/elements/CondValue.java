package net.dzikoysk.wildskript.objects.hashmap.elements;

import net.dzikoysk.wildskript.objects.hashmap.SkriptHashMap;

import org.bukkit.event.Event;
import ch.njol.skript.doc.NoDoc;
import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

@NoDoc
public class CondValue extends Condition{

  private Expression<String> id;
  private Expression<Object> o;
  
  public boolean check(Event event){
	  Object o = this.o.getSingle(event);
	  String id = this.id.getSingle(event);
	  if(o == null || id == null) return false;
	  if(SkriptHashMap.get(id).getHashMap().containsValue(o)){
		  if (isNegated()) return false;
		  return true;
	  }
	  if (isNegated()) return true;
	  return false;
  }

  public String toString(Event event, boolean b) { 
	  return this.getClass().getName();
  }

  @SuppressWarnings("unchecked")
  public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
	this.o = (Expression<Object>) expressions[1];
	this.id = (Expression<String>) expressions[0];
    setNegated(i == 1);
    return true;
  }
}
