package HauntedBiome;

import HauntedBiome.Mobs.AncientGhoulMob;
import HauntedBiome.Mobs.BoneConstructMob;
import HauntedBiome.Mobs.GhoulMob;
import HauntedBiome.Mobs.VoidCaveling;
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

// TODO: List of tasks to complete below.
/*  1. Tweak mob sprites until suitable for art style.
    2. Implement void spirit for deep caves.
    3. Implement more mobs generally to fill out spawn lists. Could do mini spiders for the surface?
    4. Implement mini-bosses and relevant presets for them to spawn in. Dark Disciple? Necromancer? Drop large numbers of void fragments and a trinket from
    the list of biome trinkets, that should work.
    5. Implement new trinkets to fill out spawn lists for treasures. Ruinstone, Void Amulet, what else?
    6. Need presets for the surface, too. Could do miniature shrines with some treasure instead, like that old pirate outpost preset idea?
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
        System.out.println("[Haunted Biome Mod] Mod initialisation complete.");
    }

    public void initResources() 
    {
        GhoulMob.Texture = new HumanTexture(fromFile("ghoul"), fromFile("ghoul_arms_left"), fromFile("ghoul_arms_right"));
        BoneConstructMob.Texture = new HumanTexture(fromFile("bone_construct"), fromFile("bone_construct_arms_left"), fromFile("bone_construct_arms_right"));
        AncientGhoulMob.Texture = new HumanTexture(fromFile("ancient_ghoul"), fromFile("ancient_ghoul_arms_left"), fromFile("ancient_ghoul_arms_right"));
        VoidCaveling.TextureTemp = new HumanTexture(fromFile("void_caveling"), fromFile("void_caveling_arms_back"), fromFile("void_caveling_arms_front"));
    }

    public void postInit() 
    {
        System.out.println("[Haunted Biome Mod] Mod post-initialisation complete. Please enjoy!");
    }

}
