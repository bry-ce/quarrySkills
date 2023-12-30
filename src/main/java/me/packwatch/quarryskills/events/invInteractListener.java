package me.packwatch.quarryskills.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class invInteractListener implements Listener {

    @EventHandler
    public void onInvInteract(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GRAY + "Skills")){
            switch(e.getCurrentItem().getType()){
                case CHISELED_DEEPSLATE:
                    //p.performCommand()
                    break;
            }
            e.setCancelled(true);
        }

    }


}
