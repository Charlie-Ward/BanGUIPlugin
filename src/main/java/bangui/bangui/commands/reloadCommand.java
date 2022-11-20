package bangui.bangui.commands;

import bangui.bangui.files.CustomConfig;
import bangui.bangui.utils.BanMenuUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class reloadCommand implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player p = (Player) sender;

            if (p.hasPermission("bangui.reload")){
                CustomConfig.reload();
                p.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.GREEN + "Config Should Have Reloaded");
            }else{
                p.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.RED + "You do not have correct permissions to use this feature");
            }

        }

        return true;
    }
}
