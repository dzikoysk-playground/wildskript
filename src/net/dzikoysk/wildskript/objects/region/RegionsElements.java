package net.dzikoysk.wildskript.objects.region;

import org.bukkit.Location;
import org.bukkit.World;

import net.dzikoysk.wildskript.objects.region.elements.CondExists;
import net.dzikoysk.wildskript.objects.region.elements.CondIsIn;
import net.dzikoysk.wildskript.objects.region.elements.CondIsInID;
import net.dzikoysk.wildskript.objects.region.elements.EffDelete;
import net.dzikoysk.wildskript.objects.region.elements.EffHeight;
import net.dzikoysk.wildskript.objects.region.elements.EffNew;
import net.dzikoysk.wildskript.objects.region.elements.EffRestore;
import net.dzikoysk.wildskript.objects.region.elements.EffSelectLL;
import net.dzikoysk.wildskript.objects.region.elements.EffSelectLS;
import net.dzikoysk.wildskript.objects.region.elements.EffCenter;
import net.dzikoysk.wildskript.objects.region.elements.EffL;
import net.dzikoysk.wildskript.objects.region.elements.EffP;
import net.dzikoysk.wildskript.objects.region.elements.EffSize;
import net.dzikoysk.wildskript.objects.region.elements.EffWorld;
import net.dzikoysk.wildskript.objects.region.elements.ExprCenter;
import net.dzikoysk.wildskript.objects.region.elements.ExprHeight;
import net.dzikoysk.wildskript.objects.region.elements.ExprL;
import net.dzikoysk.wildskript.objects.region.elements.ExprName;
import net.dzikoysk.wildskript.objects.region.elements.ExprP;
import net.dzikoysk.wildskript.objects.region.elements.ExprRegion;
import net.dzikoysk.wildskript.objects.region.elements.ExprRegionAt;
import net.dzikoysk.wildskript.objects.region.elements.ExprSize;
import net.dzikoysk.wildskript.objects.region.elements.ExprWorld;
import net.dzikoysk.wildskript.register.RegisterManager;
import net.dzikoysk.wildskript.util.doc.Documentation;
import net.dzikoysk.wildskript.util.doc.Element;
import net.dzikoysk.wildskript.util.doc.Type;

public class RegionsElements {
	
	public static void register(){
		
		Documentation.addElement(new Element(Type.DESC)
		.object("Regions")
		.name("Regions")
		.desc("Allows you to create regions. They aren't securing it themselves, but they're offering their defining and some useful tools.\n\n"
				+ "Using list of functions we can create and define the simplest possible region (They are 2 methods), and then check if given point is situated in it. Extended list of functions offers greater amount of available possibilities, which for sure will be useful in advanced projects. Full list of functions excepting aforementioned functions, has also these, which are rarely used.. "
		)
		);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Regions")
		.name("Initialize")
		.desc("# Initialize region")
		.example("new Region [id];")
		.usage(new String[]{
			"new Region %string%[;]"
		}), EffNew.class);

		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Regions")
		.name("Select LL")
		.desc("# Define region, type 1 - Define your region using 2 locations")
		.example("[Object].selectLL{[loc], [loc]};")
		.usage(new String[]{
			"%string%.Region.selectLL{%location%,%location%}[;]"
		}), EffSelectLL.class);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Regions")
		.name("Select LS")
		.desc("# Define region, type 2 - Define your region using 1 location (centre) and size")
		.example("[Object].selectLS{[loc], [number]}[;]")
		.usage(new String[]{
			"%string%.Region.selectLS{%location%,%number%}[;]"
		}), EffSelectLS.class);	
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Regions")
		.name("L")
		.desc("# Set pos 1")
		.example("[Object].getL{[location]};")
		.usage(new String[]{
			"%string%.Region.setL{%location%}[;]"
		}), EffL.class);	
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Regions")
		.name("P")
		.desc("# Set pos 2")
		.example("[Object].setP{[location]};")
		.usage(new String[]{
			"%string%.Region.setP{%location%}[;]"
		}), EffP.class);	
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Regions")
		.name("Center")
		.desc("# Set center")
		.example("[Object].setCenter{[location]};")
		.usage(new String[]{
			"%string%.Region.setCenter{%location%}[;]"
		}), EffCenter.class);	
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Regions")
		.name("Size")
		.desc("# Set size")
		.example("[Object].setSize{[number]};")
		.usage(new String[]{
			"%string%.Region.setSize{%number%}[;]"
		}), EffSize.class);	
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Regions")
		.name("Height")
		.desc("# Set height")
		.example("[Object].setHeight{[number]};")
		.usage(new String[]{
			"%string%.Region.setHeight{%number%}[;]"
		}), EffHeight.class);	
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Regions")
		.name("World")
		.desc("# Set world")
		.example("[Object].setWorld{[world]};")
		.usage(new String[]{
			"%string%.Region.setWorld{%world%}[;]"
		}), EffWorld.class);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Regions")
		.name("Restore")
		.desc("# Restore region from region variable")
		.example("[Object].restore{[region]};")
		.usage(new String[]{
			"%string%.Region.restore{%regions%}[;]"
		}), EffRestore.class);	
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Regions")
		.name("Delete")
		.desc("# Delete region")
		.example("[Object].delete{};")
		.usage(new String[]{
			"%string%.Region.delete{}[;]"
		}), EffDelete.class);	
	
		
		// Cond 
		
		
		RegisterManager.registerCondition(new Element(Type.OBJECT)
		.object("Regions")
		.name("Is In ID")
		.desc("# Checks whether the location is in region")
		.example("if [location] is in region [id]")
		.usage(new String[]{
			"%location% is in region %string%",
			"%location% (isn't|is not) in region %string%"
		})
		, CondIsInID.class);
		
		RegisterManager.registerCondition(new Element(Type.OBJECT)
		.object("Regions")
		.name("Is In")
		.desc("# Checks whether the location is in any region")
		.example("if [location] is in any region")
		.usage(new String[]{
			"%location% is in any region",
			"%location% (isn't|is not) in any region"
		})
		, CondIsIn.class);
		
		RegisterManager.registerCondition(new Element(Type.OBJECT)
		.object("Regions")
		.name("Exists")
		.desc("# Checks whether the region is exists")
		.example("if region [id] is exists")
		.usage(new String[]{
			"region %string% is exists",
			"region %string% (does not|doesn't|is not|isn't) exists"
		})
		, CondExists.class);
	
		// Expr
		
		RegisterManager.registerExpression(new Element(Type.OBJECT)
		.object("Regions")
		.name("Get At")
		.desc("# Get region at location")
		.example("Region.getAt{[location]}[;]")
		.usage(new String[]{
			"Region.getAt{%location%}[;]"
		})
		, ExprRegionAt.class, String.class);

		RegisterManager.registerExpression(new Element(Type.OBJECT)
		.object("Regions")
		.name("Region")
		.desc("# Get region")
		.example("region [id]")
		.usage(new String[]{
			"region %string%"
		})
		, ExprRegion.class, Regions.class);

		RegisterManager.registerExpression(new Element(Type.OBJECT)
		.object("Regions")
		.name("Get Name")
		.desc("# Get name")
		.example("[Object].getName{};")
		.usage(new String[]{
			"%string%.Region.getName{}[;]"
		})
		, ExprName.class, String.class);
		
		RegisterManager.registerExpression(new Element(Type.OBJECT)
		.object("Regions")
		.name("Get Name")
		.desc("# Get center")
		.example("[Object].getCenter{};")
		.usage(new String[]{
			"%string%.Region.getCenter{}[;]"
		})
		, ExprCenter.class, Location.class);
		
		RegisterManager.registerExpression(new Element(Type.OBJECT)
		.object("Regions")
		.name("Get L")
		.desc("# Get pos 1")
		.example("[Object].getL{};")
		.usage(new String[]{
			"%string%.Region.getL{}[;]"
		})
		, ExprL.class, Location.class);
		
		RegisterManager.registerExpression(new Element(Type.OBJECT)
		.object("Regions")
		.name("Get P")
		.desc("# Get pos 2")
		.example("[Object].getP{};")
		.usage(new String[]{
			"%string%.Region.getP{}[;]"
		})
		, ExprP.class, Location.class);

		RegisterManager.registerExpression(new Element(Type.OBJECT)
		.object("Regions")
		.name("Get Size")
		.desc("# Get size")
		.example("[Object].getSize{};")
		.usage(new String[]{
			"%string%.Region.getSize{}[;]"
		})
		, ExprSize.class, Integer.class);
		
		RegisterManager.registerExpression(new Element(Type.OBJECT)
		.object("Regions")
		.name("Get height")
		.desc("# Get height")
		.example("[Object].getHeight{};")
		.usage(new String[]{
			"%string%.Region.getHeight{}[;]"
		})
		, ExprHeight.class, Integer.class);
		
		RegisterManager.registerExpression(new Element(Type.OBJECT)
		.object("Regions")
		.name("Get world")
		.desc("# Get world")
		.example("[Object].getWorld{};")
		.usage(new String[]{
			"%string%.Region.getWorld{}[;]"
		})
		, ExprWorld.class, World.class);
	}

}
