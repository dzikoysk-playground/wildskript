package net.dzikoysk.wildskript.collections.bossbar;

import net.dzikoysk.wildskript.collections.bossbar.elemetns.EffDisplay;
import net.dzikoysk.wildskript.collections.bossbar.elemetns.EffRemove;
import net.dzikoysk.wildskript.collections.bossbar.elemetns.ExprPercent;
import net.dzikoysk.wildskript.collections.bossbar.elemetns.ExprText;
import net.dzikoysk.wildskript.register.RegisterManager;
import net.dzikoysk.wildskript.util.doc.Documentation;
import net.dzikoysk.wildskript.util.doc.Element;
import net.dzikoysk.wildskript.util.doc.Type;

public class BossHealthBarElements {
	
	public static void register(){
		
		Documentation.addElement(new Element(Type.DESC)
		.collection("BossBar")
		.name("BossBar")
		.desc("This element allows us to display the bar of dragon. We have the ability to set the screen text (supports colors), fill level, timing and player, which is to be sent.")
		);
	
		RegisterManager.registerEffect(new Element(Type.COLLECTION)
		.collection("BossBar")
		.name("Display")
		.desc("# Display bossbar")
		.example(new String[]{
			"display [text] on bossbar for [player]",
			"display [text] on bossbar with [number] percent for [player]",
			"display [text] on bossbar with [number] percent by [number] seconds for [player]",
		})
		.usage(new String[]{
			"display %string% on bossbar [with %number% percent [by %number% seconds]] for %player%"
		})
		, EffDisplay.class);

		RegisterManager.registerEffect(new Element(Type.COLLECTION)
		.collection("BossBar")
		.name("Remove")
		.desc("# Remove bossbar")
		.example(new String[]{
			"remove bossbar from [player]",
		})
		.usage(new String[]{
			"remove bossbar from %player%"
		})
		, EffRemove.class);
	
		RegisterManager.registerExpression(new Element(Type.COLLECTION)
		.collection("BossBar")
		.name("Percent")
		.desc("# Get percent of player's bossbar")
		.example("percent of [player]'s bossbar")
		.usage(new String[]{
			"percent of %player%'s bossbar"
		})
		, ExprPercent.class, Integer.class);
		
		RegisterManager.registerExpression(new Element(Type.COLLECTION)
		.collection("BossBar")
		.name("Text")
		.desc("# Get text of player's bossbar")
		.example("text of [player]'s bossbar")
		.usage(new String[]{
			"text of %player%'s bossbar"
		})
		, ExprText.class, String.class);
	}
}
