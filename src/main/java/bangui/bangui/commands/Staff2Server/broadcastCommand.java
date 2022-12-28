package bangui.bangui.commands.Staff2Server;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

public class broadcastCommand implements CommandExecutor, TabCompleter ,Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (!(sender instanceof Player)){
            sender.sendMessage("Command only for players");
            return false;
        }
        Player p = (Player) sender;
        if (!(p.hasPermission("bangui.broadcast"))){
            p.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.RED + "You do not have correct permissions to use this feature");
            return false;
        }
        if (args.length < 1) {
            p.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.RED + "Message cannot be empty");
            return false;
        }
        String mess = ChatColor.RED + "BROADCAST" + ": ";
        for (String s : args) {
            mess = mess + s + " ";
        }
        for (Player player : Bukkit.getOnlinePlayers()){
                player.sendMessage(mess);
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        return null;
    }
}
