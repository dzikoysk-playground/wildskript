package net.dzikoysk.wildskript.expressions;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

public class ExprPing extends SimpleExpression<Integer>{

	private static String packageName = Bukkit.getServer().getClass().getPackage().getName();
    private static String version = packageName.substring(packageName.lastIndexOf(".") + 1);
    
	private Expression<Player> player;
	
	protected Integer[] get(Event event) {
		Player p = this.player.getSingle(event);
		if(p == null) return null;
		try{	     
			Class<?> craftPlayer = Class.forName("org.bukkit.craftbukkit." + version + ".entity.CraftPlayer");
			Object cp = craftPlayer.cast(p);
	        Object handle = craftPlayer.getMethod("getHandle").invoke(cp);
			Integer ping = (int) handle.getClass().getField("ping").get(handle);
			return new Integer[] { ping };
		} catch (Exception e){
			e.printStackTrace();
	    }
		return new Integer[] { null };
		
    }

	
	public boolean isSingle() { return true; }

    public Class<? extends Integer> getReturnType() { return Integer.class; }

	public String toString(Event event, boolean b) { 
		return this.getClass().getName();
	}

	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {    
		this.player = (Expression<Player>) expressions[0];
		return true;
	}
}	

