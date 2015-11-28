package net.dzikoysk.wildskript.collections.packet.elements;

import net.dzikoysk.wildskript.collections.packet.PacketList;
import net.dzikoysk.wildskript.util.PacketUtils;
import net.dzikoysk.wildskript.util.ReflectionUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffPacket extends Effect {
	
	private Expression<Player> ps;
	private Expression<Object> os;
		
	protected void execute (Event event) {
		Player[] ps = this.ps.getAll(event);
		Object[] os = this.os.getAll(event);
		if(os == null || ps == null) return;
		try{
			Object[] values = new Object[os.length - 1];
			for(int i = 1; i < os.length; i++) values[i - 1] = os[i];
			Class<?> packetClass = ReflectionUtils.getCraftClass(os[0].toString());
			if(!(values.length < 1)){
				Object packet = PacketList.getPacket(packetClass, values);
				for(Player p : ps) PacketUtils.sendPacket(p, packet);
			}else{
				Object packet = PacketList.getPacket(packetClass);
				for(Player p : ps) PacketUtils.sendPacket(p, packet);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}

	public String toString(Event e, boolean bool) { 
		return this.getClass().getName();
	}
	
	@SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult){
		this.ps = (Expression<Player>) expressions[0];
		this.os = (Expression<Object>) expressions[1];
	    return true; 
	}
}
