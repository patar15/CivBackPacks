package pat.tar.civbackpacks;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class DropBackPackListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e){

        Player player = e.getPlayer();
        Inventory enderChest = player.getEnderChest();

        // Drop the items of the player's enderchest at their death location
        for (ItemStack item : enderChest.getContents()) {
            if (item != null) {
                player.getWorld().dropItemNaturally(player.getLocation(), item);
            }
        }

        enderChest.clear();

    }

}
