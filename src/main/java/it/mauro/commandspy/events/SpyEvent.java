package it.mauro.commandspy.events;

import it.mauro.commandspy.CommandSpy;
import it.mauro.commandspy.api.FormatAPI;
import it.mauro.commandspy.api.SpyAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class SpyEvent implements Listener {

    private final CommandSpy pl;

    private final SpyAPI spyAPI;

    public SpyEvent(CommandSpy pl, SpyAPI spyAPI) {
        this.pl = pl;
        this.spyAPI = spyAPI;
    }

    @EventHandler
    public void onCommandPreprocess(PlayerCommandPreprocessEvent e) {
        Player player = e.getPlayer();

        if(!player.hasPermission("unrealspy.bypass") && spyAPI.isSpyAlerts()) {
            for(Player onlineplayer : Bukkit.getOnlinePlayers()) {
                if(onlineplayer != player) {
                    onlineplayer.sendMessage(FormatAPI.translate("&e[CHAT-SPY] &8» &7{player}: &e%command%")
                                             .replaceAll("%command%", e.getMessage())
                                             .replace("{player}", player.getName()));
                }
            }
        }
    }
}
