package bangui.bangui;

import bangui.bangui.commands.*;
import bangui.bangui.commands.NightVisionCommands.clearnvCommand;
import bangui.bangui.commands.NightVisionCommands.nvCommand;
import bangui.bangui.events.JoinEventVanish;
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
import bangui.bangui.utils.tabCompletes.staffChatCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public final class BanGUI extends JavaPlugin {

    private static BanGUI plugin;
    public ArrayList<Player> invisibleList = new ArrayList<>();

    @Override
    public void onEnable() {

        plugin = this;

        // Plugin startup logic
        getCommand("Staff").setExecutor(new StaffGUICommand());
        getCommand("report").setExecutor(new ReportCommand());
        getCommand("nv").setExecutor(new nvCommand());
        getCommand("clearnv").setExecutor(new clearnvCommand());
        getCommand("lockdown").setExecutor(new LockdownCommand());
        getCommand("bgreload").setExecutor(new reloadCommand());
        getCommand("banGUI").setExecutor(new banCommand());
        getCommand("kickGUI").setExecutor(new kickCommand());
        getCommand("sc").setExecutor(new staffChat());
        getCommand("sc").setTabCompleter(new staffChatCompleter());
        getCommand("vanish").setExecutor(new vanishCommand(this));


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
        getServer().getPluginManager().registerEvents(new LockdownCommand(), this);
        getServer().getPluginManager().registerEvents(new JoinEventVanish(this), this);

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        CustomConfig.setup();
        CustomConfig.get().addDefault("Please put your discord invite link below", "e.g https://discord.gg/pQbQcQ6y");
        CustomConfig.get().addDefault("Discord Server Invite", "");
        CustomConfig.get().addDefault("Please put a link to a place where users can find the rules to your server" ,"e.g https://myserver.org/rules");
        CustomConfig.get().addDefault("Understand that this can also be a discord invite link", "like the previous setting");
        CustomConfig.get().addDefault("Rules Link", "");
        CustomConfig.get().addDefault("Please put a link to a place where users can appeal a ban on your server" ,"e.g https://myserver.org/appeal");
        CustomConfig.get().addDefault("Understand that this can also be a discord invite link", "like the previous setting");
        CustomConfig.get().addDefault("Appeal Link", "");
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
