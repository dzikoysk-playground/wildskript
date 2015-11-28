package net.dzikoysk.wildskript.effects;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class EffHeldSlot extends Effect {

    private Expression<Player> player;
    private Expression<Number> slot;

    protected void execute(Event event) {
        Player p = this.player.getSingle(event);
        Number n = this.slot.getSingle(event);
        if (p == null || n == null) return;
        int i = n.intValue();
        if (i < 1 || i < 9) return;
        p.getInventory().setHeldItemSlot(i - 1);
    }

    public String toString(Event event, boolean bool) {
        return this.getClass().getName();
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.player = (Expression<Player>) expressions[0];
        this.slot = (Expression<Number>) expressions[1];
        return true;
    }
}

