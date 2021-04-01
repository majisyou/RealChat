package com.github.huda0209.realchat;

import com.github.huda0209.realchat.command.CommandHandler;
import com.github.huda0209.realchat.listener.ChatEventListener;
import com.github.huda0209.realchat.config.loadConfig;

import com.github.huda0209.realchat.listener.tellCommandListener;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class RealChat extends JavaPlugin implements CommandExecutor{

    final String PluginName = this.getDescription().getName();

    @Override
    public void onEnable(){
        this.saveDefaultConfig();

        loadConfig.LoadConfigFile(this);
        if(!SetMode()) return;

        String[] EnableMessage = {"=============================","Plugin Name : "+PluginName ,"Author : "+ this.getDescription().getAuthors(),"============================="};
        for (String s : EnableMessage) {
            getLogger().info(s);
        }

        getServer().getPluginManager().registerEvents(new ChatEventListener(this),this);
        getServer().getPluginManager().registerEvents(new tellCommandListener(this),this);
        getCommand("realchat").setExecutor(new CommandHandler(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public void logger(String msg){
        getLogger().info(msg);
    }

    public boolean SetMode(){
        if(!loadConfig.config.getBoolean("PluginMode")){
            getLogger().info("Plugin mode was false. So this plguin was disable.");
            this.setEnabled(false);
            return false;
        }
        return true;
    }
}
