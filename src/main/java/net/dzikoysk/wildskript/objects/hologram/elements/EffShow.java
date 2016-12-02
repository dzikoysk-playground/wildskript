package net.dzikoysk.wildskript.objects.hologram.elements;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.hologram.Hologram;
import org.bukkit.Location;
import org.bukkit.event.Event;

public class EffShow extends Effect {

    private Expression<String> s;
    private Expression<Location> loc;

    protected void execute(Event event) {
        String s = this.s.getSingle(event);
        Location n = this.loc.getSingle(event);
        if (s == null || n == null) {
            return;
        }
        Hologram.get(s).show(n);
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.s = (Expression<String>) expressions[0];
        this.loc = (Expression<Location>) expressions[1];
        return true;
    }

    public String toString(Event event, boolean bool) {
        return this.getClass().getName();
    }
}