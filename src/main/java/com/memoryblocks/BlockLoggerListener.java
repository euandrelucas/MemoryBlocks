package com.memoryblocks;

// import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.*;

public class BlockLoggerListener implements Listener {

    // Armazena blocos destruídos por jogador
    public static Map<UUID, List<BlocoDestruido>> blocosPorJogador = new HashMap<>();

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player jogador = event.getPlayer();
        Location loc = event.getBlock().getLocation();
        Material tipo = event.getBlock().getType();

        blocosPorJogador.putIfAbsent(jogador.getUniqueId(), new ArrayList<>());
        blocosPorJogador.get(jogador.getUniqueId()).add(new BlocoDestruido(loc, tipo));

        jogador.sendMessage("Bloco " + tipo + " registrado para possível reversão.");
    }
}
