package Vaelior.lifeStealDuels.Kits;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionType;
//Not being developed
public class SuperHealth {
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
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
