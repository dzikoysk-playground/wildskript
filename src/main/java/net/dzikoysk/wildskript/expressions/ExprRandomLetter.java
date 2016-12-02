package net.dzikoysk.wildskript.expressions;

import ch.njol.skript.doc.NoDoc;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

import java.util.Random;

@NoDoc
public class ExprRandomLetter extends SimpleExpression<String> {

    protected String[] get(Event event) {
        Random r = new Random();
        String rc = String.valueOf((char) (r.nextInt(26) + 'a'));
        return new String[]{ rc };
    }

    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        return true;
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
}


