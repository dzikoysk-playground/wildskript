package net.dzikoysk.wildskript.objects.region.elements;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.region.Regions;
import net.dzikoysk.wildskript.objects.region.RegionsUtils;
import org.bukkit.event.Event;

public class EffRestore extends Effect {

    private Expression<String> id;
    private Expression<Regions> f;

    protected void execute(Event event) {
        String id = this.id.getSingle(event);
        Regions f = this.f.getSingle(event);
        if (id == null || f == null) {
            return;
        }

        @SuppressWarnings("unused")
        Regions r = RegionsUtils.get(id);
        r = f;
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.id = (Expression<String>) expressions[0];
        this.f = (Expression<Regions>) expressions[1];
        return true;
    }

    public String toString(Event event, boolean bool) {
        return "";
    }
}









