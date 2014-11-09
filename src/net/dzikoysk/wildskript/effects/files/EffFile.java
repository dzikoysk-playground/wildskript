package net.dzikoysk.wildskript.effects.files;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import org.bukkit.event.Event;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffFile extends Effect {
	
	private int pattern;
	private Expression<String> f;
	
	protected void execute (Event event) {
		String d = (String)this.f.getSingle(event);
		if (f == null) return;
		File file = new File(d.replaceAll("/", Matcher.quoteReplacement(File.separator)));
		if(file.exists()) return;
		if(pattern == 1) file.mkdir();
		else{
			try {	
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String toString(Event event, boolean bool) {
		return this.getClass().getName();	
	}
	
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult){
	    this.pattern = i;
		this.f = (Expression<String>) expressions[0];
	    return true;  
	}




}



