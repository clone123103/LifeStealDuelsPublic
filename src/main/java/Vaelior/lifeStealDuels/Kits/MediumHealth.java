package Vaelior.lifeStealDuels.Kits;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionType;
public class MediumHealth {
    private static final double health = 20.0;

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
            speedPotionMeta.setBasePotionType(PotionType.SWIFTNESS);
            speedPotion.setItemMeta(speedPotionMeta);
            ItemStack strengthPotion = new ItemStack(Material.SPLASH_POTION);
            PotionMeta strengthPotionMeta = (PotionMeta) strengthPotion.getItemMeta();
            strengthPotionMeta.setBasePotionType(PotionType.STRENGTH);
            strengthPotion.setItemMeta(strengthPotionMeta);

            ItemStack[] inv = new ItemStack[36];
            inv[0] = new ItemStack(Material.DIAMOND_SWORD);
            inv[1] = new ItemStack(Material.IRON_AXE);
            inv[2] = new ItemStack(Material.GOLDEN_APPLE, 16);
            inv[3] = new ItemStack(Material.OAK_LOG, 32);
            inv[4] = new ItemStack(Material.LAVA_BUCKET);
            inv[5] = new ItemStack(Material.WATER_BUCKET);
            inv[6] = new ItemStack(Material.CROSSBOW);
            inv[7] = new ItemStack(Material.COBWEB, 16);
            inv[8] = new ItemStack(Material.SHIELD);
            inv[27] = new ItemStack(Material.OAK_DOOR, 32);
            inv[28] = new ItemStack(Material.WIND_CHARGE, 16);
            inv[29] = strengthPotion;
            inv[30] = strengthPotion;
            inv[31] = new ItemStack(Material.LAVA_BUCKET);
            inv[32] = new ItemStack(Material.WATER_BUCKET);
            inv[33] = speedPotion;
            inv[34] = speedPotion;
            inv[35] = new ItemStack(Material.FLINT_AND_STEEL);
            inv[18] = new ItemStack(Material.COOKED_BEEF, 32);
            inv[19] = strengthPotion;
            inv[20] = strengthPotion;
            inv[21] = strengthPotion;
            inv[22] = new ItemStack(Material.LAVA_BUCKET);
            inv[23] = new ItemStack(Material.WATER_BUCKET);
            inv[24] = speedPotion;
            inv[25] = speedPotion;
            inv[26] = speedPotion;
            inv[16] = new ItemStack(Material.TNT, 8);
            inv[17] = new ItemStack(Material.ARROW, 32);

            playerInv.setContents(inv);
            playerInv.setHelmet(new ItemStack(Material.DIAMOND_HELMET));
            playerInv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
            playerInv.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
            playerInv.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
            playerInv.setItemInOffHand(new ItemStack(Material.SHIELD));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}