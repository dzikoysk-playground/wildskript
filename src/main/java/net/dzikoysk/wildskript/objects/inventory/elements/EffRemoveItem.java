package net.dzikoysk.wildskript.objects.inventory.elements;

import net.dzikoysk.wildskript.objects.inventory.Inventories;

import org.bukkit.event.Event;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffRemoveItem extends Effect {
	
	private Expression<String> name;
	private Expression<Number> slot;
	
	protected void execute (Event event) {
		
		String name = (String)this.name.getSingle(event);
		Number slot = (Number)this.slot.getSingle(event);
		if(name == null || slot == null) return;
		
		int i = slot.intValue();
		Inventories.get(name).removeItem(i);
		
	}
	
	public String toString(Event event, boolean bool) { return "[Inventory] Remove Item"; }
	
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult)
	 {
		this.name = (Expression<String>) expressions[0];
		this.slot = (Expression<Number>) expressions[1];
		return true;
	 }
}









