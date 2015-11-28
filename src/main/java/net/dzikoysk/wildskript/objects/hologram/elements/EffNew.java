package net.dzikoysk.wildskript.objects.hologram.elements;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.hologram.Hologram;
import org.bukkit.event.Event;

public class EffNew extends Effect {

    private Expression<String> s;

    protected void execute(Event event) {
        String s = this.s.getSingle(event);
        if (s == null) return;
        Hologram.get(s);
    }

    public String toString(Event event, boolean bool) {
        return this.getClass().getName();
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.s = (Expression<String>) expressions[0];
        return true;
    }
}