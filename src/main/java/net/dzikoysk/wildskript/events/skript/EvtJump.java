package net.dzikoysk.wildskript.events.skript;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class EvtJump extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private Player p;

    public EvtJump(Player p) {
        this.p = p;
    }

    public void setCancelled(boolean c) {
        this.cancel = c;
    }

    public Player getPlayer() {
        return this.p;
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


}
