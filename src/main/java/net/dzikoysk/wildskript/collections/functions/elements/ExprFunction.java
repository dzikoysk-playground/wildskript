package net.dzikoysk.wildskript.collections.functions.elements;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.collections.functions.Function;
import net.dzikoysk.wildskript.collections.functions.FunctionEvent;
import org.bukkit.event.Event;

public class ExprFunction extends SimpleExpression<Object> {

    private Expression<String> function;
    private Expression<Object> arguments;

    protected Object[] get(Event event) {
        final String function = this.function.getSingle(event);
        if (function == null) return null;

        Object[] os = null;
        if (this.arguments != null) os = this.arguments.getArray(event);
        final Object[] args = os;

        FunctionEvent e = Function.call(function, args);
        while (!e.isFinished()) ;
        return new Object[]{e.getResult()};
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

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.function = (Expression<String>) expressions[0];
        this.arguments = (Expression<Object>) expressions[1];
        return true;
    }
}

