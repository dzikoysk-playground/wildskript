package net.dzikoysk.wildskript.objects.region.elements;

import ch.njol.skript.doc.NoDoc;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.region.RegionsUtils;
import org.bukkit.Location;
import org.bukkit.event.Event;

@NoDoc
public class ExprCenter extends SimpleExpression<Location> {

    private Expression<String> id;

    protected Location[] get(Event event) {

        String id = this.id.getSingle(event);

        Location loc = RegionsUtils.get(id).getCenter();
        return new Location[]{loc};

    }


    public boolean isSingle() {
        return true;
    }

    public Class<? extends Location> getReturnType() {
        return Location.class;
    }

    public String toString(Event event, boolean b) {
        return "";
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] e, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.id = (Expression<String>) e[0];
        return true;
    }
}


	

