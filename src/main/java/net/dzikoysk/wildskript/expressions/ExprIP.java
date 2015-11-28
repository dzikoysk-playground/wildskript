package net.dzikoysk.wildskript.expressions;

import ch.njol.skript.ScriptLoader;
import ch.njol.skript.Skript;
import ch.njol.skript.doc.NoDoc;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.skript.log.ErrorQuality;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;
import org.bukkit.event.server.ServerListPingEvent;

@NoDoc
public class ExprIP extends SimpleExpression<String> {

    protected String[] get(Event event) {
        String ip = null;
        if (event instanceof ServerListPingEvent) ip = ((ServerListPingEvent) event).getAddress().getHostAddress();
        return new String[]{ip};
    }

    public boolean isSingle() {
        return true;
    }

    public Class<? extends String> getReturnType() {
        return String.class;
    }

    public String toString(Event event, boolean b) {
        return this.getClass().getName();
    }

    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        if (!ScriptLoader.isCurrentEvent(ServerListPingEvent.class)) return true;
        Skript.error("Cannot use function argument outside of a server list ping event!", ErrorQuality.SEMANTIC_ERROR);
        return false;
    }
}


	


