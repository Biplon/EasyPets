package ep.java.Events;

import ep.java.Config.LanguageManager;
import ep.java.Manager.PetsManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.util.Objects;

public class OnPlayerInteractEntity implements Listener
{
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerClicks(PlayerInteractEntityEvent event)
    {
        Player player = event.getPlayer();
        if (event.getRightClicked().getCustomName() != null && event.getRightClicked().getCustomName().contains(LanguageManager.name))
        {
            PetsManager.getInstance().playSound(event.getRightClicked(), player);
        }
        if (player.getInventory().getItemInMainHand().getType() != Material.AIR)
        {
            if (Objects.requireNonNull(player.getInventory().getItemInMainHand().getItemMeta()).getDisplayName().contains(LanguageManager.name))
            {
                event.setCancelled(true);
                player.updateInventory();
            }
        }
    }
}