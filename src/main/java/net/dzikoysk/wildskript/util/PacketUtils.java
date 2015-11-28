package net.dzikoysk.wildskript.util;

import java.lang.reflect.Method;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PacketUtils {
	
	private static final String packageName = Bukkit.getServer().getClass().getPackage().getName();
    private static final String version = packageName.substring(packageName.lastIndexOf(".") + 1);
    
	public static void sendPacket(Player p, Object... os){
		try {
	    	Class<?> packetClass = Class.forName("net.minecraft.server." + version + ".Packet");
	    	Class<?> craftPlayer = Class.forName("org.bukkit.craftbukkit." + version + ".entity.CraftPlayer");

	      	Object cp = craftPlayer.cast(p);
	       	Object handle = craftPlayer.getMethod("getHandle").invoke(cp);
	      	Object con = handle.getClass().getField("playerConnection").get(handle);
	       	Method method = con.getClass().getMethod("sendPacket", packetClass);
	        for(Object o : os) method.invoke(con, o);
	   	} catch (Exception e){
	        e.printStackTrace();
	    }
	}
}
