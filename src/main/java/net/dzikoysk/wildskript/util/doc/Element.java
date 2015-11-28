package net.dzikoysk.wildskript.util.doc;

import net.dzikoysk.wildskript.WildSkript;

public class Element extends Object implements Comparable<Element> {
	
	Type type = Type.NO_DOC;
	String name;
	String collection;
	String object;
	String desc;
	String version;
	String[] usage;
	String example;
	
	public Element(Type type){
		this.type = type;
		this.name = "Anonymous";
		this.desc = "# To Do";
		this.version = WildSkript.getVersion();
		this.example = "# No idea";
	}
	
	public Element name(String s){
		this.name = s;
		return this;
	}
	
	public Element collection(String s){
		this.collection = s;
		return this;
	}
	
	public Element object(String s){
		this.object = s;
		return this;
	}
	
	public Element version(String s){
		this.version = s;
		return this;
	}

	public Element desc(String s){
		this.desc = s;
		return this;
	}
	
	public Element usage(String[] t){
		this.usage = t;
		return this;
	}
	
	public Element example(String s){
		this.example = s.replace("''", '"'+"");
		return this;
	}
	
	public Element example(String[] s){
		StringBuilder sb = new StringBuilder("");
		for(int i = 0; i < s.length; i++){
			if(i != 0) sb.append(" \n");
			sb.append(s[i].replace("''", '"'+""));
		}
		this.example = sb.toString();
		return this;
	}
	
	public Type getType(){
		return this.type;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getCollection(){
		return this.collection;
	}
	
	public String getObject(){
		return this.object;
	}
	
	public String getDesc(){
		return this.desc;
	}
	
	public String getVersion(){
		return this.version;
	}
	
	public String[] getRegisterUsage(){
		return this.usage;
	}
	
	public String getUsage(){
		StringBuilder sb = new StringBuilder("");
		for(String s : this.usage){
			sb.append(s);
			sb.append(" \n");
		}
		return sb.toString();
	}
	
	public String getExample(){
		return this.example;
	}
	
	@Override
    public int compareTo(Element e) {
        return this.name.compareTo(e.getName());
    }
}
