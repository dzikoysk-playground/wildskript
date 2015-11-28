package net.dzikoysk.wildskript.collections.loader.elements;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.collections.loader.Loader;
import org.bukkit.event.Event;

import java.io.File;
import java.util.regex.Matcher;

public class EffFile extends Effect {

    private Expression<String> f;

    protected void execute(Event event) {
        String f = this.f.getSingle(event);
        if (f == null) return;

        f = f.replaceAll("/", Matcher.quoteReplacement(File.separator));
        File file = new File(f);
        if (file.isFile()) Loader.loadFile(file);
    }

    public String toString(Event event, boolean bool) {
        return this.getClass().getName();
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.f = (Expression<String>) expressions[0];
        return true;
    }
}



