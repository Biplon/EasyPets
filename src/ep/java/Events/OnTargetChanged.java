package ep.java.Events;

import ep.java.Config.LanguageManager;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;

public class OnTargetChanged implements Listener
{
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamage(EntityTargetLivingEntityEvent event)
    {
        Entity entity = event.getTarget();
        if (entity !=null)
        {
            if (entity.getCustomName() != null && entity.getCustomName().contains(LanguageManager.name))
            {
                event.setTarget(null);
                event.setCancelled(true);
            }
        }
    }
}
