package com.github.huda0209.realchat.listener;

import com.github.huda0209.realchat.ModeManager;
import com.github.huda0209.realchat.RealChat;
import com.github.huda0209.realchat.chat.ChatFormat;
import com.github.huda0209.realchat.util.playerDistance;
import com.github.huda0209.realchat.config.loadConfig;

//import com.github.ucchyocean.lc3.LunaChat;
//import com.github.ucchyocean.lc3.LunaChatConfig;

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

        Player player = event.getPlayer();
        String message = event.getMessage();

        Location playerLocation = player.getLocation();

        World playerWorld = player.getWorld();
        List<Player> worldPlayers = playerWorld.getPlayers();

        if(player.hasPermission("GlobalChat")){
            if(AdminChatMode(event)) return;
        }

        event.setCancelled(true);
        message = "<"+player.getDisplayName()+">"+message;
//
//        String FormedMessage = ChatFormat.messageFormat(player,message);
        System.out.println("(RC)"+message);

        int searchPlayerNumber = 0;
        for(Player worldPlayer : worldPlayers){
            if(worldPlayer.equals(player)){
                player.sendMessage(message);
            }else {
                Location worldPlayerLocation = worldPlayer.getLocation();
                if(playerDistance.isRangeIn(playerLocation,worldPlayerLocation,loadConfig.config.getInt("CanChatRange"))) {
                    worldPlayer.sendMessage(message);
                    searchPlayerNumber += 1;
                }
            }
        }

        if(searchPlayerNumber < 1 && loadConfig.config.getBoolean("NoPlayerChatRangeError")){
            player.sendMessage("[§aRC§r]§cメッセージを送信しましたが、付近にはプレイヤーがいませんでした。");
        }
    }

    public boolean AdminChatMode(AsyncPlayerChatEvent event){
//        LunaChatConfig config = LunaChat.getConfig();
        String message = event.getMessage();
        Player player = event.getPlayer();
//        List<String> NoGlobalList = loadConfig.getNoGlobalList();

        if(ModeManager.getReserveNoLimitTellMode(player)){
            return false;
        }

//        if(config.getGlobalMarker() != null &&
//                !config.getGlobalMarker().equals("") &&
//                message.startsWith(config.getGlobalMarker()) &&
//                message.length() > config.getGlobalMarker().length()){

            event.getPlayer().setDisplayName(event.getPlayer().getName() + " §a[GLOBAL]");

            String FormedMessage = message.substring(1);
            event.setMessage(FormedMessage);

            System.out.println("(RC)"+FormedMessage);
            return true;
//        };
        //if()
//        return false;
    }
}
