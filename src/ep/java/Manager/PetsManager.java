package ep.java.Manager;

import ep.java.Config.LanguageManager;
import ep.java.CustomEntity.PetPlaySound;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ep.java.Pets.Pet;
import ep.java.Pets.PetStruct;
import ep.java.EasyPets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class PetsManager
{
    private static PetsManager instance;

    public static PetsManager getInstance()
    {
        return instance;
    }

    private final List<PetStruct> petList = new ArrayList<>();

    private List<Pet> activePets = new ArrayList<>();

    public PetsManager()
    {
        instance = this;
    }

    public void loadPets()
    {
        try
        {
            File file = new File(EasyPets.getInstance().getDataFolder() + "/pets.txt");
            BufferedReader reader;
            reader = new BufferedReader(new FileReader(file));
            String text;
            while ((text = reader.readLine()) != null)
            {
                String[] tmp = text.split(",");
                if (tmp.length == 3)
                {
                    petList.add(new PetStruct(tmp[0], EntityType.valueOf(tmp[1]), Material.valueOf(tmp[2])));
                }
                else if (tmp.length == 4)
                {
                    if (EntityType.valueOf(tmp[1]) == EntityType.FOX)
                    {
                        petList.add(new PetStruct(tmp[0], EntityType.valueOf(tmp[1]), Material.valueOf(tmp[2]), Fox.Type.valueOf(tmp[3])));
                    }
                    else if (EntityType.valueOf(tmp[1]) == EntityType.PARROT || EntityType.valueOf(tmp[1]) == EntityType.LLAMA || EntityType.valueOf(tmp[1]) == EntityType.HORSE || EntityType.valueOf(tmp[1]) == EntityType.CAT)
                    {
                        petList.add(new PetStruct(tmp[0], EntityType.valueOf(tmp[1]), Material.valueOf(tmp[2]), Integer.parseInt(tmp[3])));
                    }
                    else
                    {
                        petList.add(new PetStruct(tmp[0], EntityType.valueOf(tmp[1]), Material.valueOf(tmp[2]), DyeColor.valueOf(tmp[3])));
                    }
                }
            }
            reader.close();
        }
        catch (Exception ec)
        {
            Bukkit.getLogger().warning(ec.getMessage());
        }
    }

    public boolean setPlayerPet(String petName, Player p)
    {
        return createPet(petName, p);
    }

    private PetStruct getPetStruct(String name)
    {
        for (PetStruct p : petList)
        {
            if (p.getName().equals(name))
            {
                return p;
            }
        }
        return null;
    }

    public boolean playerPetActive(Player p)
    {
        clearList();
        for (Pet pet : activePets)
        {
            if (pet.getOwner() == p)
            {
                return true;
            }
        }
        return false;
    }

    public void playSound(Entity e, Player p)
    {
        for (Pet pet : activePets)
        {
            if (pet.getMyEntity().getDisplayName().getText().contains(Objects.requireNonNull(e.getCustomName())))
            {
                World w = p.getWorld();
                w.playSound(p.getLocation(), ((PetPlaySound) pet.getMyEntity()).getSound(), 10, 1);
            }
        }
    }

    private boolean createPet(String petName, Player p)
    {
        if (getPetStruct(petName) != null)
        {
            activePets.add(new Pet(p, Objects.requireNonNull(getPetStruct(petName))));
            return true;
        }
        else
        {
            return false;
        }
    }

    public void removePet(Player player)
    {
        for (Pet p : activePets)
        {
            if (p.getOwner() == player)
            {
                p.disable();
            }
        }
        clearList();
    }

    public void getPlayerPet(String arg, String arg1)
    {
        Map<Integer, ItemStack> map;
        Player p = Bukkit.getPlayer(arg);
        if (p != null)
        {
            for (PetStruct petStruct : petList)
            {
                if (petStruct.getName().equals(arg1))
                {
                    map = p.getInventory().addItem(createItem(petStruct.getItemMaterial(), LanguageManager.name + petStruct.getName(), LanguageManager.lore1, petStruct.getName(), LanguageManager.lore3));
                    if (map.size() == 1)
                    {
                        for (final ItemStack item : map.values())
                        {
                            p.getWorld().dropItemNaturally(p.getLocation(), item);
                        }
                        map.clear();
                    }
                    return;
                }
            }
        }
    }

    public void removePets()
    {
        for (Pet m : activePets)
        {
            m.disable();
        }
        activePets.clear();
    }

    public static ItemStack createItem(final Material material, final String name, final String... lore)
    {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        assert meta != null;
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);

        return item;
    }

    public void getPlayerAllPets(String arg)
    {
        Player p = Bukkit.getPlayer(arg);
        if (p != null)
        {
            Map<Integer, ItemStack> map;
            for (PetStruct petStruct : petList)
            {
                map = p.getInventory().addItem(createItem(petStruct.getItemMaterial(), LanguageManager.name + petStruct.getName(), LanguageManager.lore1, petStruct.getName(), LanguageManager.lore3));
                if (map.size() == 1)
                {
                    for (final ItemStack item : map.values())
                    {
                        p.getWorld().dropItemNaturally(p.getLocation(), item);
                    }
                    map.clear();
                }
            }
        }
    }

    private void clearList()
    {
        List<Pet> tmpPets = new ArrayList<>();
        for (Pet p : activePets)
        {
            if (p.getMyEntity() != null && p.getOwner() != null && !p.getMyEntity().dead)
            {
                tmpPets.add(p);
            }
        }
        activePets = tmpPets;
    }
}
