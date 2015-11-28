package net.dzikoysk.wildskript.classes;

import java.io.StreamCorruptedException;

import javax.annotation.Nullable;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import net.dzikoysk.wildskript.objects.region.Regions;
import net.dzikoysk.wildskript.objects.region.RegionsUtils;
import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.classes.Serializer;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;
import ch.njol.yggdrasil.Fields;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class RegionClasses {

	static{
		Classes.registerClass(new ClassInfo(Regions.class, "regions")
		.user("regions")
		.name("WildSkript Regions")
		.description("WildSkript Regions")
		.usage("...")
		.examples("")
		.since("1.5")
		.parser(new Parser<Regions>() {
			@Nullable
			public Regions parse(String s, ParseContext context) {
				return RegionsUtils.get(s);
			}
			
			public boolean canParse(ParseContext context){
		        return false;
		    }
			
			public String toVariableNameString(Regions r) {
				StringBuilder b = new StringBuilder("region:");
				String id = r.getID();
				String c = toS(r.getCenter());
				String l = toS(r.getL());
				String p = toS(r.getP());
				String w = r.getWorld().getName();
				if(id == null) return null;
				if(c == null) c = "";
				if(l == null) l = "";
				if(p == null) p = "";
				if(w == null) w = "";
				b.append(id + ","); // ID = 0
				b.append(c + ","); // Center = 1
				b.append(r.getSize() + ","); // Size = 2
				b.append(l + ","); // L = 3
				b.append(p + ","); // P = 4
				b.append(w + ","); // World = 5
				return b.toString();
			}
			
		    public String getVariableNamePattern(){
		    	return "region:.+";
		    }

			public String toString(Regions r, int flags) {
				return r.getID();
			}  
		}).serializer(new Serializer<Regions>() {
			@Override
			@Nullable
			public Fields serialize(Regions r){
				Fields f = new Fields();
				String id = r.getID();
				Location c = r.getCenter();
				Location l = r.getL();
				Location p = r.getP();
				World w = r.getWorld();
				f.putObject("id", id);
				f.putObject("center", c);
				f.putObject("size", r.getSize());
				f.putObject("l", l);
				f.putObject("p", p);
				f.putObject("world", w);
				return f;
			}	
			
			@Override
			public void deserialize(final Regions r, final Fields f){
			    assert false;
			}
			
			@Override
			protected Regions deserialize(final Fields fields) throws StreamCorruptedException {
				final String id = fields.getObject("id", String.class);
				final Location c = fields.getObject("center", Location.class);
				final Integer s = fields.getObject("size", Integer.class);
				final Location l = fields.getObject("l", Location.class);
				final Location p = fields.getObject("p", Location.class);
				final World w = fields.getObject("world", World.class);
				if(id == null) throw new StreamCorruptedException(); 
				Regions r = RegionsUtils.get(id);
				if(c != null) r.setCenter(c);
				if(s != null) r.setSize(s);
				if(l != null) r.setL(l);
				if(p != null) r.setP(p);
				if(w != null) r.setWorld(w);
				if(r == null) throw new StreamCorruptedException(); 
				return r;
			}
			
			@Override
			public boolean mustSyncDeserialization() {
				return true;
			}

			@Override
			public boolean canBeInstantiated(final Class<? extends Regions> c) {
				return false;
			}
			
			@Override
			public Regions deserialize(final String x){
				String d = x.replaceAll("region:", "");
				String[] t = d.split(",");
				Regions region = RegionsUtils.get(t[0]);
				Location c = null;
				int s = 0;
				Location l = null;
				Location p = null;
				World w = null;
				if(!(t[1]).equals("")) c = fromS(t[1]);
				if(!(t[2]).equals("")) s = Integer.valueOf(t[2]);
				if(!(t[3]).equals("")) l = fromS(t[3]);
				if(!(t[4]).equals("")) p = fromS(t[4]);
				if(!(t[5]).equals("")) w = Bukkit.getWorld(t[5]);
				
				region.setCenter(c);
				region.setSize(s);
				region.setL(l);
				region.setP(p);
				region.setWorld(w);
				return region;
			}
		}));
	}
	
	public static String toS(Location loc){
		StringBuilder b = new StringBuilder("");
		b.append(loc.getBlockX() + ";");
		b.append(loc.getBlockY() + ";");
		b.append(loc.getBlockZ() + ";");
		b.append(loc.getWorld());
		return b.toString();
	}
	
	public static Location fromS(String s){
		String[] t = s.split(";");
		int x = Integer.parseInt(t[0]);
		int y = Integer.parseInt(t[1]);
		int z = Integer.parseInt(t[2]);
		World w = Bukkit.getWorld(t[3]);
		return new Location(w, x, y ,z);
	}
}
