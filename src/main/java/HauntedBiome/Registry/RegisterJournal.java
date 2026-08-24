package HauntedBiome.Registry;

import HauntedBiome.Utils.HauntedLootTables;
import necesse.engine.journal.JournalEntry;
import necesse.engine.registries.BiomeRegistry;
import necesse.engine.registries.JournalRegistry;
import necesse.engine.util.LevelIdentifier;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.LootTablePresets;

public class RegisterJournal 
{
    public static void Register()
    {
        JournalEntry HauntedSurface = JournalRegistry.registerJournalEntry("haunted_surface", new JournalEntry(BiomeRegistry.getBiome("haunted_biome"), LevelIdentifier.SURFACE_IDENTIFIER));
        HauntedSurface.addBiomeLootEntry
        (      
            new String[] 
            { 
                "haunted_log", "bloodberry", "gobfish", "halffish", "furfish", "carp", "herring",
                "mackerel", "salmon", "trout" 
            }
        );
        HauntedSurface.addMobEntries
        (
            new String[] 
            { 
                "undead_cultist", "spider", "crow"
            }
        );
        HauntedSurface.addTreasureEntry(new LootTable[] { LootTablePresets.surfaceRuinsChest });

        JournalEntry HauntedCaves = JournalRegistry.registerJournalEntry("haunted_caves", new JournalEntry(BiomeRegistry.getBiome("haunted_biome"), LevelIdentifier.CAVE_IDENTIFIER));
        HauntedCaves.addBiomeLootEntry
        (      
            new String[] 
            { 
                "copperore", "ironore", "goldore", "demonic_ore", "void_fragment"
            }
        );
        HauntedCaves.addMobEntries
        (
            new String[] 
            { 
                "void_gateway_boss", "void_cultist", "void_scholar", "spider", "mouse"
            }
        );
        HauntedCaves.addTreasureEntry(new LootTable[] { HauntedLootTables.HauntedCavesChest });
        
        JournalEntry HauntedDeepCaves = JournalRegistry.registerJournalEntry("haunted_deep_caves", new JournalEntry(BiomeRegistry.getBiome("haunted_biome"), LevelIdentifier.DEEP_CAVE_IDENTIFIER));
        HauntedDeepCaves.addBiomeLootEntry
        (      
            new String[] 
            { 
                "copperore", "ironore", "goldore", "demonic_ore", "tungstenore", "nightmare_ore", "void_crystal"
            }
        );
        HauntedDeepCaves.addMobEntries
        (
            new String[] 
            { 
                "deep_void_gateway_boss", "void_sentinel", "void_arcanist", "void_crawler"
            }
        );
        HauntedDeepCaves.addTreasureEntry(new LootTable[] { HauntedLootTables.DeepHauntedCavesChest });
    }
}
