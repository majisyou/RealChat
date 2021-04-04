package com.github.huda0209.realchat.listener;

import com.github.huda0209.realchat.RealChat;
import com.github.huda0209.realchat.util.playerDistance;
import com.github.huda0209.realchat.ModeManager;
import com.github.huda0209.realchat.config.loadConfig;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class tellCommandListener implements Listener {
    private RealChat plugin;

    public tellCommandListener(RealChat realChat){
        this.plugin = realChat;
    }

    @EventHandler
    public void tellCommandHandler(PlayerCommandPreprocessEvent event){

        String[] command = event.getMessage().substring(1).split(" ");

        if(!command[0].equalsIgnoreCase("tell")) return;
        if(command.length != 3) return;

        Player FromPlayer = event.getPlayer();
        Player toPlayer = this.plugin.getServer().getPlayer((command[1]));

        if(!(FromPlayer instanceof Player) || !(toPlayer instanceof Player)) return;

        if(FromPlayer.hasPermission("RealChat.SendNoLimitTell")) return;

        if(toPlayer.hasPermission("RealChat.ReserveNoLimitTell") &&
                ModeManager.getReserveNoLimitTellMode(toPlayer) &&
                !playerDistance.isRangeIn(FromPlayer.getLocation(), toPlayer.getLocation(), loadConfig.config.getInt("CanChatRange"))
        ) return;

        if(!playerDistance.isRangeIn(FromPlayer.getLocation(), toPlayer.getLocation(), loadConfig.config.getInt("CanChatRange"))){
            event.setCancelled(true);
            FromPlayer.sendMessage("[§aRC§r]§c範囲内に指定プレイヤーがいなかったため、コマンドの実行をキャンセルしました。");
            System.out.println("tell command cancelled.");
        }
    }
}
