package net.dzikoysk.wildskript.objects.scoreboard;

import net.dzikoysk.wildskript.objects.scoreboard.elements.EffRemove;
import net.dzikoysk.wildskript.objects.scoreboard.elements.EffUpdate;
import net.dzikoysk.wildskript.objects.scoreboard.objective.ObjectivesElements;
import net.dzikoysk.wildskript.objects.scoreboard.team.TeamsElements;
import net.dzikoysk.wildskript.register.RegisterManager;
import net.dzikoysk.wildskript.util.doc.Documentation;
import net.dzikoysk.wildskript.util.doc.Element;
import net.dzikoysk.wildskript.util.doc.Type;

public class ScoreboardsElements {

    public static void register() {
        new Scoreboards();
        registerMain();
        ObjectivesElements.register();
        TeamsElements.register();
    }

    private static void registerMain() {

        Documentation.addElement(new Element(Type.DESC)
                .object("Scoreboard")
                .name("Scoreboard")
                .desc("Allows you to create scoreboard adapted for your needs. It has some universal functions, which are expanding range of possibilities and let you have greater freedom.\n\n"
                        + "We're dividing Scoreboard into 3 elements: Objective, Score and Team. Scorebord itself has only one possibility: sending changes made in these three elements to player."
                )
        );

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("Scoreboard")
                .name("Update")
                .desc("// Main\n\n" + "# Update scoreboard for player")
                .example("update scoreboard for [player]")
                .usage(new String[]{
                        "update scoreboard for %player%"
                }), EffUpdate.class);


        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("Scoreboard")
                .name("Remove")
                .desc("# Remove scoreboard from player")
                .example("remove scoreboard from [player]")
                .usage(new String[]{
                        "remove scoreboard from %player%"
                }), EffRemove.class);
    }
}
