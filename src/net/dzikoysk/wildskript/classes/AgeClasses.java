package net.dzikoysk.wildskript.classes;

import net.dzikoysk.wildskript.WildSkript;

public class AgeClasses{
	
	public enum Age{
		BABY,
		ADULT
	}
	
	static{
		
		if(!WildSkript.randomSk()){
			
			/*
			Classes.registerClass(new ClassInfo(Age.class, "age").parser(new Parser<Age>(){
				public Age parse(String s, ParseContext pc) {
					if(s.equalsIgnoreCase("baby")) return Age.BABY;
					if(s.equalsIgnoreCase("adult")) return Age.ADULT;
					return null;
				}
				
				public String getVariableNamePattern() {
					return "age:";
				}
	
				public String toString(Age ac, int i) {
					return ac.name();
				}
	
				public String toVariableNameString(Age ac) {
					return "age:" + ac.name();
				}
				}).serializer(new Serializer<Age>(){
					public Fields serialize(Age age) throws NotSerializableException{
						Fields f = new Fields();
						f.putObject("age", age);
						return f;
					}
					
					public Age deserialize(Fields f) throws StreamCorruptedException, NotSerializableException {
						return (Age) f.getObject("age");
					}
	
					public Age deserialize(String s) {
						if(s.equalsIgnoreCase("age:baby")) return Age.BABY;
						if(s.equalsIgnoreCase("age:adult")) return Age.ADULT;
						return null;
					}
					
					public void deserialize(Age age, Fields f) throws StreamCorruptedException, NotSerializableException{
						return;
					}
					
					public boolean mustSyncDeserialization() {
						return true;
					}
	
					public boolean canBeInstantiated(Class<? extends Age> arg0) {
						return false;
					}
				}).changer(Changers.age));
			*/
		}
	}
}
