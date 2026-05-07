package Vaelior.lifeStealDuels.GameModes;

import Vaelior.lifeStealDuels.LifeStealDuels;
import Vaelior.lifeStealDuels.Menus.KitSelectionMenu;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.ArrayList;

/*
Servers will be able to create world / their own maps. They can then register each world into
the map pool with something like /lsaddmap
This will then add that world into a available world array.
the duel gamemode can then use this map pool to put people into the maps.
 */
public class DuelGameMode {
    private static ArrayList<Player> playersInQue = new ArrayList<Player>();

    public void addPlayerToQue(Player p)
    {
        playersInQue.add(p);
    }
    public void removePlayerFromQue(Player p)
    {
        if(playersInQue.contains(p)) {
            playersInQue.remove(p);
        }
    }
    public int getPlayersInQue()
    {
        return playersInQue.size();
    }
    public boolean isPlayerInQue(Player p)
    {
        return (playersInQue.contains(p));
    }
}
class Duel
{
    public static int currentDuels;
    private int duelID;
    private Player p1;
    private Player p2;
    private World w;
    public Duel(Player p1, Player p2, World w)
    {
        this.p1 = p1;
        this.p2 = p2;
        this.w = w;
    }
    public void createMatch()
    {
        teleportPlayersToLocation();
        loadPlayerInventories();
        updateGameModes(GameMode.ADVENTURE);
    }
    public void countDownMatch()
    {
        p1.sendMessage(ChatColor.RED + "Organize your inventory!");
        p2.sendMessage(ChatColor.RED + "Organize your inventory!");
        new BukkitRunnable()
        {
            int count = 15;
            @Override
            public void run() {
                if(count <= 0)
                {
                    teleportPlayersToLocation();
                    updateGameModes(GameMode.SURVIVAL);

                    p1.sendMessage(ChatColor.RED + "FIGHT!");
                    p2.sendMessage(ChatColor.RED + "FIGHT!");

                    p1.playSound(p1.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1f, 1f);
                    p2.playSound(p2.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1f, 1f);
                    this.cancel();
                }
                else if (count <= 5){
                    p1.sendMessage(ChatColor.GOLD + "" + count);
                    p2.sendMessage(ChatColor.GOLD + "" + count);
                    count--;
                }

            }
        }.runTaskTimer(LifeStealDuels.getPlugin(), 0L, 20L);
    }
    public void teleportPlayersToLocation()
    {
        PersistentDataContainer worldsData = w.getPersistentDataContainer();
        worldsData.get(new NamespacedKey(LifeStealDuels.getPlugin(), "player1spawn"), PersistentDataType.STRING);
        String cords1 = worldsData.get(new NamespacedKey(LifeStealDuels.getPlugin(), "player1spawn"), PersistentDataType.STRING);

        String cords2 = worldsData.get(new NamespacedKey(LifeStealDuels.getPlugin(), "player2spawn"), PersistentDataType.STRING);

        String[] cords1Array = cords1.split("-");
        String[] cords2Array = cords2.split("-");

        Location spawn1 = new Location(w,  Double.parseDouble(cords1Array[0]), Double.parseDouble(cords1Array[1]), Double.parseDouble(cords1Array[2]));
        Location spawn2 = new Location(w,  Double.parseDouble(cords2Array[0]), Double.parseDouble(cords2Array[1]), Double.parseDouble(cords2Array[2]));

        p1.teleport(spawn1);
        p2.teleport(spawn2);
    }
    /*
    PreCondition:
    p1 and p2 have picked their desired kits (will be required in que command)
     */
    public void loadPlayerInventories()
    {
        int p1Int = KitSelectionMenu.getPlayerKitdataKitMenu(p1);
        int p2Int = KitSelectionMenu.getPlayerKitdataKitMenu(p2);

        KitSelectionMenu.loadKit(p1, p1Int);
        KitSelectionMenu.loadKit(p2, p2Int);
    }

    public void updateGameModes(GameMode game)
    {
        p1.setGameMode(game);
        p2.setGameMode(game);
    }



}