package HauntedBiome;

import HauntedBiome.Mobs.DeepCaves.VoidArcanistMob;
import HauntedBiome.Mobs.DeepCaves.VoidSentinelMob;
import HauntedBiome.Mobs.VoidCavelingMob;
import HauntedBiome.Registry.RegisterBuffs;
import HauntedBiome.Registry.RegisterItems;
import HauntedBiome.Registry.RegisterJournal;
import HauntedBiome.Registry.RegisterMobs;
import HauntedBiome.Registry.RegisterObjects;
import HauntedBiome.Registry.RegisterProjectiles;
import HauntedBiome.Registry.RegisterRecipes;
import HauntedBiome.Registry.RegisterTiles;
import HauntedBiome.Registry.RegisterWorldPresets;
import HauntedBiome.World.HauntedBiome;
import necesse.engine.modLoader.annotations.ModEntry;
import necesse.engine.registries.BiomeRegistry;
import necesse.engine.registries.MobRegistry;
import static necesse.engine.registries.MobRegistry.Textures.fromFile;
import necesse.entity.mobs.HumanTexture;

/* TODO: major list of stuff
    1. Mage enemy that inflicts Ruin debuff?
    2. Special preset that uses Void stuff, spawns in a constant supply of enemies via the Void Gateway mob.
    3. Presets representing void cult shrines, temples, etc.
    4. Void Cultist as the basic melee enemy, Void Scholar as the ranged mage enemy. Based off of Runebound enemies so they can open doors.
    5. Add more furniture types, more table decorations, perhaps some wall decorations?
    6. A specific flower type as well? 'Death Blossom' perhaps? A nice ominous glowing flower.
    7. Need journal challenges with related reward items as well. A cosmetic set for surface, some utility items for caves/deep caves.
    8. Surface challenges: Find a special rare item that spawns in a specific preset, kill X lost souls,
    9. Cave challenges: Kill a Void Scholar, find a special rare item, defeat a Void Gateway
    10. Deep cave challenges: Defeat a Void Revenant, find a special rare item, defeat a Deep Void Gateway.
    11. Soul Eater, a Deep Caves melee weapon that adds a stack of Soul Power on killing an enemy. Right click to consume all 
    stacks of Soul Power, gaining an equivalent number of stacks of a buff that grants +10% damage per stack until your next attack, thus
    buffing your next attack dramatically.
    12. Necromancer Staff, a Deep Caves Magic/Summoner weapon that adds a stack of Captured Souls on killing an enemy.
    right click to consume all stacks of Captured Souls, with each stack producing a temporary powerful summon for ten seconds.
    13. Reaper's Crossbow, a Deep Caves Ranged weapon that fires very slowly, but each bolt deals very high damage.
    14. Cursed Fire, a Deep Caves Magic weapon that launches a spray of void-cursed flames at enemies. Enemies are afflicted with a debuff
    that lasts only for a few seconds, but causes them to take more damage.
    16. Use 'Cosmic Noise' track for surface, 'Dark Streets' for underground?
    17. 
*/

/* TODO:
    - Add the weapons.
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
        RegisterProjectiles.Register();
        System.out.println("[Haunted Biome Mod] Mod initialisation complete.");
    }

    public void initResources() 
    {
        VoidCavelingMob.TextureTemp = new HumanTexture(fromFile("void_caveling"), fromFile("void_caveling_arms_back"), fromFile("void_caveling_arms_front"));
        VoidSentinelMob.texture = MobRegistry.Textures.humanTexture("void_sentinel", "void_sentinel_arms");
        VoidArcanistMob.texture = MobRegistry.Textures.humanTexture("void_arcanist", "void_sentinel_arms");
    }

    public void postInit() 
    {
        System.out.println("[Haunted Biome Mod] Mod post-initialisation complete.");
    }

}
