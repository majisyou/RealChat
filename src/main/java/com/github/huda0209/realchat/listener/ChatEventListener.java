package com.github.huda0209.realchat.listener;

import com.github.huda0209.realchat.RealChat;
import com.github.huda0209.realchat.chat.ChatFormat;
import com.github.huda0209.realchat.util.playerDistance;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;


public class ChatEventListener implements Listener {
    private final RealChat plugin;

    public ChatEventListener(RealChat realChat){
        this.plugin = realChat;
    }

    @EventHandler
    public void ChatEvent(AsyncPlayerChatEvent event){
        event.setCancelled(true);

        Player player = event.getPlayer();
        String message = event.getMessage();

        Location playerLocation = player.getLocation();

        World playerWorld = player.getWorld();
        List<Player> worldPlayers = playerWorld.getPlayers();


        String FormedMessage = ChatFormat.messageFormat(player,message);

        System.out.println("(RC)"+FormedMessage);

        for(Player worldPlayer : worldPlayers){
            Location worldPlayerLocation = worldPlayer.getLocation();
            if(playerDistance.isRangeIn(playerLocation,worldPlayerLocation,10)){
                player.sendMessage(FormedMessage);
            }
        }
    }
}
