package bangui.bangui.commands.gamemodeCommands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class gmspCommand implements CommandExecutor, Listener{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player p = (Player) sender;

            if (p.hasPermission("bangui.gmsp")){

                p.setGameMode(GameMode.SPECTATOR);

            }else if(p.isOp()) {

                p.setGameMode(GameMode.SPECTATOR);

            }else{

                p.sendMessage(ChatColor.RED + "This is only available to op players");
                p.sendMessage(ChatColor.RED + "You are not an op player on this server");
                p.sendMessage(ChatColor.RED + "If this is a mistake please contact a server admin");

            }

        }

        return true;

    }

}

