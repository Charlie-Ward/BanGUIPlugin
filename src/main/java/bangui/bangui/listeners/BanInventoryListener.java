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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class BanInventoryListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();
        //Check inventory
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Ban Time")){
            //make sure they clicked on a player head
            if (e.getCurrentItem().getType() == Material.CLOCK){

                //Get player they clicked on from item name
                //Player whoToBan = BanGUI.getPlugin().getServer().getPlayerExact(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
                //String whyToBan = String.valueOf(BanGUI.getPlugin().getServer().getPlayerExact(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getLore().get(0))));
                //String howLongToBan = String.valueOf(BanGUI.getPlugin().getServer().getPlayerExact(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getLore().get(1))));
                //ArrayList lorelist = new ArrayList<>((Collection) BanGUI.getPlugin().getServer().getPlayerExact(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getLore().toString())));

                String whoToBan2 = e.getCurrentItem().getItemMeta().getDisplayName();

                String[] splitString = whoToBan2.split(",");
                String whoToBan = splitString[0];
                String whyToBan = splitString[1];
                String howLongToBan = splitString[2];

                if (e.getClick() == ClickType.LEFT) {
                    BanMenuUtils.openPlayerMenu(player, whoToBan, whyToBan, howLongToBan);
                }

            } else if (e.getCurrentItem().getType() == Material.BARRIER) {

                player.closeInventory();

            }
            e.setCancelled(true);
        } else if(e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Confirm Ban")){

            String whoToBan2 = e.getClickedInventory().getItem(4).getItemMeta().getDisplayName();

            String[] splitString = whoToBan2.split(",");
            player.sendMessage(splitString[0]);
            player.sendMessage(splitString[1]);
            player.sendMessage(splitString[2]);
            String whoToBan = splitString[0];
            String whyToBan = splitString[1];
            String howLongToBan = splitString[2];

            //Date timeToBeBanned;

            String playerName = String.valueOf(player);

            if (e.getCurrentItem().getType() == Material.WOODEN_AXE) {
                Date timeToBeBanned = null;

                switch(splitString[2]){
                    case "1 hour":
                        timeToBeBanned = new Date(System.currentTimeMillis() + 3600000);
                        player.sendMessage("Set to 1 hour");
                        break;
                    case "1 day":
                        timeToBeBanned = new Date(System.currentTimeMillis() + 86400000);
                        player.sendMessage("Set to 1 day");
                        break;
                    case "1 week":
                        timeToBeBanned = new Date(System.currentTimeMillis() + 604800000);
                        player.sendMessage("Set to 1 week");
                        break;
                    case "1 month":
                        timeToBeBanned = new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 30));
                        player.sendMessage("Set to 1 month");
                        break;
                    case "1 year":
                        timeToBeBanned = new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 365));
                        player.sendMessage("Set to 1 year");
                        break;
                    case "Permanently":
                        timeToBeBanned = null;
                        player.sendMessage("Set to 1 permanently");
                        break;
                }

            player.sendMessage("Trying to ban player");
            player.getServer().getBanList(BanList.Type.NAME).addBan(whoToBan, whyToBan, timeToBeBanned, playerName);
            player.sendMessage(ChatColor.GREEN + "Banned Player");

            player.closeInventory();

            } else if (e.getCurrentItem().getType() == Material.BARRIER) {

                player.closeInventory();

            }

            e.setCancelled(true);
        }
        //make it so they cant move items

    }

}


