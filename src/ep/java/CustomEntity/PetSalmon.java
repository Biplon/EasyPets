package ep.java.CustomEntity;

import ep.java.Pathfinder.PathfinderGoalPet;
import net.minecraft.server.v1_15_R1.*;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_15_R1.event.CraftEventFactory;
import org.bukkit.entity.Player;

public class PetSalmon extends EntitySalmon implements PetPlaySound
{
    private EntityLiving goal;

    public PetSalmon(Location loc, Player p)
    {
        super(EntityTypes.SALMON, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());
        this.setInvulnerable(true);
        goal = ((EntityLiving) ((CraftPlayer) p).getHandle());
    }

    @Override
    public void setOnFire(int i, boolean callEvent) { }

    @Override
    protected void collideNearby() { }

    @Override
    protected void initPathfinder()
    {
    }

    @Override
    protected void mobTick()
    {
        super.mobTick();
        BlockPosition blockposition = new BlockPosition(this);
            if (goal.h( this) > (double) ( 15 *  15))
            {
                this.setPosition(this.goal.locX(), this.goal.locY(), this.goal.locZ());
            }
            else
            {
                double d0 = this.goal.locX() + 0.5D - this.locX() +  (Math.random() * 5) + 1;
                double d1 = this.goal.locY() + 0.1D - this.locY();
                double d2 = this.goal.locZ() + 0.5D - this.locZ() + (Math.random() * 5) + 1;
                Vec3D vec3d = this.getMot();
                Vec3D vec3d1 = vec3d.add((Math.signum(d0) * 0.5D - vec3d.x) * 0.10000000149011612D, (Math.signum(d1) * 0.699999988079071D - vec3d.y) * 0.10000000149011612D, (Math.signum(d2) * 0.5D - vec3d.z) * 0.10000000149011612D);
                this.setMot(vec3d1);
                float f = (float)(MathHelper.d(vec3d1.z, vec3d1.x) * 57.2957763671875D) - 90.0F;
                float f1 = MathHelper.g(f - this.yaw);
                this.bb = 0.5F;
                this.yaw += f1;

        }
    }

    @Override
    public Sound getSound()
    {
        return Sound.ENTITY_SALMON_AMBIENT;
    }
}
