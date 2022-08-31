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

public class BanReasonListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){

        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Player List")){

            if (e.getCurrentItem().getType() == Material.PLAYER_HEAD){

                //Player whoToBan = BanGUI.getPlugin().getServer().getPlayerExact(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));

                String whoToBan2 = e.getCurrentItem().getItemMeta().getDisplayName();
                String whoToBan = whoToBan2;

                if (e.getClick() == ClickType.LEFT){

                    BanMenuUtils.BanReasonMenu(player, whoToBan);

                }
            }else if (e.getCurrentItem().getType() == Material.BARRIER){

                player.closeInventory();

            } else if (e.getCurrentItem().getType() == Material.OAK_DOOR) {

                BanMenuUtils.StaffMainMenu(player);

            }
            e.setCancelled(true);
        }

    }

}
