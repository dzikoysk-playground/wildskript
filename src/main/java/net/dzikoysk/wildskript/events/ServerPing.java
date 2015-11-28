package net.dzikoysk.wildskript.events;

import net.dzikoysk.wildskript.util.data.Data;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerPing implements Listener {
	
	public void onServerListPing(ServerListPingEvent e) {
		if(Data.motd != null) e.setMotd(Data.motd);
		if(Data.fakeMaxPlayers != null) e.setMaxPlayers(Data.fakeMaxPlayers);
		try {
			if(Data.iconFile != null) e.setServerIcon(Bukkit.loadServerIcon(Data.iconFile));
			else if(Data.iconImage != null) e.setServerIcon(Bukkit.loadServerIcon(Data.iconImage));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
	
	
	


