package net.dzikoysk.wildskript.collections;

import net.dzikoysk.wildskript.collections.bossbar.BossHealthBarElements;
import net.dzikoysk.wildskript.collections.functions.FunctionElements;
import net.dzikoysk.wildskript.collections.loader.LoaderElements;
import net.dzikoysk.wildskript.collections.obfuscator.ObfuscatorElements;
import net.dzikoysk.wildskript.collections.packet.PacketElements;

public class Collections {
	
	public static void registerComplex(){
		BossHealthBarElements.register();
		FunctionElements.register();
		LoaderElements.register();
		PacketElements.register();
		ObfuscatorElements.register();
	}
}
