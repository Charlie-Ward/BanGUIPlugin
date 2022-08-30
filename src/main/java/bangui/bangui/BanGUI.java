package bangui.bangui;

import bangui.bangui.commands.BanGUICommand;
import bangui.bangui.commands.HelpCommand;
import bangui.bangui.listeners.BanInventoryListener;
import bangui.bangui.listeners.BanReasonListener;
import bangui.bangui.listeners.BanTimeListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class BanGUI extends JavaPlugin {

    private static BanGUI plugin;

    @Override
    public void onEnable() {

        plugin = this;

        // Plugin startup logic
        getCommand("bangui").setExecutor(new BanGUICommand());
        getCommand("BGhelp").setExecutor(new HelpCommand());

        getServer().getPluginManager().registerEvents(new BanInventoryListener(), this);
        getServer().getPluginManager().registerEvents(new BanReasonListener(), this);
        getServer().getPluginManager().registerEvents(new BanTimeListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static BanGUI getPlugin(){
        return plugin;
    }

}
