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

public class PetSheep extends EntitySheep implements PetPlaySound
{
    public PetSheep(Location loc, Player p, EnumColor color)
    {
        super(EntityTypes.SHEEP, ((CraftWorld) Objects.requireNonNull(loc.getWorld())).getHandle());
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());
        this.setInvulnerable(true);
        this.setAge(-1);
        this.ageLocked = true;
        this.setColor(color);
        this.setGoalTarget(((CraftPlayer) p).getHandle(), EntityTargetEvent.TargetReason.CUSTOM, true);
    }

    @Override
    public void setOnFire(int i, boolean callEvent)
    {
    }

    @Override
    protected void collideNearby()
    {
    }

    @Override
    public boolean isCollidable()
    {
        return false;
    }

    @Override
    protected void initPathfinder()
    {
        super.initPathfinder();
        this.goalSelector.a(0, new PathfinderGoalPet(this, 1, 15));
    }

    @Override
    public Sound getSound()
    {
        return Sound.ENTITY_SHEEP_AMBIENT;
    }
}
