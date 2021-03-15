package com.github.huda0209.realchat.config;

import com.github.huda0209.realchat.RealChat;
import org.bukkit.configuration.Configuration;

public class loadConfig {

    public static Configuration config;

    public static void LoadConfigFile(RealChat realChat){
            try{
                config = realChat.getConfig();

            }catch (Exception exception){

                System.out.println("While load the config file, occurred error. Please check console.");
                //System.out.println(exception);
            }
    }
}