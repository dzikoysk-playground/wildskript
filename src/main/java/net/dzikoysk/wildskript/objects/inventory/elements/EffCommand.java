package net.dzikoysk.wildskript.objects.inventory.elements;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.inventory.Inventories;
import org.bukkit.event.Event;

public class EffCommand extends Effect {

    private Expression<String> name;
    private Expression<Number> slot;
    private Expression<String> command;

    protected void execute(Event event) {

        String name = (String) this.name.getSingle(event);
        Number slot = (Number) this.slot.getSingle(event);
        String command = (String) this.command.getSingle(event);
        if (name == null || command == null || slot == null) return;

        int i = slot.intValue();
        Inventories.get(name).setCommand(i, command);

    }

    public String toString(Event event, boolean bool) {
        return "[Inventory] Register name";
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.name = (Expression<String>) expressions[0];
        this.command = (Expression<String>) expressions[2];
        this.slot = (Expression<Number>) expressions[1];
        return true;
    }
}









