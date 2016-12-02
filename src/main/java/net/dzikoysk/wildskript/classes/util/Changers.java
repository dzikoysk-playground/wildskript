package net.dzikoysk.wildskript.classes.util;

import ch.njol.skript.classes.Changer;
import ch.njol.util.coll.CollectionUtils;
import net.dzikoysk.wildskript.classes.AgeClasses.Age;
import org.bukkit.entity.Ageable;
import org.bukkit.entity.Entity;

public class Changers {

    public static final Changer<Age> age = new Changer<Age>() {
        public Class<?>[] acceptChange(Changer.ChangeMode mode) {
            if (mode == Changer.ChangeMode.SET) {
                return (Class[]) CollectionUtils.array(new Class[]{ Age.class });
            }
            return null;
        }

        public void change(Age[] age, Object[] delta, Changer.ChangeMode mode) {
            for (Age a : age) {
                for (Object o : delta) {
                    if (o instanceof Entity) {
                        if (o instanceof Ageable) {
                            if (a == Age.BABY) {
                                ((Ageable) o).setBaby();
                            }
                            if (a == Age.ADULT) {
                                ((Ageable) o).setAdult();
                            }
                        }
                    }
                }
            }
        }
    };
}
