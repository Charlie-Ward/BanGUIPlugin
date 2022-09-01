package bangui.bangui.commands;

import bangui.bangui.utils.BanMenuUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class OnlinePlayersCommand implements CommandExecutor, Listener{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if (sender instanceof Player){

            Player p = (Player) sender;
            if (p.isOp()){

                p.sendMessage(ChatColor.GRAY + "Please use the staff menu to access this now" + ChatColor.RED + "/staff");

            }else{

                BanMenuUtils.onlinePlayersNonStaff(p);

            }

        }

        return true;
    }

}
