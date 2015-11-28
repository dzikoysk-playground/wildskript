package net.dzikoysk.wildskript.objects.hashmap;

import net.dzikoysk.wildskript.objects.hashmap.elements.*;
import net.dzikoysk.wildskript.register.RegisterManager;
import net.dzikoysk.wildskript.util.doc.Documentation;
import net.dzikoysk.wildskript.util.doc.Element;
import net.dzikoysk.wildskript.util.doc.Type;

public class SkriptHashMapElements {

    public static void register() {

        Documentation.addElement(new Element(Type.DESC)
                .object("HashMap")
                .name("HashMap")
                .desc("Allows you to create virtual map (key: value)")
        );

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("HashMap")
                .name("Initialize")
                .desc("# Initialize HashMap")
                .example("new HashMap{[id]};")
                .usage(new String[]{
                        "new HashMap{%string%}[;]"
                }), EffNew.class);

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("HashMap")
                .name("Put")
                .desc("# Put key and value")
                .example("[Object].put{[object], [object]}[;]")
                .usage(new String[]{
                        "%string%.HashMap.put{%object%,%object%}[;]"
                }), EffPut.class);

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("HashMap")
                .name("Delete")
                .desc("# Delete HashMap")
                .example("[Object].delete{}[;]")
                .usage(new String[]{
                        "%string%.HashMap.delete{}[;]"
                }), EffDelete.class);

        RegisterManager.registerExpression(new Element(Type.OBJECT)
                        .object("HashMap")
                        .name("Get")
                        .desc("# Get value by key")
                        .example("[Object].get{[object]}[;]")
                        .usage(new String[]{
                                "%string%.HashMap.get{%object%}[;]"
                        })
                , ExprGet.class, Object.class);

        RegisterManager.registerExpression(new Element(Type.OBJECT)
                        .object("HashMap")
                        .name("Keys")
                        .desc("# Get keys")
                        .example("[Object].getKeys{}[;]")
                        .usage(new String[]{
                                "%string%.HashMap.getKeys{}[;]"
                        })
                , ExprKeys.class, Object.class);

        RegisterManager.registerExpression(new Element(Type.OBJECT)
                        .object("HashMap")
                        .name("Values")
                        .desc("# Get values")
                        .example("[Object].getValues{}[;]")
                        .usage(new String[]{
                                "%string%.HashMap.getValues{}[;]"
                        })
                , ExprValues.class, Object.class);

        RegisterManager.registerExpression(new Element(Type.OBJECT)
                        .object("HashMap")
                        .name("Size")
                        .desc("# Get size")
                        .example("[Object].getSize{}[;]")
                        .usage(new String[]{
                                "%string%.HashMap.getSize{}[;]"
                        })
                , ExprSize.class, Integer.class);

        RegisterManager.registerCondition(new Element(Type.OBJECT)
                        .object("HashMap")
                        .name("Exists")
                        .desc("# Checks whether the hashmap exists")
                        .example("if hashmap [id] is exists")
                        .usage(new String[]{
                                "hashmap %string% is exists",
                                "hashmap %string% (does not|doesn't|is not|isn't) exists"
                        })
                , CondExists.class);

        RegisterManager.registerCondition(new Element(Type.OBJECT)
                        .object("HashMap")
                        .name("Contains Key")
                        .desc("# Checks whether the hashmap contains key")
                        .example("if hashmap [id] contains key [object]")
                        .usage(new String[]{
                                "hashmap %string% contains key %object%",
                                "hashmap %string% (does not|doesn't|is not|isn't) contains key %object%"
                        })
                , CondKey.class);

        RegisterManager.registerCondition(new Element(Type.OBJECT)
                        .object("HashMap")
                        .name("Contains Value")
                        .desc("# Checks whether the hashmap contains value")
                        .example("if hashmap [id] contains value [object]")
                        .usage(new String[]{
                                "hashmap %string% contains value %object%",
                                "hashmap %string% (does not|doesn't|is not|isn't) contains value %object%"
                        })
                , CondValue.class);

    }
}
