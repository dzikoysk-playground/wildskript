package net.dzikoysk.wildskript.effects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.regex.Matcher;

import javax.imageio.ImageIO;

import net.dzikoysk.wildskript.util.data.Data;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.server.ServerListPingEvent;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffIcon extends Effect {
	
	private int i;
	private Expression<String> s;
	
	protected void execute (Event event) {
		String s = this.s.getSingle(event);
		if(s == null) return;
		try{
			if(i == 0){
				s = s.replaceAll("/", Matcher.quoteReplacement(File.separator));
				File file = new File(s);
				if(!file.exists()) return;
				if(event instanceof ServerListPingEvent){
					((ServerListPingEvent) event).setServerIcon(Bukkit.loadServerIcon(file));
				}
				Data.iconFile = file;
				return;
			}
			BufferedImage img = ImageIO.read(new URL(s));
			if(event instanceof ServerListPingEvent){
				((ServerListPingEvent) event).setServerIcon(Bukkit.loadServerIcon(img));
			}
			Data.iconImage = img;
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}
	
	public String toString(Event e, boolean bool) {
		return this.getClass().getName();
	}
	
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult){
	    this.i = i;
		this.s = (Expression<String>) expressions[0];
	    return true;
	}
}

