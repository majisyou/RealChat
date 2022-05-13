package com.github.huda0209.realchat.config;

import com.github.huda0209.realchat.RealChat;
import org.bukkit.configuration.Configuration;

import java.util.List;

public class loadConfig {

    public static Configuration config;
//    private static List<String> NoGlobalList;

    public static void LoadConfigFile(RealChat realChat){
            try{
                config = realChat.getConfig();

            }catch (Exception exception){

                System.out.println("While load the config file, occurred error. Please check console.");
                //System.out.println(exception);
            }
    }

//    public static void Load(RealChat realChat){
//        if(config == null){
//            LoadConfigFile(realChat);
//        }
//        if(config != null){
//            NoGlobalList = config.getStringList("NoGlobalList");
//        }
//    }
//
//    public static List<String> getNoGlobalList(){return NoGlobalList;}

}