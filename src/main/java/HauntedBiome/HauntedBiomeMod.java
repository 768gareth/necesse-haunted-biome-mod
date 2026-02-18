package HauntedBiome;

import HauntedBiome.Mobs.AncientGhoulMob;
import HauntedBiome.Mobs.BoneConstructMob;
import HauntedBiome.Mobs.GhoulMob;
import HauntedBiome.Registry.RegisterItems;
import HauntedBiome.Registry.RegisterMobs;
import HauntedBiome.Registry.RegisterObjects;
import HauntedBiome.Registry.RegisterStatusEffects;
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
        RegisterStatusEffects.Register();
        System.out.println("[Haunted Biome Mod] Mod initialisation complete. Please enjoy!");
    }

    public void initResources() 
    {
        GhoulMob.Texture = new HumanTexture(fromFile("ghoul"), fromFile("ghoul_arms_left"), fromFile("ghoul_arms_right"));
        BoneConstructMob.Texture = new HumanTexture(fromFile("bone_construct"), fromFile("bone_construct_arms_left"), fromFile("bone_construct_arms_right"));
        AncientGhoulMob.Texture = new HumanTexture(fromFile("ancient_ghoul"), fromFile("ancient_ghoul_arms_left"), fromFile("ancient_ghoul_arms_right"));
    }

    public void postInit() 
    {
        
    }

}
