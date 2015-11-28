package net.dzikoysk.wildskript.objects.region.elements;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.region.Regions;
import net.dzikoysk.wildskript.objects.region.RegionsUtils;
import org.bukkit.Location;
import org.bukkit.event.Event;


public class ExprRegionAt extends SimpleExpression<String> {

    private Expression<Location> loc;

    protected String[] get(Event event) {

        Location loc = this.loc.getSingle(event);
        Regions region = RegionsUtils.getAt(loc);
        String name = null;
        if (region != null) name = region.getID();
        return new String[]{name};
    }


    public boolean isSingle() {
        return true;
    }

    public Class<? extends String> getReturnType() {
        return String.class;
    }

    public String toString(Event event, boolean b) {
        return "";
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] e, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.loc = (Expression<Location>) e[0];
        return true;
    }
}


	

