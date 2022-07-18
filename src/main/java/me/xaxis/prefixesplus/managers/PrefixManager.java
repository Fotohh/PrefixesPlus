package me.xaxis.prefixesplus.managers;

import me.xaxis.prefixesplus.PrefixesPlus;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PrefixManager {

    private final PrefixesPlus instance;

    Map<String, String> prefixes = new HashMap<>();

    Map<UUID, Boolean> hasPrefix = new HashMap<>();

    Map<UUID, String> prefix = new HashMap<>();

    public PrefixManager(PrefixesPlus instance){
        this.instance = instance;
    }

    public void loadPrefixes(){

        for(String sectionName : instance.getConfig().getConfigurationSection("Prefixes").getKeys(false)){

            ConfigurationSection prefixSection = instance.getConfig().getConfigurationSection("Prefixes").getConfigurationSection(sectionName);

            if(prefixSection == null) return;

            prefixes.put(prefixSection.getString("key"), prefixSection.getString("display"));

        }

    }

    public void setPrefix(UUID playerUUID, String value){
        if(prefix.containsKey(playerUUID)){
            prefix.replace(playerUUID, value);
        }else{
            prefix.put(playerUUID, value);
        }
    }

    public boolean hasPrefix(UUID playerUUID){
        return hasPrefix.get(playerUUID);
    }

    public String getPrefix(UUID playerUUID){

        if(hasPrefix(playerUUID)){

            return prefix.get(playerUUID);

        }

        return "";
    }

    public void setHasPrefix(UUID playerUUID, boolean value){
        if(hasPrefix.containsKey(playerUUID)){
            hasPrefix.replace(playerUUID, value);
        }else{
            hasPrefix.put(playerUUID, value);
        }
    }


    public Map<String, String> getPrefixes(){
        return prefixes;
    }

    public String getPrefix(String key){

        return prefixes.get(key);

    }



}
