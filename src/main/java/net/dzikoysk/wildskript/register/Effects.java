package net.dzikoysk.wildskript.register;

import net.dzikoysk.wildskript.collections.loader.elements.EffFolder;
import net.dzikoysk.wildskript.collections.loader.elements.EffPlugin;
import net.dzikoysk.wildskript.effects.EffAnvil;
import net.dzikoysk.wildskript.effects.EffAsOp;
import net.dzikoysk.wildskript.effects.EffBungeeConnect;
import net.dzikoysk.wildskript.effects.EffClose;
import net.dzikoysk.wildskript.effects.EffFakeMaxPlayers;
import net.dzikoysk.wildskript.effects.EffHologram;
import net.dzikoysk.wildskript.effects.EffIcon;
import net.dzikoysk.wildskript.effects.EffIndividual;
import net.dzikoysk.wildskript.effects.EffMetrics;
import net.dzikoysk.wildskript.effects.EffRecipes;
import net.dzikoysk.wildskript.effects.EffSkin;
import net.dzikoysk.wildskript.effects.EffTame;
import net.dzikoysk.wildskript.effects.EffVisibility;
import net.dzikoysk.wildskript.effects.EffFlight;
import net.dzikoysk.wildskript.effects.EffFurnace;
import net.dzikoysk.wildskript.effects.EffGarbageCollectors;
import net.dzikoysk.wildskript.effects.EffHeldSlot;
import net.dzikoysk.wildskript.effects.EffMotd;
import net.dzikoysk.wildskript.effects.EffPushFrom;
import net.dzikoysk.wildskript.effects.EffReplaceLast;
import net.dzikoysk.wildskript.effects.EffResourcePack;
import net.dzikoysk.wildskript.effects.EffShutdown;
import net.dzikoysk.wildskript.effects.EffTag;
import net.dzikoysk.wildskript.effects.UtilComments;
import net.dzikoysk.wildskript.effects.files.EffDelete;
import net.dzikoysk.wildskript.effects.files.EffDownload;
import net.dzikoysk.wildskript.effects.files.EffFile;
import net.dzikoysk.wildskript.effects.files.EffLine;
import net.dzikoysk.wildskript.effects.files.EffSet;
import net.dzikoysk.wildskript.util.doc.Element;
import net.dzikoysk.wildskript.util.doc.Type;

public class Effects {
	
	 public static void registerEffects() {
		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Skin")
		.version("1.8")
		.desc("With this effect, u can change player's skin. (Required CraftBukkit 1.7.9+)")
		.example("change player's skin to ''Dinnerbone''")
		.usage(new String[] {
			"(change|set) %player%'s skin to %string%"
		})
		, EffSkin.class);
		 
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Recipes")
		.version("1.8")
		.desc("Clear all recipes")
		.example("clear all recipes")
		.usage(new String[] {
			"clear all recipes"
		})
		, EffRecipes.class);
		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Metrics")
		.version("1.8")
		.desc("With this effect, u can enable metrics for your script on mcstats.org. Your script's name on the metrics site starts by ''WS''!")
		.example("enable metrics for ''MyAwesomeScript'', version ''1.0.1''")
		.usage(new String[] {
			"enable metrics for %string%[,] version %string%"
		})
		, EffMetrics.class);
		 
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Garbage Collectors")
		.version("1.5")
		.desc("Garbage Collector is a form of automatic memory management. With this effect you can run it.")
		.example("every 5 minutes:\n	System.gc{};")
		.usage(new String[] {
			"System.gc{};",
			"run g[arbage ]c[ollector[s]]"
		})
		, EffGarbageCollectors.class);
		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Resource Pack")
		.version("1.5")
		.desc("This effect allows you to send resourcepack to player")
		.example("on join:\n	send resourcepack " + '"' + "[url]" + '"' + " to player")
		.usage(new String[] {
			"send resourcepack %string% to %player%"
		})
		, EffResourcePack.class);
		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Tag")
		.version("1.2")
		.desc("Change the tag at the player's nick. The length of tag is a maximum of 16 char (&6 is also counted)")
		.example("command /tag <text>:\n " +
		"	trigger:\n" +
		"		set player's tag to arg")
		.usage(new String[] {
			"(set|edit) %player%'s tag to %string%", 
			"(set|edit) tag of %player% to %string%"
		})
		, EffTag.class);
		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Motd")
		.version("1.3")
		.desc("Change server's motd. After restart you must set again.")
		.example("on server list ping:\n " +
		"	set motd to " + '"' + "Skript is awesome!" + '"')
		.usage(new String[] {
			"set motd to %string%", 
		})
		, EffMotd.class);
		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Close")
		.version("1.1")
		.desc("Closes currently open inventory.")
		.example("on open inventory:\n " +
		"	close player's inventory")
		.usage(new String[] {
			"close %player%'s inventory", 
		})
		, EffClose.class);
		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("As Op")
		.version("1.2")
		.desc("Allows player to execute the command as Op.")
		.example("command /join:\n " +
		"	trigger:\n"+
		"		run player command " + '"' + "//rg addmember %player%" + '"' + " as op")
		.usage(new String[] {
			"run %player% (command|cmd) %string% as op"
		})
		, EffAsOp.class);
		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Flight")
		.version("1.0")
		.desc("Allows/Disallows player to fly.")
		.example("command /fly:\n " +
		"	trigger:\n"+
		"		allow fly for player")
		.usage(new String[] {
			"(allow|enable) (fly|flight) (for|to) %player%",
			"(disallow|disable) (fly|flight) (for|to) %player%"
		})
		, EffFlight.class);
		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Push From")
		.version("1.5")
		.desc("Push player from direction.")
		.example("push player from spawn point")
		.usage(new String[] {
			"push %player% from %location%"
		})
		, EffPushFrom.class);
		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Held Slot")
		.version("1.0")
		.desc("Changes slot in player's hand bar. Accepts the numbers from 1 to 9.")
		.example("on rightclick with stone named " + '"' + "&6Magic" + '"' + ":\n " +
		"	set slot in player's hand bar to 1")
		.usage(new String[] {
			"(set|change) slot in %player%'s hand[ bar] to %number%"
		})
		, EffHeldSlot.class);
		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Tame")
		.version("1.6")
		.desc("Tame entities for the player.")
		.example("on leftclick on ocelot:\n" +
				"	tame clicked entity for player")
		.usage(new String[] {
			"tame %entity% (to|for) %player%"
		})
		, EffTame.class);
		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Replace Last")
		.version("1.0")
		.desc("Replace last occurrence of charset in string (text).")
		.example("set {_text} to " + '"' + "x, y, z" + '"' + "\n"
				+"replace last " + '"' + "," + '"' + " with " + '"' + " and" + '"' + " in {_text}")
		.usage(new String[] {
			"replace last %string% with %string% in %string%"
		})
		, EffReplaceLast.class);
		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Furnace")
		.version("1.5")
		.desc("Opens virtual furnace to the player. In this furnace you can't do anything :(")
		.example("command /virtual: \n"
				+"	trigger: \n"
				+"		open furnace to the player")
		.usage(new String[] {
			"open [(virtual|fake)] furnace (to|for) [the] %player%"
		})
		, EffFurnace.class);
		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Anvil")
		.version("1.5")
		.desc("Opens fake anvil to the player. In the anvil you can't do anything :(")
		.example("command /fake: \n"
				+"	trigger: \n"
				+"		open anvil to the player")
		.usage(new String[] {
			"open [(virtual|fake)] anvil (to|for) [the] %player%"
		})
		, EffAnvil.class);
		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("BungeeCord")
		.version("1.5")
		.desc("This support for BungeeCord allows you to connect the player to bungee server.")
		.example("on rightclick on sign:\n"
				+"	if line 1 of the clicked block is " + '"' + "[MINIGAMES]" + '"' + ":\n"
				+"		bungeecord connect player to " + '"' + "<name of server from bungee's>" + '"')
		.usage(new String[] {
			"BungeeCord.connect{%player%,%string%}[;]",
			"bungeecord connect %player% to %string%"
		})
		, EffBungeeConnect.class);
		
		/*
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Particle")
		.version("1.5")
		.desc("#TODO")
		.example("#TODO")
		.usage(new String[] {
			"effect %string% [[with [data]] %number%] at %location% to %player%"
		})
		, EffParticle.class);
		*/
		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Hide/Show")
		.version("1.6")
		.desc("Hide or show specific player for the player.")
		.example("command /vanish:\n " +
		"	trigger:\n"+
		"		loop all players:\n" +
		"			hide player for loop-player")
		.usage(new String[] {
			"hide %player% for %player%",
			"show %player% for %player%"
		})
		, EffVisibility.class);
		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Shutdown")
		.version("1.6")
		.desc("Shudowns (stop) the server.")
		.example("command /shutdown:\n " +
		"	trigger:\n"+
		"		shutdown")
		.usage(new String[] {
			"shutdown [server]"
		})
		, EffShutdown.class);
		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Hologram")
		.version("1.6.1")
		.desc("If you don't want to use object-holograms, this effect is for you. With this, you can display timed hologram.")
		.example("leftclick:\n	display hologram " + '"' + "Click" + '"' + " at location of clicked block for 1 second")
		.usage(new String[] {
			"display hologram %string% at %location% (for|by) %number% [second[s]]"
		})
		, EffHologram.class);
		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Icon")
		.version("1.7")
		.desc("This effect allows you to set server icon. Remember, size of the icon must be 64x64!")
		.example("on list ping event:\n	change server icon to image from file " + '"' + "icons/icon.png" + '"')
		.usage(new String[] {
			"change server icon to image from file %string%",
			"change server icon to image from url %string%"
		})
		, EffIcon.class);
		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Fake Max Players")
		.version("1.7")
		.desc("This effect allows you to set max number of players on server list. Remember, this is only fake change.")
		.example("on list ping event:\n	set max number of players to 666")
		.usage(new String[] {
			"(set|change) max number of players to %number%"
		})
		, EffFakeMaxPlayers.class);

		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Individual")
		.version("1.8")
		.desc("Show the player prefix/suffix, which is visible for everyone differently!")
		.example(new String[]{
			"make player see player's prefix as ''&aAlly''",
			"make player see player's suffix as ''&cEnemy''"
		})
		.usage(new String[] {
			"make %players% see %players%'s prefix as %string%",
			"make %players% see %players%'s suffix as %string%"
		})
		, EffIndividual.class);

		// Files
		
		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Script")
		.version("1.5")
		.desc("This effect allows you to load folder with scripts from other path. Now: 'plugins/Skript/scripts', with this: 'plugins/Skript/scripts/addons'")
		.example("on load:\n"
				+"	load scripts from " + '"' + "plugins/Skript/scripts/addons" + '"')
		.usage(new String[] {
			"(load|install) script[s] from %string%",
			"Skript.(install|load){%string%}[;]"
		})
		, EffFolder.class);
		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("File")
		.version("1.0")
		.desc("With this, you can create file/folder in any path. ")
		.example("on load:\n"
				+"	create file " + '"'+"plugins/FakePlugin/config.yml" + '"')
		.usage(new String[] {
			"create file %string%",
			"create folder %string%"
		})
		, EffFile.class);
		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Line")
		.version("1.0")
		.desc("Writes new line to file. Any usage moves to the next line.")
		.example("on break of stone:\n"
				+"	wf " + '"'+"[%now%] %player%: break stone" + '"' + " to " + '"'+"plugins/Skript/scripts/Logger/log.txt" + '"')
		.usage(new String[] {
			"(c[reate]|g[enerate]) l[ine] %string% in %string%",
			"w[rite ]f[ile] %string% [to] %string%"
		})
		, EffLine.class);
		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Download")
		.version("1.1")
		.desc("This effect allows you to download anything (jar file, image etc.) from url. ")
		.example("on break of stone:\n"
				+"	wf " + '"'+"[%now%] %player%: break stone" + '"' + " to " + '"'+"plugins/Skript/scripts/Logger/log.txt" + '"')
		.usage(new String[] {
			"download [from] %string% to [file] %string%"
		})
		, EffDownload.class);
		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Plugin")
		.version("1.5")
		.desc("Enables plugin from path or disables by name.")
		.example("command /plugin reload <text>:\n"
				+"	trigger:\n"
				+"		disable plugin " + '"' + "Essentials" + '"' + "\n"
				+"		wait 3 tick\n"
				+"		enable plugin " + '"' + "plugins/Essentials.jar" + '"')
		.usage(new String[] {
			"enable plugin %string%",
			"disable plugin %string%"
		})
		, EffPlugin.class);
		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Delete")
		.version("1.1")
		.desc("Deletes file or folder (with files) from the path. Use with caution! But remember - file/folder to delete can't be used.")
		.example("on unload:\n"
				+"	df " + '"'+"plugins/Skript/scripts/Logger/temp"+ '"')
		.usage(new String[] {
			"delete (file|folder) %string%",
            "df %string%"
		})
		, EffDelete.class);
		
		RegisterManager.registerEffect(new Element(Type.EFFECT)
		.name("Set")
		.version("1.5")
		.desc("Set value in file. Note that this only works in yaml configuration file (*.yml).")
		.example("on join:\n"
				+"	set " + '"'+"%player's UUID%"+ '"' + " to " + '"'+"%name of player%"+ '"' + " in yaml file " + '"'+"plugins/Skript/scripts/Logger/players.yml"+ '"')
		.usage(new String[] {
			"(set|put) %string% (to|in) %string% (in|to) [(yaml|yml)] [file] %string%"
		})
		, EffSet.class);
	
		
		RegisterManager.registerEffect(new Element(Type.NO_DOC)
		.name("Comments")
		.version("1.5")
		.desc("Lack of usefulness ...")
		.example("// No idea \n"
				+"\n"
				+"/* No idea \n"
				+"* No idea \n"
				+"*/ No idea \n")
		.usage(new String[] {
				"//%object%",
				"/*%object%",
				"*%object%",
				"*/%object%"
		})
		, UtilComments.class);
	 }

}
