package com.github.huda0209.realchat.listener;

import com.github.huda0209.realchat.RealChat;
import com.github.huda0209.realchat.util.playerDistance;
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

        System.out.println(FromPlayer.getName());
        System.out.println(toPlayer.getName());

        if(!(FromPlayer instanceof Player) || !(toPlayer instanceof Player)) return;

        if(!playerDistance.isRangeIn(FromPlayer.getLocation(),toPlayer.getLocation(),10)){
            event.setCancelled(false);
            FromPlayer.sendMessage("[§aRC§r]§c範囲内に指定プレイヤーがいなかったため、コマンドの実行をキャンセルしました。");
            System.out.println("tell command cancelled.");
        }
    }
}
