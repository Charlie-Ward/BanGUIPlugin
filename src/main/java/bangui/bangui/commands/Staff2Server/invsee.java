package bangui.bangui.commands.Staff2Server;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class invsee implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("bangui.invsee")){
                if(args.length == 1){
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target == null){
                        player.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.RED + "Player is not online");
                        return true;
                    }else{
                        player.openInventory(target.getInventory());
                    }
                }else {
                    player.sendMessage(ChatColor.BLUE + "[BanGUI] " + "Your inputted arguments for this command are invalid");
                    player.sendMessage(ChatColor.RED + "/invsee [Target Player]");
                    return true;
                }
            }else{
                player.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.RED + "You do not have correct permissions to use this feature");
                return true;
            }
        }else {
            return true;
        }

        return true;
    }
}
