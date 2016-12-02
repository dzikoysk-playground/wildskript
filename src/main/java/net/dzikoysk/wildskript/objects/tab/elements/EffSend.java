package net.dzikoysk.wildskript.objects.tab.elements;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.tab.TabUtils;
import net.dzikoysk.wildskript.util.User;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class EffSend extends Effect {

    private Expression<String> id;
    private Expression<Player> p;

    protected void execute(Event event) {
        String id = this.id.getSingle(event);
        Player p = this.p.getSingle(event);
        if (id == null || p == null) {
            return;
        }
        try {
            TabUtils.sendTab(TabUtils.get(id), User.get(p));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.id = (Expression<String>) expressions[0];
        this.p = (Expression<Player>) expressions[1];
        return true;
    }

    public String toString(Event event, boolean bool) {
        return this.getClass().getName();
    }
}