package me.packwatch.quarryskills.events;

import me.packwatch.quarryskills.QuarrySkills;
import me.packwatch.quarryskills.model.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.SQLException;

public class JoinListener implements Listener {

    private final QuarrySkills plugin;

    public JoinListener(QuarrySkills plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onFirstJoin(PlayerJoinEvent e){
        //Create playerdata if none exists
        Player p = e.getPlayer();

        PlayerData data = null;
        try {
            data = this.plugin.getDatabase().findPlayerDataByUUID(p.getUniqueId().toString());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        if (data == null){
            data = new PlayerData(p.getUniqueId().toString(), 0, 0, 0, 1.0, 0.0,1);
            try {
                this.plugin.getDatabase().createPlayerData(data);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}


