package net.dzikoysk.wildskript.objects;

import net.dzikoysk.wildskript.objects.hashmap.SkriptHashMapElements;
import net.dzikoysk.wildskript.objects.hologram.HologramElements;
import net.dzikoysk.wildskript.objects.inventory.InventoryElements;
import net.dzikoysk.wildskript.objects.mysql.MySQLElements;
import net.dzikoysk.wildskript.objects.recipe.RecipesElements;
import net.dzikoysk.wildskript.objects.region.RegionsElements;
import net.dzikoysk.wildskript.objects.scoreboard.ScoreboardsElements;
import net.dzikoysk.wildskript.objects.tab.TabElements;

public class Objects {
	
	public static void registerObjects(){
		InventoryElements.register();
		SkriptHashMapElements.register();
		RegionsElements.register();
		TabElements.register();
		RecipesElements.register();
		ScoreboardsElements.register();
		HologramElements.register();
		MySQLElements.register();
	}
}
