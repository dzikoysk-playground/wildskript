package net.dzikoysk.wildskript.collections.loader;

import ch.njol.skript.ScriptLoader;
import org.bukkit.Bukkit;
import org.bukkit.plugin.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.regex.Matcher;

public class Loader {

    private static void loadScript(File f) {
        try {
            Class<?> cs = ScriptLoader.class;
            Method method = cs.getDeclaredMethod("loadScript", File.class);
            method.setAccessible(true);
            method.invoke(null, f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadFile(File f) {
        loadScript(f);
    }

    public static void loadString(String content) {
        File f = new File("plugins" + File.separator + "WildSkript" + File.separator + "tmp.lck");
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(content);
            fw.close();
            loadFile(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (f.exists()) f.delete();
    }

    @SuppressWarnings("resource")
    public static void loadURL(URL url) {
        File f = new File("plugins" + File.separator + "WildSkript" + File.separator + "tmp.lck");
        try {
            ReadableByteChannel rbc = Channels.newChannel(url.openStream());
            FileOutputStream fos = new FileOutputStream(f);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            loadFile(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (f.exists()) f.delete();
    }

    public static void loadPlugin(String s) {
        PluginManager pm = Bukkit.getPluginManager();

        s = s.replaceAll("/", Matcher.quoteReplacement(File.separator));
        File file = new File(s);

        try {
            pm.loadPlugin(file);
        } catch (UnknownDependencyException e) {
            return;
        } catch (InvalidPluginException e) {
            return;
        } catch (InvalidDescriptionException e) {
            return;
        }
        String name = file.getName().replace(".jar", "");
        Plugin plugin = pm.getPlugin(name);
        pm.enablePlugin(plugin);
    }
}