package com.memoryblocks;

import org.bukkit.plugin.java.JavaPlugin;

public class App extends JavaPlugin {

    private BlockLoggerListener listener;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        listener = new BlockLoggerListener(this);
        listener.carregarDoArquivo();

        getServer().getPluginManager().registerEvents(listener, this);
        getCommand("reverter").setExecutor(new ReverterCommand());
    }

    @Override
    public void onDisable() {
        listener.salvarEmArquivo();
    }
}
