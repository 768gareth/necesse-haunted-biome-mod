package HauntedBiome;

import HauntedBiome.Mobs.VoidCavelingMob;
import HauntedBiome.Registry.RegisterBuffs;
import HauntedBiome.Registry.RegisterItems;
import HauntedBiome.Registry.RegisterJournal;
import HauntedBiome.Registry.RegisterMobs;
import HauntedBiome.Registry.RegisterObjects;
import HauntedBiome.Registry.RegisterRecipes;
import HauntedBiome.Registry.RegisterTiles;
import HauntedBiome.Registry.RegisterWorldPresets;
import HauntedBiome.World.HauntedBiome;
import necesse.engine.modLoader.annotations.ModEntry;
import necesse.engine.registries.BiomeRegistry;
import static necesse.engine.registries.MobRegistry.Textures.fromFile;
import necesse.entity.mobs.HumanTexture;

/* TODO: major list of stuff
    1. Mage enemy that inflicts Ruin debuff?
    2. Special preset that uses Void stuff, spawns in a constant supply of enemies via the Void Gateway mob.
    3. Presets representing void cult shrines, temples, etc.
    4. Void Cultist as the basic melee enemy, Void Scholar as the ranged mage enemy. Based off of Runebound enemies so they can open doors.
    5. Add more furniture types.
    6. A specific flower type as well? 'Death Blossom' perhaps? A nice ominous glowing flower.
    7. Need journal challenges with related reward items as well. A cosmetic set for surface, some utility items for caves/deep caves.
    8. Surface challenges: Find a special rare item that spawns in a specific preset, kill X lost souls,
    9. Cave challenges: Kill a Void Scholar, find a special rare item, defeat a Void Gateway
    10. Deep cave challenges: Defeat a Void Revenant, find a special rare item, defeat a Deep Void Gateway

*/

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
        RegisterWorldPresets.Register();
        RegisterRecipes.Register();
        RegisterJournal.Register();
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
