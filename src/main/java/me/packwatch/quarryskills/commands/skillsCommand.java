package me.packwatch.quarryskills.commands;

import me.packwatch.quarryskills.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class skillsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player){

            Player p = (Player) commandSender;

            // p.playSound(Sound.BLOCK_CHEST_OPEN, 1);

            Inventory mainGui = Bukkit.createInventory(p, 27, ChatColor.DARK_GRAY + "Skills");

            ItemStack geology = new ItemStack(Material.CHISELED_DEEPSLATE, 1);
            ItemStack spelunker = new ItemStack(Material.SPYGLASS, 1);
            ItemStack demolitionist = new ItemStack(Material.CHIPPED_ANVIL, 1);


            ItemMeta geologyMeta = geology.getItemMeta();
            geologyMeta.setDisplayName(Utils.chat("&bGeology"));

            geology.setItemMeta(geologyMeta);

            ItemMeta spelunkerMeta = geology.getItemMeta();
            geologyMeta.setDisplayName(Utils.chat("&Spelunker"));

            geology.setItemMeta(spelunkerMeta);

            ItemMeta demolitionistMeta = geology.getItemMeta();
            geologyMeta.setDisplayName(Utils.chat("&Demolitionist"));

            geology.setItemMeta(demolitionistMeta);


            for(int i = 0; i < mainGui.getSize()-1; i++){
                mainGui.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
            }

            mainGui.setItem(11, geology);
            mainGui.setItem(13, spelunker);
            mainGui.setItem(15, demolitionist);


            p.openInventory(mainGui);
        }


        return true;
    }
}
