package net.dzikoysk.wildskript.objects.hologram;

import net.dzikoysk.wildskript.objects.hologram.elements.EffChange;
import net.dzikoysk.wildskript.objects.hologram.elements.EffDelete;
import net.dzikoysk.wildskript.objects.hologram.elements.EffDestroy;
import net.dzikoysk.wildskript.objects.hologram.elements.EffNew;
import net.dzikoysk.wildskript.objects.hologram.elements.EffShow;
import net.dzikoysk.wildskript.register.RegisterManager;
import net.dzikoysk.wildskript.util.doc.Documentation;
import net.dzikoysk.wildskript.util.doc.Element;
import net.dzikoysk.wildskript.util.doc.Type;

public class HologramElements {
	
	public static void register(){
		
		Documentation.addElement(new Element(Type.DESC)
		.object("Hologram")
		.name("Hologram")
		.desc("This object allows you to create holograms.")
		);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Hologram")
		.name("Initialize")
		.desc("# Initizalize hologram")
		.example("new Hologram [id];")
		.usage(new String[]{
			"new Hologram %string%[;]"
		}), EffNew.class);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Hologram")
		.name("Change")
		.desc("# Change text")
		.example("[Object].change{[text]};")
		.usage(new String[]{
			"%string%.Hologram.(change|set){%string%}[;]"
		}), EffChange.class);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Hologram")
		.name("Show")
		.desc("# Display hologram")
		.example("[Object].display{[location]};")
		.usage(new String[]{
			"%string%.Hologram.(show|display){%location%}[;]"
		}), EffShow.class);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Hologram")
		.name("Destroy")
		.desc("# Destroy hologram")
		.example("[Object].destroy{};")
		.usage(new String[]{
			"%string%.Hologram.(destroy|hide)[{}][;]"
		}), EffDestroy.class);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Hologram")
		.name("Delete")
		.desc("# Delete object")
		.example("[Object].delete{};")
		.usage(new String[]{
			"%string%.Hologram.(delete|remove)[{}][;]"
		}), EffDelete.class);
	}

}
