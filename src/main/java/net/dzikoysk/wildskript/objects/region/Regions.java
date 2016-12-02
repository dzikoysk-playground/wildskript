package net.dzikoysk.wildskript.objects.region;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class Regions {

    public static ArrayList<Regions> regions = new ArrayList<Regions>();

    String id;

    Location center;
    World world;

    Location l;
    Location p;

    int size = 0;
    int height = 256;


    public Regions(String id) {
        this.id = id;
        regions.add(this);
    }

    public Regions(String id, Location loc, int size) {
        this.id = id;
        this.world = loc.getWorld();
        this.height = this.world.getMaxHeight();
        this.size = size;
        this.center = loc;
        regions.add(this);
        this.update();
    }

    public Regions(String id, Location loc1, Location loc2) {
        this.id = id;
        this.world = loc1.getWorld();
        this.height = this.world.getMaxHeight();
        this.l = loc1;
        this.p = loc2;
        regions.add(this);
    }

    public void update() {
        if (this.center != null) {
            if (this.size > 0) {
                if (this.world == null) {
                    this.world = Bukkit.getWorld("world");
                }
                if (this.world != null) {
                    int lx = this.center.getBlockX() + this.size;
                    int lz = this.center.getBlockZ() + this.size;

                    int px = this.center.getBlockX() - this.size;
                    int pz = this.center.getBlockZ() - this.size;

                    Vector l = new Vector(lx, 0, lz);
                    Vector p = new Vector(px, this.height, pz);

                    this.l = l.toLocation(this.world);
                    this.p = p.toLocation(this.world);
                }
            }
        }
    }

    public void delete() {
        regions.remove(this);
        this.id = null;
        this.world = null;
        this.center = null;
        this.l = null;
        this.p = null;
    }

    public boolean isIn(Location loc) {
        if (loc == null) {
            return false;
        }
        this.update();
        if (loc.getBlockX() > this.getLowerX() && loc.getBlockX() < this.getUpperX()) {
            if (loc.getBlockY() > this.getLowerY() && loc.getBlockY() < this.getUpperY()) {
                if (loc.getBlockZ() > this.getLowerZ() && loc.getBlockZ() < this.getUpperZ()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setCenter(Location loc) {
        this.center = loc;
        this.world = loc.getWorld();
        this.update();
    }

    public void setSize(int i) {
        this.size = i;
        this.update();
    }

    public void setHeight(int i) {
        this.height = i;
        this.update();
    }

    public void setWorld(World world) {
        this.world = world;
        this.update();
    }

    public void setL(Location loc) {
        this.l = loc;
        this.update();
    }

    public void setP(Location loc) {
        this.p = loc;
        this.update();
    }

    public String getID() {
        return this.id;
    }

    public Location getCenter() {
        if (this.center != null) {
            return this.center;
        }
        else {
            this.update();
            int x1 = this.getUpperX();
            int y1 = this.getLowerY();
            int z1 = this.getLowerZ();
            Location loc = new Location(this.world, this.getLowerX() + (x1 - this.getLowerX()) / 2.0, this.getLowerY() + (y1 - this.getLowerY()) / 2.0, this.getLowerZ() + (z1 - this.getLowerZ()) / 2.0);
            return (this.center = loc);
        }
    }

    public int getSize() {
        return this.size;
    }

    public int getHeight() {
        return this.height;
    }

    public World getWorld() {
        return this.world;
    }

    public Location getL() {
        return this.l;
    }

    public Location getP() {
        return this.p;
    }

    public int getUpperX() {
        this.update();
        if (this.l == null || this.p == null) {
            return 0;
        }
        int x = this.l.getBlockX();
        int y = this.p.getBlockX();
        if (y < x) {
            return x;
        }
        return y;
    }

    public int getUpperY() {
        this.update();
        if (this.l == null || this.p == null) {
            return 0;
        }
        int x = this.l.getBlockY();
        int y = this.p.getBlockY();
        if (y < x) {
            return x;
        }
        return y;
    }

    public int getUpperZ() {
        this.update();
        if (this.l == null || this.p == null) {
            return 0;
        }
        int x = this.l.getBlockZ();
        int y = this.p.getBlockZ();
        if (y < x) {

            return x;
        }
        return y;
    }

    public int getLowerX() {
        this.update();
        if (this.l == null || this.p == null) {
            return 0;
        }
        int x = this.l.getBlockX();
        int y = this.p.getBlockX();
        if (x > y) {
            return y;
        }
        return x;
    }

    public int getLowerY() {
        this.update();
        if (this.l == null || this.p == null) {
            return 0;
        }
        int x = this.l.getBlockY();
        int y = this.p.getBlockY();
        if (x > y) {
            return y;
        }
        return x;
    }

    public int getLowerZ() {
        this.update();
        if (this.l == null || this.p == null) {
            return 0;
        }
        int x = this.l.getBlockZ();
        int y = this.p.getBlockZ();
        if (x > y) {
            return y;
        }
        return x;
    }
}