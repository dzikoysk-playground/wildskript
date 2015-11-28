package net.dzikoysk.wildskript.collections.loader.elements;

import ch.njol.skript.ScriptLoader;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

import java.io.File;
import java.util.regex.Matcher;

public class EffFolder extends Effect {

    private Expression<String> dir;

    protected void execute(Event event) {
        String d = this.dir.getSingle(event);
        if (d == null) return;

        d = d.replaceAll("/", Matcher.quoteReplacement(File.separator));
        File file = new File(d);
        if (!file.isFile()) ScriptLoader.loadScripts(file);
    }

    public String toString(Event event, boolean bool) {
        return this.getClass().getName();
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.dir = (Expression<String>) expressions[0];
        return true;
    }
}



