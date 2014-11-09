package net.dzikoysk.wildskript.util.doc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class ElementMap<K, V>{

	private final Map<String, List<Element>> content;

	public ElementMap(){
		content = new HashMap<String, List<Element>>();
	}
	
	public boolean containsKey(String key) {
		if(content.containsKey(key)) return true;
		return false;
	}

	public boolean containsValue(List<Element> value) {
		if(content.containsValue(value)) return true;
		return false;
	}

	public Set<Entry<String, List<Element>>> entrySet() {
		return content.entrySet();
	}

	public List<Element> get(String key) {
		if(!this.containsKey(key)) content.put(key, new ArrayList<Element>());
		return content.get(key);
	}
	
	public List<Element> get(int i) {
		return content.get(i);
	}

	public boolean isEmpty() {
		if(content.isEmpty()) return true;
		return false;
	}

	public Set<String> keySet() {
		return content.keySet();
	}

	public void add(Element e){
		if(e.getType() == Type.COLLECTION) this.get(e.getCollection()).add(e);
		else if(e.getType() == Type.OBJECT) this.get(e.getObject()).add(e);
	}

	public void remove(Element e) {
		if(e.getType() == Type.COLLECTION) this.get(e.getCollection()).remove(e);
		else if(e.getType() == Type.OBJECT) this.get(e.getObject()).remove(e);
	}

	public int size() {
		return content.size();
	}

	public Collection<List<Element>> values() {
		return content.values();
	}
}
