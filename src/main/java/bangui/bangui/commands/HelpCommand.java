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

            p.sendMessage(ChatColor.GOLD + "BanGUI Plugin Help -" + ChatColor.WHITE + " V1.3.1");

           if (p.isOp() == true){



               p.sendMessage(ChatColor.RED + "Commands");

               p.sendMessage(ChatColor.WHITE + "/staff");
               p.sendMessage(ChatColor.GRAY + "Opens the staff menu");
               p.sendMessage(ChatColor.WHITE + "/report");
               p.sendMessage(ChatColor.GRAY + "Opens the player report menu");
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
