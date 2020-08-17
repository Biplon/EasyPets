package ep.java.Commands;

import ep.java.Config.ConfigManager;
import ep.java.Config.LanguageManager;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class ChangePetNameCommand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args)
    {
        if (commandSender instanceof Player)
        {
            Player player = (Player) commandSender;
            if (!player.hasPermission("ep.changename"))
            {
                return false;
            }
            else
            {
                if (player.getInventory().getItemInMainHand().getType() != Material.AIR && Objects.requireNonNull(player.getInventory().getItemInMainHand().getItemMeta()).getDisplayName().contains(LanguageManager.name))
                {
                    if (args.length == 1)
                    {
                        if (args[0].contains("&"))
                        {
                            if (!player.hasPermission("ep.changenamecolor"))
                            {
                                return false;
                            }
                        }
                        if(args[0].length() <= ConfigManager.nameSize)
                        {
                            ItemStack i = player.getInventory().getItemInMainHand();
                            ItemMeta im = i.getItemMeta();
                            im.setDisplayName(LanguageManager.name + args[0].replace("&", "§"));
                            i.setItemMeta(im);
                            return true;
                        }
                        else
                        {
                            player.sendMessage(LanguageManager.nameToLong);
                        }
                    }
                }
                else
                {
                    player.sendMessage(LanguageManager.witem);
                }
            }
        }
        return false;
    }
}