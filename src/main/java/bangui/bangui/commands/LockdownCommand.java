package bangui.bangui.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class LockdownCommand implements CommandExecutor, Listener {

    boolean lockdown = false;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if (sender instanceof Player){

            Player p = (Player) sender;

            if (p.hasPermission("bangui.lockdown")){

                if (lockdown == false){

                    p.sendMessage(ChatColor.RED + "LOCKDOWN HAS BEEN ENABLED");
                    p.sendMessage(ChatColor.RED + "All players without lockdown permissions have been kicked and will not be able to join until lockdown is disabled");
                    lockdown = true;

                }else if(lockdown){

                    p.sendMessage(ChatColor.RED + "LOCKDOWN HAS BEEN DISABLED");
                    p.sendMessage(ChatColor.RED + "All players can now join the server again");
                    lockdown = false;

                }

            }

        }


        return true;
    }

}
