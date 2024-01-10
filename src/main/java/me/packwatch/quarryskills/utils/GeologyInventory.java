package me.packwatch.quarryskills.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GeologyInventory {
    public static Inventory createGeologyInventory(Player p) {
        Inventory geoInv = Bukkit.createInventory(p, 54, Utils.chat("&8Geology"));
        ItemStack grayPane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta blankName = grayPane.getItemMeta();
        assert blankName != null;
        blankName.setDisplayName("");
        grayPane.setItemMeta(blankName);

        ItemStack levelPane = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta levelMeta = levelPane.getItemMeta();



        int level = 0;
        assert levelMeta != null;
        levelMeta.setDisplayName(Utils.chat("&aGeology&b " + level));
        levelPane.setItemMeta(levelMeta);

        for (int i = 0; i < geoInv.getSize(); i++) {
            geoInv.setItem(i, grayPane);
            switch (i) {
                case 0:
                    geoInv.setItem(i, new ItemStack(Material.BOOK));
                    break;
                case 9:
                    allTileMeta(levelPane, levelMeta, 1);
                    geoInv.setItem(i, levelPane);
                    break;
                case 11:
                    allTileMeta(levelPane, levelMeta, 9);
                    geoInv.setItem(i, levelPane);
                    break;
                case 12:
                    allTileMeta(levelPane, levelMeta, 10);
                    geoInv.setItem(i, levelPane);
                    break;
                case 13:
                    allTileMeta(levelPane, levelMeta, 11);
                    geoInv.setItem(i, levelPane);
                    break;
                case 15:
                    allTileMeta(levelPane, levelMeta, 19);
                    geoInv.setItem(i, levelPane);
                    break;
                case 16:
                    allTileMeta(levelPane, levelMeta, 20);
                    geoInv.setItem(i, levelPane);
                    break;
                case 17:
                    allTileMeta(levelPane, levelMeta, 21);
                    geoInv.setItem(i, levelPane);
                    break;
                case 18:
                    allTileMeta(levelPane, levelMeta, 2);
                    geoInv.setItem(i, levelPane);
                    break;
                case 20:
                    allTileMeta(levelPane, levelMeta, 8);
                    geoInv.setItem(i, levelPane);
                    break;
                case 22:
                    allTileMeta(levelPane, levelMeta, 12);
                    geoInv.setItem(i, levelPane);
                    break;
                case 24:
                    allTileMeta(levelPane, levelMeta, 18);
                    geoInv.setItem(i, levelPane);
                    break;
                case 26:
                    allTileMeta(levelPane, levelMeta, 22);
                    geoInv.setItem(i, levelPane);
                    break;
                case 27:
                    allTileMeta(levelPane, levelMeta, 3);
                    geoInv.setItem(i, levelPane);
                    break;
                case 29:
                    allTileMeta(levelPane, levelMeta, 7);
                    geoInv.setItem(i, levelPane);
                    break;
                case 31:
                    allTileMeta(levelPane, levelMeta, 13);
                    geoInv.setItem(i, levelPane);
                    break;
                case 33:
                    allTileMeta(levelPane, levelMeta, 17);
                    geoInv.setItem(i, levelPane);
                    break;
                case 35:
                    allTileMeta(levelPane, levelMeta, 23);
                    geoInv.setItem(i, levelPane);
                    break;
                case 36:
                    allTileMeta(levelPane, levelMeta, 4);
                    geoInv.setItem(i, levelPane);
                    break;
                case 37:
                    allTileMeta(levelPane, levelMeta, 5);
                    geoInv.setItem(i, levelPane);
                    break;
                case 38:
                    allTileMeta(levelPane, levelMeta, 6);
                    geoInv.setItem(i, levelPane);
                    break;
                case 40:
                    allTileMeta(levelPane, levelMeta, 14);
                    geoInv.setItem(i, levelPane);
                    break;
                case 41:
                    allTileMeta(levelPane, levelMeta, 15);
                    geoInv.setItem(i, levelPane);
                    break;
                case 42:
                    allTileMeta(levelPane, levelMeta, 16);
                    geoInv.setItem(i, levelPane);
                    break;
                case 44:
                    allTileMeta(levelPane, levelMeta, 24);
                    geoInv.setItem(i, levelPane);
                    break;
                case 53:
                    allTileMeta(levelPane, levelMeta, 25);
                    geoInv.setItem(i, levelPane);
                    break;
            }
        }

        return geoInv;
    }
    private static void allTileMeta(ItemStack i, ItemMeta m, int level){
        i.setAmount(level);
        m.setDisplayName(Utils.chat("&aGeology&b " + level));
        m.setLore(tileLore(level));
        i.setItemMeta(m);
    }

    private static ArrayList<String> tileLore(int level){
        ArrayList<String> levelLore = new ArrayList<>();
        levelLore.add(Utils.chat("&7Rewards:"));
        levelLore.add(Utils.chat("  &eFortunate Miner " + level));
        levelLore.add(Utils.chat("      &fGrants you &a+&8"+ (Math.round((level-1)*0.1*1000)/100) + "⇰&a" + (Math.round((level*0.1)*1000)/100) + " &6Fortune"));
        levelLore.add(Utils.chat("      &fwhich increases the amount of &3shards &fyou"));
        levelLore.add(Utils.chat("      &fgain from mining any ore, as a flat multiplier."));

        return levelLore;
    }

}
