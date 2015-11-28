package net.dzikoysk.wildskript.objects.region.elements;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.region.RegionsUtils;
import org.bukkit.Location;
import org.bukkit.event.Event;

public class EffP extends Effect {

    private Expression<String> id;
    private Expression<Location> l;

    protected void execute(Event event) {

        String id = this.id.getSingle(event);
        Location l = this.l.getSingle(event);

        if (id == null || l == null) return;

        RegionsUtils.get(id).setP(l);
    }

    public String toString(Event event, boolean bool) {
        return "";
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] e, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.id = (Expression<String>) e[0];
        this.l = (Expression<Location>) e[1];
        return true;
    }

}




