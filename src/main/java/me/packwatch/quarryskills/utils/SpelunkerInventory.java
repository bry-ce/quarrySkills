package me.packwatch.quarryskills.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class SpelunkerInventory {

    public static Inventory createSpelunkerInventory(Player p) {
        Inventory spelInv = Bukkit.createInventory(p, 54, Utils.chat("&8Spelunker"));
        ItemStack grayPane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);

        ItemStack levelPane = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta levelMeta = levelPane.getItemMeta();

        ItemStack infoBook = new ItemStack(Material.BOOK);

        for (int i = 0; i < spelInv.getSize(); i++) {
            spelInv.setItem(i, grayPane);
            switch (i) {
                case 0:
                    spelInv.setItem(i, new ItemStack(Material.BOOK));
                    break;
                case 9:
                    allTileMeta(levelPane, levelMeta, 1);
                    spelInv.setItem(i, levelPane);
                    break;
                case 11:
                    allTileMeta(levelPane, levelMeta, 9);
                    spelInv.setItem(i, levelPane);
                    break;
                case 12:
                    allTileMeta(levelPane, levelMeta, 10);
                    spelInv.setItem(i, levelPane);
                    break;
                case 13:
                    allTileMeta(levelPane, levelMeta, 11);
                    spelInv.setItem(i, levelPane);
                    break;
                case 15:
                    allTileMeta(levelPane, levelMeta, 19);
                    spelInv.setItem(i, levelPane);
                    break;
                case 16:
                    allTileMeta(levelPane, levelMeta, 20);
                    spelInv.setItem(i, levelPane);
                    break;
                case 17:
                    allTileMeta(levelPane, levelMeta, 21);
                    spelInv.setItem(i, levelPane);
                    break;
                case 18:
                    allTileMeta(levelPane, levelMeta, 2);
                    spelInv.setItem(i, levelPane);
                    break;
                case 20:
                    allTileMeta(levelPane, levelMeta, 8);
                    spelInv.setItem(i, levelPane);
                    break;
                case 22:
                    allTileMeta(levelPane, levelMeta, 12);
                    spelInv.setItem(i, levelPane);
                    break;
                case 24:
                    allTileMeta(levelPane, levelMeta, 18);
                    spelInv.setItem(i, levelPane);
                    break;
                case 26:
                    allTileMeta(levelPane, levelMeta, 22);
                    spelInv.setItem(i, levelPane);
                    break;
                case 27:
                    allTileMeta(levelPane, levelMeta, 3);
                    spelInv.setItem(i, levelPane);
                    break;
                case 29:
                    allTileMeta(levelPane, levelMeta, 7);
                    spelInv.setItem(i, levelPane);
                    break;
                case 31:
                    allTileMeta(levelPane, levelMeta, 13);
                    spelInv.setItem(i, levelPane);
                    break;
                case 33:
                    allTileMeta(levelPane, levelMeta, 17);
                    spelInv.setItem(i, levelPane);
                    break;
                case 35:
                    allTileMeta(levelPane, levelMeta, 23);
                    spelInv.setItem(i, levelPane);
                    break;
                case 36:
                    allTileMeta(levelPane, levelMeta, 4);
                    spelInv.setItem(i, levelPane);
                    break;
                case 37:
                    allTileMeta(levelPane, levelMeta, 5);
                    spelInv.setItem(i, levelPane);
                    break;
                case 38:
                    allTileMeta(levelPane, levelMeta, 6);
                    spelInv.setItem(i, levelPane);
                    break;
                case 40:
                    allTileMeta(levelPane, levelMeta, 14);
                    spelInv.setItem(i, levelPane);
                    break;
                case 41:
                    allTileMeta(levelPane, levelMeta, 15);
                    spelInv.setItem(i, levelPane);
                    break;
                case 42:
                    allTileMeta(levelPane, levelMeta, 16);
                    spelInv.setItem(i, levelPane);
                    break;
                case 44:
                    allTileMeta(levelPane, levelMeta, 24);
                    spelInv.setItem(i, levelPane);
                    break;
                case 53:
                    allTileMeta(levelPane, levelMeta, 25);
                    spelInv.setItem(i, levelPane);
                    break;
            }
        }

        return spelInv;
    }
    private static void allTileMeta(ItemStack i, ItemMeta m, int level){
        i.setAmount(level);
        m.setDisplayName(Utils.chat("&6Spelunker&b " + level));
        m.setLore(tileLore(level));
        i.setItemMeta(m);
    }

    private static ArrayList<String> tileLore(int level){
        ArrayList<String> levelLore = new ArrayList<>();
        levelLore.add(Utils.chat("&7Rewards:"));
        levelLore.add(Utils.chat("  &eTreasure Finder " + level));
        levelLore.add(Utils.chat("      &fGrants you &a+&8"+ String.valueOf(((level-1)*500)/100) + "⇰&a"+String.valueOf((level*500)/100) + " &bTreasure Find"));
        levelLore.add(Utils.chat("      &fwhich increases your chance at finding rare"));
        levelLore.add(Utils.chat("      &fitems, like lootboxes, or pebbles."));

        return levelLore;
    }
}
