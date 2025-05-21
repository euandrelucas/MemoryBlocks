package com.memoryblocks;

import org.bukkit.plugin.java.JavaPlugin;

public class App extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin MemoryBlocks ativado!");
        getServer().getPluginManager().registerEvents(new BlockLoggerListener(), this);
        getCommand("reverter").setExecutor(new ReverterCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin MemoryBlocks desativado!");
    }
}
