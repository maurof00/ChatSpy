package it.mauro.commandspy;

import it.mauro.commandspy.api.SpyAPI;
import it.mauro.commandspy.commands.ToggleAlerts;
import it.mauro.commandspy.events.SpyEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class CommandSpy extends JavaPlugin {

    private SpyAPI spyAPI;

    @Override
    public void onEnable() {
        spyAPI = new SpyAPI();
        commands();
        events();
    }

    @Override
    public void onDisable() {
    }

    private void commands() {
        getCommand("spy").setExecutor(new ToggleAlerts(this, spyAPI));
    }

    private void events() {
        getServer().getPluginManager().registerEvents(new SpyEvent(this, spyAPI), this);
    }
}
