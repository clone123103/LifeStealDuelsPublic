package Vaelior.lifeStealDuels.Listeners;


import Vaelior.lifeStealDuels.Menus.KitSelectionMenu;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;


public class InventoryClickListener implements Listener {



    @EventHandler
    public void onInventoryClick(InventoryClickEvent event)
    {
        //kit selection menu
        if(event.getView().getTitle().equalsIgnoreCase("lifesteal kit selector"))
        {
            event.setCancelled(true);
            try {
                Player p = (Player) event.getWhoClicked();
                int amountItem;
                if (event.getCurrentItem().getAmount() == 5 && event.getCurrentItem().getType().equals(Material.RED_DYE)) {
                    amountItem = event.getCurrentItem().getAmount();
                    KitSelectionMenu.clearSideEffectsKitMenu(event.getClickedInventory());
                    KitSelectionMenu.setItemSelectedKitMenu(event.getCurrentItem());
                    KitSelectionMenu.changeKitdataKitMenu(p, amountItem);

                } else if (event.getCurrentItem().getAmount() == 10 && event.getCurrentItem().getType().equals(Material.RED_DYE)) {
                    amountItem = event.getCurrentItem().getAmount();
                    KitSelectionMenu.clearSideEffectsKitMenu(event.getClickedInventory());
                    KitSelectionMenu.setItemSelectedKitMenu(event.getCurrentItem());
                    KitSelectionMenu.changeKitdataKitMenu(p, amountItem);
                } else if (event.getCurrentItem().getAmount() == 15 && event.getCurrentItem().getType().equals(Material.RED_DYE)) {
                    amountItem = event.getCurrentItem().getAmount();
                    KitSelectionMenu.clearSideEffectsKitMenu(event.getClickedInventory());
                    KitSelectionMenu.setItemSelectedKitMenu(event.getCurrentItem());
                    KitSelectionMenu.changeKitdataKitMenu(p, amountItem);
                }
            }
            catch (Exception e)
            {

            }
        }
    }
}
