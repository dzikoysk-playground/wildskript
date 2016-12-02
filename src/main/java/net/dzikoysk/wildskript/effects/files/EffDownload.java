package net.dzikoysk.wildskript.effects.files;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.events.skript.EvtDownload;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.regex.Matcher;

public class EffDownload extends Effect {

    private Expression<String> url;
    private Expression<String> file;

    protected void execute(Event event) {
        String u = this.url.getSingle(event);
        String f = this.file.getSingle(event);
        if (u == null || f == null) {
            return;
        }

        EvtDownload custom = new EvtDownload(u);
        Bukkit.getServer().getPluginManager().callEvent(custom);
        if (!custom.isCancelled()) {
            f = f.replaceAll("/", Matcher.quoteReplacement(File.separator));
            File file = new File(f);
            try {
                downloadFile(u, file);
            } catch (Exception e) {
            }
        }
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.url = (Expression<String>) expressions[0];
        this.file = (Expression<String>) expressions[1];
        return true;
    }

    public String toString(Event event, boolean bool) {
        return this.getClass().getName();
    }

    @SuppressWarnings("resource")
    public static void downloadFile(String url, File file) throws Exception {
        URL website = new URL(url);
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    }
}




