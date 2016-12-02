package net.dzikoysk.wildskript.effects;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.util.Vector;

public class EffPushFrom extends Effect {

    private Expression<Player> player;
    private Expression<Location> loc;

    protected void execute(Event event) {
        Player p = this.player.getSingle(event);
        Location n = this.loc.getSingle(event);
        if (p == null || n == null) {
            return;
        }
        Vector direction = p.getLocation().toVector().subtract(n.toVector()).normalize();
        p.setVelocity(direction);
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.player = (Expression<Player>) expressions[0];
        this.loc = (Expression<Location>) expressions[1];
        return true;
    }

    public String toString(Event event, boolean bool) {
        return this.getClass().getName();
    }
}