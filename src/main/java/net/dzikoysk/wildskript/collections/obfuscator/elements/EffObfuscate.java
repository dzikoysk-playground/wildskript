package net.dzikoysk.wildskript.collections.obfuscator.elements;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.collections.obfuscator.Obfuscator;
import org.bukkit.event.Event;

public class EffObfuscate extends Effect {

    private Expression<String> from;
    private Expression<String> to;
    private Expression<Number> power;

    protected void execute(Event event) {
        String from = this.from.getSingle(event);
        String to = this.to.getSingle(event);
        Number power = this.power.getSingle(event);
        if (from == null || to == null || power == null) return;
        try {
            Obfuscator.to(from, to, power.intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString(Event event, boolean bool) {
        return this.getClass().getName();
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.from = (Expression<String>) expressions[0];
        this.to = (Expression<String>) expressions[1];
        this.power = (Expression<Number>) expressions[2];
        return true;
    }
}