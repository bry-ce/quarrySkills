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
        double coinsperblock = 1*pd.getFortune();
        if (m.equals(Material.COAL_ORE)){
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Utils.chat("&6⛂&7 +" + String.valueOf(coinsperblock))));
            pd.setCoins(pd.getCoins()+coinsperblock);
            try {
                this.plugin.getDatabase().updatePlayerData(pd);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            this.tabAPI.getPlaceholderManager().registerPlayerPlaceholder("%coins%", 50, player -> pd.getCoins());

        }
    }
}
