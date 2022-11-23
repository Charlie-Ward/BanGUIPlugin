package bangui.bangui.commands.AllPlayer;

import bangui.bangui.utils.BanMenuUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Objects;

public class kickCommand implements CommandExecutor, Listener {

    public String[] args = {""};
    ArrayList<String> playersOnline = new ArrayList<String>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("bangui.kickMenu")) {
                if (args.length == 0) {
                    p.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.RED + "Please provide a username");
                } else {
                    String whoToKick = args[0];
                    for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                        String playerName = all.getDisplayName();
                        playersOnline.add(playerName);
                    }
                    if(playersOnline.contains(whoToKick)){
                        BanMenuUtils.openPlayerMenuKick(p, whoToKick);
                    }else{
                        p.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.RED + "Please input a correct username");
                    }
                }
            }else{
                p.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.RED + "You do not have correct permissions to use this feature");
            }
        }

        return true;
    }


}