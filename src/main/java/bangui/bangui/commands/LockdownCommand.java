package bangui.bangui.commands;

import bangui.bangui.BanGUI;
import bangui.bangui.files.CustomConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Date;

public class LockdownCommand implements CommandExecutor, Listener {


    BanGUI plugin;

    public LockdownCommand(BanGUI plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (sender instanceof Player){
            if (player.hasPermission("bangui.lockdown")){
                Date startOfLockdown = new Date();
                if(plugin.lockdown == false){
                    plugin.lockdown = true;
                    for (Player all : Bukkit.getOnlinePlayers()){
                        if(all.hasPermission("bangui.LogInDuringLockdown")){
                            all.sendMessage(ChatColor.RED + "[BanGUI]");
                            all.sendMessage(ChatColor.RED + "A LOCKDOWN HAS BEEN ENABLED");
                            all.sendMessage(ChatColor.WHITE + "Info:");
                            all.sendMessage(ChatColor.RED + "   Enabled by " + ChatColor.WHITE + player.getDisplayName());
                            all.sendMessage(ChatColor.RED + "   At: " + ChatColor.WHITE + startOfLockdown);
                        }else{
                            all.kickPlayer("A lockdown has started on this server. Please stand by for more information. " + CustomConfig.get().getString("Discord Server Invite"));
                        }
                    }
                }else{
                    plugin.lockdown = false;
                    for (Player all : Bukkit.getOnlinePlayers()){
                        if(all.hasPermission("bangui.LogInDuringLockdown")){
                            all.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.RED + "Lockdown has been disabled");
                            all.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.RED + "Players can join back to the server");
                        }
                    }
                }
            }else{
                player.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.RED + "You do not have correct permissions to use this feature");
            }
        }else {
            player.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.RED + "This command is only available for players");
        }

        return true;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if(plugin.lockdown == true){
            if (!(event.getPlayer().hasPermission("bangui.LogInDuringLockdown"))) {
                event.getPlayer().kickPlayer("A lockdown is currently in progress on this server. Please stand by for more information. " + CustomConfig.get().getString("Discord Server Invite"));
            }else{
                event.getPlayer().sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.RED + "A lockdown is currently active. No unauthorised players are able to join");
            }
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        if(plugin.lockdown == true){
            e.setQuitMessage("");
        }
    }

}
