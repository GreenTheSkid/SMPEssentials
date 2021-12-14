package com.green.smpessentials.smpessentials.smpessentials;

import com.green.smpessentials.smpessentials.smpessentials.Utilities.Color;
import com.green.smpessentials.smpessentials.smpessentials.commands.GamemodeCommands;
import com.green.smpessentials.smpessentials.smpessentials.commands.HealingCommands;
import com.green.smpessentials.smpessentials.smpessentials.commands.SpawnCommand;
import com.green.smpessentials.smpessentials.smpessentials.events.OpGuard;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;


public final class SMPEssentials extends JavaPlugin implements CommandExecutor {

    private SpawnCommand spawnCommand;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        spawnCommand = new SpawnCommand();
        getServer().getPluginManager().registerEvents(new OpGuard(), this);
        getCommand("setspawn");
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("gmc").setExecutor(new GamemodeCommands());
        getCommand("gms").setExecutor(new GamemodeCommands());
        getCommand("gmsp").setExecutor(new GamemodeCommands());
        getCommand("gma").setExecutor(new GamemodeCommands());
        getCommand("heal").setExecutor(new HealingCommands());
        getCommand("feed").setExecutor(new HealingCommands());
        getServer().getConsoleSender().sendMessage(Color.color("&a[SMPEssentials]: The plugin is enabled!"));
        this.getConfig().options().copyDefaults(true);

    }

    @Override
    public void onDisable() {
        spawnCommand.onDisable();
        getServer().getConsoleSender().sendMessage(Color.color("&c[SMPEssentials]: The plugin is disabled!"));
    }


}