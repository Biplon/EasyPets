package ep.java.CustomEntity;

import ep.java.Pathfinder.PathfinderGoalPet;
import net.minecraft.server.v1_15_R1.*;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent;

import java.util.Objects;

public class PetParrot extends EntityParrot implements PetPlaySound
{

    public PetParrot(Location loc, Player p,int variant)
    {
        super(EntityTypes.PARROT, ((CraftWorld) Objects.requireNonNull(loc.getWorld())).getHandle());
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());
        this.setInvulnerable(true);
        this.setVariant(variant);
        this.setOwnerUUID(p.getUniqueId());
        this.setGoalTarget(((CraftPlayer) p).getHandle(), EntityTargetEvent.TargetReason.CUSTOM, true);
    }

    @Override
    public void setOnFire(int i, boolean callEvent) { }

    @Override
    protected void collideNearby() { }

    @Override
    public boolean isCollidable(){return false;}

    @Override
    protected void initPathfinder()
    {
        this.goalSelector.a(0, new PathfinderGoalPet(this, 2, 15));
        this.goalSelector.a(2, new PathfinderGoalRandomFly(this, 1.0D));
    }

    @Override
    public Sound getSound()
    {
        return Sound.ENTITY_PARROT_AMBIENT;
    }
}
