package bangui.bangui.listeners.ReportListeners;

import bangui.bangui.utils.BanMenuUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ReportReasonListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){

        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GREEN + "Player List")){

            if (e.getCurrentItem().getType() == Material.PLAYER_HEAD){

                //Player whoToBan = BanGUI.getPlugin().getServer().getPlayerExact(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));

                String whoToBan2 = e.getCurrentItem().getItemMeta().getDisplayName();
                String whoToBan = whoToBan2;

                if (e.getClick() == ClickType.LEFT){

                    BanMenuUtils.ReportReasonMenu(player, whoToBan);

                }
            }else if (e.getCurrentItem().getType() == Material.BARRIER) {

                player.closeInventory();

            }
            e.setCancelled(true);
        }

    }

}
