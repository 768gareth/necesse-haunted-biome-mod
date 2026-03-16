package HauntedBiome.Registry;

import HauntedBiome.Mobs.VoidCavelingMob;
import HauntedBiome.Mobs.ZombieMageMob;
import HauntedBiome.Mobs.ZombieVillagerMob;
import HauntedBiome.Mobs.ZombieWarriorMob;
import necesse.engine.registries.MobRegistry;

public class RegisterMobs 
{
    public static void Register()
    {
        MobRegistry.registerMob("void_caveling", VoidCavelingMob.class, true);

        MobRegistry.registerMob("zombie_villager", ZombieVillagerMob.class, true);
        MobRegistry.registerMob("zombie_warrior", ZombieWarriorMob.class, true);
        MobRegistry.registerMob("zombie_mage", ZombieMageMob.class, true);
    }
}
