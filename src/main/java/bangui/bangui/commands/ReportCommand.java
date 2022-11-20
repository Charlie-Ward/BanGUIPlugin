package bangui.bangui.commands;

import bangui.bangui.utils.BanMenuUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.Objects;


public class ReportCommand implements CommandExecutor, Listener {

    public String[] args = {""};
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length == 0){
                p.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.RED + "Please provide a username");
            }else {
                String whoToBan = args[0];
                for (Player all : Bukkit.getServer().getOnlinePlayers()){

                    if (Objects.equals(whoToBan, all.getDisplayName())){
                        BanMenuUtils.ReportReasonMenu(p, whoToBan);
                    }else {
                        p.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.RED + "Please input a correct username");
                    }
                }
            }
        }

        return true;
    }


}
