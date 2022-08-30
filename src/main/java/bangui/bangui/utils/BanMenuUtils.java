package bangui.bangui.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.lang.Math;

import java.util.ArrayList;

import static java.util.logging.Logger.global;

public class BanMenuUtils {

    public static void openBanMenu(Player player){

        //Get a list of players on the server
        ArrayList<Player> list = new ArrayList<Player>(player.getServer().getOnlinePlayers());

        float LAmount = list.size() / 9;
        int LAmountR = Math.round(LAmount);

        int PlayerSize = LAmountR;

        int InvSize = 0;

        if (PlayerSize <= 9){

            InvSize = 18;

        } else if (PlayerSize >= 10) {

            if (PlayerSize >= 46){

                player.sendMessage(ChatColor.RED + "Too many players online please ban through commands");
                InvSize = 0;

            }else{

                InvSize = PlayerSize + 9;

            }
        }


        //Make and open the ban gui
        Inventory bangui = Bukkit.createInventory(player, InvSize, ChatColor.BLUE + "Player List");

        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);

        ItemStack info = new ItemStack(Material.PAPER, 1);
        ItemMeta pMeta = info.getItemMeta();
        pMeta.setDisplayName(ChatColor.GOLD + "BanGUI Plugin Info");
        ArrayList<String> pLore = new ArrayList<>();
        pLore.add(ChatColor.LIGHT_PURPLE + "Click on the player head of the person you want to");
        pLore.add(ChatColor.LIGHT_PURPLE + "ban and confirm the ban");
        pMeta.setLore(pLore);
        info.setItemMeta(pMeta);

        ItemStack close = new ItemStack(Material.BARRIER, 1);
        ItemMeta cMeta = info.getItemMeta();
        cMeta.setDisplayName(ChatColor.RED + "Close");
        ArrayList<String> cLore = new ArrayList<>();
        cLore.add(ChatColor.WHITE + "Close the current menu");
        cMeta.setLore(cLore);
        close.setItemMeta(cMeta);

        bangui.setItem(0, filler);
        bangui.setItem(1, filler);
        bangui.setItem(2, filler);

        bangui.setItem(3, info);

        bangui.setItem(4, filler);

        bangui.setItem(5, close);

        bangui.setItem(6, filler);
        bangui.setItem(7, filler);
        bangui.setItem(8, filler);

        //For every player, add their name to gui
        for (int i = 0; i < list.size(); i++){
            ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
            ItemMeta meta = playerHead.getItemMeta();
            //Set player info on the item
            meta.setDisplayName(list.get(i).getDisplayName());
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.GOLD + "Player Health: " + ChatColor.RED + list.get(i).getHealth());
            lore.add(ChatColor.GOLD + "EXP: " + ChatColor.AQUA + list.get(i).getExp());
            meta.setLore(lore);
            playerHead.setItemMeta(meta);
            //Add player head to gui
            bangui.addItem(playerHead);
        }
        player.openInventory(bangui);

    }

    public static void openPlayerMenu(Player player1, Player whoToBan){

        //Player to be banned
        Player banMe = whoToBan;

        //Open up ban menu
        Inventory banPlayerMenu = Bukkit.createInventory(player1, 9, ChatColor.RED + "Confirm Ban");

        //Create Filler thing

        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);

        //Ban Option
        ItemStack ban = new ItemStack(Material.WOODEN_AXE, 1);
        ItemMeta ban_meta = ban.getItemMeta();
        ban_meta.setDisplayName(ChatColor.DARK_GREEN + "Ban");
        ban.setItemMeta(ban_meta);
        banPlayerMenu.setItem(0, ban);

        //Add fillers

        banPlayerMenu.setItem(1, filler);
        banPlayerMenu.setItem(2, filler);
        banPlayerMenu.setItem(3, filler);

        //Add player
        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
        ItemMeta player_meta = playerHead.getItemMeta();
        player_meta.setDisplayName(banMe.getDisplayName());
        playerHead.setItemMeta(player_meta);
        banPlayerMenu.setItem(4, playerHead);

        //Add fillers

        banPlayerMenu.setItem(5, filler);
        banPlayerMenu.setItem(6, filler);
        banPlayerMenu.setItem(7, filler);

        //Cancel option
        ItemStack cancel = new ItemStack(Material.BARRIER, 1);
        ItemMeta cancel_meta = cancel.getItemMeta();
        cancel_meta.setDisplayName(ChatColor.RED + "Go Back!");
        cancel.setItemMeta(cancel_meta);
        banPlayerMenu.setItem(8, cancel);

        player1.openInventory(banPlayerMenu);
    }

}