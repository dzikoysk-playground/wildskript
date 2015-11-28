package net.dzikoysk.wildskript.collections.bossbar.elemetns;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.collections.bossbar.BossHealthBar;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class EffRemove extends Effect {

    private Expression<Player> player;

    protected void execute(Event event) {
        Player player = this.player.getSingle(event);
        if (player == null) return;
        BossHealthBar.remove(player);
    }

    public String toString(Event e, boolean bool) {
        return this.getClass().getName();
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.player = (Expression<Player>) expressions[0];
        return true;
    }
}

