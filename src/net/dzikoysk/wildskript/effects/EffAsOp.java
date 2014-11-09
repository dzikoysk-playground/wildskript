package net.dzikoysk.wildskript.effects;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;


import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class EffAsOp extends Effect {
	
	private Expression<Player> player;
	private Expression<String> command;
  
  	public void execute (Event event) {
	  for (String command : (String[])this.command.getArray(event)) {
	      if (command.startsWith("/")) command = command.substring(1);
	      if (this.player == null) Skript.dispatchCommand(Bukkit.getConsoleSender(), command);
	      else
	        for (CommandSender sender : (CommandSender[])this.player.getArray(event)){
				 if(!sender.isOp()){
					sender.setOp(true);
					Skript.dispatchCommand(sender, command);
					sender.setOp(false);
				 }else{
					 Skript.dispatchCommand(sender, command);
				 }
	        }
	    }
  	}

	public String toString(Event event, boolean bool) { 
		return this.getClass().getName();
	}
	
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int matchedPattern, Kleenean kleenean, SkriptParser.ParseResult parseResult){	
		this.player = (Expression<Player>) expressions[0];
		this.command = (Expression<String>) expressions[1];
	    return true;
	}
}




