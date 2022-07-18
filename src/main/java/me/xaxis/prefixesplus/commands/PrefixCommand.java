package me.xaxis.prefixesplus.commands;

import me.xaxis.prefixesplus.Lang;
import me.xaxis.prefixesplus.Permission;
import me.xaxis.prefixesplus.PrefixesPlus;
import me.xaxis.prefixesplus.managers.PrefixManager;
import me.xaxis.prefixesplus.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("DuplicatedCode")
public class PrefixCommand implements CommandExecutor {

    private final PrefixesPlus instance;
    private final PrefixManager manager;

    public PrefixCommand(PrefixesPlus instance, PrefixManager manager) {
        this.instance = instance;
        this.manager = manager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player player) {

            if(args.length >= 1) {

                if (args[0].equalsIgnoreCase("list")) {

                    player.sendMessage(Utils.chat("&aList of available prefixes:"));

                    for (String keys : manager.getPrefixes().keySet()) {

                        player.sendMessage(Utils.chat(keys + ": " + manager.getPrefix(keys)));

                    }

                    return true;

                }

            }

            if (args.length >= 2) {

                if (args[0].equalsIgnoreCase("set") && player.hasPermission(Permission.SET_PREFIX.string(instance)) || args[0].equalsIgnoreCase("set") && player.hasPermission(Permission.ADMIN.string(instance))) {

                    Player other = Bukkit.getServer().getPlayer(args[1]);

                    if (other == null) {

                        player.sendMessage(Utils.chat(Lang.PLAYER_INVALID.string(instance)));

                        return true;

                    }

                    String prefix_name = args[2];

                    if (!manager.getPrefixes().containsKey(prefix_name)) {

                        return true;
                    }

                    other.setDisplayName(Utils.chat(manager.getPrefix(prefix_name) + " " + other.getName()));

                    other.setPlayerListName(Utils.chat(manager.getPrefix(prefix_name) + " " + other.getName()));

                    manager.setHasPrefix(player.getUniqueId(), true);

                    manager.setPrefix(player.getUniqueId(), manager.getPrefix(prefix_name));

                    player.sendMessage(Utils.chat("&aSuccessfully set " + other.getDisplayName() + "'s prefix!"));

                    return true;
                }

                if (args[0].equalsIgnoreCase("remove") && player.hasPermission(Permission.REMOVE_PREFIX.string(instance)) || args[0].equalsIgnoreCase("remove") && player.hasPermission(Permission.ADMIN.string(instance))) {

                    Player other = Bukkit.getServer().getPlayer(args[1]);

                    if (other == null) {
                        player.sendMessage(Utils.chat(Lang.PLAYER_INVALID.string(instance)));
                        return true;
                    }

                    if(!manager.hasPrefix(other.getUniqueId())){
                        player.sendMessage(Utils.chat("&4This player does not have a prefix set!"));
                        return true;
                    }

                    other.setDisplayName(Utils.chat(other.getName()));

                    other.setPlayerListName(Utils.chat(other.getName()));

                    manager.setHasPrefix(player.getUniqueId(), false);

                    player.sendMessage(Utils.chat("&aSuccessfully removed " + other.getDisplayName() + "'s prefix!"));

                    return true;
                }

            } else {

                player.sendMessage(Utils.chat("&4Invalid arguments!\n/prefix [set|remove] <player> <type>"));

                return true;

            }

        }else{

            sender.sendMessage(Utils.chat(Lang.SENDER_NOT_PLAYER.string(instance)));

        }

        return true;
    }
}
