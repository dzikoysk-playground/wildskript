package net.dzikoysk.wildskript.expressions.bukkit;

import ch.njol.skript.doc.NoDoc;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;

@NoDoc
public class ExprAllowEnd extends SimpleExpression<Boolean> {

    protected Boolean[] get(Event event) {
        Boolean allow = Bukkit.getAllowEnd();
        return new Boolean[]{allow};
    }

    public boolean isSingle() {
        return true;
    }

    public Class<? extends Boolean> getReturnType() {
        return Boolean.class;
    }

    public String toString(Event event, boolean b) {
        return this.getClass().getName();
    }

    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        return true;
    }
}


	

