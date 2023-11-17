package it.mauro.commandspy.commands;

import it.mauro.commandspy.CommandSpy;
import it.mauro.commandspy.api.FormatAPI;
import it.mauro.commandspy.api.SpyAPI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ToggleAlerts implements CommandExecutor {

    private final CommandSpy pl;

    private final SpyAPI spyAPI;

    public ToggleAlerts(CommandSpy pl, SpyAPI spyAPI) {
        this.pl = pl;
        this.spyAPI = spyAPI;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player player = (Player) commandSender;
        // Controllo se il giocatore ha il permesso, senno' mandiamo un messaggio.
        if(!player.hasPermission("unrealspy.alerts")) {
            player.sendMessage(FormatAPI.translate("&cYou can't execute that command!"));
        }

        // Controllo se gli args[0] ,quindi /spy <args[0]>, sono presenti, senno mandiamo un messaggio
        if(strings.length == 1 && strings[0].equalsIgnoreCase("alerts") && player.hasPermission("unrealspy.alerts")) {
            // Disabilitiamo gli alerts tramite un boolean.
            spyAPI.setSpyAlerts(!spyAPI.isSpyAlerts());

            player.sendMessage(ChatColor.DARK_PURPLE+"Spy alerts are now " + (spyAPI.isSpyAlerts() ? "enabled" : "disabled"));
        } else {
            player.sendMessage(FormatAPI.translate("&cUsage: /spy alerts"));
        }


        return false;
    }
}
