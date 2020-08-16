package ep.java.Pathfinder;

import ep.java.Config.LanguageManager;
import net.minecraft.server.v1_15_R1.*;

import java.util.EnumSet;

public class PathfinderGoalPet extends PathfinderGoal
{
    private final EntityInsentient a;

    private EntityLiving b;

    private final double f;

    private final float g;

    private double c;
    private double d;
    private double e;

    public PathfinderGoalPet(EntityInsentient a, double f, float g)
    {
        this.a = a;
        this.f = f;
        this.g = g;
        this.a(EnumSet.of(Type.MOVE));
    }

    @Override
    public boolean a()
    {
        this.b = this.a.getGoalTarget();
        if (this.b == null)
        {
            return false;
        }
        else if (this.a.getDisplayName() == null)
        {
            return false;
        }
        else if (!this.a.getDisplayName().toString().contains(LanguageManager.name))
        {
            return false;
        }
        else if (b.h(this.a) > (double) (this.g * this.g))
        {
            this.a.setPosition(this.b.locX(), this.b.locY(), this.b.locZ());
            return false;
        }
        else
        {

            if (this.a instanceof EntityCreature)
            {
                Vec3D vec = RandomPositionGenerator.a((EntityCreature) this.a, 16, 7, this.b.getPositionVector());
                if (vec == null)
                {
                    return false;
                }
            }

            this.c = this.b.locX();
            this.d = this.b.locY();
            this.e = this.b.locZ();
            return true;
        }
    }

    public void c()
    {
        this.a.getNavigation().a(this.c, this.d, this.e, this.f);
    }

    public boolean b()
    {
        return !this.a.getNavigation().m() && this.b.h(this.a) < (double) (this.g * this.g);
    }

    public void d()
    {
        this.b = null;
    }
}
