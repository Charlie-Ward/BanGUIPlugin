package bangui.bangui.listeners;

import bangui.bangui.BanGUI;
import bangui.bangui.utils.BanMenuUtils;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

public class TeleportListener implements Listener {

    public void onMenuClick(InventoryClickEvent e){

        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "Player List")){

            if (e.getCurrentItem().getType() == Material.PLAYER_HEAD){

                if(e.getClick() == ClickType.LEFT){

                    String whoToTeleport = e.getCurrentItem().getItemMeta().getDisplayName();
                    String whoToTeleport2 = String.valueOf(player);
                    player.sendMessage(whoToTeleport);
                    player.sendMessage(whoToTeleport2);
                    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                    String command = "tp " + player + " " +whoToTeleport;
                    Bukkit.dispatchCommand(console, command);

                }

            }

        }

    }

}
