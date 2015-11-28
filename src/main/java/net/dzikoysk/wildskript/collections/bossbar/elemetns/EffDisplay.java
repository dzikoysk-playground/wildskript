package net.dzikoysk.wildskript.collections.bossbar.elemetns;

import net.dzikoysk.wildskript.WildSkript;
import net.dzikoysk.wildskript.collections.bossbar.BossHealthBar;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffDisplay extends Effect {
	
	private Expression<Player> player;
	private Expression<String> text;
	private Expression<Number> percent;
	private Expression<Number> time;
	
	protected void execute (Event event) {
		
		final Player player = this.player.getSingle(event);
		String text = this.text.getSingle(event);
		Number pn = this.percent.getSingle(event);
		Number pt = this.time.getSingle(event);
		if(player == null || text == null) return;

		int percent = 0;
		if(pn != null) percent = pn.intValue();
		if(percent < 1) percent = 1;
		if(percent > 100) percent = 100;
		
		float p = (float)percent/100;
		BossHealthBar.display(player, text, p);
		
		if(pt != null && pt.intValue() > 0) Bukkit.getScheduler().runTaskLater(WildSkript.getInstance(), new Runnable(){
		    @Override
		    public void run(){
		    	BossHealthBar.remove(player);
		    }
		}, pt.intValue()*20);
	}
	
	public String toString(Event e, boolean bool) {
		return this.getClass().getName();
	}
	
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult){
		this.text = (Expression<String>) expressions[0];
		this.percent = (Expression<Number>) expressions[1];
		this.time = (Expression<Number>) expressions[2];
	    this.player = (Expression<Player>) expressions[3];
	    return true;
	}
}

