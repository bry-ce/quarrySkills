package me.packwatch.quarryskills.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class invInteractListener implements Listener {

    @EventHandler
    public void onInvInteract(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        InventoryView einv = (InventoryView) e.getInventory();

        if (einv.getTitle().equalsIgnoreCase(ChatColor.DARK_GRAY + "Skills")){
            e.setCancelled(true);
            switch(e.getCurrentItem().getType()){
                case CHISELED_DEEPSLATE:
                    //p.performCommand("skillsgeology")
                    break;
                case CHIPPED_ANVIL:
                    //p.performCommand(skillsdemolitionist)
                    break;
                case SPYGLASS:
                    //p.performCommand(skillsspelunker)
                    break;
            }

        }

    }


}
