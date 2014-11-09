package net.dzikoysk.wildskript.objects.inventory.elements;
import net.dzikoysk.wildskript.objects.inventory.Inventories;

import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffLore extends Effect {
	
	private Expression<String> name;
	private Expression<Number> slot;
	private Expression<String> lore;
	
	protected void execute (Event event) {
		
		String name = (String)this.name.getSingle(event);
		Number slot = (Number)this.slot.getSingle(event);
		String lore = (String)this.lore.getSingle(event);
		if(name == null || lore == null || slot == null) return;
		
		int i = slot.intValue();
		Inventories.get(name).setLore(i, lore);
		
	}
	
	public String toString(Event event, boolean bool) { return "[Inventory] Register lore"; }
	
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult)
	 {
		this.name = (Expression<String>) expressions[0];
		this.lore = (Expression<String>) expressions[2];
		this.slot = (Expression<Number>) expressions[1];
		return true;
	 }
}









