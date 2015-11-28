package net.dzikoysk.wildskript.objects.tab;

import net.dzikoysk.wildskript.objects.tab.elements.EffRestore;
import net.dzikoysk.wildskript.objects.tab.elements.EffSend;
import net.dzikoysk.wildskript.objects.tab.elements.EffSet;
import net.dzikoysk.wildskript.objects.tab.elements.ExprBackup;
import net.dzikoysk.wildskript.register.RegisterManager;
import net.dzikoysk.wildskript.util.doc.Documentation;
import net.dzikoysk.wildskript.util.doc.Element;
import net.dzikoysk.wildskript.util.doc.Type;

public class TabElements {

    public static void register() {

        Documentation.addElement(new Element(Type.DESC)
                .object("Tab")
                .name("Tab")
                .desc("This object allows you to edit online player list (tab list).")
        );

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("Tab")
                .name("Set")
                .desc("# Set slot")
                .example("[Object].set{[number], [text]};")
                .usage(new String[]{
                        "%string%.Tab.set{%number%,%string%}[;]"
                }), EffSet.class);

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("Tab")
                .name("Send")
                .desc("# Send tab object to player")
                .example("[Object].send{[player]};")
                .usage(new String[]{
                        "%string%.Tab.send{%player%}[;]"
                }), EffSend.class);

        RegisterManager.registerExpression(new Element(Type.OBJECT)
                        .object("Tab")
                        .name("Backup")
                        .desc("# Save backup list")
                        .example("[Object].getBackup{};")
                        .usage(new String[]{
                                "%string%.Tab.getBackup{}[;]"
                        })
                , ExprBackup.class, String.class);

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("Tab")
                .name("Backup")
                .desc("# Restore tab from backup varaible")
                .example("[Object].restore{[backup variable]};")
                .usage(new String[]{
                        "%string%.Tab.restore{%string%}[;]"
                }), EffRestore.class);
    }
}
