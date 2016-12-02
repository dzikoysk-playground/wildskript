package net.dzikoysk.wildskript.objects.mysql.elements;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.mysql.MySQL;
import org.bukkit.event.Event;

public class EffUpdate extends Effect {

    private Expression<String> id;
    private Expression<String> update;

    protected void execute(Event event) {
        String id = this.id.getSingle(event);
        String[] update = this.update.getAll(event);
        if (id == null || update == null) {
            return;
        }
        MySQL sql = MySQL.get(id);
        if (sql != null) {
            sql.updateSQL(update);
        }
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] e, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.id = (Expression<String>) e[0];
        this.update = (Expression<String>) e[1];
        return true;
    }

    public String toString(Event event, boolean bool) {
        return this.getClass().getName();
    }
}








