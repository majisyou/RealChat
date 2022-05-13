package com.github.huda0209.realchat.util;

import com.github.huda0209.realchat.RealChat;
import org.bukkit.Location;

public class playerDistance {

    public static boolean isRangeIn(Location player,Location worldPlayer,int distance){
        double Dx = (worldPlayer.getX() - player.getX());
        double Dy = (worldPlayer.getY() - player.getY());
        double Dz = (worldPlayer.getZ() - player.getZ());

        double SquaredPlayerDistance = (Dx*Dx + Dy*Dy + Dz*Dz);
        RealChat.getInstance().getLogger().info(SquaredPlayerDistance+"の距離と"+(distance*distance)+"の距離");
        RealChat.getInstance().getLogger().info((SquaredPlayerDistance <= (distance*distance))+"の結果");
        return SquaredPlayerDistance <= (distance*distance);
    }
}
