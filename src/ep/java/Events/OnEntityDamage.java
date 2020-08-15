package ep.java.Events;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import ep.java.Config.LanguageManager;


public class OnEntityDamage implements Listener
{
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamage(EntityDamageByEntityEvent event)
    {
        Entity entity = event.getDamager();
        if (entity.getCustomName() != null && entity.getCustomName().contains(LanguageManager.name))
        {
            event.setCancelled(true);
        }
    }
}
