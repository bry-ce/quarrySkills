package me.packwatch.quarryskills.commands;

import me.packwatch.quarryskills.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;


public class ReloadCommand implements CommandExecutor {
    final Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("quarrySkills");
    FileConfiguration configuration = plugin.getConfig();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {
        Player p = (Player) sender;
        if (!(sender instanceof Player)){
            System.out.println("must be player to reload");
            return true;
        }
        if (command.getLabel().equalsIgnoreCase("quarrySkills")) {

            if (strings.length == 1 && strings[0].equalsIgnoreCase("reload")) {

                if (sender.hasPermission("Permissions.Reload-Command")){

                    p.sendMessage(Utils.chat("&aquarrySkills reload complete."));
                }

            }
        }


        return true;
    }
}
