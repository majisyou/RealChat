package com.github.huda0209.realchat.listener;

import com.github.huda0209.realchat.config.loadConfig;
import com.github.huda0209.realchat.util.playerDistance;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.List;

public class DeathMessageListener implements Listener {

    @EventHandler
    public static void DeathMessage(PlayerDeathEvent event) {
        Player player = event.getEntity();
        Player killer = player.getKiller();
        List<Player> worldPlayers = player.getWorld().getPlayers();
        String message = event.getDeathMessage();

        if (killer != null) {
            message = player.getName() + "は" + killer.getName() + "に倒された";
            player.sendMessage(message);
            killer.sendMessage(message);
        } else {
            player.sendMessage(message);
        }
        for (Player worldPlayer : worldPlayers) {
            if (!worldPlayer.equals(player)) {
                Location worldPlayerLocation = worldPlayer.getLocation();
                if (playerDistance.isRangeIn(player.getLocation(), worldPlayerLocation, loadConfig.config.getInt("CanChatRange"))) {
                    worldPlayer.sendMessage(message);
                }
            }
        }
    }

}
