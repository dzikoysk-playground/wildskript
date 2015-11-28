package net.dzikoysk.wildskript.objects.inventory.elements;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.inventory.Inventories;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class EffDisplay extends Effect {

    private Expression<String> name;
    private Expression<Player> player;

    protected void execute(Event event) {

        String name = (String) this.name.getSingle(event);
        Player p = (Player) this.player.getSingle(event);
        if (name == null || p == null) return;

        Inventories inv = Inventories.get(name);
        inv.display(p);

    }

    public String toString(Event event, boolean bool) {
        return "[Inventory] Display";
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.name = (Expression<String>) expressions[0];
        this.player = (Expression<Player>) expressions[1];
        return true;
    }
}









