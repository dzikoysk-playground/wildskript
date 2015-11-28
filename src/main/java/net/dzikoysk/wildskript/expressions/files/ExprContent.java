package net.dzikoysk.wildskript.expressions.files;

import ch.njol.skript.doc.NoDoc;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;

@NoDoc
public class ExprContent extends SimpleExpression<String> {

    private Expression<String> file;

    protected String[] get(Event event) {
        String f = this.file.getSingle(event);
        if (f == null) return null;
        File file = new File(f.replaceAll("/", Matcher.quoteReplacement(File.separator)));
        StringBuilder sb = new StringBuilder("");
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[]{sb.toString()};
    }

    public boolean isSingle() {
        return true;
    }

    public Class<? extends String> getReturnType() {
        return String.class;
    }

    public String toString(Event event, boolean b) {
        return this.getClass().getName();
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.file = (Expression<String>) expressions[0];
        return true;
    }
}


