package bangui.bangui.commands.Staff2Server;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Random;


public class randomTP implements CommandExecutor, Listener {
    ArrayList<Player> onlinePlayers = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("bangui.randomTP")){
                player.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.GREEN + "Teleporting...");
                for(Player all : Bukkit.getOnlinePlayers()){
                    onlinePlayers.add(all);
                }
                randomTP obj = new randomTP();
                System.out.println(obj.getRandomElement(onlinePlayers));
            }else{
                player.sendMessage(ChatColor.BLUE + "[BanGUI] " + ChatColor.RED + "You do not have correct permissions to use this feature");
            }
        }

        return true;
    }

    private Player getRandomElement(ArrayList<Player> onlinePlayers) {
        Random rand = new Random();
        return onlinePlayers.get(rand.nextInt(onlinePlayers.size()));
    }
}
