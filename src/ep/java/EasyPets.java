package ep.java;

import ep.java.Commands.ChangePetNameCommand;
import ep.java.Commands.GivePlayerPetCommand;
import ep.java.Config.LanguageManager;
import ep.java.Events.*;
import ep.java.Manager.PetsManager;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import ep.java.Config.ConfigManager;

import java.util.Objects;

public class EasyPets extends JavaPlugin
{
    private static EasyPets instance;

    public static EasyPets getInstance()
    {
        return instance;
    }

    @Override
    public void onEnable()
    {
        instance = this;
        ConfigManager.loadConfig();
        LanguageManager.loadLang();
        new PetsManager();
        PetsManager.getInstance().loadPets();
        regCommands();
        regEvents();
    }

    private void regCommands()
    {
        Objects.requireNonNull(this.getCommand("epgive")).setExecutor(new GivePlayerPetCommand());
        Objects.requireNonNull(this.getCommand("epchangename")).setExecutor(new ChangePetNameCommand());
    }

    private void regEvents()
    {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new OnPlayerClicks(), this);
        pm.registerEvents(new OnEntityDamage(), this);
        pm.registerEvents(new OnTargetChanged(), this);
        pm.registerEvents(new OnPlayerQuit(), this);
        pm.registerEvents(new OnPlayerInteractEntity(), this);
    }

    @Override
    public void onDisable()
    {
        HandlerList.unregisterAll(this);
        PetsManager.getInstance().removePets();
    }
}
