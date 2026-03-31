package HauntedBiome.Registry;

import HauntedBiome.Mobs.VoidCavelingMob;
import HauntedBiome.Mobs.ZombieMageMob;
import HauntedBiome.Mobs.ZombieWarriorMob;
import necesse.engine.registries.MobRegistry;

public class RegisterMobs 
{
    // TODO: Could have *actual* demons/void entities in the Deep Caves? e.g Void Devourer is a big worm thing.
    public static void Register()
    {
        MobRegistry.registerMob("void_caveling", VoidCavelingMob.class, true);

        MobRegistry.registerMob("zombie_warrior", ZombieWarriorMob.class, true);
        MobRegistry.registerMob("zombie_mage", ZombieMageMob.class, true);
    }
}
