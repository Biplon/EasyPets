package ep.java.Config;

import ep.java.EasyPets;

import java.io.File;

public class ConfigManager
{
    public static void loadConfig()
    {
        File configFile = new File("plugins" + File.separator + EasyPets.getInstance().getName() + File.separator + "config.yml");
        if (!configFile.exists())
        {
            EasyPets.getInstance().getLogger().info("Creating config ...");
            EasyPets.getInstance().saveDefaultConfig();
        }
        try
        {
            EasyPets.getInstance().getLogger().info("Loading the config ...");
            EasyPets.getInstance().getConfig().load(configFile);
        }
        catch (Exception e)
        {
            EasyPets.getInstance().getLogger().severe("Could not load the config! Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
