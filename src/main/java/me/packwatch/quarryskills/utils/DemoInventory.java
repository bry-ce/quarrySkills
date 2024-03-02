package me.packwatch.quarryskills.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class DemoInventory {
    public static Inventory createDemoInventory(Player p){
        Inventory demoInv = Bukkit.createInventory(p, 54, Utils.chat("&cDemolitionist"));
        ItemStack grayPane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta blankName = grayPane.getItemMeta();
        assert blankName != null;
        blankName.setDisplayName("");
        grayPane.setItemMeta(blankName);

        ItemStack levelPane = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta levelMeta = levelPane.getItemMeta();

        int level = 0;
        assert levelMeta != null;
        levelMeta.setDisplayName(Utils.chat("&cDemolitionist&b " + level));
        levelPane.setItemMeta(levelMeta);

        for (int i = 0; i < demoInv.getSize(); i++) {
            demoInv.setItem(i, grayPane);
            switch (i) {
                case 0:
                    demoInv.setItem(i, new ItemStack(Material.BOOK));
                    break;
                case 9:
                    allTileMeta(levelPane, levelMeta, 1);
                    demoInv.setItem(i, levelPane);
                    break;
                case 11:
                    allTileMeta(levelPane, levelMeta, 9);
                    demoInv.setItem(i, levelPane);
                    break;
                case 12:
                    allTileMeta(levelPane, levelMeta, 10);
                    demoInv.setItem(i, levelPane);
                    break;
                case 13:
                    allTileMeta(levelPane, levelMeta, 11);
                    demoInv.setItem(i, levelPane);
                    break;
                case 15:
                    allTileMeta(levelPane, levelMeta, 19);
                    demoInv.setItem(i, levelPane);
                    break;
                case 16:
                    allTileMeta(levelPane, levelMeta, 20);
                    demoInv.setItem(i, levelPane);
                    break;
                case 17:
                    allTileMeta(levelPane, levelMeta, 21);
                    demoInv.setItem(i, levelPane);
                    break;
                case 18:
                    allTileMeta(levelPane, levelMeta, 2);
                    demoInv.setItem(i, levelPane);
                    break;
                case 20:
                    allTileMeta(levelPane, levelMeta, 8);
                    demoInv.setItem(i, levelPane);
                    break;
                case 22:
                    allTileMeta(levelPane, levelMeta, 12);
                    demoInv.setItem(i, levelPane);
                    break;
                case 24:
                    allTileMeta(levelPane, levelMeta, 18);
                    demoInv.setItem(i, levelPane);
                    break;
                case 26:
                    allTileMeta(levelPane, levelMeta, 22);
                    demoInv.setItem(i, levelPane);
                    break;
                case 27:
                    allTileMeta(levelPane, levelMeta, 3);
                    demoInv.setItem(i, levelPane);
                    break;
                case 29:
                    allTileMeta(levelPane, levelMeta, 7);
                    demoInv.setItem(i, levelPane);
                    break;
                case 31:
                    allTileMeta(levelPane, levelMeta, 13);
                    demoInv.setItem(i, levelPane);
                    break;
                case 33:
                    allTileMeta(levelPane, levelMeta, 17);
                    demoInv.setItem(i, levelPane);
                    break;
                case 35:
                    allTileMeta(levelPane, levelMeta, 23);
                    demoInv.setItem(i, levelPane);
                    break;
                case 36:
                    allTileMeta(levelPane, levelMeta, 4);
                    demoInv.setItem(i, levelPane);
                    break;
                case 37:
                    allTileMeta(levelPane, levelMeta, 5);
                    demoInv.setItem(i, levelPane);
                    break;
                case 38:
                    allTileMeta(levelPane, levelMeta, 6);
                    demoInv.setItem(i, levelPane);
                    break;
                case 40:
                    allTileMeta(levelPane, levelMeta, 14);
                    demoInv.setItem(i, levelPane);
                    break;
                case 41:
                    allTileMeta(levelPane, levelMeta, 15);
                    demoInv.setItem(i, levelPane);
                    break;
                case 42:
                    allTileMeta(levelPane, levelMeta, 16);
                    demoInv.setItem(i, levelPane);
                    break;
                case 44:
                    allTileMeta(levelPane, levelMeta, 24);
                    demoInv.setItem(i, levelPane);
                    break;
                case 53:
                    allTileMeta(levelPane, levelMeta, 25);
                    demoInv.setItem(i, levelPane);
                    break;
            }
        }
        
        
        return demoInv;
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
