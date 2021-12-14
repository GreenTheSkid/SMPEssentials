package com.green.smpessentials.smpessentials.smpessentials.commands;

import com.green.smpessentials.smpessentials.smpessentials.Utilities.Color;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class GamemodeCommands implements CommandExecutor {

    JavaPlugin plugin = JavaPlugin.getProvidingPlugin(SpawnCommand.class);
    FileConfiguration config = plugin.getConfig();
    String noperms = config.getString("noperms");

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("§4Only players can use this command!");
            return true;
        }


        if (cmd.getName().equalsIgnoreCase("gmc")) {
            if (!player.hasPermission("SMPEssentials.gmc")) {
                player.sendMessage(Color.color(config.getString("noperms")));
                return true;
            }
            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target == null) {
                    player.sendMessage(Color.color("&cThe target you have entered is null."));
                    return true;
                }
            }

            player.setGameMode(GameMode.CREATIVE);
            player.sendMessage(Color.color("&aGamemode updated!"));
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("gms")) {
            if (!player.hasPermission("SMPEssentials.gms")) {
                player.sendMessage(Color.color(config.getString("noperms")));
                return true;
            }
            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target == null) {
                    player.sendMessage(Color.color("&cThe target you have entered is null."));
                    return true;
                }
            }

            player.setGameMode(GameMode.SURVIVAL);
            player.sendMessage("§a§l(!) §aGamemode updated!");
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("gmsp")) {
            if (!player.hasPermission("SMPEssentials.gmsp")) {
                player.sendMessage(Color.color(config.getString("noperms")));
                return true;
            }
            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target == null) {
                    player.sendMessage(Color.color("&cThe target you have entered is null."));
                    return true;
                }
            }

            player.setGameMode(GameMode.SPECTATOR);
            player.sendMessage(Color.color("&aGamemode updated!"));
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("gma")) {
            if (!player.hasPermission("SMPEssentials.gma")) {
                player.sendMessage(Color.color(config.getString("noperms")));
                return true;
            }
            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target == null) {
                    player.sendMessage(Color.color("&cThe target you have entered is null."));
                    return true;
                }
            }

            player.setGameMode(GameMode.ADVENTURE);
            player.sendMessage(Color.color("&aGamemode updated!"));
            return true;
        }
        return true;
    }


    }

