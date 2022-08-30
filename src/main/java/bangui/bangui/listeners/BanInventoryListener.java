package bangui.bangui.listeners;

import bangui.bangui.BanGUI;
import bangui.bangui.utils.BanMenuUtils;
import org.bukkit.BanList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BanInventoryListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();
        //Check inventory
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Player List")){
            //make sure they clicked on a player head
            if (e.getCurrentItem().getType() == Material.PLAYER_HEAD){

                //Get player they clicked on from item name
                Player whoToBan = BanGUI.getPlugin().getServer().getPlayerExact(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));

                BanMenuUtils.openPlayerMenu(player, whoToBan);
            } else if (e.getCurrentItem().getType() == Material.BARRIER) {

                player.closeInventory();

            }
            e.setCancelled(true);
        } else if(e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Confirm Ban")){
            switch(e.getCurrentItem().getType()){
                case BARRIER:
                    BanMenuUtils.openBanMenu(player);
                    break;
                case WOODEN_AXE:
                    //Get name
                    String name = e.getClickedInventory().getItem(4).getItemMeta().getDisplayName();
                    player.getServer().getBanList(BanList.Type.NAME).addBan(ChatColor.stripColor(name), "Try not to get caught", null, null);
                    player.sendMessage(ChatColor.GREEN + "Banned Player");

                    player.closeInventory();


                    break;
            }e.setCancelled(true);
        }
        //make it so they cant move items

    }

}


