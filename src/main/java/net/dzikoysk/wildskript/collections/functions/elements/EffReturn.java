package net.dzikoysk.wildskript.collections.functions.elements;

import ch.njol.skript.ScriptLoader;
import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.log.ErrorQuality;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.collections.functions.FunctionEvent;
import org.bukkit.event.Event;

public class EffReturn extends Effect {

    private Expression<Object> result;

    protected void execute(Event event) {
        Object o = result.getSingle(event);
        if (event instanceof FunctionEvent) {
            ((FunctionEvent) event).setResult(o);
        }
        this.getTrigger().setNext(null);
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        if (ScriptLoader.isCurrentEvent(FunctionEvent.class)) {
            this.result = (Expression<Object>) expressions[0];
            return true;
        }
        Skript.error("Cannot use return effect outside of a function!", ErrorQuality.SEMANTIC_ERROR);
        return false;
    }

    public String toString(Event event, boolean bool) {
        return this.getClass().getName();
    }
}









