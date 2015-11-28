package net.dzikoysk.wildskript.objects.scoreboard.objective.elements;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.scoreboard.Scoreboards;
import net.dzikoysk.wildskript.objects.scoreboard.objective.Scores;
import org.bukkit.event.Event;

public class EffReset extends Effect {

    private Expression<String> id;
    private Expression<String> s;

    protected void execute(Event event) {

        String id = this.id.getSingle(event);
        String s = this.s.getSingle(event);
        if (id == null || s == null) return;

        Scores.reset(Scoreboards.getScoreboard(), s);
    }


    public String toString(Event e, boolean bool) {
        return "";
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.id = (Expression<String>) expressions[0];
        this.s = (Expression<String>) expressions[1];

        return true;
    }

}


