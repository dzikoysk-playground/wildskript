package net.dzikoysk.wildskript.expressions.files;

import ch.njol.skript.doc.NoDoc;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Event;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;

@NoDoc
public class ExprYamlValueList extends SimpleExpression<String> {
    private Expression<String> value;
    private Expression<String> file;

    protected String[] get(Event event) {
        String v = (String) this.value.getSingle(event);
        String f = (String) this.file.getSingle(event);
        if ((v == null) || (f == null)) return null;

        File file = new File(f.replaceAll("/", Matcher.quoteReplacement(File.separator)));
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
            }
        }
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
        List<String> list = yml.getStringList(v);
        String[] s = new String[list.size()];
        return list.toArray(s);
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
        this.value = (Expression<String>) expressions[0];
        this.file = (Expression<String>) expressions[1];
        return true;
    }
}




