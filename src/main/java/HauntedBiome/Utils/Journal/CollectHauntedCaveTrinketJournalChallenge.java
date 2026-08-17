package HauntedBiome.Utils.Journal;

import java.util.ArrayList;

import HauntedBiome.Utils.HauntedLootTables;
import necesse.engine.journal.ItemObtainedJournalChallenge;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootList;

public class CollectHauntedCaveTrinketJournalChallenge extends ItemObtainedJournalChallenge {
  public CollectHauntedCaveTrinketJournalChallenge() {
    super(new String[0]);
  }
  
  public void onChallengeRegistryClosed() {
    super.onChallengeRegistryClosed();
    ArrayList<String> itemStringIDs = new ArrayList<>();
    LootList list = new LootList();
    HauntedLootTables.DeepHauntedCaveMainItems.addPossibleLoot(list, new Object[0]);
    for (InventoryItem invItem : list.getCombinedItemsAndCustomItems()) {
      if (invItem.item.isTrinketItem())
        itemStringIDs.add(invItem.item.getStringID()); 
    } 
    this.itemStringIDs = itemStringIDs.<String>toArray(new String[0]);
  }
}
