package ep.java.CustomEntity;

import ep.java.Pathfinder.PathfinderGoalPet;
import net.minecraft.server.v1_15_R1.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent;

public class PetZombie extends EntityZombie
{

    public PetZombie(Location loc, Player p)
    {
        super(EntityTypes.ZOMBIE, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());
        this.setInvulnerable(true);
        this.setBaby(true);
        this.setGoalTarget((EntityLiving) ((CraftPlayer) p).getHandle(), EntityTargetEvent.TargetReason.CUSTOM, true);
    }

    @Override
    protected void initPathfinder()
    {
        this.goalSelector.a(0, new PathfinderGoalFloat(this));
        this.goalSelector.a(1, new PathfinderGoalPet(this, 1, 15));
        this.goalSelector.a(2, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
    }
}

