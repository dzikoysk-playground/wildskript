package net.dzikoysk.wildskript.objects.scoreboard.team;

import net.dzikoysk.wildskript.objects.scoreboard.team.elements.EffAdd;
import net.dzikoysk.wildskript.objects.scoreboard.team.elements.EffCanSeeFriendlyInvisibles;
import net.dzikoysk.wildskript.objects.scoreboard.team.elements.EffDisplayName;
import net.dzikoysk.wildskript.objects.scoreboard.team.elements.EffFriendlyFire;
import net.dzikoysk.wildskript.objects.scoreboard.team.elements.EffPrefix;
import net.dzikoysk.wildskript.objects.scoreboard.team.elements.EffRegister;
import net.dzikoysk.wildskript.objects.scoreboard.team.elements.EffRemove;
import net.dzikoysk.wildskript.objects.scoreboard.team.elements.EffSuffix;
import net.dzikoysk.wildskript.register.RegisterManager;
import net.dzikoysk.wildskript.util.doc.Element;
import net.dzikoysk.wildskript.util.doc.Type;

public class TeamsElements {
	
	public static void register(){
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Scoreboard")
		.name("Initialize Objective")
		.desc("// Teams \n\n" + "# Initialize objective")
		.example("new Team [id];")
		.usage(new String[]{
			"new Team %string%[;]"
		}), EffRegister.class);

		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Scoreboard")
		.name("Add")
		.desc("# Add player to team")
		.example("[Object].addPlayer{[player]};")
		.usage(new String[]{
			"%string%.Team.addPlayer{%player%}[;]"
		}), EffAdd.class);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Scoreboard")
		.name("Remove")
		.desc("# Remove player from team")
		.example("[Object].removePlayer{[player]};")
		.usage(new String[]{
			"%string%.Team.removePlayer{%player%}[;]"
		}), EffRemove.class);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Scoreboard")
		.name("Prefix")
		.desc("# Set team's prefix")
		.example("[Object].setPrefix{[text]};")
		.usage(new String[]{
			"%string%.Team.setPrefix{%player%}[;]"
		}), EffPrefix.class);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Scoreboard")
		.name("Suffix")
		.desc("# Set team's suffix")
		.example("[Object].setSuffix{[text]};")
		.usage(new String[]{
			"%string%.Team.setSuffix{%player%}[;]"
		}), EffSuffix.class);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Scoreboard")
		.name("Display Name")
		.desc("# Set team's display name")
		.example("[Object].setDisplayName{[text]};")
		.usage(new String[]{
			"%string%.Team.setDisplayName{%player%}[;]"
		}), EffDisplayName.class);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Scoreboard")
		.name("Friendly fire")
		.desc("# Set friendly fire")
		.example("[Object].setFriendlyFire{[boolean]};")
		.usage(new String[]{
			"%string%.Team.setFriendlyFire{%boolean%}[;]"
		}), EffFriendlyFire.class);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Scoreboard")
		.name("Friendly Invisibles")
		.desc("# Set friendly invisibles")
		.example("[Object].setFriendlyInvisibles{[boolean]};")
		.usage(new String[]{
			"%string%.Team.setFriendlyInvisibles{%boolean%}[;]"
		}), EffCanSeeFriendlyInvisibles.class);
	}
}
