package bangui.bangui.events;

import bangui.bangui.BanGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEventVanish implements Listener {

    BanGUI plugin;

    public JoinEventVanish(BanGUI banGUI) {
        this.plugin = banGUI;
    }

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        for(int i = 0; i < plugin.invisibleList.size(); i++){
            player.hidePlayer(plugin, plugin.invisibleList.get(i));
        }
    }
}
