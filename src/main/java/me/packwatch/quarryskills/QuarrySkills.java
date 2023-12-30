package me.packwatch.quarryskills;

import me.packwatch.quarryskills.commands.skillsCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class QuarrySkills extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("skills").setExecutor(new skillsCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
