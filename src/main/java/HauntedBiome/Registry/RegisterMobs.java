package HauntedBiome.Registry;

import HauntedBiome.Mobs.Caves.VoidCultistMob;
import HauntedBiome.Mobs.DeepCaves.VoidArcanistMob;
import HauntedBiome.Mobs.DeepCaves.VoidSentinelMob;
import HauntedBiome.Mobs.Surface.HauntedSkeleton;
import HauntedBiome.Mobs.VoidCavelingMob;
import HauntedBiome.Mobs.VoidGatewayMinionMob;
import HauntedBiome.Mobs.VoidGatewayMob;
import necesse.engine.registries.MobRegistry;

public class RegisterMobs 
{
    public static void Register()
    {
        // Neutral
        MobRegistry.registerMob("void_caveling", VoidCavelingMob.class, true);
        // TODO: Need unique critters!

        // Surface
        MobRegistry.registerMob("haunted_skeleton", HauntedSkeleton.class, true);

        // Caves
        MobRegistry.registerMob("void_cultist", VoidCultistMob.class, true);
        // Void Scholar (rarer ranged enemy with more powerful magic, serves a mini-mini-boss that drops some nice loot)

        // Deep Caves
        // Void Devourer (worm enemy)
        // Void Ascendant (attacks using ranged magic, summons weak skeletons)
        MobRegistry.registerMob("void_arcanist", VoidArcanistMob.class, true);
        MobRegistry.registerMob("void_sentinel", VoidSentinelMob.class, true);

        // Boss/misc
        MobRegistry.registerMob("void_gateway_boss", VoidGatewayMob.class, true);
        MobRegistry.registerMob("void_gateway_minion", VoidGatewayMinionMob.class, true);
    }
}
