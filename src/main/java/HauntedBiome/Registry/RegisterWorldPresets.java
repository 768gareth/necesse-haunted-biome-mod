package HauntedBiome.Registry;

import HauntedBiome.World.DeepCavesVoidFlameShrineWorldPreset;
import necesse.engine.registries.BiomeRegistry;
import necesse.engine.registries.WorldPresetRegistry;
import necesse.engine.util.LevelIdentifier;
import necesse.engine.world.worldPresets.CustomCrystalsWorldPreset;

public class RegisterWorldPresets 
{
    public static void Register()
    {
        WorldPresetRegistry.registerPreset("void_fragment_clusters_caves", new CustomCrystalsWorldPreset(BiomeRegistry.getBiome("haunted_biome"), LevelIdentifier.CAVE_IDENTIFIER, 0.02F, "void_gravel_tile", "void_fragment_cluster_small", "void_fragment_cluster_large"));
        WorldPresetRegistry.registerPreset("void_fragment_clusters_deep_caves", new CustomCrystalsWorldPreset(BiomeRegistry.getBiome("haunted_biome"), LevelIdentifier.DEEP_CAVE_IDENTIFIER, 0.01F, "void_gravel_tile", "void_fragment_cluster_small", "void_fragment_cluster_large"));
        WorldPresetRegistry.registerPreset("deep_caves_void_flame_shrine", new DeepCavesVoidFlameShrineWorldPreset());
    }
}
