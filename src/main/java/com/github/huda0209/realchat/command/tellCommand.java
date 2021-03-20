package com.github.huda0209.realchat.command;

import com.github.huda0209.realchat.RealChat;
import com.github.ucchyocean.lc3.LunaChat;
import com.github.ucchyocean.lc3.LunaChatAPI;
import com.github.ucchyocean.lc3.bukkit.event.LunaChatBukkitPreChatEvent;
import com.github.ucchyocean.lc3.member.ChannelMember;
import com.github.ucchyocean.lc3.util.ClickableFormat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class tellCommand implements Listener {
    private RealChat plugin;

    public tellCommand(RealChat realChat){
        this.plugin = realChat;
    }



    @EventHandler
    public void onChat(LunaChatBukkitPreChatEvent event){
        Player sender = null;
        LunaChatAPI api = LunaChat.getAPI();
        System.out.println("chatEvent");

        for(Player player : plugin.getServer().getOnlinePlayers()){
            if(player.getName().equals(event.getMember().getName())){
                sender = player;
                System.out.println("tell??");
            }
        }
        if(sender != null){
        }
    }
}
