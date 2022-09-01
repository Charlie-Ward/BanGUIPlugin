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

           if (p.isOp() == true){

               p.sendMessage(ChatColor.GOLD + "BanGUI Plugin Help -" + ChatColor.WHITE + " V1.2.4");

               p.sendMessage(ChatColor.RED + "Commands");

               p.sendMessage(ChatColor.WHITE + "/staff");
               p.sendMessage(ChatColor.GRAY + "Opens the staff menu");
               p.sendMessage(ChatColor.WHITE + "/bangui");
               p.sendMessage(ChatColor.GRAY + "Opens the Ban GUI");
               p.sendMessage(ChatColor.WHITE + "/onlineplayers");
               p.sendMessage(ChatColor.GRAY + "Show a list of all online players");
               p.sendMessage(ChatColor.WHITE + "/checktopplayers");
               p.sendMessage(ChatColor.GRAY + "Shows the players who can see OP players in the ban and kick menus");
               p.sendMessage(ChatColor.WHITE + "/bghelp");
               p.sendMessage(ChatColor.GRAY + "Shows all available commands");


           }else{

                p.sendMessage(ChatColor.GOLD + "BanGUI Plugin Help");
                p.sendMessage(ChatColor.RED + "There are currently no commands for un-opped players");

            }

        }

        return true;
    }

}
