package bangui.bangui.listeners;

import bangui.bangui.utils.BanMenuUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class StaffMenuListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){

        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "Staff Menu")){

            if (e.getCurrentItem().getType() == Material.IRON_DOOR){

                BanMenuUtils.openBanMenu(player);

            }else if (e.getCurrentItem().getType() == Material.BARRIER){

                player.closeInventory();

            }else if (e.getCurrentItem().getType() == Material.GREEN_DYE){

                    BanMenuUtils.onlinePlayers(player);

            }else if (e.getCurrentItem().getType() == Material.WOODEN_AXE){

                BanMenuUtils.openKickMenu(player);

            }else if(e.getCurrentItem().getType() == Material.COMMAND_BLOCK){

                BanMenuUtils.onlineStaff(player);

            }else if (e.getCurrentItem().getType() == Material.WHITE_CONCRETE){

                player.sendMessage(ChatColor.GOLD + "This feature is coming to the BanGUI plugin soon");

            }


            e.setCancelled(true);

        }

    }

}
