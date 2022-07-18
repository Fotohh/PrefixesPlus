package me.xaxis.prefixesplus;

import me.xaxis.prefixesplus.commands.PrefixCommand;
import me.xaxis.prefixesplus.managers.PrefixManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PrefixesPlus extends JavaPlugin {

    PrefixManager manager;

    @Override
    public void onEnable() {

        getCommand("prefix").setExecutor(new PrefixCommand(this, manager));
        manager = new PrefixManager(this);
        manager.loadPrefixes();
        saveDefaultConfig();

    }
}
