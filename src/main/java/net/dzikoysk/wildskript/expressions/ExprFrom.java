package net.dzikoysk.wildskript.expressions;

import ch.njol.skript.ScriptLoader;
import ch.njol.skript.Skript;
import ch.njol.skript.doc.NoDoc;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.skript.log.ErrorQuality;
import ch.njol.util.Kleenean;
import org.bukkit.Location;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerMoveEvent;

@NoDoc
public class ExprFrom extends SimpleExpression<Location> {

    protected Location[] get(Event event) {

        Location from = null;
        if (event instanceof PlayerMoveEvent) {
            from = ((PlayerMoveEvent) event).getFrom();
        }
        return new Location[]{ from };

    }

    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        if (!ScriptLoader.isCurrentEvent(PlayerMoveEvent.class)) {
            Skript.error("Cannot use function argument outside of a server list ping event!", ErrorQuality.SEMANTIC_ERROR);
            return false;
        }
        return true;
    }

    public boolean isSingle() {
        return true;
    }

    public Class<? extends Location> getReturnType() {
        return Location.class;
    }

    public String toString(Event event, boolean b) {
        return "";
    }
}


	


