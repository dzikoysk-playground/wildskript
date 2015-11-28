package net.dzikoysk.wildskript.collections.packet;

public class Parser {

    public static Object parse(Class<?> targetClass, Object o) {
        if (targetClass == int.class) {
            if ((o instanceof Number)) return Integer.valueOf(((Number) o).intValue());
            if ((o instanceof String)) return Integer.valueOf(o.toString());
            return o;
        }
        if (targetClass == short.class) {
            if ((o instanceof Number)) return Short.valueOf(((Number) o).shortValue());
            if ((o instanceof String)) return Short.valueOf(o.toString());
            return o;
        }
        if (targetClass == double.class) {
            if ((o instanceof Number)) return Double.valueOf(((Number) o).doubleValue());
            if ((o instanceof String)) return Double.valueOf(o.toString());
            return o;
        }
        if (targetClass == float.class) {
            if ((o instanceof Number)) return Float.valueOf(((Number) o).floatValue());
            if ((o instanceof String)) return Double.valueOf(o.toString());
            return o;
        }
        if (targetClass == long.class) {
            if ((o instanceof Number)) return Long.valueOf(((Number) o).longValue());
            if ((o instanceof String)) return Double.valueOf(o.toString());
            return o;
        }
        return o;
    }

}
