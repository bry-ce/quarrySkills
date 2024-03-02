package me.packwatch.quarryskills.events;

import me.packwatch.quarryskills.QuarrySkills;
import me.packwatch.quarryskills.commands.SkillsCommand;
import me.packwatch.quarryskills.utils.DemoInventory;
import me.packwatch.quarryskills.utils.GeologyInventory;
import me.packwatch.quarryskills.utils.SpelunkerInventory;
import me.packwatch.quarryskills.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;


public class InvInteractListener implements Listener {

    private final QuarrySkills plugin;
    public InvInteractListener(QuarrySkills plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInvInteract(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GRAY + "Skills")){
            e.setCancelled(true);


            switch(Objects.requireNonNull(e.getCurrentItem()).getType()) {
                case CHISELED_DEEPSLATE:

                    p.openInventory(GeologyInventory.createGeologyInventory(p));

                    break;
                case CHIPPED_ANVIL:

                    p.openInventory(DemoInventory.createDemoInventory(p));

                    break;
                case SPYGLASS:
                    p.openInventory(SpelunkerInventory.createSpelunkerInventory(p));
                    break;
            }

        } else if (e.getView().getTitle().equalsIgnoreCase(Utils.chat("&8Geology")) || e.getView().getTitle().equalsIgnoreCase(Utils.chat("&8Spelunker"))){
            e.setCancelled(true);
            if(Objects.requireNonNull(e.getCurrentItem()).getType() == Material.BOOK){
                p.openInventory(SkillsCommand.mainGui(p, this.plugin.getDatabase() ));
            }

        }

    }


}
