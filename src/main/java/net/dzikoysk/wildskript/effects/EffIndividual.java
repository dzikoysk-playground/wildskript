package net.dzikoysk.wildskript.effects;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.util.IndividualPrefix;
import net.dzikoysk.wildskript.util.User;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class EffIndividual extends Effect {

    private int i;

    private Expression<Player> f;
    private Expression<Player> b;
    private Expression<String> text;

    protected void execute(Event event) {
        Player[] psx = this.f.getAll(event);
        Player[] psy = this.b.getAll(event);
        String text = this.text.getSingle(event);

        if (psx == null || psy == null || text == null) return;

        User[] us = new User[psx.length];
        User[] bs = new User[psy.length];

        for (int i = 0; i < psx.length; i++) us[i] = User.get(psx[i]);
        for (int i = 0; i < psy.length; i++) bs[i] = User.get(psy[i]);

        if (i == 1) IndividualPrefix.see(us, bs, "", text);
        else IndividualPrefix.see(us, bs, text, "");
    }

    public String toString(Event e, boolean bool) {
        return this.getClass().getName();
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.i = i;
        this.f = (Expression<Player>) expressions[0];
        this.b = (Expression<Player>) expressions[1];
        this.text = (Expression<String>) expressions[2];
        return true;
    }
}
