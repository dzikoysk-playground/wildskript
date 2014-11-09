package net.dzikoysk.wildskript.register;

import net.dzikoysk.wildskript.conditions.CondFileExists;
import net.dzikoysk.wildskript.conditions.CondIsTamed;
import net.dzikoysk.wildskript.util.doc.Element;
import net.dzikoysk.wildskript.util.doc.Type;

public class Conditions {
	
	 public static void registerConditions() {
		RegisterManager.registerCondition(new Element(Type.CONDITION)
		.name("File Exists")
		.version("1.3")
		.desc("Checks whether a file/folder (whatever) exists.")
		.example("on load:\n	" 
		+ "if file " + '"' + "plugins/Skript/scripts/addon.sk" + '"' + " doesn't exists:\n		"
		+ "	create file " + '"' + "plugins/Skript/scripts/addon.sk" + '"')
		.usage(new String[]{
			"(file|folder) %string% exists",
			"(file|folder) %string% (does not|doesn't|is not|isn't) exists"
		})
		, CondFileExists.class);
		
		RegisterManager.registerCondition(new Element(Type.CONDITION)
		.name("Is Tamed")
		.version("1.6")
		.desc("Checks whether a entity (tameable) is tamed.")
		.example("on leftclick on ocelot:\n" +
				"	if clicked entity is tamed:\n" +
				"		cancel event")
		.usage(new String[]{
			"%entity% is tamed",
			"%entity% (is not|isn't) tamed"
		})
		, CondIsTamed.class);
	
	 }

}
