package net.dzikoysk.wildskript.objects.tab.elements;

import net.dzikoysk.wildskript.objects.tab.TabUtils;
import org.bukkit.event.Event;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffRestore extends Effect {

	private Expression<String> id;
	private Expression<String> b;

	protected void execute(Event event) {
		String id = this.id.getSingle(event);
		String s = this.b.getSingle(event);
		if (id == null || s == null) return;
		
		String[] b = s.split(";;;");
		if(b.length < 60) return;
		String[] prefix = new String[60];
		String[] center = new String[60];
		String[] suffix = new String[60];
		
		for(int i = 0; i < 60; i++){
			String[] todo = b[i].split(";;");
	        prefix[i] = todo[0].replace("<EMPTY>", "");
	        center[i] = todo[1];
	        suffix[i] = todo[2].replace("<EMPTY>", "");
		}
		TabUtils.get(id).backup(prefix, center, suffix);
	}

	public String toString(Event event, boolean bool) {
		return this.getClass().getName();
	}

	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
		this.id = (Expression<String>) expressions[0];
		this.b = (Expression<String>) expressions[1];
		return true;
	}
}