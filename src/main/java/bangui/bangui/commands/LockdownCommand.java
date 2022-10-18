package bangui.bangui.commands;

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

import java.util.Date;

public class LockdownCommand implements CommandExecutor, Listener {

    public static boolean lockdown;

    Date timeOfLockdown;
    Player p;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

            if (sender instanceof Player) {

                p = (Player) sender;
                timeOfLockdown = new Date(System.currentTimeMillis());

                if (p.hasPermission("bangui.lockdown")) {

                    if (lockdown == false) {

                        p.sendMessage(ChatColor.RED + "LOCKDOWN HAS BEEN ENABLED");
                        p.sendMessage(ChatColor.WHITE + "All players without lockdown permissions have been kicked and will not be able to join until lockdown is disabled");
                        lockdown = true;

                        for (Player all : Bukkit.getServer().getOnlinePlayers()) {

                            if (all.hasPermission("bangui.LogInDuringLockdown")) {

                                if (all.getDisplayName() != p.getDisplayName()) {

                                    all.sendMessage(ChatColor.RED + "A LOCKDOWN HAS BEEN ENABLED");
                                    all.sendMessage(ChatColor.WHITE + "Please talk to " + p.getDisplayName() + " to find out why");
                                    all.sendMessage(ChatColor.WHITE + "It was enabled at: " + timeOfLockdown + " by: " + p.getDisplayName());
                                }
                            } else {

                                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                                String commandKick = (" " + ChatColor.RED + " A lockdown has just started on this server." + ChatColor.WHITE + " Please stand by for more information " + CustomConfig.get().getString("Discord Server Invite"));
                                String kickCommand = "kick " + all.getDisplayName() + commandKick;
                                Bukkit.dispatchCommand(console, kickCommand);

                            }

                        }

                        System.out.println("The lockdown variable is set to " + lockdown);

                    } else if (lockdown  == true) {

                        p.sendMessage(ChatColor.RED + "LOCKDOWN HAS BEEN DISABLED");
                        p.sendMessage(ChatColor.RED + "Please restart the server to allow players to rejoin");
                        lockdown = false;

                        for (Player all : Bukkit.getServer().getOnlinePlayers()) {

                            if (all.getDisplayName() != p.getDisplayName()) {

                                all.sendMessage(ChatColor.RED + "A LOCKDOWN HAS BEEN DISABLED");
                                all.sendMessage(ChatColor.WHITE + "Please restart the server to allow players to rejoin");
                            }

                        }

                    }

                }

            }

        System.out.println("Lockdown is now set to " + lockdown);
            boolean lockdownState;
            if (lockdown == true){
                lockdownState = true;
            }else{
                lockdownState = false;
            }


        return true;
    }

    public class LockDownState{
        public static boolean LockdownStateVar = lockdown;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        class LockDownKickState{
            public static boolean LockdownKickState = lockdown;
        }

        Player player = e.getPlayer();
        boolean kickLockdown = LockDownKickState.LockdownKickState;


        System.out.println("Player has joined");
        System.out.println("The lockdown variable is set to " + kickLockdown);

        if (kickLockdown == true) {
            System.out.println("A lockdown is active");

            if (player.hasPermission("bangui.LogInDuringLockdown")) {

                System.out.println("Player is immune");
                player.sendMessage(ChatColor.RED + "A LOCKDOWN IS IN PROGRESS");
                player.sendMessage(ChatColor.WHITE + "No players without the correct permission are allowed to log in");

            } else {

                System.out.println("Player should be kicked");
                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                String commandKick2 = (" " + ChatColor.RED + " A lockdown has just started on this server." + ChatColor.WHITE + " Please stand by for more information " + CustomConfig.get().getString("Discord Server Invite"));
                String kickCommand2 = "kick " + player.getDisplayName() + commandKick2;
                Bukkit.dispatchCommand(console, kickCommand2);
                System.out.println(kickCommand2);
            }
        }
    }



}
