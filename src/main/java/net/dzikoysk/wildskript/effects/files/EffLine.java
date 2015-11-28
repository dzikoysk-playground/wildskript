package net.dzikoysk.wildskript.effects.files;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.regex.Matcher;

public class EffLine extends Effect {

    private Expression<String> value;
    private Expression<String> file;

    protected void execute(Event event) {
        String v = this.value.getSingle(event);
        String f = this.file.getSingle(event);
        if ((v == null) || (f == null)) return;
        try {
            RandomAccessFile x = new RandomAccessFile(f.replaceAll("/", Matcher.quoteReplacement(File.separator)), "rw");
            x.seek(x.length());
            x.write(v.getBytes("UTF-8"));
            x.write("\r\n".getBytes());
            x.close();
        } catch (Exception e) {
        }
    }

    public String toString(Event event, boolean bool) {
        return this.getClass().getName();
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.value = (Expression<String>) expressions[0];
        this.file = (Expression<String>) expressions[1];
        return true;
    }
}




