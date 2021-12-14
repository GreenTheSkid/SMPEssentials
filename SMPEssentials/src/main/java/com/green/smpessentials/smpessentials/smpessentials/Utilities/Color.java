package com.green.smpessentials.smpessentials.smpessentials.Utilities;

import org.bukkit.ChatColor;

public class Color {
    public static String color(String s) {
        return s != null ? ChatColor.translateAlternateColorCodes('&',s) : null;
    }
}
