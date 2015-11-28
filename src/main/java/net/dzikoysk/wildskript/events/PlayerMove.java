package net.dzikoysk.wildskript.events;

import net.dzikoysk.wildskript.events.skript.EvtJump;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		Block block, control;
		if (event.getTo().getY() > event.getFrom().getY()) {
			block = event.getPlayer().getWorld().getBlockAt(new Location(event.getPlayer().getWorld(), event.getTo().getX(), event.getTo().getY() + 2, event.getTo().getZ()));
			control = event.getPlayer().getWorld().getBlockAt(new Location(event.getPlayer().getWorld(), event.getTo().getX(), event.getTo().getY() - 2, event.getTo().getZ()));
			if (!(block.getTypeId() != 0 || control.getTypeId() == 0)) {
				EvtJump custom = new EvtJump(event.getPlayer());
		        Bukkit.getServer().getPluginManager().callEvent(custom);
		        if (custom.isCancelled()) {
		        	event.setCancelled(true);
		        }
			}
	     }
	  }

}
