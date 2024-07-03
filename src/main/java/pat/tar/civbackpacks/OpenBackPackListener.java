package pat.tar.civbackpacks;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class OpenBackPackListener implements Listener {

    private final CivBackPacks plugin;

    public OpenBackPackListener(CivBackPacks plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onOpen(PlayerInteractEvent e){

        Player player = e.getPlayer();
        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
        Block clickedBlock = e.getClickedBlock();

        //If canPlaceShulkerBox is false in the config then the player can't shift place the shulker box. Reason why this exist is to give the admins of the server a choice whether or not they want the players to use shulker boxes as a building block.
        if (!(plugin.canPlaceShulkerBox()) && (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) && (itemInMainHand.getType().equals(Material.SHULKER_BOX) || itemInMainHand.getType().equals(Material.WHITE_SHULKER_BOX) || itemInMainHand.getType().equals(Material.ORANGE_SHULKER_BOX) || itemInMainHand.getType().equals(Material.MAGENTA_SHULKER_BOX) || itemInMainHand.getType().equals(Material.LIGHT_BLUE_SHULKER_BOX) || itemInMainHand.getType().equals(Material.YELLOW_SHULKER_BOX) || itemInMainHand.getType().equals(Material.LIME_SHULKER_BOX) || itemInMainHand.getType().equals(Material.PINK_SHULKER_BOX) || itemInMainHand.getType().equals(Material.GRAY_SHULKER_BOX) || itemInMainHand.getType().equals(Material.LIGHT_GRAY_SHULKER_BOX) || itemInMainHand.getType().equals(Material.CYAN_SHULKER_BOX) || itemInMainHand.getType().equals(Material.PURPLE_SHULKER_BOX) || itemInMainHand.getType().equals(Material.BLUE_SHULKER_BOX) || itemInMainHand.getType().equals(Material.BROWN_SHULKER_BOX) || itemInMainHand.getType().equals(Material.GREEN_SHULKER_BOX) || itemInMainHand.getType().equals(Material.RED_SHULKER_BOX) || itemInMainHand.getType().equals(Material.BLACK_SHULKER_BOX))){
            e.setCancelled(true);
            player.openInventory(player.getEnderChest());

        } else if (plugin.canPlaceShulkerBox() && !(player.isSneaking()) && (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) && (itemInMainHand.getType().equals(Material.SHULKER_BOX) || itemInMainHand.getType().equals(Material.WHITE_SHULKER_BOX) || itemInMainHand.getType().equals(Material.ORANGE_SHULKER_BOX) || itemInMainHand.getType().equals(Material.MAGENTA_SHULKER_BOX) || itemInMainHand.getType().equals(Material.LIGHT_BLUE_SHULKER_BOX) || itemInMainHand.getType().equals(Material.YELLOW_SHULKER_BOX) || itemInMainHand.getType().equals(Material.LIME_SHULKER_BOX) || itemInMainHand.getType().equals(Material.PINK_SHULKER_BOX) || itemInMainHand.getType().equals(Material.GRAY_SHULKER_BOX) || itemInMainHand.getType().equals(Material.LIGHT_GRAY_SHULKER_BOX) || itemInMainHand.getType().equals(Material.CYAN_SHULKER_BOX) || itemInMainHand.getType().equals(Material.PURPLE_SHULKER_BOX) || itemInMainHand.getType().equals(Material.BLUE_SHULKER_BOX) || itemInMainHand.getType().equals(Material.BROWN_SHULKER_BOX) || itemInMainHand.getType().equals(Material.GREEN_SHULKER_BOX) || itemInMainHand.getType().equals(Material.RED_SHULKER_BOX) || itemInMainHand.getType().equals(Material.BLACK_SHULKER_BOX))){
            e.setCancelled(true);
            player.openInventory(player.getEnderChest());

        }

        //prevents the player from opening a shulker box
        if (clickedBlock != null && e.getAction() == Action.RIGHT_CLICK_BLOCK && (clickedBlock.getType().equals(Material.SHULKER_BOX) || clickedBlock.getType().equals(Material.WHITE_SHULKER_BOX) || clickedBlock.getType().equals(Material.ORANGE_SHULKER_BOX) || clickedBlock.getType().equals(Material.MAGENTA_SHULKER_BOX) || clickedBlock.getType().equals(Material.LIGHT_BLUE_SHULKER_BOX) || clickedBlock.getType().equals(Material.YELLOW_SHULKER_BOX) || clickedBlock.getType().equals(Material.LIME_SHULKER_BOX) || clickedBlock.getType().equals(Material.PINK_SHULKER_BOX) || clickedBlock.getType().equals(Material.GRAY_SHULKER_BOX) || clickedBlock.getType().equals(Material.LIGHT_GRAY_SHULKER_BOX) || clickedBlock.getType().equals(Material.CYAN_SHULKER_BOX) || clickedBlock.getType().equals(Material.PURPLE_SHULKER_BOX) || clickedBlock.getType().equals(Material.BLUE_SHULKER_BOX) || clickedBlock.getType().equals(Material.BROWN_SHULKER_BOX) || clickedBlock.getType().equals(Material.GREEN_SHULKER_BOX) || clickedBlock.getType().equals(Material.RED_SHULKER_BOX) || clickedBlock.getType().equals(Material.BLACK_SHULKER_BOX))){
            e.setCancelled(true);

            //if canAccessEnderChestViaShulkerBlock is true in the config then this will allow player to open their backpack without it being in their inventory
            if (plugin.canAccessEnderChestViaShulkerBlock()) {
                player.openInventory(player.getEnderChest());
            }
        }
    }
}
