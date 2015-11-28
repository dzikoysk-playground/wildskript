package net.dzikoysk.wildskript.collections.obfuscator.elements;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.collections.loader.Loader;
import net.dzikoysk.wildskript.collections.obfuscator.Obfuscator;
import org.bukkit.event.Event;

import java.io.File;
import java.util.regex.Matcher;

public class EffLoad extends Effect {

    private Expression<String> from;
    private Expression<Number> n;

    protected void execute(Event event) {
        String from = this.from.getSingle(event);
        Number power = this.n.getSingle(event);
        if (from == null || power == null) return;
        String code = "";
        try {
            code = Obfuscator.load(new File(from.replaceAll("/", Matcher.quoteReplacement(File.separator))), power.intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Loader.loadString(code);
    }

    public String toString(Event event, boolean bool) {
        return this.getClass().getName();
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.from = (Expression<String>) expressions[0];
        this.n = (Expression<Number>) expressions[1];
        return true;
    }
}