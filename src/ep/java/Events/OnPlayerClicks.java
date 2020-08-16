package ep.java.Events;

import com.mysql.jdbc.Buffer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import ep.java.Config.LanguageManager;
import ep.java.Manager.PetsManager;

import java.util.Objects;

public class OnPlayerClicks implements Listener
{
    @EventHandler
    public void onPlayerClicks(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        Action action = event.getAction();
        if (player.getInventory().getItemInMainHand().getType() != Material.AIR)
        {
            if (Objects.requireNonNull(player.getInventory().getItemInMainHand().getItemMeta()).getDisplayName().contains(LanguageManager.name))
            {
                if (action == Action.RIGHT_CLICK_AIR)
                {
                    if (PetsManager.getInstance().playerPetActive(player))
                    {
                        PetsManager.getInstance().removePet(player);
                    }
                    else if (PetsManager.getInstance().setPlayerPet(player.getInventory().getItemInMainHand().getItemMeta().getLore().get(1),player))
                    {

                    }
                }
                event.setCancelled(true);
            }
        }
    }
}

