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
                "spider", "mouse"
            }
        );
        HauntedSurface.addTreasureEntry(new LootTable[] { LootTablePresets.surfaceRuinsChest });

        JournalEntry HauntedCaves = JournalRegistry.registerJournalEntry("haunted_caves", new JournalEntry(BiomeRegistry.getBiome("haunted_biome"), LevelIdentifier.CAVE_IDENTIFIER));
        HauntedCaves.addBiomeLootEntry
        (      
            new String[] 
            { 
                "demonic_ore", "demonicbar", "void_fragment", "voidshard"
            }
        );
        HauntedCaves.addMobEntries
        (
            new String[] 
            { 
                "spider", "mouse"
            }
        );
        HauntedCaves.addTreasureEntry(new LootTable[] { HauntedLootTables.HauntedCavesChest });
        
        JournalEntry HauntedDeepCaves = JournalRegistry.registerJournalEntry("haunted_deep_caves", new JournalEntry(BiomeRegistry.getBiome("haunted_biome"), LevelIdentifier.DEEP_CAVE_IDENTIFIER));
        HauntedDeepCaves.addBiomeLootEntry
        (      
            new String[] 
            { 
                "demonic_ore", "demonicbar", "void_fragment", "voidshard"
            }
        );
        HauntedDeepCaves.addMobEntries
        (
            new String[] 
            { 
                "spider", "mouse"
            }
        );
        HauntedDeepCaves.addTreasureEntry(new LootTable[] { HauntedLootTables.DeepHauntedCavesChest });
    }
}
