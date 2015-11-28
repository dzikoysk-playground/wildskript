package net.dzikoysk.wildskript.objects.hashmap.elements;

import ch.njol.skript.doc.NoDoc;
import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.hashmap.SkriptHashMap;
import org.bukkit.event.Event;

@NoDoc
public class CondExists extends Condition {

    private Expression<String> id;

    public boolean check(Event event) {
        String id = this.id.getSingle(event);
        if (id == null) return false;
        if (SkriptHashMap.isExists(id)) {
            if (isNegated()) return false;
            return true;
        }
        if (isNegated()) return true;
        return false;
    }

    public String toString(Event event, boolean b) {
        return this.getClass().getName();
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.id = (Expression<String>) expressions[0];
        setNegated(i == 1);
        return true;
    }
}
