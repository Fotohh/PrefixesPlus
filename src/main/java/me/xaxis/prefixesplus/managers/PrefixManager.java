package me.xaxis.prefixesplus.managers;

import me.xaxis.prefixesplus.PrefixesPlus;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.Map;

public class PrefixManager {

    private final PrefixesPlus instance;

    Map<String, String> prefixes = new HashMap<>();

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

    public Map<String, String> getPrefixes(){
        return prefixes;
    }

    public String getPrefix(String key){

        return prefixes.get(key);

    }



}
