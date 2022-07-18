package me.xaxis.prefixesplus.listeners;

import me.xaxis.prefixesplus.managers.PrefixManager;
import me.xaxis.prefixesplus.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.jetbrains.annotations.NotNull;

public class AsyncChat implements Listener {

    private final PrefixManager manager;

    public AsyncChat(PrefixManager manager){
        this.manager = manager;
    }

    @EventHandler
    public void onChat(@NotNull AsyncPlayerChatEvent e){

        Player player = e.getPlayer();

        if(!manager.hasPrefix(player.getUniqueId())) return;

        String a = e.getMessage().replace("<", "");
        String b = a.replace(">", "");
        String result = Utils.chat(b);

        e.setMessage(result);

    }

}
