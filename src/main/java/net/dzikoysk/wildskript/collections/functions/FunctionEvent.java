package net.dzikoysk.wildskript.collections.functions;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import javax.annotation.Nullable;

public class FunctionEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private final String name;
    private final Object[] args;
    private Object result;
    private boolean end;

    @Nullable
    public FunctionEvent(String name, Object[] args) {
        this.name = name;
        this.args = args;
    }

    public void setResult(Object o) {
        this.result = o;
        this.end = true;
    }

    public boolean isFinished() {
        return end;
    }

    public String getName() {
        return name;
    }

    public Object[] getArgs() {
        return args;
    }

    public Object getResult() {
        return result;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }


}
