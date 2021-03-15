package com.github.huda0209.realchat.command;

import com.github.huda0209.realchat.RealChat;
import com.github.huda0209.realchat.config.loadConfig;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Locale;

public class CommandHandler implements CommandExecutor {
    private RealChat plugin;

    public CommandHandler(RealChat realChat){
        this.plugin = realChat;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        Player player = (Player)sender;

        switch (args[0].toLowerCase(Locale.ROOT)){
            case "mode" :

                break;

            //reload RealChat config file
            case "reload":
                if(!sender.hasPermission("RealChat.Reload")){
                    player.sendMessage("§9[" + plugin.getDescription().getName() + "]§c You don't have permission!");
                    return true;
                }
                try {
                    loadConfig.LoadConfigFile(plugin);

                    player.sendMessage("§9[" + plugin.getDescription().getName() + "]§a Reload the config file.");
                    System.out.println("Reload the config file.");

                }catch(Exception e){
                    player.sendMessage("§9[" + plugin.getDescription().getName() + "]§c While reload the config file, occurred error. Please check console.");
                    System.out.println("While reload the config file, occurred error.");
                    System.out.println(e.toString());
                }
                break;

            //reload config file, RealChat and LunaChat
            case "reloadall":
                if(!(sender.hasPermission("RealChat.Reload") && sender.hasPermission("lunachat-admin.reload"))){
                    player.sendMessage("§9[" + plugin.getDescription().getName() + "]§c You don't have permission!");
                    return true;
                }
                try {
                    loadConfig.LoadConfigFile(plugin);
                    plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "lc reload");

                    player.sendMessage("§9[" + plugin.getDescription().getName() + "]§a Reload RealChat and LunaChat plugin's config file.");
                    System.out.println("Reload RealChat and LunaChat plugin's config file.");

                }catch(Exception e){
                    player.sendMessage("§9[" + plugin.getDescription().getName() + "]§c While reload the config file, occurred error. Please check console.");
                    System.out.println("While reload the config file, occurred error.");
                    System.out.println(e.toString());
                }
                break;

            default:
                player.sendMessage("§9[" + plugin.getDescription().getName() + "]§c Unknown command.");
                break;
        }
        return true;
    }
}
