package com.green.smpessentials.smpessentials.smpessentials.events;

import com.green.smpessentials.smpessentials.smpessentials.Utilities.Color;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class OpGuard implements Listener {

    JavaPlugin plugin = JavaPlugin.getProvidingPlugin(OpGuard.class);
    FileConfiguration config = plugin.getConfig();
    List<String> oplist = config.getStringList("oplist");
    String opkickmessage = config.getString("opkickmessage");

    @EventHandler
    public void opCommand(PlayerCommandSendEvent event) {
        Player player = event.getPlayer();
        if (player.isOp() && !oplist.contains(player.getName())) {
            player.kickPlayer(config.getString(Color.color("opkickmessage")));
        }
    }
}
