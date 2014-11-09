package net.dzikoysk.wildskript.objects.inventory;

import net.dzikoysk.wildskript.objects.inventory.elements.EffDisplay;
import net.dzikoysk.wildskript.objects.inventory.elements.EffNew;
import net.dzikoysk.wildskript.objects.inventory.elements.EffRemoveCommand;
import net.dzikoysk.wildskript.objects.inventory.elements.EffRemoveExecutor;
import net.dzikoysk.wildskript.objects.inventory.elements.EffRemoveItem;
import net.dzikoysk.wildskript.objects.inventory.elements.EffRemoveLore;
import net.dzikoysk.wildskript.objects.inventory.elements.EffCancelled;
import net.dzikoysk.wildskript.objects.inventory.elements.EffClosed;
import net.dzikoysk.wildskript.objects.inventory.elements.EffCommand;
import net.dzikoysk.wildskript.objects.inventory.elements.EffExecutor;
import net.dzikoysk.wildskript.objects.inventory.elements.EffItem;
import net.dzikoysk.wildskript.objects.inventory.elements.EffLore;
import net.dzikoysk.wildskript.objects.inventory.elements.EffRow;
import net.dzikoysk.wildskript.objects.inventory.elements.EffUnregister;
import net.dzikoysk.wildskript.objects.inventory.elements.EffUpdate;
import net.dzikoysk.wildskript.objects.inventory.elements.ExprCancelled;
import net.dzikoysk.wildskript.objects.inventory.elements.ExprClosed;
import net.dzikoysk.wildskript.objects.inventory.elements.ExprCommand;
import net.dzikoysk.wildskript.objects.inventory.elements.ExprExecutor;
import net.dzikoysk.wildskript.objects.inventory.elements.ExprFirstEmpty;
import net.dzikoysk.wildskript.objects.inventory.elements.ExprItem;
import net.dzikoysk.wildskript.objects.inventory.elements.ExprLore;
import net.dzikoysk.wildskript.objects.inventory.elements.ExprName;
import net.dzikoysk.wildskript.objects.inventory.elements.ExprRow;
import net.dzikoysk.wildskript.register.RegisterManager;
import net.dzikoysk.wildskript.util.doc.Documentation;
import net.dzikoysk.wildskript.util.doc.Element;
import net.dzikoysk.wildskript.util.doc.Type;
import ch.njol.skript.aliases.ItemType;

public class InventoryElements {
	
	public static void register(){
		
		Documentation.addElement(new Element(Type.DESC)
		.object("Inventory")
		.name("Inventory")
		.desc("Allows you to create a virtual and customized by us for your needs inventory. It is almost everything! \n\n" +  
			  "Using the table of basic functions, we can create the simplest gui, executing commands after clicking on the item set by us. Expanded list of functions allows us already to manipulate every aspect of custom inv. The full list of functions contains all inventory's functions.")
		);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Inventory")
		.name("Initialize")
		.desc("# Initialize inventory")
		.example("new Invnetory [id];")
		.usage(new String[]{
			"new Inventory %string%[;]"	
		}), EffNew.class);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Inventory")
		.name("Row")
		.desc("# Set row")
		.example("[Object].setRow{[number]};")
		.usage(new String[]{
			"%string%.Inventory.setRow{%number%}[;]"
		}), EffRow.class);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Inventory")
		.name("Item")
		.desc("# Set item")
		.example("[Object].setItem{[number], [itemtype]};")
		.usage(new String[]{
			"%string%.Inventory.setItem{%number%,%itemtype%}[;]"
		}), EffItem.class);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Inventory")
		.name("Lore")
		.desc("# Set lore")
		.example("[Object].setLore{[number], [text]};")
		.usage(new String[]{
			"%string%.Inventory.setLore{%number%,%string%}[;]"
		}), EffLore.class);

		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Inventory")
		.name("Command")
		.desc("# Set command")
		.example("[Object].setCommand{[number], [text]};")
		.usage(new String[]{
			"%string%.Inventory.setCommand{%number%,%string%}[;]"
		}), EffCommand.class);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Inventory")
		.name("Executor")
		.desc("# Set executor")
		.example("[Object].setExecutor{[number], [text - ''player''/''console'']};")
		.usage(new String[]{
			"%string%.Inventory.setExecutor{%number%,%string%}[;]"
		}), EffExecutor.class);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Inventory")
		.name("Cancelled")
		.desc("# Set cancelled")
		.example("[Object].setCancelled{[number], [boolean]};")
		.usage(new String[]{
			"%string%.Inventory.setCommand{%number%,%boolean%}[;]"
		}), EffCancelled.class);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Inventory")
		.name("Closed")
		.desc("# Set closed")
		.example("[Object].setCommand{[number], [boolean]};")
		.usage(new String[]{
			"%string%.Inventory.setClosed{%number%,%boolean%}[;]"
		}), EffClosed.class);

		// Do [...]
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Inventory")
		.name("Display")
		.desc("# Display inventory for player")
		.example("[Object].display{[player]};")
		.usage(new String[]{
			"%string%.Inventory.display{%player%}[;]"
		}), EffDisplay.class);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Inventory")
		.name("Update")
		.desc("# Update inventory object")
		.example("[Object].update{};")
		.usage(new String[]{
			"%string%.Inventory.update{}[;]"
		}), EffUpdate.class);

		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Inventory")
		.name("Unregister")
		.desc("# Unregister inventory")
		.example("[Object].unregister{};")
		.usage(new String[]{
			"%string%.Inventory.unregister{}[;]"
		}), EffUnregister.class);
		
		// Remove
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Inventory")
		.name("Remove Item")
		.desc("# Remove item from the slot")
		.example("[Object].removeItem{[number]};")
		.usage(new String[]{
			"%string%.Inventory.removeItem{%number%}[;]"
		}), EffRemoveItem.class);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Inventory")
		.name("Remove Lore")
		.desc("# Remove lore from the slot")
		.example("[Object].removeLore{[number]};")
		.usage(new String[]{
			"%string%.Inventory.removeLore{%number%}[;]"
		}), EffRemoveLore.class);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Inventory")
		.name("Remove Command")
		.desc("# Remove command from the slot")
		.example("[Object].removeCommand{[number]};")
		.usage(new String[]{
			"%string%.Inventory.removeCommand{%number%}[;]"
		}), EffRemoveCommand.class);
		
		RegisterManager.registerEffect(new Element(Type.OBJECT)
		.object("Inventory")
		.name("Remove Executor")
		.desc("# Remove executor from the slot")
		.example("[Object].removeExecutor{[number]};")
		.usage(new String[]{
			"%string%.Inventory.removeExecutor{%number%}[;]"
		}), EffRemoveExecutor.class);
	
		RegisterManager.registerExpression(new Element(Type.OBJECT)
		.object("Inventory")
		.name("Get Name")
		.desc("# Get name")
		.example("[Object].getName{};")
		.usage(new String[]{
			"%string%.Inventory.getName{}[;]"
		})
		, ExprName.class, String.class);
		
		RegisterManager.registerExpression(new Element(Type.OBJECT)
		.object("Inventory")
		.name("Get Row")
		.desc("# Get row")
		.example("[Object].getRow{};")
		.usage(new String[]{
			"%string%.Inventory.getRow{}[;]"
		})
		, ExprRow.class, Integer.class);
		
		RegisterManager.registerExpression(new Element(Type.OBJECT)
		.object("Inventory")
		.name("Get Item")
		.desc("# Get item by slot")
		.example("[Object].getItem{[number]};")
		.usage(new String[]{
			"%string%.Inventory.getItem{%number%}[;]"
		})
		, ExprItem.class, ItemType.class);
		
		RegisterManager.registerExpression(new Element(Type.OBJECT)
		.object("Inventory")
		.name("Get Lore")
		.desc("# Get lore by slot")
		.example("[Object].getLore{[number]};")
		.usage(new String[]{
			"%string%.Inventory.getLore{%number%}[;]"
		})
		, ExprLore.class, String.class);
		
		RegisterManager.registerExpression(new Element(Type.OBJECT)
		.object("Inventory")
		.name("Get Command")
		.desc("# Get command by slot")
		.example("[Object].getCommand{[number]};")
		.usage(new String[]{
			"%string%.Inventory.getCommand{%number%}[;]"
		})
		, ExprCommand.class, String.class);
		
		RegisterManager.registerExpression(new Element(Type.OBJECT)
		.object("Inventory")
		.name("Get Cancelled")
		.desc("# Get cancelled by slot")
		.example("[Object].getCancelled{[number]};")
		.usage(new String[]{
			"%string%.Inventory.getCancelled{%number%}[;]"
		})
		, ExprCancelled.class, Boolean.class);
		
		RegisterManager.registerExpression(new Element(Type.OBJECT)
		.object("Inventory")
		.name("Get Executor")
		.desc("# Get executor by slot")
		.example("[Object].getExecutor{[number]};")
		.usage(new String[]{
			"%string%.Inventory.getExecutor{%number%}[;]"
		})
		, ExprExecutor.class, String.class);
		
		RegisterManager.registerExpression(new Element(Type.OBJECT)
		.object("Inventory")
		.name("Get Closed")
		.desc("# Get closed by slot")
		.example("[Object].getCloased{[number]};")
		.usage(new String[]{
			"%string%.Inventory.getClosed{%number%}[;]"
		})
		, ExprClosed.class, Boolean.class);
		
		RegisterManager.registerExpression(new Element(Type.OBJECT)
		.object("Inventory")
		.name("First Empty")
		.desc("# Get first empty slot")
		.example("[Object].getFirstEmpty{};")
		.usage(new String[]{
			"%string%.Inventory.getFirstEmpty{}[;]"
		})
		, ExprFirstEmpty.class, Integer.class);
	}
}
