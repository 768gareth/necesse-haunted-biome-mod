package HauntedBiome.Registry;

import HauntedBiome.Utils.Journal.CollectHauntedCaveTrinketJournalChallenge;
import necesse.engine.journal.DefeatMobJournalChallenge;
import necesse.engine.journal.JournalChallenge;
import necesse.engine.journal.MultiJournalChallenge;
import necesse.engine.journal.ObjectsDestroyedJournalChallenge;
import necesse.engine.registries.JournalChallengeRegistry;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.LootItem;

public class RegisterJournalChallenges 
{
    public static void Register()
    {
        LootTable SURFACE_REWARD = new LootTable(new LootItemInterface[] { new LootItem("egg")});
        LootTable CAVES_REWARD = new LootTable(new LootItemInterface[] { new LootItem("egg")});
        LootTable DEEP_CAVES_REWARD = new LootTable(new LootItemInterface[] { new LootItem("amulet_of_corruption")});

        // Surface Challenges - Reward: Void Cultist cosmetic set.
        int ACQUIRE_HAUNTED_SURFACE_TRINKET;
        int CRAFT_BLOODBERRY_JAM;

        // Caves Challenges - Reward: Void 
        int DESTROY_VOID_CRYSTALS = JournalChallengeRegistry.registerChallenge("destroy_void_crystals", (JournalChallenge)new ObjectsDestroyedJournalChallenge(20, new String[] { "leafpile" }));
        int DEFEAT_VOID_GATEWAY_ID = JournalChallengeRegistry.registerChallenge("defeat_void_gateway", (JournalChallenge)new DefeatMobJournalChallenge(new String[] { "void_gateway_boss" }));
        int ACQUIRE_HAUNTED_CAVES_TRINKET = JournalChallengeRegistry.registerChallenge("loot_haunted_caves_trinket", (JournalChallenge)new CollectHauntedCaveTrinketJournalChallenge());

        @SuppressWarnings("unused")
        int CAVES_CHALLENGES = JournalChallengeRegistry.registerChallenge
        (
            "haunted_caves_challenges", 
            (JournalChallenge)
            (new MultiJournalChallenge
                (
                    new Integer[] 
                    { 
                        DESTROY_VOID_CRYSTALS, 
                        DEFEAT_VOID_GATEWAY_ID, 
                        ACQUIRE_HAUNTED_CAVES_TRINKET 
                    }
                )
            ).setReward(CAVES_REWARD)
        );

        // Deep Caves Challenges - Reward: Amulet of Corruption
        int DEFEAT_DEEP_VOID_GATEWAY_ID;
        int ACQUIRE_DEEP_HAUNTED_CAVES_TRINKET_ID;
        int COLLECT_NIGHTMARE_ORE;

        
    }
}
