package Vaelior.lifeStealDuels.MapCommands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;

import java.util.Random;

//source https://www.spigotmc.org/threads/create-air-world.392858/
// didnt know how to generate blank worlds
class VoidGenerator extends ChunkGenerator
{
    @Override
    public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome)
    {
        ChunkData chunk = createChunkData(world);
        return chunk;
    }
}
public class CreateMapCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player && args[0] != null)
        {


            Player p = (Player) sender;
            if(p.isOp()) {
                String worldName = args[0];
                Server s = p.getServer();
                if (s.getWorld(worldName) == null) {
                    WorldCreator world = new WorldCreator(worldName);
                    world.type(WorldType.FLAT);
                    world.generator(new VoidGenerator());

                    s.createWorld(world);
                    p.sendMessage(ChatColor.GREEN + "World Created!");
                } else {
                    p.sendMessage(ChatColor.RED + "That's already a world!");
                }
            }
            else{
                p.sendMessage(ChatColor.RED + "Sorry but you must have Operator for this command");
            }





        }
        else
        {return false;}
        return true;
    }
}
