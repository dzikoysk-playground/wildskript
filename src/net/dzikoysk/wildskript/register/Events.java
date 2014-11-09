package net.dzikoysk.wildskript.register;
import net.dzikoysk.wildskript.events.skript.EvtDownload;
import net.dzikoysk.wildskript.events.skript.EvtJump;
import net.dzikoysk.wildskript.util.doc.Element;
import net.dzikoysk.wildskript.util.doc.Type;

import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.HorseJumpEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.server.ServerListPingEvent;

public class Events {
	
	public static void registerEvents() {
		RegisterManager.registerEvent(new Element(Type.EVENT)
		.name("On Jump")
		.version("1.5")
		.desc("Called when player jumps")
		.example(new String[]{
			"on jump:",
			"	send ''Yolo''"
		})
		.usage(new String[]{
			"on jump[ing]:"	
		})
		, EvtJump.class);
		 
		RegisterManager.registerEvent(new Element(Type.EVENT)
		.name("On Download")
		.version("1.3")
		.desc("Called when WildSkript downloads file. ")
		.example("on download:\n	cancel event\n	send " + '"' + "I don't allow to download" + '"' + " to console")
		.usage(new String[]{
			"on download:"	
		})
		, EvtDownload.class);
		
		RegisterManager.registerEvent(new Element(Type.EVENT)
		.name("On Server Ping")
		.version("1.0")
		.desc("Called when a servers list is refreshed. In the event, you can get ip of caller.")
		.example("on server list ping:\n	set {_ip} to ip")
		.usage(new String[]{
			"on [server] [list] ping:"	
		})
		, ServerListPingEvent.class);
			
		RegisterManager.registerEvent(new Element(Type.EVENT)
		.name("On Inventory Close")
		.version("1.0")
		.desc("Called when player closes inventory. You can't cancel the event because it's only a notification from the client.")
		.example("on inventory close: \n	send " + '"' + "Close" + '"')
		.usage(new String[]{
			"on inventory open:",
			"on close inventory:"
		})
		, InventoryCloseEvent.class);
		
		RegisterManager.registerEvent(new Element(Type.EVENT)
		.name("On Inventory Open")
		.version("1.0")
		.desc("Called when player opens inventory. You can't cancel the event because it's only a notification from the client, but you can use effect 'Close' :>")
		.example("on inventory open:  \n	close player's inventory")
		.usage(new String[]{
			"on inventory open:",
			"on open inventory:"
		})
		, InventoryOpenEvent.class);
		
		RegisterManager.registerEvent(new Element(Type.EVENT)
		.name("On Enchant")
		.version("1.0")
		.desc("Called when player enchants item.")
		.example("on enchant:  \n	if event-item is diamond sword:\n	add 1 to {enchant.diamond.sword.%player%}")
		.usage(new String[]{
			"on enchant [item]:",
		})
		, EnchantItemEvent.class);
		
		RegisterManager.registerEvent(new Element(Type.EVENT)
		.name("On Any Move")
		.version("1.0")
		.desc("Called when a player performs any movement.")
		.example("# Don't do it alone at home \non any move:  \n	cancel event")
		.usage(new String[]{
			"on any[ ]move:",
		})
		, PlayerMoveEvent.class);
		
		RegisterManager.registerEvent(new Element(Type.EVENT)
		.name("On Inventory Click")
		.version("1.0")
		.desc("Called when a player performs any click in any inventory.")
		.example("on inventory click:  \n	send " + '"' + "Click" + '"')
		.usage(new String[]{
			"on inventory click:",
		})
		, InventoryClickEvent.class);
		
		RegisterManager.registerEvent(new Element(Type.EVENT)
		.name("On Prepare Item Craft")
		.version("1.5")
		.desc("Called when a player crafts item.")
		.example("on prepare item craft:  \n	send " + '"' + "No idea" + '"')
		.usage(new String[]{
			"on prepare item craft:",
		})
		, PrepareItemCraftEvent.class);
		
		RegisterManager.registerEvent(new Element(Type.EVENT)
		.name("On Horse Jump")
		.version("1.0")
		.desc("Called when a horse jumps.")
		.example("# I don't know if it works :P \non horse jump:  \n	kill horse	# :O")
		.usage(new String[]{
			"on horse jump:",
		})
		, HorseJumpEvent.class);
		
		RegisterManager.registerEvent(new Element(Type.EVENT)
		.name("On Edit Book")
		.version("1.0")
		.desc("Called when player edits book.")
		.example("on book edit:  \n	send " + '"' + "Is it the Bible?" + '"')
		.usage(new String[]{
			"on [player] edit book:",
		})
		, PlayerEditBookEvent.class);
		
		 
	 }
}
