package net.dzikoysk.wildskript.collections.functions;

import net.dzikoysk.wildskript.collections.functions.elements.*;
import net.dzikoysk.wildskript.register.RegisterManager;
import net.dzikoysk.wildskript.util.doc.Documentation;
import net.dzikoysk.wildskript.util.doc.Element;
import net.dzikoysk.wildskript.util.doc.Type;

public class FunctionElements {

    public static void register() {

        Documentation.addElement(new Element(Type.DESC)
                .collection("Function")
                .name("Function")
                .desc("This element allows us to create functions.")
        );

        RegisterManager.registerEvent(new Element(Type.COLLECTION)
                        .collection("Function")
                        .name("Function")
                        .desc("# Function code")
                        .example("method [text] {[args]}:")
                        .usage(new String[]{
                                "on (method|function) %string%{[%-objects%]}"
                        })
                , FunctionAdapter.class, FunctionEvent.class);

        RegisterManager.registerEffect(new Element(Type.COLLECTION)
                        .collection("Function")
                        .name("Return")
                        .desc("# Return value")
                        .example("function [text]{[values]};")
                        .usage(new String[]{
                                "function %string%{[%-objects%]}[;]"
                        })
                , EffFunction.class);

        RegisterManager.registerExpression(new Element(Type.COLLECTION)
                        .collection("Function")
                        .name("Function")
                        .desc("# Call function and get result")
                        .example("result of function [text]{[values]};")
                        .usage(new String[]{
                                "(return|result) of (function|method) %string%{[%-objects%]}[;]"
                        })
                , ExprFunction.class, Object.class);

        RegisterManager.registerEffect(new Element(Type.COLLECTION)
                        .collection("Function")
                        .name("Return")
                        .desc("# Return value")
                        .example("return [whatever];")
                        .usage(new String[]{
                                "return %object%[;]"
                        })
                , EffReturn.class);

        RegisterManager.registerExpression(new Element(Type.COLLECTION)
                        .collection("Function")
                        .name("Argument")
                        .desc("# Get argument")
                        .example("arg{[number]}")
                        .usage(new String[]{
                                "arg{%number%}[;]"
                        })
                , ExprArgument.class, Object.class);

        RegisterManager.registerExpression(new Element(Type.COLLECTION)
                        .collection("Function")
                        .name("Arguments")
                        .desc("# Get arguments")
                        .example("args")
                        .usage(new String[]{
                                "args[;]"
                        })
                , ExprArguments.class, Object.class);
    }


}
