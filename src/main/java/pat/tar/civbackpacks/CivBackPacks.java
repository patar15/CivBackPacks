package pat.tar.civbackpacks;



import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class CivBackPacks extends JavaPlugin {

    private boolean canPlaceShulkerBox;
    private boolean canAccessEnderChestViaShulkerBlock;
    private Set<Material> enderChestBlacklist;


    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        loadConfig();


        this.getServer().getPluginManager().registerEvents(new OpenBackPackListener(this),this);
        this.getServer().getPluginManager().registerEvents(new DropBackPackListener(),this);
        this.getServer().getPluginManager().registerEvents(new BlackListListener(this),this);
    }

    private void loadConfig() {
        FileConfiguration config = getConfig();

        canPlaceShulkerBox = config.getBoolean("can_place_shulker_box", true);
        canAccessEnderChestViaShulkerBlock = config.getBoolean("can_access_ender_chest_via_shulker_block", true);
        List<String> blacklist = config.getStringList("ender_chest_blacklist");

        //loads the blacklist from the config
        enderChestBlacklist = new HashSet<>();
        for (String item : blacklist) {
            try {
                enderChestBlacklist.add(Material.valueOf(item.toUpperCase()));
            } catch (IllegalArgumentException e) {
                getLogger().warning("Invalid material in ender_chest_blacklist: " + item);
            }
        }
    }

    public boolean canPlaceShulkerBox() {
        return canPlaceShulkerBox;
    }

    public boolean canAccessEnderChestViaShulkerBlock() {
        return canAccessEnderChestViaShulkerBlock;
    }

    public Set<Material> getEnderChestBlacklist() {
        return enderChestBlacklist;
    }
}
