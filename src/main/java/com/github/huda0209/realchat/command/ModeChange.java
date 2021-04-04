package com.github.huda0209.realchat.command;

import com.github.huda0209.realchat.ModeManager;
import org.bukkit.entity.Player;

public class ModeChange{
    public static void AdminModeChanger(Player player){
        if(!ModeManager.getAdminMode(player)){
            ModeManager.setAdminMode(player,true);
            player.sendMessage("[§aRC§r]§a admin mode was enable.");
        }else{
            ModeManager.setAdminMode(player,false);
            player.sendMessage("[§aRC§r]§c admin mode was disable.");
        }
    }

    public static void ReserveNoLimitTellModeChanger(Player player){
        if(!ModeManager.getReserveNoLimitTellMode(player)){
            ModeManager.setReserveNoLimitTellMode(player,true);
            player.sendMessage("[§aRC§r]§a Reserve No Limit Tell mode was enable.");
        }else{
            ModeManager.setReserveNoLimitTellMode(player,false);
            player.sendMessage("[§aRC§r]§c Reserve No Limit Tell mode was disable.");
        }
    }
}
