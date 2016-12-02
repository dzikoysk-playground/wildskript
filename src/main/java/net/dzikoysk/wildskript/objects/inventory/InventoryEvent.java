package net.dzikoysk.wildskript.objects.inventory;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryEvent implements Listener {


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event == null) {
            return;
        }

        Inventory inventory = event.getInventory();
        if (inventory instanceof CraftingInventory) {
            return;
        }

        String name = inventory.getName();

        if (!Inventories.nameExists(name)) {
            return;
        }
        Inventories inv = Inventories.get(name);

        Player player = (Player) event.getWhoClicked();
        ItemStack clicked = event.getCurrentItem();
        int slot = event.getSlot() + 1;

        if (clicked == null) {
            return;
        }

        boolean cancelled = inv.getCancelled(slot);
        event.setCancelled(cancelled);

        boolean close = inv.getClosed(slot);
        if (close) {
            player.closeInventory();
        }

        String command = inv.getCommand(slot);
        String executor = inv.getExecutor(slot);

        if (!(command == null)) {
            if (executor != null && executor.equals("player")) {
                Bukkit.getServer().dispatchCommand(player, command);
            }
            else {
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), command);
            }
        }
    }
}



