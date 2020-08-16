package ep.java.Events;

import ep.java.Manager.PetsManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnPlayerQuit implements Listener
{
    @EventHandler
    public void onDisconnect(final PlayerQuitEvent event)
    {
        PetsManager.getInstance().removePet(event.getPlayer());
    }
}