package ep.java.Pets;

import net.minecraft.server.v1_15_R1.EntityFox;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fox;

public class PetStruct
{
    private final String name;

    private final Material itemMaterial;

    private EntityType myEntityType;

    private DyeColor color;

    private EntityFox.Type type;

    public DyeColor getColor()
    {
        return color;
    }

    public net.minecraft.server.v1_15_R1.EntityFox.Type getType()
    {
        return type;
    }

    public String getName()
    {
        return name;
    }

    public EntityType getMyEntityType()
    {
        return myEntityType;
    }

    public Material getItemMaterial()
    {
        return itemMaterial;
    }

    public PetStruct(String name, EntityType myEntityType, Material material)
    {
        this.name = name;

        this.myEntityType = myEntityType;

        itemMaterial = material;
    }

    public PetStruct(String name, EntityType myEntityType, Material material, DyeColor color)
    {
        this.name = name;
        this.myEntityType = myEntityType;

        itemMaterial = material;
        this.color = color;
    }

    public PetStruct(String name, EntityType myEntityType, Material material, Fox.Type type)
    {
        this.name = name;
        this.myEntityType = myEntityType;
        itemMaterial = material;
        if (type == Fox.Type.RED)
        {
            this.type = EntityFox.Type.RED;
        }
        else
        {
            this.type = EntityFox.Type.SNOW;
        }
    }
}
