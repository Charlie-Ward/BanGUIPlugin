package bangui.bangui.listeners;

import bangui.bangui.utils.BanMenuUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ReportConfirmListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();
        //Check inventory
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Reason For Report")){
            //make sure they clicked on a player head
            if (e.getCurrentItem().getType() != Material.GRAY_STAINED_GLASS_PANE){

                if (e.getCurrentItem().getType() != Material.BARRIER){

                    if (e.getCurrentItem().getType() != Material.PAPER){

                        String whoToBan2 = e.getCurrentItem().getItemMeta().getDisplayName();

                        String[] splitString = whoToBan2.split(",");
                        String whoToBan = splitString[0];
                        String whyToBan = splitString[1];

                        if (e.getClick() == ClickType.LEFT) {
                            BanMenuUtils.openReportConfirmMenu(player, whoToBan, whyToBan);
                        }

                    }

                }
            } else if (e.getCurrentItem().getType() == Material.BARRIER) {

                player.closeInventory();

            }
            e.setCancelled(true);
        } else if(e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Confirm Report")){

            String whoToBan2 = e.getClickedInventory().getItem(4).getItemMeta().getDisplayName();

            String[] splitString = whoToBan2.split(",");
            String whoToBan = splitString[0];
            String whyToBan = splitString[1];

            //Date timeToBeBanned;

            String playerName = String.valueOf(player);

            String splitPlayerName = String.valueOf(playerName.split("="));

            for (Player all : Bukkit.getServer().getOnlinePlayers()){

                    if (all.isOp()) {

                        all.sendMessage(ChatColor.GOLD + "[BanGUI Report Alert] " + ChatColor.RED + "Reported Player: " + ChatColor.WHITE + whoToBan + ChatColor.RED + " for: " + ChatColor.WHITE + whyToBan + ChatColor.RED + " by: " + ChatColor.WHITE + player.getDisplayName());

                    }

                }

                player.closeInventory();

            } else if (e.getCurrentItem().getType() == Material.BARRIER) {

                player.closeInventory();

            }

            e.setCancelled(true);
        }
        //make it so they cant move items

    }

