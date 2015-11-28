package net.dzikoysk.wildskript.objects.recipe;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

public class RecipesEvent implements Listener {

    @EventHandler
    public void onPrepareItemCraft(PrepareItemCraftEvent event) {
        CraftingInventory ci = event.getInventory();
        for (Recipes recipe : Recipes.list) {
            if (!recipe.isRegistered()) continue;
            if (!recipe.getResult().equals(ci.getResult())) continue;
            ItemStack[] in = ci.getMatrix();
            ItemStack[] req = recipe.getIngredients();
            boolean bad = false;
            for (int i = 0; i < 9; i++) {
                if (in[i] == null && req[i] == null) {
                    continue;
                } else if (req[i] == null) {
                    if (in[i].getType() == Material.AIR) continue;
                } else if (in[i].equals(req[i])) continue;
                bad = true;
                break;
            }
            if (bad) ci.setResult(null);
            break;
        }
    }
}
