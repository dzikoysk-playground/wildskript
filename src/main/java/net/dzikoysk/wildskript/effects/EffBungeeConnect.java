package net.dzikoysk.wildskript.effects;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.WildSkript;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class EffBungeeConnect extends Effect {

    private Expression<Player> p;
    private Expression<String> srv;

    protected void execute(Event event) {
        Player p = this.p.getSingle(event);
        String srv = this.srv.getSingle(event);
        if (p == null || srv == null) {
            return;
        }
        connect(p, srv);
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.p = (Expression<Player>) expressions[0];
        this.srv = (Expression<String>) expressions[1];
        return true;
    }

    public String toString(Event event, boolean bool) {
        return this.getClass().getName();
    }

    public static void connect(Player p, String srv) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF("Connect");
            out.writeUTF(srv);
        } catch (IOException e) {
        }
        p.sendPluginMessage(WildSkript.getInstance(), "BungeeCord", b.toByteArray());
    }


}











