package net.turboangle.testplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // プラグインが起動したときの処理
        getLogger().info("Test has been successfully enabled!");
    }

    @Override
    public void onDisable() {
        // プラグインが停止したときの処理
        getLogger().info("Test Plugin has been safely disabled!");
    }
}