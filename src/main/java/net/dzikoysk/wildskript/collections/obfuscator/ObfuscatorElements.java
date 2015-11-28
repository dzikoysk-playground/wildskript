package net.dzikoysk.wildskript.collections.obfuscator;

import net.dzikoysk.wildskript.collections.obfuscator.elements.EffLoad;
import net.dzikoysk.wildskript.collections.obfuscator.elements.EffObfuscate;
import net.dzikoysk.wildskript.register.RegisterManager;
import net.dzikoysk.wildskript.util.doc.Documentation;
import net.dzikoysk.wildskript.util.doc.Element;
import net.dzikoysk.wildskript.util.doc.Type;

public class ObfuscatorElements {

    public static void register() {

        Documentation.addElement(new Element(Type.DESC)
                .collection("Obfuscator")
                .name("Obfuscator")
                .desc("This collection allows you to obfuscate your code.")
        );

        RegisterManager.registerEffect(new Element(Type.COLLECTION)
                .collection("Obfuscator")
                .name("Obfuscate")
                .desc("# Obfuscate file")
                .example("obfuscate file [file] to file [file] with power [number]")
                .usage(new String[]{
                        "obfuscate file %string% to file %string% with power %number%"
                }), EffObfuscate.class);

        RegisterManager.registerEffect(new Element(Type.COLLECTION)
                .collection("Obfuscator")
                .name("Load")
                .desc("# Load obfuscated file")
                .example("load obfuscated file [file] by power [number]")
                .usage(new String[]{
                        "load obfuscated file %string% by power %number%"
                }), EffLoad.class);

    }
}
