package net.dzikoysk.wildskript.objects.mysql.elements;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.mysql.MySQL;
import org.bukkit.event.Event;

public class EffNew extends Effect {

    private Expression<String> id;
    private Expression<String> host;
    private Expression<Number> port;
    private Expression<String> database;
    private Expression<String> user;
    private Expression<String> pass;

    protected void execute(Event event) {
        String id = this.id.getSingle(event);
        String host = this.host.getSingle(event);
        Number port = this.port.getSingle(event);
        String database = this.database.getSingle(event);
        String user = this.user.getSingle(event);
        String pass = this.pass.getSingle(event);
        if (id == null || host == null || port == null || database == null || user == null || pass == null) {
            return;
        }
        new MySQL(id, host, port.toString(), database, user, pass);
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] e, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.id = (Expression<String>) e[0];
        this.host = (Expression<String>) e[1];
        this.port = (Expression<Number>) e[2];
        this.database = (Expression<String>) e[3];
        this.user = (Expression<String>) e[4];
        this.pass = (Expression<String>) e[5];
        return true;
    }

    public String toString(Event event, boolean b) {
        return this.getClass().getName();
    }
}






