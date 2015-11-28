package net.dzikoysk.wildskript.collections.loader.elements;

import net.dzikoysk.wildskript.collections.loader.Loader;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffPlugin extends Effect {
	
	private int matchedPattern;
	private Expression<String> s;
	
	protected void execute (Event event) {
		String s = this.s.getSingle(event);
		if (s == null) return;
		
		PluginManager pm = Bukkit.getPluginManager();
	
		if(matchedPattern == 0){
			Loader.loadPlugin(s);
		}else if (matchedPattern == 1){
			Plugin plugin = pm.getPlugin(s);
			pm.disablePlugin(plugin);
		}
	}
	
	public String toString(Event event, boolean bool) {
		return this.getClass().getName();
	}
	
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult){ 
	    this.matchedPattern = i;
		this.s = (Expression<String>) expressions[0];
	    return true;
	}
}