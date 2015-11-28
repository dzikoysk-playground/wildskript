package net.dzikoysk.wildskript.objects.region.elements;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.region.RegionsUtils;
import org.bukkit.event.Event;

public class EffHeight extends Effect {

    private Expression<String> id;
    private Expression<Number> s;

    protected void execute(Event event) {

        String id = this.id.getSingle(event);
        Number s = this.s.getSingle(event);
        if (id == null || s == null) return;
        int i = s.intValue();

        RegionsUtils.get(id).setHeight(i);
    }

    public String toString(Event event, boolean bool) {
        return "";
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] e, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.id = (Expression<String>) e[0];
        this.s = (Expression<Number>) e[1];
        return true;
    }

}




