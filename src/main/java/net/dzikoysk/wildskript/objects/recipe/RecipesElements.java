package net.dzikoysk.wildskript.objects.recipe;

import net.dzikoysk.wildskript.objects.recipe.elements.*;
import net.dzikoysk.wildskript.register.RegisterManager;
import net.dzikoysk.wildskript.util.doc.Documentation;
import net.dzikoysk.wildskript.util.doc.Element;
import net.dzikoysk.wildskript.util.doc.Type;

public class RecipesElements {

    public static void register() {

        Documentation.addElement(new Element(Type.DESC)
                .object("Recipes")
                .name("Recipes")
                .desc("Allows you to create your own recipe including ingredient's amount, enchant, name and even lore. This element is very simple and the only thing you have to remember is necessity of registering recipe after you'd created it. ")
        );

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("Recipes")
                .name("Initialize")
                .desc("# Initialize recipe")
                .example("new Recipe [id];")
                .usage(new String[]{
                        "new Recipe %string%[;]"
                }), EffNew.class);

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("Recipes")
                .name("Ingredient")
                .desc("# Set ingredient for slot")
                .example("[Object].registerIngredient{[number],[item]};")
                .usage(new String[]{
                        "%string%.Recipe.(set|register)Ingredient{%number%,%itemtype%}[;]"
                }), EffIngredient.class);

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("Recipes")
                .name("Result")
                .desc("# Set result")
                .example("[Object].registerResult{[item]};")
                .usage(new String[]{
                        "%string%.Recipe.(set|register)Result{%itemtype%}[;]"
                }), EffResult.class);

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("Recipes")
                .name("Register")
                .desc("# Register recipe")
                .example("[Object].register{};")
                .usage(new String[]{
                        "%string%.Recipe.register{}[;]"
                }), EffRegister.class);

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("Recipes")
                .name("Unregister")
                .desc("# Unregister recipe")
                .example("[Object].unregister{};")
                .usage(new String[]{
                        "%string%.Recipe.unregister{}[;]"
                }), EffUnregister.class);
    }
}
