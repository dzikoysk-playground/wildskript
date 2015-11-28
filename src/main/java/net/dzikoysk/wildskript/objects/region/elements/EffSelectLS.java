package net.dzikoysk.wildskript.objects.region.elements;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.region.Regions;
import net.dzikoysk.wildskript.objects.region.RegionsUtils;
import org.bukkit.Location;
import org.bukkit.event.Event;

public class EffSelectLS extends Effect {

    private Expression<String> id;
    private Expression<Location> loc;
    private Expression<Number> size;

    protected void execute(Event event) {

        String id = this.id.getSingle(event);
        Location loc = this.loc.getSingle(event);
        Number size = this.size.getSingle(event);

        if (id == null || loc == null || size == null) return;
        int i = size.intValue();

        Regions region = RegionsUtils.get(id);
        region.setCenter(loc);
        region.setSize(i);


    }

    public String toString(Event event, boolean bool) {
        return "";
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] e, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.id = (Expression<String>) e[0];
        this.loc = (Expression<Location>) e[1];
        this.size = (Expression<Number>) e[2];
        return true;
    }

}




