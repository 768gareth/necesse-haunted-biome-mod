package HauntedBiome.Registry;

import HauntedBiome.Mobs.VoidCavelingMob;
import necesse.engine.registries.MobRegistry;

public class RegisterMobs 
{
    public static void Register()
    {
        MobRegistry.registerMob("void_caveling", VoidCavelingMob.class, true);
    }
}
