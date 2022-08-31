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

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){

        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "Player List")){

            if (e.getCurrentItem().getType() == Material.PLAYER_HEAD){

                String whoToTeleport = e.getCurrentItem().getItemMeta().getDisplayName();
                String whoToTeleport2 = player.getDisplayName();

                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                String command = "tp " + whoToTeleport2 + " " +whoToTeleport;
                Bukkit.dispatchCommand(console, command);



            }

        }

    }

}
