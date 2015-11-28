package net.dzikoysk.wildskript.collections.loader;

import net.dzikoysk.wildskript.collections.loader.elements.EffFile;
import net.dzikoysk.wildskript.collections.loader.elements.EffFolder;
import net.dzikoysk.wildskript.collections.loader.elements.EffPlugin;
import net.dzikoysk.wildskript.collections.loader.elements.EffString;
import net.dzikoysk.wildskript.collections.loader.elements.EffURL;
import net.dzikoysk.wildskript.register.RegisterManager;
import net.dzikoysk.wildskript.util.doc.Documentation;
import net.dzikoysk.wildskript.util.doc.Element;
import net.dzikoysk.wildskript.util.doc.Type;

public class LoaderElements {
	
	public static void register(){
		
		Documentation.addElement(new Element(Type.DESC)
		.collection("Loader")
		.name("Loader")
		.desc("Allows you to load script from file/folder/string/url")
		);
		
		RegisterManager.registerEffect(new Element(Type.COLLECTION)
		.collection("Loader")
		.name("File")
		.desc("# Load content of file as script")
		.example("load script from file [path]")
		.usage(new String[]{
			"load script from file %string%"	
		})
		, EffFile.class);
		
		RegisterManager.registerEffect(new Element(Type.COLLECTION)
		.collection("Loader")
		.name("Folder")
		.desc("# Load Skript's file from folder")
		.example("load scripts from folder [path]")
		.usage(new String[] {
			"load scripts from folder %string%"
		})
		, EffFolder.class);
	
		RegisterManager.registerEffect(new Element(Type.COLLECTION)
		.collection("Loader")
		.name("Plugin")
		.desc("# Enable/Disable plugin")
		.example(new String[] {
			"enable plugin [file]",
			"disable plugin [name]"
		})
		.usage(new String[]{
			"enable plugin %string%",
			"disable plugin %string%"
		})
		, EffPlugin.class);
		
		RegisterManager.registerEffect(new Element(Type.COLLECTION)
		.collection("Loader")
		.name("String")
		.desc("# Load script from string")
		.example("load script from [string]")
		.usage(new String[] {
			"load script from %string%"
		})
		, EffString.class);
		
		RegisterManager.registerEffect(new Element(Type.COLLECTION)
		.collection("Loader")
		.name("URL")
		.desc("# Load content of url as script")
		.example("load script from url [url]")
		.usage(new String[] {
			"load script from url %string%"
		})
		, EffURL.class);
	}
}
