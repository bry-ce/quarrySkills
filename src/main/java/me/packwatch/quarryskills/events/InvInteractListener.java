package me.packwatch.quarryskills.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvInteractListener implements Listener {

    @EventHandler
    public void onInvInteract(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GRAY + "Skills")){
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
