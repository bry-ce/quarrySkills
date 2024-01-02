package me.packwatch.quarryskills;

import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.event.plugin.PlaceholderRegisterEvent;
import me.neznamy.tab.api.placeholder.PlaceholderManager;
import me.packwatch.quarryskills.commands.SkillsCommand;
import me.packwatch.quarryskills.db.Database;
import me.packwatch.quarryskills.events.InvInteractListener;
import me.packwatch.quarryskills.events.JoinListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public final class QuarrySkills extends JavaPlugin {
    private Database database;

    @Override
    public void onEnable() {
        //mySQL database connection

        try{
            this.database = new Database();
            database.initDatabase();
            System.out.println("[QUARRYDATABASECONNECTION]: Success!");
        }catch (SQLException ex){
            System.out.println("[QUARRYDATABASECONNECTION]: Unable to connect to QuarryMC database.");
            throw new RuntimeException(ex);
        }


        // Plugin startup logic
        getCommand("skills").setExecutor(new SkillsCommand(this));
        getServer().getPluginManager().registerEvents(new InvInteractListener(), this);
        getServer().getPluginManager().registerEvents(new JoinListener(this, TabAPI.getInstance()), this);
    }

    public Database getDatabase() {
        return database;
    }
}
