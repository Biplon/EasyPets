package ep.java.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ep.java.Manager.PetsManager;

public class GivePlayerPetCommand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args)
    {
        if (commandSender instanceof Player)
        {
            Player player = (Player) commandSender;
            if (!player.hasPermission("sp.admin"))
            {
                return false;
            }
            else
            {
                if (args.length == 2)
                {
                    PetsManager.getInstance().getPlayerPet(args[0],args[1]);
                    return true;
                }
            }
        }
        else
        {
            if (args.length == 1)
            {
                PetsManager.getInstance().getPlayerAllPets(args[0]);
                return true;
            }
            else if (args.length == 2)
            {
                PetsManager.getInstance().getPlayerPet(args[0],args[1]);
                return true;
            }
        }
        return false;
    }
}