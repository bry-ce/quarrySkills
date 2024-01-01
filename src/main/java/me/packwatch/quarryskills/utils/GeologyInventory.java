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
        blankName.setDisplayName("");
        grayPane.setItemMeta(blankName);

        ItemStack levelPane = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta levelMeta = levelPane.getItemMeta();

        int level = 0;
        levelMeta.setDisplayName(Utils.chat("&aGeology&b " + level));
        levelPane.setItemMeta(levelMeta);

        for (int i = 0; i < geoInv.getSize(); i++) {
            geoInv.setItem(i, grayPane);
            switch (i) {
                case 0:
                    geoInv.setItem(i, new ItemStack(Material.BOOK));
                    break;
                case 9:
                    levelPane.setAmount(1);

                    level = 1;
                    levelMeta.setDisplayName(Utils.chat("&aGeology&b " + level));
                    levelMeta.setLore(tileLore(level));
                    levelPane.setItemMeta(levelMeta);
                    geoInv.setItem(i, levelPane);
                    break;
                case 11:
                    levelPane.setAmount(9);

                    level = 9;
                    levelMeta.setDisplayName(Utils.chat("&aGeology&b " + level));
                    levelMeta.setLore(tileLore(level));
                    levelPane.setItemMeta(levelMeta);
                    geoInv.setItem(i, levelPane);
                    break;
                case 12:
                    levelPane.setAmount(10);

                    level = 10;
                    levelMeta.setDisplayName(Utils.chat("&aGeology&b " + level));
                    levelMeta.setLore(tileLore(level));
                    levelPane.setItemMeta(levelMeta);
                    geoInv.setItem(i, levelPane);
                    break;
                case 13:
                    levelPane.setAmount(11);

                    level = 11;
                    levelMeta.setDisplayName(Utils.chat("&aGeology&b " + level));
                    levelMeta.setLore(tileLore(level));
                    levelPane.setItemMeta(levelMeta);
                    geoInv.setItem(i, levelPane);
                    break;
                case 15:
                    levelPane.setAmount(19);

                    level = 19;
                    levelMeta.setDisplayName(Utils.chat("&aGeology&b " + level));
                    levelMeta.setLore(tileLore(level));
                    levelPane.setItemMeta(levelMeta);
                    geoInv.setItem(i, levelPane);
                    break;
                case 16:
                    levelPane.setAmount(20);

                    level = 20;
                    levelMeta.setDisplayName(Utils.chat("&aGeology&b " + level));
                    levelMeta.setLore(tileLore(level));
                    levelPane.setItemMeta(levelMeta);
                    geoInv.setItem(i, levelPane);
                    break;
                case 17:
                    levelPane.setAmount(21);

                    level = 21;
                    levelMeta.setDisplayName(Utils.chat("&aGeology&b " + level));
                    levelMeta.setLore(tileLore(level));
                    levelPane.setItemMeta(levelMeta);
                    geoInv.setItem(i, levelPane);
                    break;
                case 18:
                    levelPane.setAmount(2);

                    level = 2;
                    levelMeta.setDisplayName(Utils.chat("&aGeology&b " + level));
                    levelMeta.setLore(tileLore(level));
                    levelPane.setItemMeta(levelMeta);
                    geoInv.setItem(i, levelPane);
                    break;
                case 20:
                    levelPane.setAmount(8);

                    level = 8;
                    levelMeta.setDisplayName(Utils.chat("&aGeology&b " + level));
                    levelMeta.setLore(tileLore(level));
                    levelPane.setItemMeta(levelMeta);
                    geoInv.setItem(i, levelPane);
                    break;
                case 22:
                    levelPane.setAmount(12);

                    level = 12;
                    levelMeta.setDisplayName(Utils.chat("&aGeology&b " + level));
                    levelMeta.setLore(tileLore(level));
                    levelPane.setItemMeta(levelMeta);
                    geoInv.setItem(i, levelPane);
                    break;
                case 24:
                    levelPane.setAmount(18);

                    level = 18;
                    levelMeta.setDisplayName(Utils.chat("&aGeology&b " + level));
                    levelMeta.setLore(tileLore(level));
                    levelPane.setItemMeta(levelMeta);
                    geoInv.setItem(i, levelPane);
                    break;
                case 26:
                    levelPane.setAmount(22);

                    level = 22;
                    levelMeta.setDisplayName(Utils.chat("&aGeology&b " + level));
                    levelMeta.setLore(tileLore(level));
                    levelPane.setItemMeta(levelMeta);
                    geoInv.setItem(i, levelPane);
                    break;
                case 27:
                    levelPane.setAmount(3);

                    level = 3;
                    levelMeta.setDisplayName(Utils.chat("&aGeology&b " + level));
                    levelMeta.setLore(tileLore(level));
                    levelPane.setItemMeta(levelMeta);
                    geoInv.setItem(i, levelPane);
                    break;
                case 29:
                    levelPane.setAmount(7);

                    level = 7;
                    levelMeta.setDisplayName(Utils.chat("&aGeology&b " + level));
                    levelMeta.setLore(tileLore(level));
                    levelPane.setItemMeta(levelMeta);
                    geoInv.setItem(i, levelPane);
                    break;
                case 31:
                    levelPane.setAmount(13);

                    level = 13;
                    levelMeta.setDisplayName(Utils.chat("&aGeology&b " + level));
                    levelMeta.setLore(tileLore(level));
                    levelPane.setItemMeta(levelMeta);
                    geoInv.setItem(i, levelPane);
                    break;
                case 33:
                    levelPane.setAmount(17);

                    level = 17;
                    levelMeta.setDisplayName(Utils.chat("&aGeology&b " + level));
                    levelMeta.setLore(tileLore(level));
                    levelPane.setItemMeta(levelMeta);
                    geoInv.setItem(i, levelPane);
                    break;
                case 35:
                    levelPane.setAmount(23);

                    level = 23;
                    levelMeta.setDisplayName(Utils.chat("&aGeology&b " + level));
                    levelMeta.setLore(tileLore(level));
                    levelPane.setItemMeta(levelMeta);
                    geoInv.setItem(i, levelPane);
                    break;
                case 36:
                    levelPane.setAmount(4);

                    level = 4;
                    levelMeta.setDisplayName(Utils.chat("&aGeology&b " + level));
                    levelMeta.setLore(tileLore(level));
                    levelPane.setItemMeta(levelMeta);
                    geoInv.setItem(i, levelPane);
                    break;
                case 37:
                    levelPane.setAmount(5);

                    level = 5;
                    levelMeta.setDisplayName(Utils.chat("&aGeology&b " + level));
                    levelMeta.setLore(tileLore(level));
                    levelPane.setItemMeta(levelMeta);
                    geoInv.setItem(i, levelPane);
                    break;
                case 38:
                    levelPane.setAmount(6);

                    level = 6;
                    levelMeta.setDisplayName(Utils.chat("&aGeology&b " + level));
                    levelMeta.setLore(tileLore(level));
                    levelPane.setItemMeta(levelMeta);
                    geoInv.setItem(i, levelPane);
                    break;
                case 40:
                    levelPane.setAmount(14);

                    level = 14;
                    levelMeta.setDisplayName(Utils.chat("&aGeology&b " + level));
                    levelMeta.setLore(tileLore(level));
                    levelPane.setItemMeta(levelMeta);
                    geoInv.setItem(i, levelPane);
                    break;
                case 41:
                    levelPane.setAmount(15);

                    level = 15;
                    levelMeta.setDisplayName(Utils.chat("&aGeology&b " + level));
                    levelMeta.setLore(tileLore(level));
                    levelPane.setItemMeta(levelMeta);
                    geoInv.setItem(i, levelPane);
                    break;
                case 42:
                    levelPane.setAmount(16);

                    level = 16;
                    levelMeta.setDisplayName(Utils.chat("&aGeology&b " + level));
                    levelMeta.setLore(tileLore(level));
                    levelPane.setItemMeta(levelMeta);
                    geoInv.setItem(i, levelPane);
                    break;
                case 44:
                    levelPane.setAmount(24);

                    level = 24;
                    levelMeta.setDisplayName(Utils.chat("&aGeology&b " + level));
                    levelMeta.setLore(tileLore(level));
                    levelPane.setItemMeta(levelMeta);
                    geoInv.setItem(i, levelPane);
                    break;
                case 53:
                    levelPane.setAmount(25);
                    allTileMeta(levelPane, levelMeta, 25);
                    geoInv.setItem(i, levelPane);
                    break;
            }
        }

        return geoInv;
    }
    private static void allTileMeta(ItemStack i, ItemMeta m, int level){
        m.setDisplayName(Utils.chat("&aGeology&b " + level));
        m.setLore(tileLore(level));
        i.setItemMeta(m);
    }

    private static ArrayList<String> tileLore(int level){
        ArrayList<String> levelLore = new ArrayList<>();
        levelLore.add(Utils.chat("&7Rewards:"));
        levelLore.add(Utils.chat("  &eFortunate Miner " + level));
        levelLore.add(Utils.chat("      &fGrants you &a+&8"+ String.valueOf((level-1)*0.1) + "⇰&a"+String.valueOf(level*0.1) + " &6Fortune"));
        return levelLore;
    }

}
