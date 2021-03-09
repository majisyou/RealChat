package com.github.huda0209.realchat.util;

import org.bukkit.Location;

public class playerDistance {

    public static boolean isRangeIn(Location player,Location worldPlayer,int distance){
        double Dx = (worldPlayer.getX() - player.getX());
        double Dy = (worldPlayer.getY() - player.getY());
        double Dz = (worldPlayer.getZ() - player.getZ());

        double SquaredPlayerDistance = (Dx*Dx + Dy*Dy + Dz*Dz);

        return SquaredPlayerDistance <= distance;
    }






}
