package net.dzikoysk.wildskript.objects.region;

import org.bukkit.Location;

public class RegionsUtils {

    public static Regions get(String id) {
        for (Regions region : Regions.regions) {
            if (region.getID().equals(id)) {
                return region;
            }
        }
        return new Regions(id);
    }

    public static boolean isIn(Location loc) {
        for (Regions region : Regions.regions) {
            if (region.isIn(loc)) {
                return true;
            }
        }
        return false;
    }

    public static Regions getAt(Location loc) {
        for (Regions region : Regions.regions) {
            if (region.isIn(loc)) {
                return region;
            }
        }
        return null;
    }

    public static boolean exists(String s) {
        for (Regions region : Regions.regions) {
            if (region.getID().equals(s)) {
                return true;
            }
        }
        return false;
    }
}
