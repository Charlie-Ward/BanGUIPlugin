package bangui.bangui.commands.NightVisionCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class clearnvCommand implements CommandExecutor, Listener{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player p = (Player) sender;

            if (p.hasPermission("bangui.clearnv")){

                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                String commandToSend = "effect clear " +  p.getDisplayName() + " minecraft:night_vision";
                Bukkit.dispatchCommand(console, commandToSend);

            }else if (p.isOp()) {

                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                String commandToSend = "effect clear " +  p.getDisplayName() + " minecraft:night_vision";
                Bukkit.dispatchCommand(console, commandToSend);

            }else{

                p.sendMessage(ChatColor.RED + "This is only available to op players");
                p.sendMessage(ChatColor.RED + "You are not an op player on this server");
                p.sendMessage(ChatColor.RED + "If this is a mistake please contact a server admin");

            }

        }

        return true;

    }

}