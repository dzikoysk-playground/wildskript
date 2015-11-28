package net.dzikoysk.wildskript.expressions;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

import java.util.Calendar;

public class ExprCalendar extends SimpleExpression<Integer> {

    private int matchedPattern;

    protected Integer[] get(Event event) {
        Calendar now = Calendar.getInstance();
        int i = 0;
        if (this.matchedPattern == 0) i = now.get(Calendar.YEAR);
        if (this.matchedPattern == 1) i = now.get(Calendar.MONTH) + 1;
        if (this.matchedPattern == 2) i = now.get(Calendar.DAY_OF_MONTH);
        if (this.matchedPattern == 3) i = now.get(Calendar.HOUR_OF_DAY);
        if (this.matchedPattern == 4) i = now.get(Calendar.MINUTE);
        if (this.matchedPattern == 5) i = now.get(Calendar.SECOND);
        if (this.matchedPattern == 6) i = now.get(Calendar.MILLISECOND);
        return new Integer[]{i};
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

    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.matchedPattern = i;
        return true;
    }
}	
