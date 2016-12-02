package net.dzikoysk.wildskript.objects.scoreboard.objective.elements;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.scoreboard.objective.Objectives;
import org.bukkit.event.Event;

public class EffRegister extends Effect {

    private Expression<String> id;
    private Expression<String> criteria;

    protected void execute(Event event) {

        String id = this.id.getSingle(event);
        String c = this.criteria.getSingle(event);
        if (id == null || c == null) {
            return;
        }

        Objectives.get(id, c);

    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.id = (Expression<String>) expressions[0];
        this.criteria = (Expression<String>) expressions[1];

        return true;
    }

    public String toString(Event e, boolean bool) {
        return "";
    }

}


