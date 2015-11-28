package net.dzikoysk.wildskript.collections.functions;

import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import org.bukkit.event.Event;

public class FunctionAdapter extends SkriptEvent {

    private String name;

    public boolean check(Event event) {
        if (event instanceof FunctionEvent) if (((FunctionEvent) event).getName().equals(name)) return true;
        return false;
    }

    public String toString(Event event, boolean bool) {
        return this.getClass().getName();
    }

    public boolean init(Literal<?>[] args, int matchedPattern, SkriptParser.ParseResult parser) {
        this.name = ((String) args[0].getSingle());
        if (this.name == null) return false;
        return true;
    }
}
