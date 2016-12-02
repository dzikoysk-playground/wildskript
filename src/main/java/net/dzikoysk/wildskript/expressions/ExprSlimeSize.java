package net.dzikoysk.wildskript.expressions;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Slime;
import org.bukkit.event.Event;

public class ExprSlimeSize extends SimpleExpression<Integer> {

    private Expression<Entity> e;

    protected Integer[] get(Event event) {
        Entity e = this.e.getSingle(event);
        if (!(e instanceof Slime)) {
            return new Integer[]{ 0 };
        }
        int i = ((Slime) e).getSize();
        return new Integer[]{ i };
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] e, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.e = (Expression<Entity>) e[0];
        return true;
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


	

