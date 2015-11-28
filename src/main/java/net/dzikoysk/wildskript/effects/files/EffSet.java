package net.dzikoysk.wildskript.effects.files;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Event;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;

public class EffSet extends Effect {

    private Expression<String> file;
    private Expression<String> key;
    private Expression<String> value;

    protected void execute(Event event) {
        String path = this.file.getSingle(event);
        String key = this.key.getSingle(event);
        String value = this.value.getSingle(event);
        if (path == null || key == null) return;
        File file = new File(path.replaceAll("/", Matcher.quoteReplacement(File.separator)));
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
            yml.set(key, value);
            yml.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String toString(Event event, boolean bool) {
        return this.getClass().getName();
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.key = (Expression<String>) expressions[0];
        this.value = (Expression<String>) expressions[1];
        this.file = (Expression<String>) expressions[2];
        return true;
    }
}




