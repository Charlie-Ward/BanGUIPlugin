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
        ItemMeta fMeta = filler.getItemMeta();
        fMeta.setDisplayName(ChatColor.GRAY + "");
        filler.setItemMeta(fMeta);

        ItemStack info = new ItemStack(Material.PAPER, 1);
        ItemMeta pMeta = info.getItemMeta();
        pMeta.setDisplayName(ChatColor.GOLD + "BanGUI Plugin Info");
        ArrayList<String> pLore = new ArrayList<>();
        pLore.add(ChatColor.LIGHT_PURPLE + "Left click on the player head of the person you want to");
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

            int coordsX = list.get(i).getLocation().getBlockX();
            int coordsY = list.get(i).getLocation().getBlockY();
            int coordsZ = list.get(i).getLocation().getBlockZ();

            lore.add(ChatColor.GOLD + "Player Location: " + ChatColor.WHITE + coordsX + "," + coordsY + "," + coordsZ);
            lore.add(ChatColor.GOLD + "Player IP: " + ChatColor.WHITE + list.get(i).getAddress());
            lore.add(ChatColor.GOLD + "Is Player Op: " + ChatColor.WHITE + list.get(i).isOp());

            meta.setLore(lore);
            playerHead.setItemMeta(meta);
            //Add player head to gui

            bangui.addItem(playerHead);

        }
        player.openInventory(bangui);

    }

    public static void openPlayerMenu(Player player1, String whoToBan, String whyToBan, String howLongToBan){

        //Player to be banned
        String banMe = whoToBan;
        String whyBanMe = whyToBan;
        String howLongToBanMe = howLongToBan;

        //Open up ban menu
        Inventory banPlayerMenu = Bukkit.createInventory(player1, 9, ChatColor.RED + "Confirm Ban");

        //Create Filler thing

        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta fMeta = filler.getItemMeta();
        fMeta.setDisplayName(ChatColor.GRAY + "");
        filler.setItemMeta(fMeta);

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
        player_meta.setDisplayName(banMe + "," + whyBanMe + "," + howLongToBanMe);
        ArrayList<String> PHlore = new ArrayList<>();
        PHlore.add(whyBanMe);
        PHlore.add(howLongToBanMe);
        player_meta.setLore(PHlore);
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

    public static void BanReasonMenu (Player player1, Player whoToBan){

        Player banMe = whoToBan;

        Inventory ReasonToBanMenu = Bukkit.createInventory(player1, 45, ChatColor.RED + "Reason For Ban");

        ItemStack Filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta fMeta = Filler.getItemMeta();
        fMeta.setDisplayName(ChatColor.GRAY + "");
        Filler.setItemMeta(fMeta);

        ItemStack info = new ItemStack(Material.PAPER);
        ItemMeta pMeta = info.getItemMeta();
        pMeta.setDisplayName(ChatColor.GOLD + "Ban Reason Info");
        ArrayList<String> pLore = new ArrayList<>();
        pLore.add(ChatColor.LIGHT_PURPLE + "Left click on the reason you want the player to be");
        pLore.add(ChatColor.LIGHT_PURPLE + "banned for");
        pMeta.setLore(pLore);
        info.setItemMeta(pMeta);

        ItemStack back = new ItemStack(Material.BARRIER);
        ItemMeta bMeta = back.getItemMeta();
        bMeta.setDisplayName(ChatColor.RED + "Close");
        back.setItemMeta(bMeta);

        ItemStack HarassmentItem = new ItemStack(Material.BEDROCK);
        ItemMeta hMeta = HarassmentItem.getItemMeta();
        hMeta.setDisplayName(banMe.getDisplayName() + ",Harassing a player or Staff Member");
        HarassmentItem.setItemMeta(hMeta);

        ItemStack XrayItem = new ItemStack(Material.WOODEN_PICKAXE);
        ItemMeta xMeta = XrayItem.getItemMeta();
        xMeta.setDisplayName(banMe.getDisplayName() + ",Using X-Ray Hacks");
        XrayItem.setItemMeta(xMeta);

        ItemStack CombatItem = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta cMeta = CombatItem.getItemMeta();
        cMeta.setDisplayName(banMe.getDisplayName() + ",Using Combat Hacks");
        CombatItem.setItemMeta(cMeta);

        ItemStack beItem = new ItemStack(Material.DARK_OAK_DOOR);
        ItemMeta beMeta = beItem.getItemMeta();
        beMeta.setDisplayName(banMe.getDisplayName() + ",Ban Evasion");
        beItem.setItemMeta(beMeta);

        ItemStack oItem = new ItemStack(Material.OAK_SIGN);
        ItemMeta oMeta = oItem.getItemMeta();
        oMeta.setDisplayName(banMe.getDisplayName() + ",Other please ask staff for further details");
        oItem.setItemMeta(oMeta);

        //Line 1
        ReasonToBanMenu.setItem(0, Filler);
        ReasonToBanMenu.setItem(1, Filler);
        ReasonToBanMenu.setItem(2, Filler);

        ReasonToBanMenu.setItem(3, info);
        ReasonToBanMenu.setItem(4, Filler);
        ReasonToBanMenu.setItem(5, back);

        ReasonToBanMenu.setItem(6, Filler);
        ReasonToBanMenu.setItem(7, Filler);
        ReasonToBanMenu.setItem(8, Filler);

        //Line 2
        ReasonToBanMenu.setItem(9, Filler);
        ReasonToBanMenu.setItem(10, Filler);

        ReasonToBanMenu.setItem(11, HarassmentItem);
        ReasonToBanMenu.setItem(12, Filler);
        ReasonToBanMenu.setItem(13, Filler);
        ReasonToBanMenu.setItem(14, Filler);
        ReasonToBanMenu.setItem(15, XrayItem);

        ReasonToBanMenu.setItem(16, Filler);
        ReasonToBanMenu.setItem(17, Filler);

        //Line 3
        ReasonToBanMenu.setItem(18, Filler);
        ReasonToBanMenu.setItem(19, Filler);
        ReasonToBanMenu.setItem(20, Filler);
        ReasonToBanMenu.setItem(21, Filler);

        ReasonToBanMenu.setItem(22, CombatItem);

        ReasonToBanMenu.setItem(23, Filler);
        ReasonToBanMenu.setItem(24, Filler);
        ReasonToBanMenu.setItem(25, Filler);
        ReasonToBanMenu.setItem(26, Filler);

        //Line 4
        ReasonToBanMenu.setItem(27, Filler);
        ReasonToBanMenu.setItem(28, Filler);

        ReasonToBanMenu.setItem(29, beItem);
        ReasonToBanMenu.setItem(30, Filler);
        ReasonToBanMenu.setItem(31, Filler);
        ReasonToBanMenu.setItem(32, Filler);
        ReasonToBanMenu.setItem(33, oItem);

        ReasonToBanMenu.setItem(34, Filler);
        ReasonToBanMenu.setItem(35, Filler);

        //Line 5

        ReasonToBanMenu.setItem(36, Filler);
        ReasonToBanMenu.setItem(37, Filler);
        ReasonToBanMenu.setItem(38, Filler);
        ReasonToBanMenu.setItem(39, Filler);
        ReasonToBanMenu.setItem(40, Filler);
        ReasonToBanMenu.setItem(41, Filler);
        ReasonToBanMenu.setItem(42, Filler);
        ReasonToBanMenu.setItem(43, Filler);
        ReasonToBanMenu.setItem(44, Filler);


        player1.openInventory(ReasonToBanMenu);
    }

    public static void BanTimeMenu (Player player1, String whoToBan, String whyToBan){

        String banMe = whoToBan;
        String whyBanMe = whyToBan;

        Inventory timeToBanMenu = Bukkit.createInventory(player1, 36, ChatColor.RED + "Ban Time");

        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta fMeta = filler.getItemMeta();
        fMeta.setDisplayName(ChatColor.GRAY + "");
        filler.setItemMeta(fMeta);

        ItemStack info = new ItemStack(Material.PAPER);
        ItemMeta pMeta = info.getItemMeta();
        pMeta.setDisplayName(ChatColor.GOLD + "Ban Time Info");
        ArrayList<String> pLore = new ArrayList<>();
        pLore.add(ChatColor.LIGHT_PURPLE + "Left click on how long you want the player to be");
        pLore.add(ChatColor.LIGHT_PURPLE + "banned for");
        pMeta.setLore(pLore);
        info.setItemMeta(pMeta);

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta bMeta = close.getItemMeta();
        bMeta.setDisplayName(ChatColor.RED + "Close");
        close.setItemMeta(bMeta);

        ItemStack hour = new ItemStack(Material.CLOCK);
        ItemMeta hMeta = hour.getItemMeta();
        hMeta.setDisplayName(banMe + "," + whyBanMe + ",1 hour");
        hour.setItemMeta(hMeta);

        ItemStack day = new ItemStack(Material.CLOCK);
        ItemMeta dMeta = day.getItemMeta();
        dMeta.setDisplayName(banMe + "," + whyBanMe + ",1 day");
        day.setItemMeta(dMeta);

        ItemStack week = new ItemStack(Material.CLOCK);
        ItemMeta wMeta = week.getItemMeta();
        wMeta.setDisplayName(banMe + "," + whyBanMe + ",1 week");
        week.setItemMeta(wMeta);

        ItemStack month = new ItemStack(Material.CLOCK);
        ItemMeta mMeta = month.getItemMeta();
        mMeta.setDisplayName(banMe + "," + whyBanMe + ",1 month");
        month.setItemMeta(mMeta);

        ItemStack year = new ItemStack(Material.CLOCK);
        ItemMeta yMeta = year.getItemMeta();
        yMeta.setDisplayName(banMe + "," + whyBanMe + ",1 year");
        year.setItemMeta(yMeta);

        ItemStack permanent = new ItemStack(Material.CLOCK);
        ItemMeta peMeta = permanent.getItemMeta();
        peMeta.setDisplayName(banMe + "," + whyBanMe + ",Permanently");
        permanent.setItemMeta(peMeta);

        //Line 1
        timeToBanMenu.setItem(0, filler);
        timeToBanMenu.setItem(1, filler);

        timeToBanMenu.setItem(2, info);
        timeToBanMenu.setItem(3, filler);
        timeToBanMenu.setItem(4, filler);
        timeToBanMenu.setItem(5, filler);
        timeToBanMenu.setItem(6, close);

        timeToBanMenu.setItem(7, filler);
        timeToBanMenu.setItem(8, filler);

        //Line 2
        timeToBanMenu.setItem(9, filler);
        timeToBanMenu.setItem(10, hour);
        timeToBanMenu.setItem(11, filler);

        timeToBanMenu.setItem(12, filler);
        timeToBanMenu.setItem(13, day);
        timeToBanMenu.setItem(14, filler);

        timeToBanMenu.setItem(15, filler);
        timeToBanMenu.setItem(16, week);
        timeToBanMenu.setItem(17, filler);

        //Line 3

        timeToBanMenu.setItem(18, filler);
        timeToBanMenu.setItem(19, filler);
        timeToBanMenu.setItem(20, month);

        timeToBanMenu.setItem(21, filler);
        timeToBanMenu.setItem(22, filler);
        timeToBanMenu.setItem(23, filler);

        timeToBanMenu.setItem(24, year);
        timeToBanMenu.setItem(25, filler);
        timeToBanMenu.setItem(26, filler);

        //Line 4

        timeToBanMenu.setItem(27, filler);
        timeToBanMenu.setItem(28, filler);
        timeToBanMenu.setItem(29, filler);
        timeToBanMenu.setItem(30, filler);

        timeToBanMenu.setItem(31, permanent);

        timeToBanMenu.setItem(32, filler);
        timeToBanMenu.setItem(33, filler);
        timeToBanMenu.setItem(34, filler);
        timeToBanMenu.setItem(35, filler);

        player1.openInventory(timeToBanMenu);

    }

}