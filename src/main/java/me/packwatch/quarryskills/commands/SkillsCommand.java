package me.packwatch.quarryskills.commands;

import me.packwatch.quarryskills.QuarrySkills;
import me.packwatch.quarryskills.db.Database;
import me.packwatch.quarryskills.model.PlayerData;
import me.packwatch.quarryskills.utils.SkillXpConverter;
import me.packwatch.quarryskills.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.sql.SQLException;
import java.util.ArrayList;

import static java.lang.String.valueOf;

public class SkillsCommand implements CommandExecutor {

    private final QuarrySkills plugin;
    private final int[] skill_requirements = {100, 200, 250, 400, 500, 750, 900, 1000, 1250, 1500, 1650, 1750, 1850, 2000, 2500, 3000, 3500, 4000, 5000, 6000, 7000, 8000, 9000, 10000, 15000};

    public SkillsCommand(QuarrySkills plugin) {
        this.plugin = plugin;

    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {

            Player p = (Player) commandSender;
            double gxp;
            try {
                gxp = this.plugin.getDatabase().findPlayerSkillXpByUUID(p.getUniqueId().toString()).getGeologistXp();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            double sxp;
            try {
                sxp = this.plugin.getDatabase().findPlayerSkillXpByUUID(p.getUniqueId().toString()).getSpelunkerXp();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            double dxp;
            try {
                dxp = this.plugin.getDatabase().findPlayerSkillXpByUUID(p.getUniqueId().toString()).getDemolitionistXp();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            double pFortune = this.plugin.getDatabase().fetchFortuneByUUID(p.getUniqueId().toString());
            int pSwingStrength = this.plugin.getDatabase().fetchSwingStrengthByUUID(p.getUniqueId().toString());
            double pTreasureFind = this.plugin.getDatabase().fetchTreasureFindByUUID(p.getUniqueId().toString());

            // p.playSound(Sound.BLOCK_CHEST_OPEN, 1);

            Inventory mainGui = Bukkit.createInventory(p, 27, ChatColor.DARK_GRAY + "Skills");

            ItemStack geology = new ItemStack(Material.CHISELED_DEEPSLATE, 1);
            ItemStack spelunker = new ItemStack(Material.SPYGLASS, 1);
            ItemStack demolitionist = new ItemStack(Material.CHIPPED_ANVIL, 1);


            ItemMeta geologyMeta = geology.getItemMeta();
            geologyMeta.setDisplayName(Utils.chat("&bGeology level " + String.valueOf(SkillXpConverter.skillXpToLvlAndOverflow(gxp, this.skill_requirements)[0])));
            ArrayList<String> geologyLore = new ArrayList<>();
            geologyLore.add(Utils.chat(""));
            geologyLore.add(Utils.chat("&7The geology skill increases your &6Fortune&7!"));
            geologyLore.add(Utils.chat("&7Progress: &f%geoprogress%"));
            geologyLore.add(Utils.chat("&7Your current bonus: " + pFortune));
            geologyLore.add(Utils.chat("&7next bonus: &6" + String.valueOf((double) (Math.round(pFortune * 100) / 100 + .1))));
            geologyLore.add(Utils.chat("&bProgress: (" + String.valueOf(SkillXpConverter.skillXpToLvlAndOverflow(gxp, this.skill_requirements)[1]) + "/" + this.skill_requirements[(int) SkillXpConverter.skillXpToLvlAndOverflow(gxp, this.skill_requirements)[0]] + ") %" + String.valueOf(SkillXpConverter.skillXpToLvlAndOverflow(gxp, this.skill_requirements)[2])));
            geologyLore.add(Utils.chat(""));
            geologyLore.add(Utils.chat("&8&o(click to expand)"));


            geologyMeta.setLore(geologyLore);
            geology.setItemMeta(geologyMeta);

            ItemMeta spelunkerMeta = spelunker.getItemMeta();

            ArrayList<String> spelunkerLore = new ArrayList<>();
            spelunkerLore.add(Utils.chat(""));
            spelunkerLore.add(Utils.chat("&7The spelunker skill increases your &bTreasure Find&7!"));
            spelunkerLore.add(Utils.chat("&7Progress: &f%spelprogress%"));
            spelunkerLore.add(Utils.chat("&7Your current bonus: &b" + pTreasureFind));
            spelunkerLore.add(Utils.chat("&7next bonus: &b" + String.valueOf((double) (Math.round(pFortune * 100) / 100 + .05))));
            geologyLore.add(Utils.chat("&bProgress: (" + String.valueOf(SkillXpConverter.skillXpToLvlAndOverflow(sxp, this.skill_requirements)[1]) + "/" + this.skill_requirements[(int) SkillXpConverter.skillXpToLvlAndOverflow(sxp, this.skill_requirements)[0]] + ") %" + String.valueOf(SkillXpConverter.skillXpToLvlAndOverflow(sxp, this.skill_requirements)[2])));
            spelunkerLore.add(Utils.chat(""));
            spelunkerLore.add(Utils.chat("&8&o(click to expand)"));

            spelunkerMeta.setDisplayName(Utils.chat("&bSpelunker"));
            spelunkerMeta.setLore(spelunkerLore);
            spelunker.setItemMeta(spelunkerMeta);

            ItemMeta demolitionistMeta = demolitionist.getItemMeta();

            ArrayList<String> demoLitionistLore = new ArrayList<>();
            demoLitionistLore.add(Utils.chat(""));
            demoLitionistLore.add(Utils.chat("&7The demolitionist skill increases your &cSwing Strength&7!"));
            demoLitionistLore.add(Utils.chat("&7Progress: &f%demoprogress%"));
            demoLitionistLore.add(Utils.chat("&7Your current bonus: &c" + pSwingStrength));
            demoLitionistLore.add(Utils.chat("&7next bonus: &c" + String.valueOf(pSwingStrength + 1)));
            geologyLore.add(Utils.chat("&bProgress: (" + String.valueOf(SkillXpConverter.skillXpToLvlAndOverflow(dxp, this.skill_requirements)[1]) + "/" + this.skill_requirements[(int) SkillXpConverter.skillXpToLvlAndOverflow(dxp, this.skill_requirements)[0]] + ") %" + String.valueOf(SkillXpConverter.skillXpToLvlAndOverflow(dxp, this.skill_requirements)[2])));

            demoLitionistLore.add(Utils.chat(""));
            demoLitionistLore.add(Utils.chat("&8&o(click to expand)"));


            demolitionistMeta.setDisplayName(Utils.chat("&bDemolitionist"));
            demolitionistMeta.setLore(demoLitionistLore);
            demolitionist.setItemMeta(demolitionistMeta);


            ItemStack graypane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta m = graypane.getItemMeta();

            m.setDisplayName("");
            graypane.setItemMeta(m);

            for (int i = 0; i < mainGui.getSize(); i++) {
                if (i != 11 && i != 13 && i != 15) {
                    mainGui.setItem(i, graypane);
                }
            }

            mainGui.setItem(11, geology);
            mainGui.setItem(13, spelunker);
            mainGui.setItem(15, demolitionist);


            p.openInventory(mainGui);
        }


        return true;
    }

    public static Inventory mainGui(Player p, Database db){
        double d = db.fetchSkillXPByUUID(p.getUniqueId().toString());
        final int[] skill_requirements = {100, 200, 250, 400, 500, 750, 900, 1000, 1250, 1500, 1650, 1750, 1850, 2000, 2500, 3000, 3500, 4000, 5000, 6000, 7000, 8000, 9000, 10000, 15000};

        double pFortune = db.fetchFortuneByUUID(p.getUniqueId().toString());
        int pSwingStrength = db.fetchSwingStrengthByUUID(p.getUniqueId().toString());
        double pTreasureFind = db.fetchTreasureFindByUUID(p.getUniqueId().toString());

        // p.playSound(Sound.BLOCK_CHEST_OPEN, 1);

        Inventory mainGui = Bukkit.createInventory(p, 27, ChatColor.DARK_GRAY + "Skills");

        ItemStack geology = new ItemStack(Material.CHISELED_DEEPSLATE, 1);
        ItemStack spelunker = new ItemStack(Material.SPYGLASS, 1);
        ItemStack demolitionist = new ItemStack(Material.CHIPPED_ANVIL, 1);


        ItemMeta geologyMeta = geology.getItemMeta();
        geologyMeta.setDisplayName(Utils.chat("&bGeology level " + String.valueOf(SkillXpConverter.skillXpToLvlAndOverflow(d, skill_requirements)[0])));
        ArrayList<String> geologyLore = new ArrayList<>();
        geologyLore.add(Utils.chat(""));
        geologyLore.add(Utils.chat("&7The geology skill increases your &6Fortune&7!"));
        geologyLore.add(Utils.chat("&7Progress: &f%geoprogress%"));
        geologyLore.add(Utils.chat("&7Your current bonus: "+ pFortune ));
        geologyLore.add(Utils.chat("&7next bonus: &6" + String.valueOf((double) (Math.round(pFortune*100)/100 +.1))));
        geologyLore.add(Utils.chat(""));
        geologyLore.add(Utils.chat("&8&o(click to expand)"));


        geologyMeta.setLore(geologyLore);
        geology.setItemMeta(geologyMeta);

        ItemMeta spelunkerMeta = spelunker.getItemMeta();

        ArrayList<String> spelunkerLore = new ArrayList<>();
        spelunkerLore.add(Utils.chat(""));
        spelunkerLore.add(Utils.chat("&7The spelunker skill increases your &bTreasure Find&7!"));
        spelunkerLore.add(Utils.chat("&7Progress: &f%spelprogress%"));
        spelunkerLore.add(Utils.chat("&7Your current bonus: &b"+ pTreasureFind));
        spelunkerLore.add(Utils.chat("&7next bonus: &b" + String.valueOf((double) (Math.round(pFortune*100)/100 +.05))));
        spelunkerLore.add(Utils.chat(""));
        spelunkerLore.add(Utils.chat("&8&o(click to expand)"));

        spelunkerMeta.setDisplayName(Utils.chat("&bSpelunker"));
        spelunkerMeta.setLore(spelunkerLore);
        spelunker.setItemMeta(spelunkerMeta);

        ItemMeta demolitionistMeta = demolitionist.getItemMeta();

        ArrayList<String> demoLitionistLore = new ArrayList<>();
        demoLitionistLore.add(Utils.chat(""));
        demoLitionistLore.add(Utils.chat("&7The demolitionist skill increases your &cSwing Strength&7!"));
        demoLitionistLore.add(Utils.chat("&7Progress: &f%demoprogress%"));
        demoLitionistLore.add(Utils.chat("&7Your current bonus: &c" + pSwingStrength));
        demoLitionistLore.add(Utils.chat("&7next bonus: &c" + String.valueOf(pSwingStrength+1)));
        demoLitionistLore.add(Utils.chat(""));
        demoLitionistLore.add(Utils.chat("&8&o(click to expand)"));


        demolitionistMeta.setDisplayName(Utils.chat("&bDemolitionist"));
        demolitionistMeta.setLore(demoLitionistLore);
        demolitionist.setItemMeta(demolitionistMeta);


        ItemStack graypane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta m = graypane.getItemMeta();

        m.setDisplayName("");
        graypane.setItemMeta(m);

        for(int i = 0; i < mainGui.getSize(); i++){
            if(i != 11 && i != 13 && i != 15) {
                mainGui.setItem(i, graypane);
            }
        }

        mainGui.setItem(11, geology);
        mainGui.setItem(13, spelunker);
        mainGui.setItem(15, demolitionist);

        return mainGui;
    }
}
