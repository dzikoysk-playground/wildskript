package net.dzikoysk.wildskript.expressions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.bukkit.ChatColor;
import org.bukkit.event.Event;

import ch.njol.skript.doc.NoDoc;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

@NoDoc
public class ExprConnectResult extends SimpleExpression<String>{

	private String res = null;
	private Expression<String> url;
	
	@SuppressWarnings("deprecation")
	protected String[] get(Event event) {
		final String url = this.url.getSingle(event);
		if(url == null) return null;
		Thread t = new Thread(){
			public void run(){
				StringBuilder response = new StringBuilder();
				try{
					URL website = new URL(ChatColor.stripColor(url));
			        URLConnection connection = website.openConnection();
			        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			        
			        String inputLine;
			        while ((inputLine = in.readLine()) != null) 
			            response.append(inputLine);
			        in.close();
				}catch(Exception e) { e.printStackTrace(); }
				res = response.toString();
			}
		};
		t.start();
		long tm = System.currentTimeMillis() + 5 * 1000;
		while(System.currentTimeMillis() < tm) if(res != null) break;
		t.stop();
		t = null;
		return new String[] { res };
	}

	
	public boolean isSingle() { 
		return true;
	}

	public Class<? extends String> getReturnType() { return String.class; }

	public String toString(Event event, boolean b) {
		return this.getClass().getName();
	}

	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] e, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {    
		this.url = (Expression<String>) e[0];
		return true;
	}
}

