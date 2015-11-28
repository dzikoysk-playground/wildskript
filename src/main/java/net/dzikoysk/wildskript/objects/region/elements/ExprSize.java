package net.dzikoysk.wildskript.objects.region.elements;

import ch.njol.skript.doc.NoDoc;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.region.RegionsUtils;
import org.bukkit.event.Event;

@NoDoc
public class ExprSize extends SimpleExpression<Integer> {

    private Expression<String> id;

    protected Integer[] get(Event event) {
        String id = this.id.getSingle(event);
        int s = RegionsUtils.get(id).getSize();
        return new Integer[]{s};
    }


    public boolean isSingle() {
        return true;
    }

    public Class<? extends Integer> getReturnType() {
        return Integer.class;
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


	

