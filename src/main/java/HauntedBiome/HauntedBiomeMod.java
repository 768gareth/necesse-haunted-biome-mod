package HauntedBiome;

import HauntedBiome.Mobs.VoidCavelingMob;
import HauntedBiome.Registry.RegisterBuffs;
import HauntedBiome.Registry.RegisterItems;
import HauntedBiome.Registry.RegisterMobs;
import HauntedBiome.Registry.RegisterObjects;
import HauntedBiome.Registry.RegisterTiles;
import HauntedBiome.World.HauntedBiome;
import necesse.engine.modLoader.annotations.ModEntry;
import necesse.engine.registries.BiomeRegistry;
import static necesse.engine.registries.MobRegistry.Textures.fromFile;
import necesse.entity.mobs.HumanTexture;

@ModEntry
public class HauntedBiomeMod 
{
    public void init() 
    {
        System.out.println("[Haunted Biome Mod] Initialising mod...");
        BiomeRegistry.registerBiome("haunted_biome", new HauntedBiome().setGenerationWeight(0.75f), true);
        RegisterItems.Register();
        RegisterObjects.Register();
        RegisterTiles.Register();
        RegisterMobs.Register();
        RegisterBuffs.Register();
        System.out.println("[Haunted Biome Mod] Mod initialisation complete.");
    }

    public void initResources() 
    {
        VoidCavelingMob.TextureTemp = new HumanTexture(fromFile("void_caveling"), fromFile("void_caveling_arms_back"), fromFile("void_caveling_arms_front"));
    }

    public void postInit() 
    {
        System.out.println("[Haunted Biome Mod] Mod post-initialisation complete.");
    }

}
