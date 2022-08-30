package bangui.bangui.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
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
        Inventory bangui = Bukkit.createInventory(player, InvSize, ChatColor.RED + "Player List");

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

        ItemStack home = new ItemStack(Material.OAK_DOOR, 1);
        ItemMeta hMeta = home.getItemMeta();
        hMeta.setDisplayName(ChatColor.GOLD + "Staff Home");
        ArrayList<String> hLore = new ArrayList<>();
        hLore.add(ChatColor.LIGHT_PURPLE + "Go back to the staff home");
        hMeta.setLore(hLore);
        home.setItemMeta(hMeta);

        ItemStack close = new ItemStack(Material.BARRIER, 1);
        ItemMeta cMeta = info.getItemMeta();
        cMeta.setDisplayName(ChatColor.RED + "Close");
        ArrayList<String> cLore = new ArrayList<>();
        cLore.add(ChatColor.LIGHT_PURPLE + "Close the current menu");
        cMeta.setLore(cLore);
        close.setItemMeta(cMeta);

        bangui.setItem(0, filler);
        bangui.setItem(1, filler);
        bangui.setItem(2, filler);

        bangui.setItem(3, info);

        bangui.setItem(4, home);

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
        PHlore.add(banMe);
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
        cancel_meta.setDisplayName(ChatColor.RED + "Close");
        cancel.setItemMeta(cancel_meta);
        ArrayList<String> cLore = new ArrayList<>();
        cLore.add(ChatColor.LIGHT_PURPLE + "Close the current menu");
        cancel_meta.setLore(cLore);
        banPlayerMenu.setItem(8, cancel);

        player1.openInventory(banPlayerMenu);
    }

    public static void BanReasonMenu (Player player1, String whoToBan){

        String banMe = whoToBan;

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
        ArrayList<String> cLore = new ArrayList<>();
        cLore.add(ChatColor.LIGHT_PURPLE + "Close the current menu");
        bMeta.setLore(cLore);
        back.setItemMeta(bMeta);

        ItemStack HarassmentItem = new ItemStack(Material.BEDROCK);
        ItemMeta hMeta = HarassmentItem.getItemMeta();
        hMeta.setDisplayName(banMe + ",Harassing a player or Staff Member");
        ArrayList<String> hLore = new ArrayList<>();
        hLore.add(String.valueOf(banMe));
        hLore.add(ChatColor.LIGHT_PURPLE + "Harassing a player or staff member");
        hMeta.setLore(hLore);
        HarassmentItem.setItemMeta(hMeta);

        ItemStack XrayItem = new ItemStack(Material.WOODEN_PICKAXE);
        ItemMeta xMeta = XrayItem.getItemMeta();
        xMeta.setDisplayName(banMe + ",Using X-Ray Hacks");
        ArrayList<String> xLore = new ArrayList<>();
        xLore.add(String.valueOf(banMe));
        xLore.add(ChatColor.LIGHT_PURPLE + "Using X-Ray Hacks");
        xMeta.setLore(xLore);
        XrayItem.setItemMeta(xMeta);

        ItemStack CombatItem = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta cMeta = CombatItem.getItemMeta();
        cMeta.setDisplayName(banMe + ",Using Combat Hacks");
        ArrayList<String> coLore = new ArrayList<>();
        coLore.add(String.valueOf(banMe));
        coLore.add(ChatColor.LIGHT_PURPLE + "Using Combat Hacks");
        cMeta.setLore(coLore);
        CombatItem.setItemMeta(cMeta);

        ItemStack beItem = new ItemStack(Material.DARK_OAK_DOOR);
        ItemMeta beMeta = beItem.getItemMeta();
        beMeta.setDisplayName(banMe + ",Ban Evasion");
        ArrayList<String> beLore = new ArrayList<>();
        beLore.add(String.valueOf(banMe));
        beLore.add(ChatColor.LIGHT_PURPLE + "Ban Evasion");
        beMeta.setLore(beLore);
        beItem.setItemMeta(beMeta);

        ItemStack oItem = new ItemStack(Material.OAK_SIGN);
        ItemMeta oMeta = oItem.getItemMeta();
        oMeta.setDisplayName(banMe + ",Other please ask staff for further details");
        ArrayList<String> oLore = new ArrayList<>();
        oLore.add(String.valueOf(banMe));
        oLore.add(ChatColor.LIGHT_PURPLE + "Other please ask staff for further details");
        oMeta.setLore(oLore);
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
        ArrayList<String> cLore = new ArrayList<>();
        cLore.add(ChatColor.LIGHT_PURPLE + "Close the current menu");
        bMeta.setLore(cLore);
        close.setItemMeta(bMeta);

        ItemStack hour = new ItemStack(Material.CLOCK);
        ItemMeta hMeta = hour.getItemMeta();
        hMeta.setDisplayName(banMe + "," + whyBanMe + ",1 hour");
        ArrayList<String> hLore = new ArrayList<>();
        hLore.add(banMe);
        hLore.add(whyBanMe);
        hLore.add(ChatColor.LIGHT_PURPLE + "1 hour");
        hMeta.setLore(hLore);
        hour.setItemMeta(hMeta);

        ItemStack day = new ItemStack(Material.CLOCK);
        ItemMeta dMeta = day.getItemMeta();
        dMeta.setDisplayName(banMe + "," + whyBanMe + ",1 day");
        ArrayList<String> dLore = new ArrayList<>();
        dLore.add(banMe);
        dLore.add(whyBanMe);
        dLore.add(ChatColor.LIGHT_PURPLE + "1 day");
        dMeta.setLore(dLore);
        day.setItemMeta(dMeta);

        ItemStack week = new ItemStack(Material.CLOCK);
        ItemMeta wMeta = week.getItemMeta();
        wMeta.setDisplayName(banMe + "," + whyBanMe + ",1 week");
        ArrayList<String> wLore = new ArrayList<>();
        wLore.add(banMe);
        wLore.add(whyBanMe);
        wLore.add(ChatColor.LIGHT_PURPLE + "1 week");
        wMeta.setLore(wLore);
        week.setItemMeta(wMeta);

        ItemStack month = new ItemStack(Material.CLOCK);
        ItemMeta mMeta = month.getItemMeta();
        mMeta.setDisplayName(banMe + "," + whyBanMe + ",1 month");
        ArrayList<String> mLore = new ArrayList<>();
        mLore.add(banMe);
        mLore.add(whyBanMe);
        mLore.add(ChatColor.LIGHT_PURPLE + "1 month");
        mMeta.setLore(mLore);
        month.setItemMeta(mMeta);

        ItemStack year = new ItemStack(Material.CLOCK);
        ItemMeta yMeta = year.getItemMeta();
        yMeta.setDisplayName(banMe + "," + whyBanMe + ",1 year");
        ArrayList<String> yLore = new ArrayList<>();
        yLore.add(banMe);
        yLore.add(whyBanMe);
        yLore.add(ChatColor.LIGHT_PURPLE + "1 year");
        yMeta.setLore(yLore);
        year.setItemMeta(yMeta);

        ItemStack permanent = new ItemStack(Material.CLOCK);
        ItemMeta peMeta = permanent.getItemMeta();
        peMeta.setDisplayName(banMe + "," + whyBanMe + ",Permanently");
        ArrayList<String> peLore = new ArrayList<>();
        peLore.add(banMe);
        peLore.add(whyBanMe);
        peLore.add(ChatColor.LIGHT_PURPLE + "1 hour");
        peMeta.setLore(peLore);
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

    public static void StaffMainMenu (Player player1){

        Inventory StaffMenu = Bukkit.createInventory(player1, 36, ChatColor.GOLD + "Staff Menu");

        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS);
        ItemMeta fMeta = filler.getItemMeta();
        fMeta.setDisplayName("");

        ItemStack info = new ItemStack(Material.PAPER);
        ItemMeta pMeta = info.getItemMeta();
        pMeta.setDisplayName(ChatColor.GOLD + "Staff Home");
        ArrayList<String> pLore = new ArrayList<>();
        pLore.add(ChatColor.LIGHT_PURPLE + "The homepage for the BanGUI plugin");
        pMeta.setLore(pLore);
        info.setItemMeta(pMeta);

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta cMeta = info.getItemMeta();
        cMeta.setDisplayName(ChatColor.GOLD + "Close");
        ArrayList<String> cLore = new ArrayList<>();
        cLore.add(ChatColor.LIGHT_PURPLE + "Close the current menu");
        cMeta.setLore(cLore);
        close.setItemMeta(cMeta);

        ItemStack banGUI = new ItemStack(Material.IRON_DOOR);
        ItemMeta bMeta = banGUI.getItemMeta();
        bMeta.setDisplayName(ChatColor.GOLD + "BanGUI");
        ArrayList<String> bLore = new ArrayList<>();
        bLore.add(ChatColor.LIGHT_PURPLE + "Opens the BanGUI menu");
        bMeta.setLore(bLore);
        banGUI.setItemMeta(bMeta);

        ItemStack onlinePlayers = new ItemStack(Material.GREEN_DYE);
        ItemMeta opMeta = onlinePlayers.getItemMeta();
        opMeta.setDisplayName(ChatColor.GOLD + "Online Players");
        ArrayList<String> opLore = new ArrayList<>();
        opLore.add(ChatColor.LIGHT_PURPLE + "Shows online players");
        opMeta.setLore(opLore);
        onlinePlayers.setItemMeta(opMeta);

        ItemStack vanish = new ItemStack(Material.WHITE_DYE);
        ItemMeta vMeta = vanish.getItemMeta();
        vMeta.setDisplayName(ChatColor.GOLD + "Vanish");
        ArrayList<String> vLore = new ArrayList<>();
        vLore.add(ChatColor.LIGHT_PURPLE + "Coming Soon");
        vMeta.setLore(vLore);
        onlinePlayers.setItemMeta(vMeta);

        ItemStack opPlayers = new ItemStack(Material.COMMAND_BLOCK);
        ItemMeta oMeta = opPlayers.getItemMeta();
        oMeta.setDisplayName(ChatColor.GOLD + "Online Staff");
        ArrayList<String> oLore = new ArrayList<>();
        oLore.add(ChatColor.LIGHT_PURPLE + "Shows online staff member");
        oMeta.setLore(oLore);
        opPlayers.setItemMeta(oMeta);

        //Line 1
        StaffMenu.setItem(0, filler);
        StaffMenu.setItem(1, filler);
        StaffMenu.setItem(2, info);

        StaffMenu.setItem(3, filler);
        StaffMenu.setItem(4, filler);
        StaffMenu.setItem(5, filler);

        StaffMenu.setItem(6, close);
        StaffMenu.setItem(7, filler);
        StaffMenu.setItem(8, filler);

        //Line 2
        StaffMenu.setItem(9, filler);
        StaffMenu.setItem(10, filler);
        StaffMenu.setItem(11, filler);
        StaffMenu.setItem(12, banGUI);

        StaffMenu.setItem(13, filler);

        StaffMenu.setItem(14, onlinePlayers);
        StaffMenu.setItem(15, filler);
        StaffMenu.setItem(16, filler);
        StaffMenu.setItem(17, filler);

        //Line 3

        StaffMenu.setItem(18, filler);
        StaffMenu.setItem(19, filler);
        StaffMenu.setItem(20, vanish);

        StaffMenu.setItem(21, filler);
        StaffMenu.setItem(22, filler);
        StaffMenu.setItem(23, filler);

        StaffMenu.setItem(24, opPlayers);
        StaffMenu.setItem(25, filler);
        StaffMenu.setItem(26, filler);

        //Line 4

        StaffMenu.setItem(27, filler);
        StaffMenu.setItem(28, filler);
        StaffMenu.setItem(29, filler);

        StaffMenu.setItem(30, filler);
        StaffMenu.setItem(31, filler);
        StaffMenu.setItem(32, filler);

        StaffMenu.setItem(33, filler);
        StaffMenu.setItem(34, filler);
        StaffMenu.setItem(35, filler);

        player1.openInventory(StaffMenu);

    }

    public static void onlinePlayers(Player player){

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
        Inventory onlinePlayers = Bukkit.createInventory(player, InvSize, ChatColor.GOLD + "Player List");

        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta fMeta = filler.getItemMeta();
        fMeta.setDisplayName(ChatColor.GRAY + "");
        filler.setItemMeta(fMeta);

        ItemStack info = new ItemStack(Material.PAPER, 1);
        ItemMeta pMeta = info.getItemMeta();
        pMeta.setDisplayName(ChatColor.GOLD + "Online Players Info");
        ArrayList<String> pLore = new ArrayList<>();
        pLore.add(ChatColor.LIGHT_PURPLE + "Shows all online players left click to teleport to them");
        pMeta.setLore(pLore);
        info.setItemMeta(pMeta);

        ItemStack home = new ItemStack(Material.OAK_DOOR, 1);
        ItemMeta hMeta = home.getItemMeta();
        hMeta.setDisplayName(ChatColor.GOLD + "Staff Home");
        ArrayList<String> hLore = new ArrayList<>();
        hLore.add(ChatColor.LIGHT_PURPLE + "Go back to the staff home");
        hMeta.setLore(hLore);
        home.setItemMeta(hMeta);


        ItemStack close = new ItemStack(Material.BARRIER, 1);
        ItemMeta cMeta = info.getItemMeta();
        cMeta.setDisplayName(ChatColor.RED + "Close");
        ArrayList<String> cLore = new ArrayList<>();
        cLore.add(ChatColor.LIGHT_PURPLE + "Close the current menu");
        cMeta.setLore(cLore);
        close.setItemMeta(cMeta);

        onlinePlayers.setItem(0, filler);
        onlinePlayers.setItem(1, filler);
        onlinePlayers.setItem(2, filler);

        onlinePlayers.setItem(3, info);

        onlinePlayers.setItem(4, home);

        onlinePlayers.setItem(5, close);

        onlinePlayers.setItem(6, filler);
        onlinePlayers.setItem(7, filler);
        onlinePlayers.setItem(8, filler);

        //For every player, add their name to gui
        for (int i = 0; i < list.size(); i++){
            ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
            ItemMeta meta = playerHead.getItemMeta();
            //Set player info on the item
            meta.setDisplayName(list.get(i).getDisplayName());
            playerHead.setItemMeta(meta);
            //Add player head to gui

            onlinePlayers.addItem(playerHead);

        }
        player.openInventory(onlinePlayers);

    }
}