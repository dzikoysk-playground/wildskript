package net.dzikoysk.wildskript.objects.region.elements;

import ch.njol.skript.doc.NoDoc;
import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.region.RegionsUtils;
import org.bukkit.event.Event;

@NoDoc
public class CondExists extends Condition {
    private Expression<String> id;

    public boolean check(Event event) {
        String id = this.id.getSingle(event);

        if (RegionsUtils.exists(id)) {
            if (isNegated()) {
                return false;
            }
            return true;
        }
        if (isNegated()) {
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] e, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.id = e[0].getConvertedExpression(new Class[]{ Object.class });
        setNegated(i == 1);
        return true;
    }

    public String toString(Event event, boolean b) {
        return "";
    }
}
