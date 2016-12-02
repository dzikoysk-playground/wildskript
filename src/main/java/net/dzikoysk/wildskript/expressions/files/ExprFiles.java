package net.dzikoysk.wildskript.expressions.files;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class ExprFiles extends SimpleExpression<String> {

    private Expression<String> dir;

    protected String[] get(Event event) {
        String d = this.dir.getSingle(event);
        if (d == null) {
            return null;
        }

        File f = new File(d.replaceAll("/", Matcher.quoteReplacement(File.separator)));
        if (!f.exists()) {
            f.mkdir();
        }
        File[] path = f.listFiles();
        if (path == null || path.length < 1) {
            return null;
        }

        List<String> files = new ArrayList<>();
        for (File file : path) {
            if (file.isFile()) {
                files.add(file.getName());
            }
        }
        String[] arr = new String[files.size()];
        return files.toArray(arr);
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.dir = (Expression<String>) expressions[0];
        return true;
    }

    public boolean isSingle() {
        return true;
    }

    public Class<? extends String> getReturnType() {
        return String.class;
    }

    public String toString(Event event, boolean b) {
        return this.getClass().toString();
    }
}




