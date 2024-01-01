package me.packwatch.quarryskills.events;

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


            switch(e.getCurrentItem().getType()){
                case CHISELED_DEEPSLATE:
                    Inventory geoInv = Bukkit.createInventory(p, 45, "&8Geology");
                    ItemStack grayPane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                    ItemMeta blankName = grayPane.getItemMeta();
                    blankName.setDisplayName("");
                    grayPane.setItemMeta(blankName);

                    ItemStack levelPane = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                    ItemMeta levelMeta = levelPane.getItemMeta();

                    int level = 0;
                    levelMeta.setDisplayName(Utils.chat("&bGeology "+ level));
                    ArrayList<String> levelLore = new ArrayList<>();
                    for(int i = 0; i < geoInv.getSize(); i++){
                        geoInv.setItem(i, grayPane);
                        switch (i){
                            case 0: geoInv.setItem(i, new ItemStack(Material.BOOK)); break;
                            case 9: levelPane.setAmount(1); geoInv.setItem(i,levelPane); level=1; levelPane.setAmount(level);break;
                            case 11: levelPane.setAmount(2); geoInv.setItem(i,levelPane);level=2; levelPane.setAmount(level);break;
                            case 12: levelPane.setAmount(3); geoInv.setItem(i,levelPane);level=3; levelPane.setAmount(level);break;
                            case 13: levelPane.setAmount(4); geoInv.setItem(i,levelPane);level=4; levelPane.setAmount(level);break;
                            case 15: levelPane.setAmount(5); geoInv.setItem(i,levelPane);level=5; levelPane.setAmount(level);break;
                            case 16: levelPane.setAmount(6); geoInv.setItem(i,levelPane);level=6; levelPane.setAmount(level);break;
                            case 17: levelPane.setAmount(7); geoInv.setItem(i,levelPane);level=7; levelPane.setAmount(level);break;
                            case 18: levelPane.setAmount(8); geoInv.setItem(i,levelPane);level=8; levelPane.setAmount(level);break;
                            case 20: levelPane.setAmount(9); geoInv.setItem(i,levelPane);level=9; levelPane.setAmount(level);break;
                            case 22: levelPane.setAmount(10); geoInv.setItem(i,levelPane);level=10; levelPane.setAmount(level);break;
                            case 24: levelPane.setAmount(11); geoInv.setItem(i,levelPane);level=11; levelPane.setAmount(level);break;
                            case 26: levelPane.setAmount(12); geoInv.setItem(i,levelPane);level=12; levelPane.setAmount(level);break;
                            case 27: levelPane.setAmount(13); geoInv.setItem(i,levelPane);level=13; levelPane.setAmount(level);break;
                            case 29: levelPane.setAmount(14); geoInv.setItem(i,levelPane);level=14; levelPane.setAmount(level);break;
                            case 31: levelPane.setAmount(15); geoInv.setItem(i,levelPane);level=15; levelPane.setAmount(level);break;
                            case 33: levelPane.setAmount(16); geoInv.setItem(i,levelPane);level=16; levelPane.setAmount(level);break;
                            case 35: levelPane.setAmount(17); geoInv.setItem(i,levelPane);level=17; levelPane.setAmount(level);break;
                            case 36: levelPane.setAmount(18); geoInv.setItem(i,levelPane);level=18; levelPane.setAmount(level);break;
                            case 37: levelPane.setAmount(19); geoInv.setItem(i,levelPane);level=19; levelPane.setAmount(level);break;
                            case 38: levelPane.setAmount(20); geoInv.setItem(i,levelPane);level=20; levelPane.setAmount(level);break;
                            case 40: levelPane.setAmount(21); geoInv.setItem(i,levelPane);level=21; levelPane.setAmount(level);break;
                            case 41: levelPane.setAmount(22); geoInv.setItem(i,levelPane);level=22; levelPane.setAmount(level);break;
                            case 42: levelPane.setAmount(23); geoInv.setItem(i,levelPane);level=23; levelPane.setAmount(level);break;
                            case 44: levelPane.setAmount(24); geoInv.setItem(i,levelPane);level=24; levelPane.setAmount(level);break;
                            case 53: levelPane.setAmount(25); geoInv.setItem(i,levelPane);level=25; levelPane.setAmount(level);break;
                        }
                    }

                    p.openInventory(geoInv);
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
