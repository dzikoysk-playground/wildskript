package net.dzikoysk.wildskript.objects.recipe.elements;

import ch.njol.skript.aliases.ItemType;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.recipe.Recipes;
import org.bukkit.event.Event;

public class EffIngredient extends Effect {

    private Expression<String> id;
    private Expression<Number> i;
    private Expression<ItemType> is;

    protected void execute(Event event) {
        String id = this.id.getSingle(event);
        int i = this.i.getSingle(event).intValue();
        ItemType ing = this.is.getSingle(event);
        if (id == null || ing == null) {
            return;
        }
        if (i < 1 || i > 9) {
            return;
        }

        Recipes.get(id).setIngredient(i - 1, ing.getRandom());

    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.id = (Expression<String>) expressions[0];
        this.i = (Expression<Number>) expressions[1];
        this.is = (Expression<ItemType>) expressions[2];
        return true;
    }

    public String toString(Event event, boolean bool) {
        return this.getClass().getName();
    }
}









