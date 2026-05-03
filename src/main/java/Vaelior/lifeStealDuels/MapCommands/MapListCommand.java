package Vaelior.lifeStealDuels.MapCommands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MapListCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player)
        {
            Player p = (Player) sender;
            if(p.isOp()) {
                Server s = p.getServer();
                for (World w : s.getWorlds()) {
                    p.sendMessage(ChatColor.YELLOW + "World: " + w.getName());
                }
            }
            else
            {
                p.sendMessage(org.bukkit.ChatColor.RED + "Sorry but you must have Operator for this command");
            }

        }
        return true;
    }
}
