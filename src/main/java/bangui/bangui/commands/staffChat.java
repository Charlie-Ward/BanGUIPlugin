package bangui.bangui.commands;

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

public class staffChat implements CommandExecutor, TabCompleter ,Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (!(sender instanceof Player)){
            sender.sendMessage("Command only for players");
            return false;
        }
        Player p = (Player) sender;
        if (!(p.hasPermission("bangui.staffchat"))){
            p.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.RED + "You do not have correct permissions to use this feature");
            return false;
        }
        if (args.length < 1) {
            p.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.RED + "Message cannot be empty");
            return false;
        }
        String mess = ChatColor.BLUE + "[BanGUI]" + ChatColor.YELLOW + "[SC] " + ChatColor.WHITE + p.getDisplayName() + ": ";
        for (String s : args) {
            mess = mess + s + " ";
        }
        for (Player player : Bukkit.getOnlinePlayers()){
            if (player.hasPermission("bangui.staffchat")){
                player.sendMessage(mess);
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        return null;
    }
}
