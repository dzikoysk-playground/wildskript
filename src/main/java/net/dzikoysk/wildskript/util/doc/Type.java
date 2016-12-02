package net.dzikoysk.wildskript.util.doc;

public enum Type {

    EVENT_VALUE,
    CONDITION,
    EVENT,
    EFFECT,
    EXPRESSION,
    COLLECTION,
    OBJECT,
    PLUGIN,
    TYPE,
    DESC,
    NO_DOC;

    public String getName() {
        if (this == Type.CONDITION) {
            return "Conditions";
        }
        if (this == Type.EVENT) {
            return "Events";
        }
        if (this == Type.EFFECT) {
            return "Effects";
        }
        if (this == Type.EXPRESSION) {
            return "Expressions";
        }
        if (this == Type.TYPE) {
            return "Types";
        }
        if (this == Type.COLLECTION) {
            return "Collections";
        }
        if (this == Type.OBJECT) {
            return "Objects";
        }
        return "No Doc";
    }
}
