package net.dzikoysk.wildskript.collections.bossbar.elemetns;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.collections.bossbar.BossHealthBar;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class ExprPercent extends SimpleExpression<Integer> {

    private Expression<Player> p;

    protected Integer[] get(Event event) {
        Player p = this.p.getSingle(event);
        Float f = BossHealthBar.percents.get(p);
        if (f != null) {
            return new Integer[]{ f.intValue() * 100 };
        }
        return new Integer[]{ 0 };
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.p = (Expression<Player>) expressions[0];
        return true;
    }

    public boolean isSingle() {
        return true;
    }

    public Class<? extends Integer> getReturnType() {
        return Integer.class;
    }

    public String toString(Event event, boolean b) {
        return this.getClass().getName();
    }
}


	

