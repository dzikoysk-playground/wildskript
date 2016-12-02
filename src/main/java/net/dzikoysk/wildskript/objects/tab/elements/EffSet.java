package net.dzikoysk.wildskript.objects.tab.elements;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.tab.TabUtils;
import org.bukkit.event.Event;

public class EffSet extends Effect {

    private Expression<String> id;
    private Expression<Number> n;
    private Expression<String> text;

    protected void execute(Event event) {
        String id = this.id.getSingle(event);
        Number n = this.n.getSingle(event);
        String text = this.text.getSingle(event);
        if (id == null || n == null || text == null) {
            return;
        }
        int i = n.intValue();
        if (i < 1 || i > 60) {
            return;
        }
        TabUtils.get(id).set(i - 1, text);
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.id = (Expression<String>) expressions[0];
        this.n = (Expression<Number>) expressions[1];
        this.text = (Expression<String>) expressions[2];
        return true;
    }

    public String toString(Event event, boolean bool) {
        return this.getClass().getName();
    }
}