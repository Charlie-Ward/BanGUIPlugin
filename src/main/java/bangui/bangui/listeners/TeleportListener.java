package bangui.bangui.listeners;

import org.bukkit.*;
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



                if (e.getClick() == ClickType.LEFT) {
                    String whoToTeleport = e.getCurrentItem().getItemMeta().getDisplayName();
                    String whoToTeleport2 = player.getDisplayName();


                    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                    String command = "tp " + whoToTeleport2 + " " + whoToTeleport;
                    Bukkit.dispatchCommand(console, command);
                } else if (e.getClick() == ClickType.RIGHT) {

                    String whoToTeleport = e.getCurrentItem().getItemMeta().getDisplayName();
                    String whoToTeleport2 = player.getDisplayName();

                    player.setGameMode(GameMode.SPECTATOR);

                    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                    String command = "tp " + whoToTeleport2 + " " + whoToTeleport;
                    Bukkit.dispatchCommand(console, command);


                }

            }

            e.setCancelled(true);

        }

    }

}
