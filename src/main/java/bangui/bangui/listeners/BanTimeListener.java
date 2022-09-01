package bangui.bangui.listeners;

import bangui.bangui.utils.BanMenuUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;



public class BanTimeListener implements Listener{

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){

        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Reason For Ban")){

            if (e.getCurrentItem().getType() != Material.GRAY_STAINED_GLASS_PANE){

                if (e.getCurrentItem().getType() != Material.BARRIER){

                    if (e.getCurrentItem().getType() != Material.PAPER){

                        //Player whoToBan = BanGUI.getPlugin().getServer().getPlayerExact(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));

                        String whoToBan2 = e.getCurrentItem().getItemMeta().getDisplayName();
                        String[] splitString = whoToBan2.split(",");
                        String whoToBan = splitString[0];
                        String whyToBan = splitString[1];

                        if (e.getClick() == ClickType.LEFT){

                            BanMenuUtils.BanTimeMenu(player, whoToBan, whyToBan);

                        }

                    }

                }

            } else if (e.getCurrentItem().getType() == Material.BARRIER) {

                player.closeInventory();
            } e.setCancelled(true);
        }


    }


}
