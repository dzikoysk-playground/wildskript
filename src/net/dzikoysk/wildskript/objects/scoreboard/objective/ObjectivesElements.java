package net.dzikoysk.wildskript.objects.scoreboard.objective;

import net.dzikoysk.wildskript.objects.scoreboard.objective.elements.EffDisplayName;
import net.dzikoysk.wildskript.objects.scoreboard.objective.elements.EffDisplaySlot;
import net.dzikoysk.wildskript.objects.scoreboard.objective.elements.EffNew;
import net.dzikoysk.wildskript.objects.scoreboard.objective.elements.EffRegister;
import net.dzikoysk.wildskript.objects.scoreboard.objective.elements.EffReset;
import net.dzikoysk.wildskript.objects.scoreboard.objective.elements.EffSet;
import net.dzikoysk.wildskript.objects.scoreboard.objective.elements.EffUnregister;
import net.dzikoysk.wildskript.register.RegisterManager;
import net.dzikoysk.wildskript.util.doc.Element;
import net.dzikoysk.wildskript.util.doc.Type;

public class ObjectivesElements {
	
	public static void register(){
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Scoreboard")
		.name("Initialize Objective")
		.desc("# Initialize objective")
		.example("new Objective {[id], [criteria]}; // criteria = <a href='http://www.minecraft.gamepedia.com/Scoreboard'>[Link - Click me]</a>")
		.usage(new String[]{
			"new Objective {%string%,%string%}[;]"
		}), EffRegister.class);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Scoreboard")
		.name("Display Slot")
		.desc("# Set display slot")
		.example("[Object].setDisplaySlot{[slot]}; // slot = ''sidebar'', ''below name'', ''player list''")
		.usage(new String[]{
			"%string%.Objective.setDisplaySlot{%string%}[;]"
		}), EffDisplaySlot.class);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Scoreboard")
		.name("Display Name")
		.desc("# Set display name")
		.example("[Object].setDisplayName{[slot]};")
		.usage(new String[]{
			"%string%.Objective.setDisplayName{%string%}[;]"
		}), EffDisplayName.class);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Scoreboard")
		.name("Unregister")
		.desc("# Unregister objective")
		.example("[Object].unregister{[slot]};")
		.usage(new String[]{
			"%string%.Objective.unregister{}[;]"
		}), EffUnregister.class);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Scoreboard")
		.name("Score")
		.desc("# New score")
		.example("[Object].newScore{[text]};")
		.usage(new String[]{
			"%string%.Objective.newScore{%string%}[;]"
		}), EffNew.class);
	
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Scoreboard")
		.name("Set")
		.desc("# Set score")
		.example("[Object].setScore{[text]};")
		.usage(new String[]{
			"%string%.Objective.setScore{%string%}[;]"
		}), EffSet.class);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Scoreboard")
		.name("Reset")
		.desc("# Reset score")
		.example("[Object].resetScore{[text]};")
		.usage(new String[]{
			"%string%.Objective.resetScore{%string%}[;]"
		}), EffReset.class);
	}

}
