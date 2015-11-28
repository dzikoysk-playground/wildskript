package net.dzikoysk.wildskript.objects.inventory.elements;

import net.dzikoysk.wildskript.objects.inventory.Inventories;

import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffExecutor extends Effect {
	
	private Expression<String> name;
	private Expression<Number> slot;
	private Expression<String> exc;
	
	protected void execute (Event event) {
		
		String name = (String)this.name.getSingle(event);
		Number slot = (Number)this.slot.getSingle(event);
		String exc = (String)this.exc.getSingle(event);
		if(name == null || slot == null || exc == null) return;
		
		int i = slot.intValue();
		Inventories.get(name).setExecutor(i, exc);
		
	}
	
	public String toString(Event event, boolean bool) { return "[Inventory] Register Executor"; }
	
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult)
	 {
		this.name = (Expression<String>) expressions[0];
		this.slot = (Expression<Number>) expressions[1];
		this.exc = (Expression<String>) expressions[2];
		return true;
	 }
}









