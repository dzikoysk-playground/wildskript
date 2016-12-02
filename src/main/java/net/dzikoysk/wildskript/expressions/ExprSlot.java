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
import org.bukkit.event.inventory.InventoryClickEvent;

@NoDoc
public class ExprSlot extends SimpleExpression<Integer> {

    protected Integer[] get(Event event) {
        if (!(event instanceof InventoryClickEvent)) {
            return new Integer[]{ 0 };
        }
        return new Integer[]{ ((InventoryClickEvent) event).getSlot() };
    }

    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        if (ScriptLoader.isCurrentEvent(InventoryClickEvent.class)) {
            return true;
        }
        Skript.error("Cannot use slot expression outside of a inventory click event!", ErrorQuality.SEMANTIC_ERROR);
        return false;
    }

    public boolean isSingle() {
        return true;
    }

    public Class<? extends Integer> getReturnType() {
        return Integer.class;
    }

    public String toString(Event event, boolean b) {
        return this.getClass().getName();
    }
}


	


