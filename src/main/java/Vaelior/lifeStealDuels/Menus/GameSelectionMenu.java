package Vaelior.lifeStealDuels.Menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GameSelectionMenu
{

    /*
    Want 2 items
    1 for duels mode and 1 for free for all.
    Free for all gamemode should go to the servers selected free for all gamemode.


    2 items:
    * Redstone dust (duels
    * Beacon (free for all)

    other ideas for items:
    * Nether star (free for all)
    * Recovery compass
     */
    private static ItemStack[] inventoryData;
    private static void checkData()
    {
        if (inventoryData == null)
        {
            //item slots 11 and 15
            inventoryData = new ItemStack[27];
            //creating display icons
            ItemStack duelMode = new ItemStack(Material.REDSTONE);
            ItemMeta duelModeMeta = duelMode.getItemMeta();
            duelModeMeta.setDisplayName(ChatColor.RED + "Duels Que");

            ItemStack freeForAllMode = new ItemStack(Material.NETHER_STAR);
            ItemMeta freeForAllModeMeta = freeForAllMode.getItemMeta();
            duelModeMeta.setDisplayName(ChatColor.BLUE + "Free For All");
            freeForAllMode.setItemMeta(freeForAllModeMeta);
            inventoryData[11] = duelMode;
            inventoryData[15] = freeForAllMode;
        }
    }
    public static void createMenu(Player p)
    {
        checkData();
        Inventory menu = Bukkit.createInventory(p, 27, "LifeSteal Game Selector");
        menu.setContents(inventoryData.clone());
        p.openInventory(menu);
    }
}
