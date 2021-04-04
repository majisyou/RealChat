package com.github.huda0209.realchat;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class ModeManager{
    private static HashMap<Player, Boolean> playerAdminMode = new HashMap<>();
    private static HashMap<Player, Boolean> ReserveNoLimitTellMode = new HashMap<>();

    //Admin mode
    public static boolean getAdminMode(Player player){
        if(!playerAdminMode.containsKey(player)){
            return false;
        }
        return playerAdminMode.get(player);
    }

    public static void setAdminMode(Player player,Boolean bool){
        if(bool){
            playerAdminMode.put(player,true);
        }else{
            playerAdminMode.remove(player);
        }
    }


    //Reserve No Limit Tell Mode
    public static boolean getReserveNoLimitTellMode(Player player){
        if(!ReserveNoLimitTellMode.containsKey(player)){
            return true;
        }
        return ReserveNoLimitTellMode.get(player);
    }

    public static void setReserveNoLimitTellMode(Player player,Boolean bool){
        if(!bool){
            ReserveNoLimitTellMode.put(player,false);
        }else{
            ReserveNoLimitTellMode.remove(player);
        }
    }
    //true: tellの受信を受け付ける  false: tellの受信を拒否する
}