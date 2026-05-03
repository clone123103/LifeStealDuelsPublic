package Vaelior.lifeStealDuels;

import Vaelior.lifeStealDuels.Commands.KitSelectorCommand;
import Vaelior.lifeStealDuels.Listeners.InventoryClickListener;
import Vaelior.lifeStealDuels.MapCommands.CreateMapCommand;
import Vaelior.lifeStealDuels.MapCommands.GoToMapCommand;
import Vaelior.lifeStealDuels.MapCommands.MapListCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class LifeStealDuels extends JavaPlugin {
    private static LifeStealDuels plugin;

    public static LifeStealDuels getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        //listener
        getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);

        //map commands
        getCommand("lsgetmaps").setExecutor(new MapListCommand());
        getCommand("lstelemap").setExecutor(new GoToMapCommand());
        getCommand("lscreatemap").setExecutor(new CreateMapCommand());


        //commands
        getCommand("lskit").setExecutor(new KitSelectorCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
