package ep.java.CustomEntity;

import net.minecraft.server.v1_15_R1.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent;

public class PetSheep extends EntitySheep
{
    public PetSheep(Location loc, Player p, EnumColor color)
    {
        super(EntityTypes.SHEEP, ((CraftWorld)loc.getWorld()).getHandle());
        this.setPosition(loc.getX(),loc.getY(),loc.getZ());
        this.setInvulnerable(true);
        this.setAge(-1);
        this.ageLocked = true;
        this.setColor(color);
        this.setGoalTarget((EntityLiving)((CraftPlayer)p).getHandle(), EntityTargetEvent.TargetReason.CUSTOM,true);
    }
}
