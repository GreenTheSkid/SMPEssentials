package com.green.smpessentials.smpessentials.smpessentials.commands;

import com.green.smpessentials.smpessentials.smpessentials.Utilities.Color;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class SpawnCommand implements CommandExecutor {

    public SpawnCommand() {
        plugin.getCommand("setspawn").setExecutor(this);
        Location loc = config.getLocation("spawncoords");
        this.spawnLocation = (loc == null) ? new Location(Bukkit.getWorld("world"),0,0,0) : loc;
        if (this.spawnLocation != loc) save();
    }

    void save() {
        config.set("spawncoords",this.spawnLocation);
        plugin.saveConfig();
    }
    //Initialization ^^
    public void onDisable() {
        save();
    }
    //Saving cache to disk ^^

    JavaPlugin plugin = JavaPlugin.getProvidingPlugin(SpawnCommand.class);
    FileConfiguration config = plugin.getConfig();
    List<Float> spawncoords = config.getFloatList("spawncoords");
    String noperms = config.getString("noperms");
    private Location spawnLocation;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("§4Only players can use this command!");
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("setspawn")) {
            if (!(player.hasPermission("SMPEssentials.Setspawn"))) {
                player.sendMessage(config.getString("noperms"));
                return true;
            }
            spawnLocation = player.getLocation();
            player.sendMessage(Color.color("&aSpawn location set!"));
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("spawn")) {
            if (!(player.hasPermission("SMPEssentials.spawn"))) {
                player.sendMessage(config.getString("noperms"));
                return true;
            }

            player.teleport(spawnLocation);
            player.sendMessage(Color.color("&aYou have been teleported to spawn!"));
            return true;
        }
        return true;
    }
}