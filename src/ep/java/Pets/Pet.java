package ep.java.Pets;


import ep.java.Config.LanguageManager;
import ep.java.CustomEntity.*;
import net.minecraft.server.v1_15_R1.ChatComponentText;
import net.minecraft.server.v1_15_R1.Entity;

import net.minecraft.server.v1_15_R1.EnumColor;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;


import org.bukkit.entity.*;



public class Pet
{
    private final Player owner;

    private Entity myEntity;

    public Player getOwner()
    {
        return owner;
    }

    public Pet(Player p, PetStruct ps)
    {
        this.owner = p;
        Entity enti = null;

        if (ps.getMyEntityType() == EntityType.BEE)
        {
            enti = new PetBee(p.getLocation(),p);
        }
        else if (ps.getMyEntityType() == EntityType.CAT)
        {
            enti = new PetCat(p.getLocation(),p);
        }
        else if (ps.getMyEntityType() == EntityType.CHICKEN)
        {
            enti = new PetChicken(p.getLocation(),p);
        }
        else if (ps.getMyEntityType() == EntityType.COW)
        {
            enti = new PetCow(p.getLocation(),p);
        }
        else if (ps.getMyEntityType() == EntityType.SHEEP)
        {
            enti = new PetSheep(p.getLocation(),p, EnumColor.valueOf(ps.getColor().name()));
        }
        else if (ps.getMyEntityType() == EntityType.FOX)
        {
            enti = new PetFox(p.getLocation(),p,ps.getType());
        }
        else if (ps.getMyEntityType() == EntityType.HUSK)
        {
            enti = new PetHusk(p.getLocation(),p);
        }
        else if (ps.getMyEntityType() == EntityType.MUSHROOM_COW)
        {
            enti = new PetMushroomCow(p.getLocation(),p);
        }
        else if (ps.getMyEntityType() == EntityType.OCELOT)
        {
            enti = new PetOcelot(p.getLocation(),p);
        }
        else if (ps.getMyEntityType() == EntityType.SLIME)
        {
            enti = new PetSlime(p.getLocation(),p);
        }
        else if (ps.getMyEntityType() == EntityType.PANDA)
        {
            enti = new PetPanda(p.getLocation(),p);
        }
        else if (ps.getMyEntityType() == EntityType.PIG)
        {
            enti = new PetPig(p.getLocation(),p);
        }
        else if (ps.getMyEntityType() == EntityType.POLAR_BEAR)
        {
            enti = new PetPolar(p.getLocation(),p);
        }
        else if (ps.getMyEntityType() == EntityType.RABBIT)
        {
            enti = new PetRabbit(p.getLocation(),p);
        }
        else if (ps.getMyEntityType() == EntityType.SILVERFISH)
        {
            enti = new PetSilverfish(p.getLocation(),p);
        }
        else if (ps.getMyEntityType() == EntityType.TURTLE)
        {
            enti = new PetTurtle(p.getLocation(),p);
        }
        else if (ps.getMyEntityType() == EntityType.VILLAGER)
        {
            enti = new PetVillager(p.getLocation(),p);
        }
        else if (ps.getMyEntityType() == EntityType.WOLF)
        {
            enti = new PetWolf(p.getLocation(),p);
        }
        else if (ps.getMyEntityType() == EntityType.ZOMBIE)
        {
            enti = new PetZombie(p.getLocation(),p);
        }
        else if (ps.getMyEntityType() == EntityType.ZOMBIE_VILLAGER)
        {
            enti = new PetZVillager(p.getLocation(),p);
        }
        else if (ps.getMyEntityType() == EntityType.ENDERMITE)
        {
            enti = new PetEndermite(p.getLocation(),p);
        }
        else if (ps.getMyEntityType() == EntityType.BAT)
        {
            enti = new PetBat(p.getLocation(),p);
        }
        else if (ps.getMyEntityType() == EntityType.MAGMA_CUBE)
        {
            enti = new PetMSlime(p.getLocation(),p);
        }
        ((CraftWorld) p.getWorld()).getHandle().addEntity(enti);
        enti.setCustomName(new ChatComponentText(LanguageManager.name + "" + ps.getName()));
        enti.setCustomNameVisible(true);
        myEntity = enti;
    }

    public void disable()
    {
        myEntity.die();
    }
}
