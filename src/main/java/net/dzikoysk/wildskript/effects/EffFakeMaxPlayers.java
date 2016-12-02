package net.dzikoysk.wildskript.effects;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.util.data.Data;
import org.bukkit.event.Event;
import org.bukkit.event.server.ServerListPingEvent;

public class EffFakeMaxPlayers extends Effect {

    private Expression<Number> n;

    protected void execute(Event event) {
        Number n = this.n.getSingle(event);
        if (n == null) {
            return;
        }
        int i = n.intValue();
        if (event instanceof ServerListPingEvent) {
            ((ServerListPingEvent) event).setMaxPlayers(i);
        }
        Data.fakeMaxPlayers = i;
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.n = (Expression<Number>) expressions[0];
        return true;
    }

    public String toString(Event e, boolean bool) {
        return this.getClass().getName();
    }
}

