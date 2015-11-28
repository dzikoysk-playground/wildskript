package net.dzikoysk.wildskript.effects.files;

import java.io.File;
import java.util.regex.Matcher;
import org.bukkit.event.Event;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffDelete extends Effect {
	
	private Expression<String> file;
	
	protected void execute (Event event) {
		String f = (String)this.file.getSingle(event);
		if (f == null) return;
		File file = new File(f.replaceAll ("/", Matcher.quoteReplacement(File.separator)));
		file.delete();
	}
	
	public String toString(Event event, boolean bool) {
		return this.getClass().getName();
	}
	
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult){
	    this.file = (Expression<String>) expressions[0];
	    return true; 
	}
}




