package net.dzikoysk.wildskript.events;

import net.dzikoysk.wildskript.util.User;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		User.get(e.getPlayer());
	}

}
