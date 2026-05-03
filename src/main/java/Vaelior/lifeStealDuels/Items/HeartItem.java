package Vaelior.lifeStealDuels.Items;

import net.md_5.bungee.api.chat.hover.content.Item;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HeartItem
{
    private static ItemStack item;
    private static void checkItem()
    {
        if(item == null)
        {
            ItemStack heart = new ItemStack(Material.RED_DYE);
            ItemMeta heartMeta = heart.getItemMeta();
            heartMeta.setDisplayName(ChatColor.RED + "HEART");
            heart.setItemMeta(heartMeta);
            item = heart;
        }

    }
    public static ItemStack getItem(int amount)
    {
        checkItem();
        ItemStack throwaway = new ItemStack(item);
        throwaway.setAmount(amount);
        return(throwaway);
    }

}
