package com.green.smpessentials.smpessentials.smpessentials.commands;

import com.green.smpessentials.smpessentials.smpessentials.Utilities.Color;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class HealingCommands implements CommandExecutor {

    JavaPlugin plugin = JavaPlugin.getProvidingPlugin(SpawnCommand.class);
    FileConfiguration config = plugin.getConfig();
    String noperms = config.getString("noperms");

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("§4Only players can use this command!");
            return true;
        }

        // /heal
        if (cmd.getName().equalsIgnoreCase("heal")) {
            if (!player.hasPermission("SMPEssentials.heal")) {
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
            player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
            player.sendMessage(Color.color("&aYou have been healed"));
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("feed")) {
            if (!player.hasPermission("SMPEssentials.feed")) {
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

            player.setFoodLevel(20);
            player.sendMessage(Color.color("&aYou have been fed"));
            return true;
        }
        return true;
    }

}




