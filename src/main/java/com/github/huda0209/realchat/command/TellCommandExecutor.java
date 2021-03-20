package com.github.huda0209.realchat.command;

import com.github.huda0209.realchat.util.playerDistance;

import com.github.huda0209.realchat.RealChat;
import com.github.ucchyocean.lc3.Messages;
import com.github.ucchyocean.lc3.command.LunaChatMessageCommand;
import com.github.ucchyocean.lc3.member.ChannelMember;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TellCommandExecutor implements CommandExecutor{
    private RealChat plugin;

    public TellCommandExecutor(RealChat realChat){
        this.plugin = realChat;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        System.out.println("RC catch");

        Player invitePlayer = (Player)sender;
        Location invitePlayerLocation = invitePlayer.getLocation();

        Player invitedPlayer;
        Location invitedPlayerLocation;

        if(!command.getName().equals("tell")) return true;

        if (args.length == 0) {
            return false;
        }

        if (args.length >= 1) {
            String invitedName = args[0];
            invitedPlayer = plugin.getServer().getPlayer(invitedName);
            invitedPlayerLocation = invitedPlayer.getLocation();
        } else {
            sender.sendMessage(Messages.errmsgCommand());
            return true;
        }

        if(invitedPlayer == null){
            sender.sendMessage(Messages.errmsgNotfoundPlayer(invitedPlayer.getName()));
            return true;
        }

        if(!invitePlayer.getWorld().getPlayers().contains(invitedPlayer) ||
                playerDistance.isRangeIn(invitePlayerLocation,invitedPlayerLocation,10)){
            invitePlayer.sendMessage("[§aRC§r]§cダイレクトメッセージを実行しましたが、付近に該当プレイヤーがいなかった為、送信をキャンセルしました。");
            return true;
        }

        LunaChatMessageCommand messageCommand = new LunaChatMessageCommand();
        return messageCommand.execute(ChannelMember.getChannelMember(sender),label,args);
    }

}
