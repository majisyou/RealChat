package com.github.huda0209.realchat.command;

import com.github.huda0209.realchat.RealChat;

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

        if(args.length == 0) return false;

        switch (args[0].toLowerCase(Locale.ROOT)){
            //AdminMode
            case "adminmode" :
                if(!sender.hasPermission("RealChat.AdminMode")){
                    sender.sendMessage("§9[" + plugin.getDescription().getName() + "]§c You don't have permission!");
                    return true;
                }
                ModeChange.AdminModeChanger((Player) sender);
                break;

            //ReserveNLTell(ReserveNoLimitTell)
            //change ReserveNoLimitTell mode
            case "reservenltell" :
                if(!sender.hasPermission("RealChat.ReserveNoLimitTellMode")){
                    sender.sendMessage("§9[" + plugin.getDescription().getName() + "]§c You don't have permission!");
                    return true;
                }
                ModeChange.ReserveNoLimitTellModeChanger((Player) sender);
                break;

            //reload RealChat config file
            case "reload":
                if(!sender.hasPermission("RealChat.Reload")){
                    sender.sendMessage("§9[" + plugin.getDescription().getName() + "]§c You don't have permission!");
                    break;
                }
                reloadConfig.Reload(sender,plugin);
                break;

            //reloadALL
            //reload config file, RealChat and LunaChat
            case "reloadall":
                if(!(sender.hasPermission("RealChat.Reload") && sender.hasPermission("lunachat-admin.reload"))){
                    sender.sendMessage("§9[" + plugin.getDescription().getName() + "]§c You don't have permission!");
                    break;
                }
                reloadConfig.ReloadAll(sender,plugin);
                break;

            default:
                sender.sendMessage("§9[" + plugin.getDescription().getName() + "]§c Unknown command.");
                break;
        }
        return true;
    }
}
