package net.dzikoysk.wildskript.objects.inventory.elements;

import net.dzikoysk.wildskript.objects.inventory.Inventories;

import org.bukkit.event.Event;

import ch.njol.skript.aliases.ItemType;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffItem extends Effect {
	
	private Expression<String> name;
	private Expression<Number> slot;
	private Expression<ItemType> item;
	
	protected void execute (Event event) {
		
		String name = this.name.getSingle(event);
		Number slot = this.slot.getSingle(event);
		ItemType item = this.item.getSingle(event);
		if(name == null || slot == null || item == null) return;
		
		int i = slot.intValue();
		Inventories.get(name).setItem(i, item);
		
	}
	
	public String toString(Event event, boolean bool) { return "[Inventory] setItem"; }
	
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult)
	 {
		this.name = (Expression<String>) expressions[0];
		this.item = (Expression<ItemType>) expressions[2];
		this.slot = (Expression<Number>) expressions[1];
		return true;
	 }
}









