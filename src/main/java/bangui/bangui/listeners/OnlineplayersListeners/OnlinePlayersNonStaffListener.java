package bangui.bangui.listeners.OnlineplayersListeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

public class OnlinePlayersNonStaffListener implements Listener{

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){

        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Player List")){

            if(e.getCurrentItem().getType() == Material.BARRIER){

                if (e.getClick() == ClickType.LEFT){

                    player.closeInventory();

                }

            }e.setCancelled(true);

        }

    }
}