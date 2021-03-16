package com.github.huda0209.realchat.command;

import com.github.huda0209.realchat.RealChat;
import com.github.huda0209.realchat.config.loadConfig;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class reloadConfig {
    public static void Reload(CommandSender sender, RealChat plugin){
        try {
            loadConfig.LoadConfigFile(plugin);

            if(sender instanceof Player) sender.sendMessage("§9[" + plugin.getDescription().getName() + "]§a Reload the config file.");
            System.out.println("Reload the config file.");

        }catch(Exception e){
            if(sender instanceof Player) sender.sendMessage("§9[" + plugin.getDescription().getName() + "]§c While reload the config file, occurred error. Please check console.");
            System.out.println("While reload the config file, occurred error.");
            System.out.println(e.toString());
        }
    }

    public static void ReloadAll(CommandSender sender,RealChat plugin){
        try {
            loadConfig.LoadConfigFile(plugin);
            plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "lc reload");

            if(sender instanceof Player) sender.sendMessage("§9[" + plugin.getDescription().getName() + "]§a Reload RealChat and LunaChat plugin's config file.");
            System.out.println("Reload RealChat and LunaChat plugin's config file.");

        }catch(Exception e){
            if(sender instanceof Player) sender.sendMessage("§9[" + plugin.getDescription().getName() + "]§c While reload the config file, occurred error. Please check console.");
            System.out.println("While reload the config file, occurred error.");
            System.out.println(e.toString());
        }
    }
}