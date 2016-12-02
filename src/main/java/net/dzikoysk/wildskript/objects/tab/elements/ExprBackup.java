package net.dzikoysk.wildskript.objects.tab.elements;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import net.dzikoysk.wildskript.objects.tab.TabUtils;
import org.bukkit.event.Event;

public class ExprBackup extends SimpleExpression<String> {

    private Expression<String> id;

    protected String[] get(Event event) {
        String id = this.id.getSingle(event);
        if (id == null) {
            return null;
        }
        String[][] backup = TabUtils.get(id).getRows().clone();
        if (backup[1].length < 60 || backup[0].length < 60 || backup[2].length < 60) {
            return null;
        }
        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < 60; i++) {
            if (backup[0][i] == null || backup[0][i].isEmpty()) {
                backup[0][i] = "<EMPTY>";
            }
            if (backup[2][i] == null || backup[2][i].isEmpty()) {
                backup[2][i] = "<EMPTY>";
            }
            if (i != 0) {
                res.append(";;;");
            }
            res.append(backup[0][i] + ";;" + backup[1][i] + ";;" + backup[2][i]);
        }
        return new String[]{ res.toString() };
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] e, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.id = (Expression<String>) e[0];
        return true;
    }

    public boolean isSingle() {
        return true;
    }

    public Class<? extends String> getReturnType() {
        return String.class;
    }

    public String toString(Event event, boolean b) {
        return this.getClass().getName();
    }
}








