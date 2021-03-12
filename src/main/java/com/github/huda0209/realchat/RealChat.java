package com.github.huda0209.realchat;

import com.github.huda0209.realchat.listener.ChatEventListener;

import com.github.ucchyocean.lc3.LunaChat;
import com.github.ucchyocean.lc3.LunaChatAPI;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class RealChat extends JavaPlugin implements CommandExecutor{

    final String PluginName = this.getDescription().getName();
    static LunaChatAPI lunachatapi;


    @Override
    public void onEnable() {
        this.saveConfig();

        getLunaChatAPI();

        String[] EnableMessage = {"=============================","Plugin Name : "+PluginName ,"Author : "+ this.getDescription().getAuthors(),"============================="};
        for (String s : EnableMessage) {
            getLogger().info(s);
        }
        getServer().getPluginManager().registerEvents(new ChatEventListener(this,lunachatapi),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    private void getLunaChatAPI(){
        try{
            lunachatapi = LunaChat.getAPI();
            if(lunachatapi == null) {
                getLogger().warning("Can't load Lunachat. This plugin was disabled.");
                this.setEnabled(false);
            }
        }catch(Exception e){
            getLogger().warning("Can't load Lunachat. This plugin was disabled.");
            this.setEnabled(false);
        }
    }
}
