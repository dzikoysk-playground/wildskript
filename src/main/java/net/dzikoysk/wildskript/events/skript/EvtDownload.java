package net.dzikoysk.wildskript.events.skript;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class EvtDownload extends Event implements Cancellable{
	
	private static final HandlerList handlers = new HandlerList();
	private boolean cancel = false;
	private String url;
	
	public EvtDownload(String url){
		this.cancel = false;
		this.url = url;
	}
	
	public String getUrl() {
		return this.url;
	}
	
    @Override
	public HandlerList getHandlers() {
		return handlers;
	}
    
	public static HandlerList getHandlerList() {
		return handlers;
	}
	
	public boolean isCancelled() {
        return cancel;
    }
	
	public void setCancelled(boolean c) {
		this.cancel = c;
    }

    



	
	
	
	
}
