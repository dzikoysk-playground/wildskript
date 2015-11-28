package net.dzikoysk.wildskript.objects.region.elements;

import ch.njol.skript.doc.NoDoc;
import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.region.RegionsUtils;
import org.bukkit.Location;
import org.bukkit.event.Event;

@NoDoc
public class CondIsIn extends Condition {
    private Expression<Location> location;

    public boolean check(Event event) {
        Location loc = this.location.getSingle(event);

        if (RegionsUtils.isIn(loc)) {
            if (isNegated()) return false;
            return true;
        }
        if (isNegated()) return true;
        return false;
    }

    public String toString(Event event, boolean b) {
        return "";
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] e, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.location = e[0].getConvertedExpression(new Class[]{Object.class});
        setNegated(i == 1);
        return true;
    }
}
