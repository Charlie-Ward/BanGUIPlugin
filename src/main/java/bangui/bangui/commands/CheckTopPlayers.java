package bangui.bangui.commands;

import bangui.bangui.files.CustomConfig;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CheckTopPlayers implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(player.isOp()){

                player.sendMessage(CustomConfig.get().getString("Owner Players"));

            } else {

                player.sendMessage(ChatColor.RED + "This is only available to op players");
                player.sendMessage(ChatColor.RED + "You are not an op player on this server");
                player.sendMessage(ChatColor.RED + "If this is a mistake please contact a server admin");

            }

        }

        return true;
    }

}
