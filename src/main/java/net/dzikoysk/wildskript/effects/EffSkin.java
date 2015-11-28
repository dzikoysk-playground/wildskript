package net.dzikoysk.wildskript.effects;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class EffSkin extends Effect {

    private Expression<Player> p;
    private Expression<String> to;

    protected void execute(Event event) {
        Player p = this.p.getSingle(event);
        String to = this.to.getSingle(event);
        if (p == null || to == null) return;
    }

    public String toString(Event event, boolean bool) {
        return this.getClass().getName();
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.p = (Expression<Player>) expressions[0];
        this.to = (Expression<String>) expressions[1];
        return true;
    }
}

