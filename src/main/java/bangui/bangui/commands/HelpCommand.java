package bangui.bangui.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player p = (Player) sender;

            p.sendMessage(ChatColor.GOLD + "BanGUI Plugin Help -" + ChatColor.WHITE + " V1.3.4");

           if (p.isOp()){



               p.sendMessage(ChatColor.RED + "Commands");

               p.sendMessage(ChatColor.WHITE + "/staff");
               p.sendMessage(ChatColor.GRAY + "Opens the staff menu");
               p.sendMessage(ChatColor.WHITE + "/report");
               p.sendMessage(ChatColor.GRAY + "Opens the player report menu");
               p.sendMessage(ChatColor.WHITE + "/gmc");
               p.sendMessage(ChatColor.GRAY + "Changes gamemode to creative");
               p.sendMessage(ChatColor.WHITE + "/gma");
               p.sendMessage(ChatColor.GRAY + "Changes gamemode to adventure");
               p.sendMessage(ChatColor.WHITE + "/gms");
               p.sendMessage(ChatColor.GRAY + "Changes gamemode to survival");
               p.sendMessage(ChatColor.WHITE + "/gmsp");
               p.sendMessage(ChatColor.GRAY + "Changes gamemode to spectator");
               p.sendMessage(ChatColor.WHITE + "/nv");
               p.sendMessage(ChatColor.GRAY + "Gives night vision to player for when trying to spectate other players");
               p.sendMessage(ChatColor.WHITE + "/clearnv");
               p.sendMessage(ChatColor.GRAY + "Clears the players night vision");
               p.sendMessage(ChatColor.WHITE + "/bghelp");
               p.sendMessage(ChatColor.GRAY + "Shows all available commands");


           }else{

               p.sendMessage(ChatColor.RED + "Commands");

               p.sendMessage(ChatColor.WHITE + "/onlineplayers");
               p.sendMessage(ChatColor.GRAY + "Opens the online players menu");
               p.sendMessage(ChatColor.WHITE + "/report");
               p.sendMessage(ChatColor.GRAY + "Opens the player report menu");

            }

        }

        return true;
    }

}
