package me.packwatch.quarryskills.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SkillsGeologyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p;
        if(commandSender instanceof Player){
             p = (Player) commandSender;
        }else{
            return true;
        }




        return true;
    }

}
