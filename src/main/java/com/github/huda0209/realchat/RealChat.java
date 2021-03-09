package com.github.huda0209.realchat;

import com.github.ucchyocean.lc3.LunaChat;
import com.github.ucchyocean.lc3.LunaChatAPI;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class RealChat extends JavaPlugin implements CommandExecutor{

    final String PluginName = this.getDescription().getName();
    static LunaChatAPI lunachatapi;

    @Override
    public void onEnable() {

        if(getServer().getPluginManager().isPluginEnabled("LunaChat")){
            LunaChat lunachat = (LunaChat)getServer().getPluginManager().getPlugin("LunaChat");
            lunachatapi = lunachat.getAPI();
        }else{
            getLogger().warning("Can't load Lunachat. This plugin was disabled.");
            this.setEnabled(false);
        }

        this.saveConfig();
        
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
