package bangui.bangui;

import bangui.bangui.commands.*;
import bangui.bangui.files.CustomConfig;
import bangui.bangui.listeners.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class BanGUI extends JavaPlugin {

    private static BanGUI plugin;

    @Override
    public void onEnable() {

        plugin = this;

        // Plugin startup logic
        getCommand("bangui").setExecutor(new BanGUICommand());
        getCommand("BGhelp").setExecutor(new HelpCommand());
        getCommand("Staff").setExecutor(new StaffGUICommand());
        getCommand("onlineplayers").setExecutor(new OnlinePlayersCommand());
        getCommand("checktopplayers").setExecutor(new CheckTopPlayers());

        getServer().getPluginManager().registerEvents(new BanInventoryListener(), this);
        getServer().getPluginManager().registerEvents(new BanReasonListener(), this);
        getServer().getPluginManager().registerEvents(new BanTimeListener(), this);
        getServer().getPluginManager().registerEvents(new StaffMenuListener(), this);
        getServer().getPluginManager().registerEvents(new OnlinePlayersListener(), this);
        getServer().getPluginManager().registerEvents(new TeleportListener(), this);
        getServer().getPluginManager().registerEvents(new KickInventoryListener(), this);
        getServer().getPluginManager().registerEvents(new OnlineStaffListener(), this);

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        CustomConfig.setup();
        CustomConfig.get().addDefault("Please seperate all players with a comma", "e.g Owner Players:LousyBoi,LousyAlt,LousyTwo");
        CustomConfig.get().addDefault("Owner Players", "");
        CustomConfig.get().options().copyDefaults(true);
        CustomConfig.save();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static BanGUI getPlugin(){
        return plugin;
    }

}
