package net.dzikoysk.wildskript.objects.inventory.elements;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.inventory.Inventories;
import org.bukkit.event.Event;

public class EffName extends Effect {

    private Expression<String> id;
    private Expression<String> name;

    protected void execute(Event event) {

        String id = (String) this.id.getSingle(event);
        String name = (String) this.name.getSingle(event);
        if (id == null || name == null) return;

        Inventories.get(id).setName(name);

    }

    public String toString(Event event, boolean bool) {
        return "[Inventory] Register";
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.id = (Expression<String>) expressions[0];
        this.name = (Expression<String>) expressions[1];
        return true;
    }
}









