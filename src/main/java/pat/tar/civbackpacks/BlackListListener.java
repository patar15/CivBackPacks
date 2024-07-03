package pat.tar.civbackpacks;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class BlackListListener implements Listener {

    private final CivBackPacks plugin;

    public BlackListListener(CivBackPacks plugin) {
        this.plugin = plugin;
    }

    //Prevents a list of items from the config from going into the backpack
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        if (e.getInventory().getType() == InventoryType.ENDER_CHEST) {

            ItemStack item = e.getCurrentItem();
            if (item != null && plugin.getEnderChestBlacklist().contains(item.getType())) {
                e.setCancelled(true);
                e.getWhoClicked().sendMessage("This item is blacklisted from the Back Pack.");
            }
        }
    }

}
