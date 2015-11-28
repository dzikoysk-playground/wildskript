package net.dzikoysk.wildskript.util;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {

    public static Class<?> getCraftClass(String ClassName) {
        String className = "net.minecraft.server." + getVersion() + ClassName;
        Class<?> c = null;
        try {
            c = Class.forName(className);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public static Object getHandle(Entity entity) {
        try {
            return getMethod(entity.getClass(), "getHandle").invoke(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object getHandle(World world) {
        try {
            return getMethod(world.getClass(), "getHandle").invoke(world);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Field getField(Class<?> cl, String field_name) {
        try {
            return cl.getDeclaredField(field_name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Method getMethod(Class<?> cl, String method, Class<?>... args) {
        for (Method m : cl.getMethods())
            if (m.getName().equals(method) && ClassListEqual(args, m.getParameterTypes()))
                return m;
        return null;
    }

    public static Method getMethod(Class<?> cl, String method) {
        for (Method m : cl.getMethods())
            if (m.getName().equals(method))
                return m;
        return null;
    }

    public static boolean ClassListEqual(Class<?>[] l1, Class<?>[] l2) {
        boolean equal = true;
        if (l1.length != l2.length)
            return false;
        for (int i = 0; i < l1.length; i++)
            if (l1[i] != l2[i]) {
                equal = false;
                break;
            }
        return equal;
    }

    public static String getVersion() {
        String name = Bukkit.getServer().getClass().getPackage().getName();
        String version = name.substring(name.lastIndexOf('.') + 1) + ".";
        return version;
    }

}