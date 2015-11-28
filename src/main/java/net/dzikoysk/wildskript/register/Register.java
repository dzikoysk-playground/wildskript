package net.dzikoysk.wildskript.register;

import net.dzikoysk.wildskript.WildSkript;
import net.dzikoysk.wildskript.collections.Collections;
import net.dzikoysk.wildskript.objects.Objects;

public class Register {
	public static void register() {
		Classes.registerClasses();
		Events.registerEvents();
		Conditions.registerConditions();
		Effects.registerEffects();
		Expressions.register();
		EventValue.registerEventValues();
		Collections.registerComplex();
		Objects.registerObjects();
		
		WildSkript.log("Classes, Events, Conditions, Effects, Expressions and EventValues have been registered!");
		WildSkript.log("Objects and Complex have been registered!");
	}
}
