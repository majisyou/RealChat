package com.github.huda0209.realchat.listener;

import com.github.huda0209.realchat.RealChat;

import com.github.ucchyocean.lc3.LunaChatAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class ChatEventListener implements Listener {
    private final RealChat plugin;
    private final LunaChatAPI lunaChatAPI;

    public ChatEventListener(RealChat realChat, LunaChatAPI lcAPI){
        this.plugin = realChat;
        this.lunaChatAPI = lcAPI;
    }

    @EventHandler
    public void ChatEvent(AsyncPlayerChatEvent event){



    }
}
