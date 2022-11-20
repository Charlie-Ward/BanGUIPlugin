package bangui.bangui.commands;

import bangui.bangui.BanGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class vanishCommand implements CommandExecutor {



    BanGUI plugin;

    String playerVanish;

    public vanishCommand(BanGUI plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("bangui.vanish")) {
                if (plugin.invisibleList.contains(player)) {
                    //Currently Vanished
                    for (Player people : Bukkit.getOnlinePlayers()){
                        if(!people.hasPermission("bangui.vanish")){
                            people.showPlayer(plugin, player);
                        }
                    }
                    plugin.invisibleList.remove(player);
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.GREEN + "You are no longer vanished");
                }else if(!plugin.invisibleList.contains(player)){
                    //Needs to be vanished
                    for (Player people : Bukkit.getOnlinePlayers()){
                        if(!people.hasPermission("bangui.vanish")){
                            people.hidePlayer(plugin, player);
                        }
                    }
                    plugin.invisibleList.add(player);
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.GREEN + "You are now vanished");
                }
            }else{
                player.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.RED + "You do not have correct permissions to use this feature");
            }
        }

        return true;
    }
}
