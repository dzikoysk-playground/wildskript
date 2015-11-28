package net.dzikoysk.wildskript.events.skript;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class EvtSetMotd extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private String m;

    public EvtSetMotd(String m) {
        this.cancel = false;
        this.m = m;
    }

    public String getMotd() {
        return this.m;
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

