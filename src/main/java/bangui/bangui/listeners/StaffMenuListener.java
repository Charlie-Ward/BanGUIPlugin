package bangui.bangui.listeners;

import bangui.bangui.utils.BanMenuUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

public class StaffMenuListener implements Listener {

    public void onMenuClick(InventoryClickEvent e){

        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "Staff Menu")){

            if (e.getCurrentItem().getType() == Material.IRON_DOOR){

                if (e.getClick() == ClickType.LEFT){

                    BanMenuUtils.openBanMenu(player);

                }

            }else if (e.getCurrentItem().getType() == Material.BARRIER){

                player.closeInventory();

            }else if (e.getCurrentItem().getType() == Material.GREEN_DYE){

                if (e.getClick() == ClickType.LEFT){

                    BanMenuUtils.onlinePlayers(player);

                }

            }


            e.setCancelled(true);

        }

    }

}
