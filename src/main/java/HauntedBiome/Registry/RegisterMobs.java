package HauntedBiome.Registry;

import HauntedBiome.Mobs.Caves.VoidCavelingMob;
import HauntedBiome.Mobs.Caves.VoidCultistMob;
import HauntedBiome.Mobs.Caves.VoidScholarMob;
import HauntedBiome.Mobs.DeepCaves.VoidArcanistMob;
import HauntedBiome.Mobs.DeepCaves.VoidSentinelMob;
import HauntedBiome.Mobs.Surface.CrowMob;
import HauntedBiome.Mobs.Surface.UndeadCultist;
import HauntedBiome.Mobs.VoidGatewayMinionMob;
import HauntedBiome.Mobs.VoidGatewayMob;
import necesse.engine.registries.MobRegistry;

public class RegisterMobs 
{
    public static void Register()
    {
        // Neutral
        MobRegistry.registerMob("void_caveling", VoidCavelingMob.class, true);
        MobRegistry.registerMob("crow", CrowMob.class, true);

        // Surface
        MobRegistry.registerMob("undead_cultist", UndeadCultist.class, true);

        // Caves
        MobRegistry.registerMob("void_cultist", VoidCultistMob.class, true);
        MobRegistry.registerMob("void_scholar", VoidScholarMob.class, true);

        // Deep Caves
        MobRegistry.registerMob("void_arcanist", VoidArcanistMob.class, true);
        MobRegistry.registerMob("void_sentinel", VoidSentinelMob.class, true);

        // Boss/misc
        MobRegistry.registerMob("void_gateway_boss", VoidGatewayMob.class, true);
        MobRegistry.registerMob("void_gateway_minion", VoidGatewayMinionMob.class, true);
    }
}
