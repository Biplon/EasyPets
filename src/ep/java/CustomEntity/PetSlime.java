package ep.java.CustomEntity;

import ep.java.Pathfinder.PathfinderGoalPet;
import ep.java.Pathfinder.PathfinderGoalPetSlime;
import net.minecraft.server.v1_15_R1.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent;


public class PetSlime extends EntitySlime implements PetPlaySound
{
    public PetSlime(Location loc, Player p)
    {
        super(EntityTypes.SLIME, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());
        this.setInvulnerable(true);
        this.setSize(1,true);
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
        super.initPathfinder();
        this.goalSelector.a(0, new PathfinderGoalPetSlime(this, 1, 10));
    }

    @Override
    public Sound getSound()
    {
        return Sound.ENTITY_SLIME_HURT_SMALL;
    }
}
