package ep.java.CustomEntity;

import net.minecraft.server.v1_15_R1.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent;


public class PetSlime extends EntitySlime
{
    public PetSlime(Location loc, Player p)
    {
        super(EntityTypes.SLIME, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());
        this.setInvulnerable(true);
        this.setSize(1,true);
        this.setGoalTarget((EntityLiving) ((CraftPlayer) p).getHandle(), EntityTargetEvent.TargetReason.CUSTOM, true);
    }
}
