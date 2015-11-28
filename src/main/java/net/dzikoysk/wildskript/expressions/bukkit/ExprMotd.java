package net.dzikoysk.wildskript.expressions.bukkit;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.util.data.Data;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;

public class ExprMotd extends SimpleExpression<String> {

    protected String[] get(Event event) {
        String motd = Bukkit.getMotd();
        if (Data.motd != null) motd = Data.motd;
        return new String[]{motd};
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

    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        return true;
    }
}


	

