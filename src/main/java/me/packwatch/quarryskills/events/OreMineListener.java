package me.packwatch.quarryskills.events;

import me.neznamy.tab.api.TabAPI;
import me.packwatch.quarryskills.QuarrySkills;
import me.packwatch.quarryskills.model.PlayerData;
import me.packwatch.quarryskills.utils.Utils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.sql.SQLException;

public class OreMineListener implements Listener {
    private final QuarrySkills plugin;
    private final TabAPI tabAPI;

    public OreMineListener(QuarrySkills plugin, TabAPI tabAPI) {
        this.plugin = plugin;
        this.tabAPI = tabAPI;

    }
    @EventHandler
    public void onOreMine(BlockBreakEvent e){
        Player p = e.getPlayer();
        Material m = e.getBlock().getType();
        PlayerData pd = this.plugin.getDatabase().findPlayerDataByUUID(p.getUniqueId().toString());

        if (m.equals(Material.COAL_ORE)){
            double coinsperblock = 1*pd.getFortune();
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Utils.chat("&6⛂&7 +" + String.valueOf(coinsperblock))));
            pd.setCoins(pd.getCoins()+coinsperblock);
            try {
                this.plugin.getDatabase().updatePlayerData(pd);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            this.tabAPI.getPlaceholderManager().registerPlayerPlaceholder("%coins%", 50, player -> pd.getCoins());

        } else if (m.equals(Material.IRON_ORE)){
            double coinsperblock = 1.5*pd.getFortune();
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Utils.chat("&6⛂&7 +" + String.valueOf(coinsperblock))));
            pd.setCoins(pd.getCoins()+coinsperblock);
            try {
                this.plugin.getDatabase().updatePlayerData(pd);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } else if (m.equals(Material.GOLD_ORE)) {
            double coinsperblock = 2.5*pd.getFortune();
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Utils.chat("&6⛂&7 +" + String.valueOf(coinsperblock))));
            pd.setCoins(pd.getCoins()+coinsperblock);
            try {
                this.plugin.getDatabase().updatePlayerData(pd);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        } else if (m.equals(Material.REDSTONE_ORE)) {
            double coinsperblock = 4*pd.getFortune();
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Utils.chat("&6⛂&7 +" + String.valueOf(coinsperblock))));
            pd.setCoins(pd.getCoins()+coinsperblock);
            try {
                this.plugin.getDatabase().updatePlayerData(pd);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        } else if (m.equals(Material.DIAMOND_ORE)) {
            double coinsperblock = 6*pd.getFortune();
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Utils.chat("&6⛂&7 +" + String.valueOf(coinsperblock))));
            pd.setCoins(pd.getCoins()+coinsperblock);
            try {
                this.plugin.getDatabase().updatePlayerData(pd);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        } else if (m.equals(Material.AMETHYST_BLOCK)) {
            double coinsperblock = 10*pd.getFortune();
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Utils.chat("&6⛂&7 +" + String.valueOf(coinsperblock))));
            pd.setCoins(pd.getCoins()+coinsperblock);
            try {
                this.plugin.getDatabase().updatePlayerData(pd);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
    }
}
