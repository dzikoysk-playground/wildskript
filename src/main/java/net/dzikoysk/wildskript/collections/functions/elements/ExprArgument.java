package net.dzikoysk.wildskript.collections.functions.elements;

import ch.njol.skript.ScriptLoader;
import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.skript.log.ErrorQuality;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.collections.functions.FunctionEvent;
import org.bukkit.event.Event;

public class ExprArgument extends SimpleExpression<Object> {

    private Expression<Number> n;

    protected Object[] get(Event event) {
        if (event instanceof FunctionEvent) {
            Number n = this.n.getSingle(event);
            if (n == null) {
                return null;
            }
            int i = n.intValue() - 1;
            if (((FunctionEvent) event).getArgs() == null) {
                return null;
            }
            if (i > ((FunctionEvent) event).getArgs().length) {
                return null;
            }
            return new Object[]{ ((FunctionEvent) event).getArgs()[i] };
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        if (ScriptLoader.isCurrentEvent(FunctionEvent.class)) {
            this.n = (Expression<Number>) expressions[0];
            return true;
        }
        Skript.error("Cannot use function argument outside of a function!", ErrorQuality.SEMANTIC_ERROR);
        return false;
    }

    public boolean isSingle() {
        return true;
    }

    public Class<? extends Object> getReturnType() {
        return Object.class;
    }

    public String toString(Event event, boolean bool) {
        return this.getClass().getName();
    }
}


