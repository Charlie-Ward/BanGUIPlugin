package bangui.bangui;

import bangui.bangui.commands.*;
import bangui.bangui.commands.NightVisionCommands.clearnvCommand;
import bangui.bangui.commands.NightVisionCommands.nvCommand;
import bangui.bangui.commands.gamemodeCommands.gmaCommand;
import bangui.bangui.commands.gamemodeCommands.gmcCommand;
import bangui.bangui.commands.gamemodeCommands.gmsCommand;
import bangui.bangui.commands.gamemodeCommands.gmspCommand;
import bangui.bangui.files.CustomConfig;
import bangui.bangui.listeners.*;
import bangui.bangui.listeners.BanListeners.BanInventoryListener;
import bangui.bangui.listeners.BanListeners.BanReasonListener;
import bangui.bangui.listeners.BanListeners.BanTimeListener;
import bangui.bangui.listeners.KickListeners.KickInventoryListener;
import bangui.bangui.listeners.OnlineplayersListeners.OnlinePlayersListener;
import bangui.bangui.listeners.OnlineplayersListeners.OnlineStaffListener;
import bangui.bangui.listeners.ReportListeners.ReportConfirmListener;
import bangui.bangui.listeners.ReportListeners.ReportReasonListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class BanGUI extends JavaPlugin {

    private static BanGUI plugin;

    @Override
    public void onEnable() {

        plugin = this;

        // Plugin startup logic
        getCommand("Staff").setExecutor(new StaffGUICommand());
        getCommand("onlineplayers").setExecutor(new OnlinePlayersCommand());
        getCommand("checktopplayers").setExecutor(new CheckTopPlayers());
        getCommand("report").setExecutor(new ReportCommand());
        getCommand("gmc").setExecutor(new gmcCommand());
        getCommand("gma").setExecutor(new gmaCommand());
        getCommand("gms").setExecutor(new gmsCommand());
        getCommand("gmsp").setExecutor(new gmspCommand());
        getCommand("nv").setExecutor(new nvCommand());
        getCommand("clearnv").setExecutor(new clearnvCommand());

        getServer().getPluginManager().registerEvents(new BanInventoryListener(), this);
        getServer().getPluginManager().registerEvents(new BanReasonListener(), this);
        getServer().getPluginManager().registerEvents(new BanTimeListener(), this);
        getServer().getPluginManager().registerEvents(new StaffMenuListener(), this);
        getServer().getPluginManager().registerEvents(new OnlinePlayersListener(), this);
        getServer().getPluginManager().registerEvents(new TeleportListener(), this);
        getServer().getPluginManager().registerEvents(new KickInventoryListener(), this);
        getServer().getPluginManager().registerEvents(new OnlineStaffListener(), this);
        getServer().getPluginManager().registerEvents(new ReportReasonListener(), this);
        getServer().getPluginManager().registerEvents(new ReportConfirmListener(), this);

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
