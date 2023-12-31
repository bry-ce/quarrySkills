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
import sun.nio.ch.Util;

import java.util.ArrayList;

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
            ArrayList<String> geologyLore = new ArrayList<>();
            geologyLore.add(Utils.chat(""));
            geologyLore.add(Utils.chat("&7The geology skill increases your &6Fortune&7!"));
            geologyLore.add(Utils.chat("&7Progress: &f%geoprogress%"));
            geologyLore.add(Utils.chat("&7Your current bonus: &6%fortune%"));
            geologyLore.add(Utils.chat("&7next bonus: &6%(fortune + .1)%"));
            geologyLore.add(Utils.chat(""));

            geologyMeta.setLore(geologyLore);
            geology.setItemMeta(geologyMeta);

            ItemMeta spelunkerMeta = spelunker.getItemMeta();

            ArrayList<String> spelunkerLore = new ArrayList<>();
            spelunkerLore.add(Utils.chat(""));
            spelunkerLore.add(Utils.chat("&7The spelunker skill increases your &btreasure find&7!"));
            spelunkerLore.add(Utils.chat("&7Progress: &f%spelprogress%"));
            spelunkerLore.add(Utils.chat("&7Your current bonus: &6%treasurefind%"));
            spelunkerLore.add(Utils.chat("&7next bonus: &6%(treasurefind + .05)%"));
            spelunkerLore.add(Utils.chat(""));

            spelunkerMeta.setDisplayName(Utils.chat("&bSpelunker"));
            spelunkerMeta.setLore(spelunkerLore);
            spelunker.setItemMeta(spelunkerMeta);

            ItemMeta demolitionistMeta = demolitionist.getItemMeta();

            ArrayList<String> demoLitionistLore = new ArrayList<>();
            demoLitionistLore.add(Utils.chat(""));
            demoLitionistLore.add(Utils.chat("&7The demolitionist skill increases your &cSwing Strength&7!"));
            demoLitionistLore.add(Utils.chat("&7Progress: &f%demoprogress%"));
            demoLitionistLore.add(Utils.chat("&7Your current bonus: &6%swingstrength%"));
            demoLitionistLore.add(Utils.chat("&7next bonus: &6%(swingstrength + 1)%"));
            demoLitionistLore.add(Utils.chat(""));

            demolitionistMeta.setDisplayName(Utils.chat("&bDemolitionist"));
            demolitionistMeta.setLore(demoLitionistLore);
            demolitionist.setItemMeta(demolitionistMeta);


            for(int i = 0; i < mainGui.getSize(); i++){
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
