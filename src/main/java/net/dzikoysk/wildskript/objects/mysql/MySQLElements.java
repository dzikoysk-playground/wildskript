package net.dzikoysk.wildskript.objects.mysql;

import net.dzikoysk.wildskript.objects.hashmap.elements.EffNew;
import net.dzikoysk.wildskript.objects.mysql.elements.EffUpdate;
import net.dzikoysk.wildskript.objects.mysql.elements.ExprQuery;
import net.dzikoysk.wildskript.register.RegisterManager;
import net.dzikoysk.wildskript.util.doc.Documentation;
import net.dzikoysk.wildskript.util.doc.Element;
import net.dzikoysk.wildskript.util.doc.Type;

public class MySQLElements {

    public static void register() {

        Documentation.addElement(new Element(Type.DESC)
                .object("MySQL")
                .name("MySQL")
                .desc("Allows you to use mysql (database).")
        );

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("MySQL")
                .name("Initialize")
                .desc("# Initialize MySQL")
                .example("new MySQL $[id] $[hostname] $[port] $[database] $[username] $[password];")
                .usage(new String[]{
                        "new MySQL $%string% $%string% $%number% $%string% $%string% $%string%[;]"
                }), EffNew.class);

        RegisterManager.registerEffect(new Element(Type.OBJECT)
                .object("MySQL")
                .name("Update")
                .desc("# Execute update to mysql")
                .example("[Object].executeUpdate{[text]};")
                .usage(new String[]{
                        "%string%.MySQL.executeUpdate{%string%}[;]"
                }), EffUpdate.class);

        RegisterManager.registerExpression(new Element(Type.OBJECT)
                        .object("MySQL")
                        .name("Query")
                        .desc("# Execute query")
                        .example("[Object].executeQuery{[text], [text]};")
                        .usage(new String[]{
                                "%string%.MySQL.executeQuery{%string%,%string%}[;]"
                        })
                , ExprQuery.class, Object.class);

    }
}
