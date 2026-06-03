package net.turboangle.testplugin;

import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Test has been successfully enabled!");
        getServer().getPluginManager().registerEvents(new Test(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Test Plugin has been safely disabled!");
    }
}