package HauntedBiome.Registry;

import HauntedBiome.Mobs.Caves.VoidGatewayMinionMob;
import HauntedBiome.Mobs.Caves.VoidGatewayMob;
import HauntedBiome.Mobs.Caves.VoidScholarMob;
import HauntedBiome.Mobs.Caves.VoidWarrior;
import HauntedBiome.Mobs.Critters.CrowMob;
import HauntedBiome.Mobs.Critters.DeepVoidCavelingMob;
import HauntedBiome.Mobs.Critters.VoidCavelingMob;
import HauntedBiome.Mobs.Critters.VoidCrawlerMob;
import HauntedBiome.Mobs.DeepCaves.DeepVoidGatewayMinionMob;
import HauntedBiome.Mobs.DeepCaves.DeepVoidGatewayMob;
import HauntedBiome.Mobs.DeepCaves.VoidArcanistMob;
import HauntedBiome.Mobs.DeepCaves.VoidSentinelMob;
import HauntedBiome.Mobs.Surface.UndeadCultist;
import HauntedBiome.Mobs.Surface.VoidCultistHumanMob;
import necesse.engine.registries.MobRegistry;

public class RegisterMobs 
{
    public static void Register()
    {
        // Neutral
        MobRegistry.registerMob("void_caveling", VoidCavelingMob.class, true);
        MobRegistry.registerMob("deep_void_caveling", DeepVoidCavelingMob.class, true);
        MobRegistry.registerMob("crow", CrowMob.class, true);
        MobRegistry.registerMob("void_cultist_human", VoidCultistHumanMob.class, true);
        MobRegistry.registerMob("void_crawler", VoidCrawlerMob.class, true);

        // Surface
        MobRegistry.registerMob("undead_cultist", UndeadCultist.class, true);

        // Caves
        MobRegistry.registerMob("void_warrior", VoidWarrior.class, true);
        MobRegistry.registerMob("void_scholar", VoidScholarMob.class, true);
        MobRegistry.registerMob("void_gateway_boss", VoidGatewayMob.class, true);
        MobRegistry.registerMob("void_gateway_minion", VoidGatewayMinionMob.class, true);

        // Deep Caves
        MobRegistry.registerMob("deep_void_arcanist", VoidArcanistMob.class, true);
        MobRegistry.registerMob("deep_void_sentinel", VoidSentinelMob.class, true);
        MobRegistry.registerMob("deep_void_gateway_boss", DeepVoidGatewayMob.class, true);
        MobRegistry.registerMob("deep_void_gateway_minion", DeepVoidGatewayMinionMob.class, true);
        
    }
}
