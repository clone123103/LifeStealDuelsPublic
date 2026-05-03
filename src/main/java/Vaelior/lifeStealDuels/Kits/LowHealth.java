package Vaelior.lifeStealDuels.Kits;


import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import org.bukkit.inventory.meta.PotionMeta;


import org.bukkit.potion.PotionType;

public class LowHealth {
    private static final double health = 10.0;
    public static boolean loadKit(Player p)
    {


        return setPlayerHealth(p) && setPlayerInventory(p);


    }
    private static boolean setPlayerHealth(Player p)
    {
        try {
            AttributeInstance maxHealthAttr = p.getAttribute(Attribute.MAX_HEALTH);
            if (maxHealthAttr != null) {
                maxHealthAttr.setBaseValue(health);
                p.setHealth(Math.min(p.getHealth(), maxHealthAttr.getBaseValue()));

            }
            return (true);
        }
        catch (Exception e)
        {
           return(false);
        }
    }
    private static boolean setPlayerInventory(Player p)
    {
        try {
            PlayerInventory playerInv = p.getInventory();

            playerInv.clear();
            ItemStack harmingPotion = new ItemStack(Material.SPLASH_POTION);
            PotionMeta harmPotionMeta = (PotionMeta) harmingPotion.getItemMeta();
            harmPotionMeta.setBasePotionType(PotionType.HARMING);
            harmingPotion.setItemMeta(harmPotionMeta);
            ItemStack healingPotion = new ItemStack(Material.SPLASH_POTION);
            PotionMeta healPotionMeta = (PotionMeta) healingPotion.getItemMeta();
            healPotionMeta.setBasePotionType(PotionType.STRONG_HEALING);
            healingPotion.setItemMeta(healPotionMeta);



            //
            ItemStack[] inv = new ItemStack[36];
            inv[0] = new ItemStack(Material.DIAMOND_SWORD);
            inv[1] = new ItemStack(Material.DIAMOND_AXE);
            inv[2] = new ItemStack(Material.GOLDEN_APPLE, 16);
            inv[3] = new ItemStack(Material.OAK_LOG, 24);
            inv[4] = new ItemStack(Material.LAVA_BUCKET);
            inv[5] = new ItemStack(Material.WATER_BUCKET);
            inv[6] = new ItemStack(Material.CROSSBOW);
            inv[7] = new ItemStack(Material.COBWEB, 16);
            inv[8] = new ItemStack(Material.ENDER_PEARL, 6);
            inv[27] = new ItemStack(Material.TNT_MINECART);
            inv[28] = new ItemStack(Material.RAIL, 16);
            inv[29] = harmingPotion;
            inv[30] = harmingPotion;
            inv[31] = new ItemStack(Material.LAVA_BUCKET);
            inv[32] = new ItemStack(Material.WATER_BUCKET);
            inv[33] = healingPotion;
            inv[34] = healingPotion;
            inv[35] = healingPotion;
            inv[18] = new ItemStack(Material.TNT_MINECART);
            inv[19] = new ItemStack(Material.TNT_MINECART);
            inv[20] = harmingPotion;
            inv[21] = harmingPotion;
            inv[22] = harmingPotion;
            inv[23] = healingPotion;
            inv[24] = healingPotion;
            inv[25] = healingPotion;
            inv[26] = healingPotion;
            inv[9] = new ItemStack(Material.FLINT_AND_STEEL);
            inv[10] = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
            inv[15] = new ItemStack(Material.COOKED_BEEF, 32);
            inv[16] = new ItemStack(Material.ARROW, 32);
            inv[17] = new ItemStack(Material.SHIELD);

            playerInv.setContents(inv);

            playerInv.setHelmet(new ItemStack(Material.DIAMOND_HELMET));
            playerInv.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
            playerInv.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
            playerInv.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
            playerInv.setItemInOffHand(new ItemStack(Material.SHIELD));

            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
}
