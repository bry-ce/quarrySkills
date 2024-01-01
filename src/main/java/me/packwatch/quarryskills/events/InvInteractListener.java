package me.packwatch.quarryskills.events;

import me.packwatch.quarryskills.utils.GeologyInventory;
import me.packwatch.quarryskills.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class InvInteractListener implements Listener {




    @EventHandler
    public void onInvInteract(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        int[] graytiles = new int[28];
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GRAY + "Skills")){
            e.setCancelled(true);


            switch(e.getCurrentItem().getType()) {
                case CHISELED_DEEPSLATE:

                    p.openInventory(GeologyInventory.createGeologyInventory(p));

                    break;
                case CHIPPED_ANVIL:
                    //p.performCommand(skillsdemolitionist)
                    break;
                case SPYGLASS:
                    //p.performCommand(skillsspelunker)
                    break;
            }

        } else if (e.getView().getTitle().equalsIgnoreCase(Utils.chat("&8Geology"))){
            e.setCancelled(true);
        }

    }


}
