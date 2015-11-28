package net.dzikoysk.wildskript.expressions;

import org.bukkit.entity.Ageable;
import org.bukkit.entity.Entity;

import net.dzikoysk.wildskript.classes.AgeClasses.Age;

import ch.njol.skript.expressions.base.SimplePropertyExpression;


public class ExprAge extends SimplePropertyExpression<Entity, Age>{
	
	@Override
	protected String getPropertyName() {
		return "age of %entity%";
	}

	@Override
	public Age convert(Entity e) {
		if(e instanceof Ageable){
			if(((Ageable) e).isAdult()){
				System.out.println("Adult");
				return Age.ADULT;
			}
			System.out.println("Baby");
			return Age.BABY;
		}
		System.out.println("Null");
		return null;
	}
	
	@Override
	public Class<? extends Age> getReturnType() {
		return Age.class;
	}

}


	

