package net.dzikoysk.wildskript.util.data;

import java.awt.image.BufferedImage;
import java.io.File;
import org.bukkit.configuration.file.YamlConfiguration;
import net.dzikoysk.wildskript.WildSkript;

public class Data {
	
	public static String motd;
	public static BufferedImage iconImage;
	public static File iconFile;
	public static Integer fakeMaxPlayers;
	
	public static boolean doc;
	public static boolean debug;
	public static boolean mcstats;
	
	private static File CFG = new File(WildSkript.getInstance().getDataFolder(), "config.yml");
	
	public static void load(){
		loadDescription();
		loadConfig();
	}
	
	public static void loadDescription(){
		WildSkript.version= WildSkript.getInstance().getDescription().getVersion();
	}
	
	private static void loadConfig(){
		loadDefaultFiles(new String[] { "config.yml" });
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(CFG);
		
		doc = yaml.getBoolean("doc");
		mcstats = yaml.getBoolean("mcstats-enable");
		debug = yaml.getBoolean("debug");
		
		WildSkript.debug = debug;
	}
	
	public static void loadDefaultFiles(String[] names){
		for(String name : names){
			File file = new File(WildSkript.getInstance().getDataFolder() + File.separator + name);
		    if (!file.exists()) {
		    	WildSkript.getInstance().saveResource(name, true);		 
		    }
		}
	}
	
}
