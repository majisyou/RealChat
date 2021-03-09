package com.github.huda0209.realchat.listener;

import com.github.huda0209.realchat.RealChat;
import com.github.huda0209.realchat.util.playerDistance;

import com.github.ucchyocean.lc3.LunaChatAPI;
import com.github.ucchyocean.lc3.japanize.JapanizeType;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;


public class ChatEventListener implements Listener {
    private final RealChat plugin;
    private final LunaChatAPI lunaChatAPI;

    public ChatEventListener(RealChat realChat, LunaChatAPI lcAPI){
        this.plugin = realChat;
        this.lunaChatAPI = lcAPI;
    }

    @EventHandler
    public void ChatEvent(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        String message = event.getMessage();

        Location playerLocation = player.getLocation();

        World playerWorld = player.getWorld();
        List<Player> worldPlayers = playerWorld.getPlayers();

        String chatMessage =  lunaChatAPI.japanize(message, JapanizeType.GOOGLE_IME);

        event.setCancelled(false);

        for(Player worldPlayer : worldPlayers){
            Location worldPlayerLocation = worldPlayer.getLocation();
            if(playerDistance.isRangeIn(playerLocation,worldPlayerLocation,10)){
                player.sendMessage(chatMessage);
            }
        }
    }

    public void SendMessage(){


    }
}
