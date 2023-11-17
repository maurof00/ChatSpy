package it.mauro.commandspy.api;

import net.md_5.bungee.api.ChatColor;

public class FormatAPI {
    public static String translate(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
