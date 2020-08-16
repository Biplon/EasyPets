package ep.java.Pathfinder;

import ep.java.Config.LanguageManager;
import net.minecraft.server.v1_15_R1.*;

import java.util.EnumSet;

public class PathfinderGoalPetSlime extends PathfinderGoal
{
    private EntityLiving b;

    private final EntitySlime a;

    private final double f;

    private final float g;

    private double c;
    private double d;
    private double e;

    public PathfinderGoalPetSlime(EntitySlime entityslime, double f, float g)
    {
        this.a = entityslime;
        this.f = f;
        this.g = g;
        this.a(EnumSet.of(Type.MOVE));
    }

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
            this.c = this.b.locX() + 0.75F;
            this.d = this.b.locY();
            this.e = this.b.locZ() + 0.75F;
            return true;
        }
    }

    public void c()
    {
        this.a.getNavigation().a(this.c, this.d, this.e, this.f);
        super.c();
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
