package bangui.bangui.listeners.KickListeners;

import bangui.bangui.utils.BanMenuUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class KickInventoryListener implements Listener{

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){

        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Player List")){

            if (e.getCurrentItem().getType() == Material.PLAYER_HEAD){

                String whoToKick = e.getCurrentItem().getItemMeta().getDisplayName();
                BanMenuUtils.openPlayerMenuKick(player, whoToKick);

            }else if (e.getCurrentItem().getType() == Material.BARRIER){

                player.closeInventory();

            }else if (e.getCurrentItem().getType() == Material.OAK_DOOR){

                BanMenuUtils.StaffMainMenu(player);

            }
            e.setCancelled(true);
        }else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Confirm Kick")){

            String whoToKick2 = e.getClickedInventory().getItem(4).getItemMeta().getDisplayName();

            if (e.getCurrentItem().getType() == Material.WOODEN_AXE){

                for (Player all : Bukkit.getServer().getOnlinePlayers()){

                    if (all.isOp()){

                        all.sendMessage(ChatColor.GOLD + "[BanGUI Kick Alert] " + ChatColor.WHITE + player.getDisplayName() + ChatColor.RED + " kicked player: " + ChatColor.WHITE + whoToKick2);

                    }

                }

                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                String command = "kick " + whoToKick2 + " You have been kicked please check over the server rules before rejoining";
                Bukkit.dispatchCommand(console, command);

                player.closeInventory();

            }else if (e.getCurrentItem().getType() == Material.BARRIER){

                player.closeInventory();

            }

            e.setCancelled(true);

        }

    }

}
