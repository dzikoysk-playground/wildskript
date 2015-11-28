package net.dzikoysk.wildskript.effects;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

public class EffReplaceLast extends Effect {

    private Expression<String> string;
    private Expression<String> from;
    private Expression<String> to;

    protected void execute(Event e) {
        String s = this.string.getSingle(e);
        String f = this.from.getSingle(e);
        String t = this.to.getSingle(e);
        if (s == null || f == null || t == null) return;
        StringBuilder b = new StringBuilder(s);
        s = (b.replace(s.lastIndexOf(f), s.lastIndexOf(f) + 1, t)).toString();
    }

    public String toString(Event event, boolean bool) {
        return this.getClass().getName();
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int matchedPattern, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.from = (Expression<String>) expressions[0];
        this.to = (Expression<String>) expressions[1];
        this.string = (Expression<String>) expressions[2];
        return true;
    }
}
