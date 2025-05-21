package com.memoryblocks;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class BlockLoggerListener implements Listener {

    public static Map<UUID, List<BlocoDestruido>> blocosPorJogador = new HashMap<>();
    private static final String ARQUIVO = "blocos.json";

    private final Plugin plugin;

    public BlockLoggerListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void aoQuebrarBloco(BlockBreakEvent e) {
        UUID id = e.getPlayer().getUniqueId();
        blocosPorJogador.putIfAbsent(id, new ArrayList<>());
        blocosPorJogador.get(id).add(new BlocoDestruido(e.getBlock().getLocation(), e.getBlock().getType()));
    }

    public void salvarEmArquivo() {
        try (Writer writer = new FileWriter(new File(plugin.getDataFolder(), ARQUIVO))) {
            new Gson().toJson(blocosPorJogador, writer);
        } catch (IOException e) {
            plugin.getLogger().warning("Erro ao salvar blocos: " + e.getMessage());
        }
    }

    public void carregarDoArquivo() {
        File file = new File(plugin.getDataFolder(), ARQUIVO);
        if (!file.exists()) return;

        try (Reader reader = new FileReader(file)) {
            Type tipo = new TypeToken<Map<UUID, List<BlocoDestruido>>>() {}.getType();
            blocosPorJogador = new Gson().fromJson(reader, tipo);
        } catch (IOException e) {
            plugin.getLogger().warning("Erro ao carregar blocos: " + e.getMessage());
        }
    }
}
