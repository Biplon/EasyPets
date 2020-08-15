package ep.java.CustomEntity;

import net.minecraft.server.v1_15_R1.EntityLiving;
import net.minecraft.server.v1_15_R1.EntityMagmaCube;
import net.minecraft.server.v1_15_R1.EntitySlime;
import net.minecraft.server.v1_15_R1.EntityTypes;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent;

public class PetMSlime extends EntityMagmaCube
{
    public PetMSlime(Location loc, Player p)
    {
        super(EntityTypes.MAGMA_CUBE, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());
        this.setInvulnerable(true);
        this.setSize(1,true);
        this.setGoalTarget((EntityLiving) ((CraftPlayer) p).getHandle(), EntityTargetEvent.TargetReason.CUSTOM, true);
    }
}
