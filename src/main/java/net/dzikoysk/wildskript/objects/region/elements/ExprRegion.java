package net.dzikoysk.wildskript.objects.region.elements;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.region.Regions;
import net.dzikoysk.wildskript.objects.region.RegionsUtils;
import org.bukkit.event.Event;

public class ExprRegion extends SimpleExpression<Regions> {

    private Expression<String> id;

    protected Regions[] get(Event event) {

        String id = this.id.getSingle(event);

        Regions r = RegionsUtils.get(id);
        return new Regions[]{ r };

    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] e, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.id = (Expression<String>) e[0];
        return true;
    }

    public boolean isSingle() {
        return true;
    }

    public Class<? extends Regions> getReturnType() {
        return Regions.class;
    }

    public String toString(Event event, boolean b) {
        return "";
    }
}


	

