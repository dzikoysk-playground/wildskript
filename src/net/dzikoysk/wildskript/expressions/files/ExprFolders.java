package net.dzikoysk.wildskript.expressions.files;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;

import org.bukkit.event.Event;

public class ExprFolders extends SimpleExpression<String>{
    
  private Expression<String> dir;

  protected String[] get(Event event) {
      String d = this.dir.getSingle(event);
      if (d == null) return null;
    
      File f = new File(d.replaceAll("/", Matcher.quoteReplacement(File.separator)));
      if(!f.exists()) f.mkdir();
      String[] path = f.list(new FilenameFilter() {
        @Override
        public boolean accept(File current, String name) {
          return new File(current, name).isDirectory();
        }
      });
      if(path == null || path.length < 1) return null;
      return path;
  }

  public boolean isSingle(){ 
      return true;
  }

  public Class<? extends String> getReturnType() { 
      return String.class;
  }

  public String toString(Event event, boolean b) {  
      return this.getClass().toString(); 
  }

  @SuppressWarnings("unchecked")
  public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
      this.dir = (Expression<String>) expressions[0];
      return true;
  }
}




