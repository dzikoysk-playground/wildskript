package net.dzikoysk.wildskript.expressions.files;

import ch.njol.skript.doc.NoDoc;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.WildSkript;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Event;

import java.io.File;
import java.util.regex.Matcher;

@NoDoc
public class ExprYamlSingleValue extends SimpleExpression<String> {
    private Expression<String> value;
    private Expression<String> file;

    protected String[] get(Event event) {
        String v = this.value.getSingle(event);
        String f = this.file.getSingle(event);
        if (v == null || f == null) return null;
        File file = new File(f.replaceAll("/", Matcher.quoteReplacement(File.separator)));
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
            Object res = yml.get(v);
            if (res == null) return null;
            String ret = res.toString();
            if (ret == null) return null;
            ret = ret
                    .replace("�", "") // Text
                    .replace("�", ""); // Color
            if (ret.contains("MemorySection")) {
                WildSkript.log("Custom Yaml Configuration Error! - You can't use read simple value expression to yaml configuration section!");
                return null;
            }
            return new String[]{ret};
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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




