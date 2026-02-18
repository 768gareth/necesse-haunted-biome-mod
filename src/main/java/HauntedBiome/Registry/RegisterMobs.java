package HauntedBiome.Registry;

import HauntedBiome.Mobs.AncientGhoulMob;
import HauntedBiome.Mobs.BoneConstructMob;
import HauntedBiome.Mobs.GhoulMob;
import HauntedBiome.Mobs.VoidCaveling;
import necesse.engine.registries.MobRegistry;

public class RegisterMobs 
{
    public static void Register()
    {
        MobRegistry.registerMob("ghoul", GhoulMob.class, true);
        MobRegistry.registerMob("bone_construct", BoneConstructMob.class, true);
        MobRegistry.registerMob("ancient_ghoul", AncientGhoulMob.class, true);
        MobRegistry.registerMob("void_caveling", VoidCaveling.class, true);
    }
}
