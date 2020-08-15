package ep.java.Config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import ep.java.EasyPets;

import java.io.File;

public class LanguageManager
{
    public static String name;
    public static String lore1;
    public static String lore3;

    public static void loadLang()
    {
        File configFile = new File("plugins" + File.separator + EasyPets.getInstance().getName() + File.separator + EasyPets.getInstance().getConfig().getString("general.lang") + ".yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(configFile);
        name = cfg.getString("name") != null ? cfg.getString("name") : "§6Pet: ";
        lore1 = cfg.getString("lore1") != null ? cfg.getString("lore1") : "'§0Item: Pet'";
        lore3 = cfg.getString("lore3") != null ? cfg.getString("lore3") : "'§6 Right click to summon'";
    }
}
