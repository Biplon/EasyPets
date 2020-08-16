package ep.java.CustomEntity;

import net.minecraft.server.v1_15_R1.*;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_15_R1.event.CraftEventFactory;
import org.bukkit.entity.Player;

import java.util.Objects;

public class PetBat extends EntityBat implements PetPlaySound
{
    private final EntityLiving goal;

    public PetBat(Location loc, Player p)
    {
        super(EntityTypes.BAT, ((CraftWorld) Objects.requireNonNull(loc.getWorld())).getHandle());
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());
        this.setInvulnerable(true);
        goal = ((CraftPlayer) p).getHandle();
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
    protected void mobTick()
    {
        BlockPosition blockposition = new BlockPosition(this);
        BlockPosition blockposition1 = blockposition.up();
        if (this.isAsleep())
        {
            if (this.world.getType(blockposition1).isOccluding(this.world, blockposition))
            {
                if (this.random.nextInt(200) == 0)
                {
                    this.aK = (float) this.random.nextInt(360);
                }
            }
            else if (CraftEventFactory.handleBatToggleSleepEvent(this, true))
            {
                this.setAsleep(false);
                this.world.a(null, 1025, blockposition, 0);
            }
        }
        else
        {
            if (goal != null)
            {
                if (goal.h(this) > (double) (15 * 15))
                {
                    this.setPosition(this.goal.locX(), this.goal.locY(), this.goal.locZ());
                }
                else
                {
                    double d0 = this.goal.locX() + 0.5D - this.locX();
                    double d1 = this.goal.locY() + 0.1D - this.locY();
                    double d2 = this.goal.locZ() + 0.5D - this.locZ();
                    Vec3D vec3d = this.getMot();
                    Vec3D vec3d1 = vec3d.add((Math.signum(d0) * 0.5D - vec3d.x) * 0.10000000149011612D, (Math.signum(d1) * 0.699999988079071D - vec3d.y) * 0.10000000149011612D, (Math.signum(d2) * 0.5D - vec3d.z) * 0.10000000149011612D);
                    this.setMot(vec3d1);
                    float f = (float) (MathHelper.d(vec3d1.z, vec3d1.x) * 57.2957763671875D) - 90.0F;
                    float f1 = MathHelper.g(f - this.yaw);
                    this.bb = 0.5F;
                    this.yaw += f1;
                    if (this.random.nextInt(100) == 0 && this.world.getType(blockposition1).isOccluding(this.world, blockposition1) && CraftEventFactory.handleBatToggleSleepEvent(this, false))
                    {
                        this.setAsleep(true);
                    }
                }
            }
        }
    }

    @Override
    public Sound getSound()
    {
        return Sound.ENTITY_BAT_AMBIENT;
    }
}
