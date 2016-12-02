package net.dzikoysk.wildskript.objects.recipe.elements;

import ch.njol.skript.aliases.ItemType;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.recipe.Recipes;
import org.bukkit.event.Event;

public class EffResult extends Effect {

    private Expression<String> id;
    private Expression<ItemType> r;

    protected void execute(Event event) {
        String id = this.id.getSingle(event);
        ItemType r = this.r.getSingle(event);
        if (id == null || r == null) {
            return;
        }

        Recipes.get(id).setResult(r.getRandom());

    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.id = (Expression<String>) expressions[0];
        this.r = (Expression<ItemType>) expressions[1];
        return true;
    }

    public String toString(Event event, boolean bool) {
        return "";
    }
}









