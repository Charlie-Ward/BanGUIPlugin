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

            if (p.hasPermission("bangui.nv")){

                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                String commandToSend = "effect clear " +  p.getDisplayName() + " minecraft:night_vision";
                Bukkit.dispatchCommand(console, commandToSend);

            }else if (p.isOp()) {

                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                String commandToSend = "effect clear " +  p.getDisplayName() + " minecraft:night_vision";
                Bukkit.dispatchCommand(console, commandToSend);

            }else{
                p.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.RED + "You do not have correct permissions to use this feature");
            }

        }

        return true;

    }

}