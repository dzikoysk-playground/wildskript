package net.dzikoysk.wildskript.register;

import net.dzikoysk.wildskript.classes.AgeClasses;
import net.dzikoysk.wildskript.classes.RegionClasses;
import net.dzikoysk.wildskript.util.doc.Element;
import net.dzikoysk.wildskript.util.doc.Type;

public class Classes {
	
	public static void registerClasses(){
		RegisterManager.registerClasses(new Element(Type.TYPE)
		.name("Age")
		.version("1.5")
		.desc("Age of entity. Can be baby or adult")
		.example("#IN BUILD")
		.usage(new String[] {
			"age of %entity%"
		})
		, new AgeClasses());
		
		RegisterManager.registerClasses(new Element(Type.TYPE)
		.name("Region")
		.version("1.5")
		.desc("Currently not applicable :C")
		.example("set {_region} to " + '"' + "Test" + '"' + ".Region" )
		.usage(new String[] {
			"%string%.Region"
		})
		, new RegionClasses());
	}
}
