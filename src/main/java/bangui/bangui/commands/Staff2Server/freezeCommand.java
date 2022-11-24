package bangui.bangui.commands.Staff2Server;

import bangui.bangui.BanGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class freezeCommand implements CommandExecutor, Listener{

    BanGUI plugin;

    public freezeCommand(BanGUI plugin){
        this.plugin = plugin;
    }


    ArrayList<String> playersOnline = new ArrayList<String>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("bangui.freeze")) {
                if (args.length == 1) {
                    for (Player people : Bukkit.getOnlinePlayers()) {
                        String peopleName = people.getDisplayName();
                        playersOnline.add(peopleName);
                    }
                    if (playersOnline.contains(args[0])) {
                        Player freezePlayer = Bukkit.getPlayer(args[0]);
                        if(!(plugin.frozenList.contains(freezePlayer.getDisplayName()))){
                            plugin.frozenList.add(freezePlayer.getDisplayName());
                            player.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.GREEN + "You have frozen " + ChatColor.GOLD + freezePlayer.getDisplayName());
                            freezePlayer.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.RED + "You have been frozen by a staff member");
                        }else{
                            plugin.frozenList.remove(freezePlayer.getDisplayName());
                            player.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.GREEN + "You have unfrozen " + ChatColor.GOLD + freezePlayer.getDisplayName());
                            freezePlayer.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.GREEN + "You have been unfrozen");
                        }
                    } else {
                        player.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.RED + "Please input a correct username");
                    }
                }else{
                    player.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.RED + "Only one argument is usable with this command");
                }
            }else{
                player.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.RED + "You do not have correct permissions to use this feature");
            }
        }

        return true;
    }

    @EventHandler
    void onPlayerMove(PlayerMoveEvent event){
        Player player = (Player) event.getPlayer();
        if (plugin.frozenList.contains(player.getDisplayName())){
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.RED + "You have been frozen by a staff member");
        }
    }

}
