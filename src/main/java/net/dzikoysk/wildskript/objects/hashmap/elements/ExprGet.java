package net.dzikoysk.wildskript.objects.hashmap.elements;

import ch.njol.skript.doc.NoDoc;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.hashmap.SkriptHashMap;
import org.bukkit.event.Event;

@NoDoc
public class ExprGet extends SimpleExpression<Object> {

    private Expression<String> id;
    private Expression<Object> key;

    protected Object[] get(Event event) {
        String id = this.id.getSingle(event);
        Object key = this.key.getSingle(event);
        if (id == null || key == null) return null;
        Object o = SkriptHashMap.get(id).getHashMap().get(key);
        return new Object[]{o};
    }

    public boolean isSingle() {
        return true;
    }

    public Class<? extends Object> getReturnType() {
        return Object.class;
    }

    public String toString(Event event, boolean b) {
        return this.getClass().getName();
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.id = (Expression<String>) expressions[0];
        this.key = (Expression<Object>) expressions[1];
        return true;
    }
}


	

