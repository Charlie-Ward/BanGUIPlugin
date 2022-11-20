package bangui.bangui.events;

import bangui.bangui.BanGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEventVanish implements Listener {

    BanGUI plugin;

    public JoinEventVanish(BanGUI plugin) {
    }

    public void JoinEvent(BanGUI plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        for(int i = 0; i < plugin.invisibleList.size(); i++){
            player.hidePlayer(plugin, plugin.invisibleList.get(i));
        }
    }
}
