package Vaelior.lifeStealDuels.Menus;

import Vaelior.lifeStealDuels.Items.HeartItem;
import Vaelior.lifeStealDuels.LifeStealDuels;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jspecify.annotations.Nullable;

public class KitSelectionMenu {
    private static ItemStack[] inventoryData;
    private static void checkData()
    {
        if(inventoryData == null)
        {
            inventoryData = new ItemStack[9];
            inventoryData[0] = HeartItem.getItem(5);
            inventoryData[4] = HeartItem.getItem(10);
            inventoryData[8] = HeartItem.getItem(15);
        }
    }
    public static void clearSideEffectsKitMenu(Inventory inv)
    {
        for(ItemStack i : inv.getContents())
        {
            if(i != null) {
                ItemMeta itemmeta = i.getItemMeta();
                itemmeta.setEnchantmentGlintOverride(null);
                itemmeta.setDisplayName(ChatColor.RED + "Heart");
                i.setItemMeta(itemmeta);
            }
        }
    }
    public static void setItemSelectedKitMenu(ItemStack item)
    {
        ItemMeta itemmeta = item.getItemMeta();
        itemmeta.setEnchantmentGlintOverride(true);
        itemmeta.setDisplayName(ChatColor.RED + "Heart " + ChatColor.GREEN + " Selected");
        item.setItemMeta(itemmeta);

    }
    public static void createMenu(Player p)
    {
        checkData();
        Inventory menu = Bukkit.createInventory(p, 9, "LifeSteal Kit Selector");
        menu.setContents(inventoryData);

        /*
        store kit as integer as kits go off the amount of hearts made
        5 = kit 1
        10 = kit 2
        15 = kit 3

        store type as integer.

         */
        PersistentDataContainer playerData = p.getPersistentDataContainer();
        if(playerData.has(new NamespacedKey(LifeStealDuels.getPlugin(), "lifestealkitselected"), PersistentDataType.INTEGER))
        {
            int kitNumber = getPlayerKitdataKitMenu(p);
            if(kitNumber == 5)
            {
                setItemSelectedKitMenu(menu.getItem(0));
            }
            else if(kitNumber == 10)
            {
                setItemSelectedKitMenu(menu.getItem(4));
            }
            else if(kitNumber == 15)
            {
                setItemSelectedKitMenu(menu.getItem(8));
            }
        }
        p.openInventory(menu);
    }
    public static void changeKitdataKitMenu(Player p, int i)
    {
        PersistentDataContainer playerData = p.getPersistentDataContainer();
        playerData.set(new NamespacedKey(LifeStealDuels.getPlugin(), "lifestealkitselected"), PersistentDataType.INTEGER, i);
    }
    @Nullable
    public static Integer getPlayerKitdataKitMenu(Player p)
    {
        int i;
        PersistentDataContainer playerData = p.getPersistentDataContainer();
        if(playerData.has(new NamespacedKey(LifeStealDuels.getPlugin(), "lifestealkitselected"), PersistentDataType.INTEGER))
        {
            i = playerData.get(new NamespacedKey(LifeStealDuels.getPlugin(), "lifestealkitselected"), PersistentDataType.INTEGER);
            return(i);
        }
        return null;


    }
}
