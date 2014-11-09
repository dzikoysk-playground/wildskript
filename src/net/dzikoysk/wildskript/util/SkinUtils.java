package net.dzikoysk.wildskript.util;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import net.dzikoysk.wildskript.WildSkript;
import net.minecraft.util.com.mojang.authlib.GameProfile;
import net.minecraft.util.com.mojang.authlib.properties.Property;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class SkinUtils {

   public static void change(final Player p, final String toSkin) {
       new BukkitRunnable() {
           @Override
           public void run() {
               try {
            	   Class<?> packetNamedEntityClass = ReflectionUtils.getCraftClass("PacketPlayOutNamedEntitySpawn");
            	   Class<?> entityHumanClass = ReflectionUtils.getCraftClass("EntityHuman");
            	   Class<?> craftPlayer = Class.forName("org.bukkit.craftbukkit." + ReflectionUtils.getVersion() + "entity.CraftPlayer");

            	   Object cp = craftPlayer.cast(p);
       	       	   Object handle = craftPlayer.getMethod("getHandle").invoke(cp);
       	       	   
            	   Object packetNamedEntity = packetNamedEntityClass.getConstructor(new Class<?>[]{ entityHumanClass }).newInstance(handle);
            	   
            	   Field gameProfileField = packetNamedEntity.getClass().getDeclaredField("b");
                   gameProfileField.setAccessible(true);

                   @SuppressWarnings("deprecation")
                   GameProfile profile = new GameProfile(Bukkit.getOfflinePlayer(p.getName()).getUniqueId(), p.getName());
                   reset(profile, toSkin);

                   gameProfileField.set(packetNamedEntity, profile);

                   for (Player pl : Bukkit.getOnlinePlayers()) {
                	   if(pl.equals(p)) continue;
                	   PacketUtils.sendPacket(pl, packetNamedEntity);
                   }
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       }.runTaskAsynchronously(WildSkript.getInstance());
   }

   @SuppressWarnings({ "deprecation", "resource" })
   private static void reset(GameProfile profile, String skinOwner) {
       try {
           URL url = new URL("https://sessionserver.mojang.com/session/minecraft/profile/" + Bukkit.getOfflinePlayer(skinOwner).getUniqueId().toString().replace("-", ""));
           URLConnection uc = url.openConnection();

           Scanner scanner = new Scanner(uc.getInputStream(), "UTF-8").useDelimiter("\\A");
           String json = scanner.next();

           JSONArray properties = (JSONArray) ((JSONObject) new JSONParser().parse(json)).get("properties");
           for (int i = 0; i < properties.size(); i++) {
               JSONObject property = (JSONObject) properties.get(i);
               String name = (String) property.get("name");
               String value = (String) property.get("value");
               String signature = property.containsKey("signature") ? (String) property.get("signature") : null;
               if (signature != null) profile.getProperties().put(name, new Property(name, value, signature));
               else  profile.getProperties().put(name, new Property(value, name));
           }
       } catch (Exception e) {
       }
   }
}
