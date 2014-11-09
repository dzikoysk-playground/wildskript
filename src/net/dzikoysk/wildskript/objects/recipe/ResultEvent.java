package net.dzikoysk.wildskript.objects.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

public class ResultEvent implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event){
		if(event == null) return;
		if(event.getInventory() instanceof CraftingInventory){
			CraftingInventory ci = (CraftingInventory) event.getInventory();
			if(event.getSlotType() == InventoryType.SlotType.RESULT){
				if(event.getCurrentItem().getType() == null || event.getCurrentItem().getType() == Material.AIR) return;
				ItemStack result = ci.getResult();
				for(Recipes r : Recipes.list){
					if(r.getResult() == null || !r.getResult().equals(result)) continue;
					event.setCancelled(true);
					ItemStack[] req = r.getIngredients();
					for(int i = 0; i < 9; i++){
						if(req[i] != null) ci.setItem(i+1, null);
					}
					ClickType ct = event.getClick();
					if(ct == ClickType.SHIFT_LEFT || ct == ClickType.SHIFT_RIGHT){
						HumanEntity he = event.getWhoClicked();
						if(he.getInventory().firstEmpty() < 0){
							he.closeInventory();
							he.getWorld().dropItem(he.getEyeLocation(), result);
							break;
						}else{
							he.getInventory().addItem(result);
							break;
						}
					}
					event.getWhoClicked().setItemOnCursor(result);
					break;
				}
			}else if(event.getSlotType() == InventoryType.SlotType.CRAFTING){
				PrepareItemCraftEvent e = new PrepareItemCraftEvent(ci, event.getView(), true);
		        Bukkit.getServer().getPluginManager().callEvent(e);
			}
		}
	}
}
