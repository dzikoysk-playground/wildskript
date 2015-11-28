package net.dzikoysk.wildskript.objects.inventory.elements;

import ch.njol.skript.aliases.ItemType;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.inventory.Inventories;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class ExprItem extends SimpleExpression<ItemType> {

    private Expression<String> name;
    private Expression<Number> slot;

    protected ItemType[] get(Event event) {
        String name = this.name.getSingle(event);
        Number slot = this.slot.getSingle(event);
        if (name == null) return null;
        ItemType it = new ItemType();
        ItemStack is = Inventories.get(name).getItem(slot.intValue());
        it.setItemMeta(is.getItemMeta());
        return new ItemType[]{it};
    }

    public boolean isSingle() {
        return true;
    }

    public Class<? extends ItemType> getReturnType() {
        return ItemType.class;
    }

    public String toString(Event event, boolean b) {
        return "[Inventory] Get Item";
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.name = (Expression<String>) expressions[0];
        this.slot = (Expression<Number>) expressions[1];
        return true;
    }
}


	


