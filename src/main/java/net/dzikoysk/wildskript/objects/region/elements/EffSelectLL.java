package net.dzikoysk.wildskript.objects.region.elements;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.region.Regions;
import net.dzikoysk.wildskript.objects.region.RegionsUtils;
import org.bukkit.Location;
import org.bukkit.event.Event;

public class EffSelectLL extends Effect {

    private Expression<String> id;
    private Expression<Location> loc1;
    private Expression<Location> loc2;

    protected void execute(Event event) {

        String id = this.id.getSingle(event);
        Location loc1 = this.loc1.getSingle(event);
        Location loc2 = this.loc2.getSingle(event);

        if (id == null || loc1 == null || loc2 == null) {
            return;
        }

        Regions region = RegionsUtils.get(id);
        region.setL(loc1);
        region.setP(loc2);


    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] e, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.id = (Expression<String>) e[0];
        this.loc1 = (Expression<Location>) e[1];
        this.loc2 = (Expression<Location>) e[2];
        return true;
    }

    public String toString(Event event, boolean bool) {
        return "";
    }

}




