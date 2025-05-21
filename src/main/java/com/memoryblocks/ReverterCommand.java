package com.memoryblocks;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class ReverterCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player jogador)) {
            sender.sendMessage("Somente jogadores podem usar esse comando.");
            return true;
        }

        UUID id = jogador.getUniqueId();
        List<BlocoDestruido> blocos = BlockLoggerListener.blocosPorJogador.get(id);

        if (blocos == null || blocos.isEmpty()) {
            jogador.sendMessage("Você não destruiu blocos recentemente.");
            return true;
        }

        int contador = 0;
        for (BlocoDestruido bloco : blocos) {
            bloco.getLocation().getBlock().setType(bloco.tipo);
            contador++;
        }

        BlockLoggerListener.blocosPorJogador.remove(id);
        jogador.sendMessage("🔁 " + contador + " blocos restaurados com sucesso.");
        return true;
    }
}
