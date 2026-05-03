package Vaelior.lifeStealDuels.MapCommands;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GoToMapCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player && args[0] != null)
        {
            Player p = (Player) sender;
            if(p.isOp()) {
                Server s = p.getServer();
                World w = s.getWorld(args[0]);
                if (w != null) {
                    p.teleport(w.getSpawnLocation());
                    p.sendMessage(ChatColor.GREEN + "Teleported to world " + args[0]);
                } else {
                    p.sendMessage(ChatColor.RED + "Sorry that's already a world");
                }
            }
            else {
                p.sendMessage(ChatColor.RED + "Sorry but you must have Operator for this command");
            }

        }
        else{
            return false;
        }
        return(true);
    }
}
