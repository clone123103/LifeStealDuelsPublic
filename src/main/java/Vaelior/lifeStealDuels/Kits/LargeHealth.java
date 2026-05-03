package Vaelior.lifeStealDuels.Kits;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionType;

public class LargeHealth {
    private static final double health = 30.0;

    public static boolean loadKit(Player p) {


        return setPlayerHealth(p) && setPlayerInventory(p);


    }

    private static boolean setPlayerHealth(Player p) {
        try {
            AttributeInstance maxHealthAttr = p.getAttribute(Attribute.MAX_HEALTH);
            if (maxHealthAttr != null) {
                maxHealthAttr.setBaseValue(health);
                p.setHealth(Math.min(p.getHealth(), maxHealthAttr.getBaseValue()));

            }
            return (true);
        } catch (Exception e) {
            return (false);
        }
    }

    private static boolean setPlayerInventory(Player p) {
        try {
            PlayerInventory playerInv = p.getInventory();

            playerInv.clear();
            ItemStack speedPotion = new ItemStack(Material.SPLASH_POTION);
            PotionMeta speedPotionMeta = (PotionMeta) speedPotion.getItemMeta();
            speedPotionMeta.setBasePotionType(PotionType.STRONG_SWIFTNESS);
            speedPotion.setItemMeta(speedPotionMeta);
            ItemStack strengthPotion = new ItemStack(Material.SPLASH_POTION);
            PotionMeta strengthPotionMeta = (PotionMeta) strengthPotion.getItemMeta();
            strengthPotionMeta.setBasePotionType(PotionType.STRONG_STRENGTH);
            strengthPotion.setItemMeta(strengthPotionMeta);

            ItemStack[] inv = new ItemStack[36];
            inv[0] = new ItemStack(Material.IRON_SWORD);
            inv[1] = new ItemStack(Material.IRON_AXE);
            inv[2] = new ItemStack(Material.GOLDEN_APPLE, 8);
            inv[3] = new ItemStack(Material.OAK_LOG, 48);
            inv[4] = new ItemStack(Material.LAVA_BUCKET);
            inv[5] = new ItemStack(Material.WATER_BUCKET);
            inv[6] = new ItemStack(Material.FLINT_AND_STEEL);
            inv[7] = new ItemStack(Material.COBWEB, 8);
            inv[8] = new ItemStack(Material.BOW);
            inv[27] = new ItemStack(Material.STONE_SWORD);
            inv[28] = strengthPotion;
            inv[29] = strengthPotion;
            inv[30] = strengthPotion;
            inv[31] = new ItemStack(Material.LAVA_BUCKET);
            inv[32] = new ItemStack(Material.WATER_BUCKET);
            inv[33] = speedPotion;
            inv[34] = speedPotion;
            inv[35] = speedPotion;
            inv[18] = new ItemStack(Material.COBBLESTONE, 24);
            inv[19] = strengthPotion;
            inv[24] = new ItemStack(Material.BUCKET, 2);
            inv[25] = speedPotion;
            inv[26] = new ItemStack(Material.TNT, 4);
            inv[16] = new ItemStack(Material.COOKED_BEEF, 16);
            inv[17] = new ItemStack(Material.ARROW, 16);
            playerInv.setContents(inv);
            playerInv.setHelmet(new ItemStack(Material.DIAMOND_HELMET));
            playerInv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
            playerInv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
            playerInv.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
            playerInv.setItemInOffHand(new ItemStack(Material.SHIELD));
            return true;

        }catch (Exception e)
        {
            return false;
        }

    }
}
