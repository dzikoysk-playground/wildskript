package net.dzikoysk.wildskript.objects.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SkriptHashMap {

    private static List<SkriptHashMap> maps = new ArrayList<>();

    String name;
    HashMap<Object, Object> hashmap;

    private SkriptHashMap(String name) {
        this.name = name;
        this.hashmap = new HashMap<>();
        maps.add(this);
    }

    public void delete() {
        maps.remove(this);
        this.hashmap = null;
        this.name = null;
    }

    public String getName() {
        return this.name;
    }

    public HashMap<Object, Object> getHashMap() {
        return this.hashmap;
    }

    public static SkriptHashMap get(String name) {
        for (SkriptHashMap shm : maps) {
            if (shm.getName().equals(name)) {
                return shm;
            }
        }
        return new SkriptHashMap(name);
    }

    public static boolean isExists(String name) {
        for (SkriptHashMap shm : maps) {
            if (shm.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
