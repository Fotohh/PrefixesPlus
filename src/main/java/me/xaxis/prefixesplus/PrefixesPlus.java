package me.xaxis.prefixesplus;

import me.xaxis.prefixesplus.commands.PrefixCommand;
import me.xaxis.prefixesplus.listeners.AsyncChat;
import me.xaxis.prefixesplus.managers.PrefixManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PrefixesPlus extends JavaPlugin {

    PrefixManager manager;

    @Override
    public void onEnable() {

        manager = new PrefixManager(this);
        manager.loadPrefixes();

        getCommand("prefix").setExecutor(new PrefixCommand(this, manager));
        getServer().getPluginManager().registerEvents(new AsyncChat(manager), this);
        saveDefaultConfig();

    }
}
