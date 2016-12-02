package net.dzikoysk.wildskript.objects.hologram.elements;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.hologram.Hologram;
import org.bukkit.event.Event;

public class EffChange extends Effect {

    private Expression<String> s;
    private Expression<String> l;

    protected void execute(Event event) {
        String s = this.s.getSingle(event);
        String n[] = this.l.getArray(event);
        if (s == null || n == null) {
            return;
        }
        Hologram.get(s).change(n);
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.s = (Expression<String>) expressions[0];
        this.l = (Expression<String>) expressions[1];
        return true;
    }

    public String toString(Event event, boolean bool) {
        return this.getClass().getName();
    }
}