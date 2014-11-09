package net.dzikoysk.wildskript.util;

import java.lang.reflect.Field;

import net.dzikoysk.wildskript.collections.packet.Parser;

import org.bukkit.Bukkit;

public class NMSPacket {
 
    static String packageName = Bukkit.getServer().getClass().getPackage().getName();
    static String version = packageName.substring(packageName.lastIndexOf(".") + 1);
 
    Object packet;
    Class<?> nmsPacket;
 
    public NMSPacket(String packetName){
        try {
            this.nmsPacket = Class.forName("net.minecraft.server." + version + "." + packetName);
            this.packet = nmsPacket.newInstance();
        } catch (Exception e){
            e.printStackTrace();
            this.packet = null;
            this.nmsPacket = null;
        }
 
    }
	public void setDeclaredField(String fieldName, Object o){
        try {
            Field f = packet.getClass().getDeclaredField(fieldName);
            f.setAccessible(true);
            Object value = Parser.parse(f.getType(), o);
            f.set(packet, value);
            f.setAccessible(false);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
 
    public Object getDeclaredField(String fieldName){
        try {
            Field f = packet.getClass().getDeclaredField(fieldName);
            f.setAccessible(true);
            Object s = f.get(packet);
            f.setAccessible(false);
            return s;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
 
    public Class<?> getPacketClass(){
        return nmsPacket;
    }
 
    public Object getPacket(){
        return packet;
    }
}

