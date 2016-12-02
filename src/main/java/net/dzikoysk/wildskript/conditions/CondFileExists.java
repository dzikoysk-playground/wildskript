package net.dzikoysk.wildskript.conditions;

import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

import java.io.File;
import java.util.regex.Matcher;

public class CondFileExists extends Condition {

    private Expression<String> dir;
    private int patt;

    public boolean check(Event event) {
        String d = this.dir.getSingle(event);
        if (d == null) {
            return false;
        }
        File f = new File(d.replaceAll("/", Matcher.quoteReplacement(File.separator)));
        if (f.exists()) {
            if (patt == 0) {
                return true;
            }
            if (patt == 1) {
                return false;
            }
        }
        if (patt == 0) {
            return false;
        }
        if (patt == 1) {
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int matchedPattern, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.dir = (Expression<String>) expressions[0];
        this.patt = matchedPattern;
        return true;
    }

    public String toString(Event event, boolean b) {
        return this.getClass().getName();
    }
}
