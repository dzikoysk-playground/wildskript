package net.dzikoysk.wildskript.expressions.system;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.WildSkript;
import org.bukkit.event.Event;

public class ExprTPS extends SimpleExpression<Double> {

    protected Double[] get(Event event) {
        double tps = WildSkript.getTimer().getTPS();
        return new Double[]{ tps };
    }

    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        return true;
    }

    public boolean isSingle() {
        return true;
    }

    public Class<? extends Double> getReturnType() {
        return Double.class;
    }

    public String toString(Event event, boolean b) {
        return this.getClass().getName();
    }
}	

