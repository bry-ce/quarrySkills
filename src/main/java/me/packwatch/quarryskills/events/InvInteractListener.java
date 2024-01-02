package me.packwatch.quarryskills.events;

import me.packwatch.quarryskills.QuarrySkills;
import me.packwatch.quarryskills.db.Database;
import me.packwatch.quarryskills.utils.GeologyInventory;
import me.packwatch.quarryskills.utils.SkillXpConverter;
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
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.SimplePluginManager;

import java.util.ArrayList;

public class InvInteractListener implements Listener {

    private final QuarrySkills plugin;
    private final int[] skill_requirements = {100, 200, 250, 400, 500, 750, 900, 1000, 1250, 1500, 1650, 1750, 1850, 2000, 2500, 3000, 3500, 4000, 5000, 6000, 7000, 8000, 9000, 10000, 15000};
    public InvInteractListener(QuarrySkills plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInvInteract(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        int[] graytiles = new int[28];
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GRAY + "Skills")){
            e.setCancelled(true);


            switch(e.getCurrentItem().getType()) {
                case CHISELED_DEEPSLATE:

                    p.openInventory(GeologyInventory.createGeologyInventory(p, String.valueOf(SkillXpConverter.skillXpToLvlAndOverflow((this.plugin.getDatabase().fetchSkillXPByUUID(p.getUniqueId().toString(), "geologist_xp")), this.skill_requirements)[0])));

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
