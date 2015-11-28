package net.dzikoysk.wildskript.objects.scoreboard.team.elements;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.scoreboard.team.Teams;
import org.bukkit.event.Event;

public class EffFriendlyFire extends Effect {

    private Expression<String> id;
    private Expression<Boolean> b;

    protected void execute(Event event) {

        String id = this.id.getSingle(event);
        Boolean b = this.b.getSingle(event);
        if (id == null || b == null) return;

        Teams.get(id).getTeam().setAllowFriendlyFire(b);

    }


    public String toString(Event e, boolean bool) {
        return "";
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.id = (Expression<String>) expressions[0];
        this.b = (Expression<Boolean>) expressions[1];

        return true;
    }

}


