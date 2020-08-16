package ep.java.CustomEntity;

import net.minecraft.server.v1_15_R1.*;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent;
import ep.java.Pathfinder.PathfinderGoalPet;

public class PetChicken extends EntityChicken implements PetPlaySound
{

    public PetChicken(Location loc, Player p)
    {
        super(EntityTypes.CHICKEN, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());
        this.setInvulnerable(true);
        this.setAge(-1);
        this.ageLocked = true;
        this.setGoalTarget((EntityLiving) ((CraftPlayer) p).getHandle(), EntityTargetEvent.TargetReason.CUSTOM, true);
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
        this.goalSelector.a(0, new PathfinderGoalFloat(this));
        this.goalSelector.a(1, new PathfinderGoalPet(this, 1, 15));
        this.goalSelector.a(2, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
        this.goalSelector.a(3, new PathfinderGoalRandomLookaround(this));
    }

    @Override
    public Sound getSound()
    {
        return Sound.ENTITY_CHICKEN_AMBIENT;
    }
}
