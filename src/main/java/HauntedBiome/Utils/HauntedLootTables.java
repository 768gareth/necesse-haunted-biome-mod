package HauntedBiome.Utils;

import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.inventory.lootTable.lootItem.RotationLootItem;
import necesse.inventory.lootTable.presets.CaveChestLootTable;
import necesse.inventory.lootTable.presets.DeepCaveChestLootTable;

public class HauntedLootTables 
{
    public static final RotationLootItem HauntedCaveMainItems = RotationLootItem.presetRotation
    (
        new LootItemInterface[] 
        { 
            (LootItemInterface)new LootItem("magicfoci"), 
            (LootItemInterface)new LootItem("rangefoci"), 
            (LootItemInterface)new LootItem("meleefoci"), 
            (LootItemInterface)new LootItem("summonfoci") 
        }
    );

    public static final LootTable HauntedCavesChest = new LootTable
    (
        new LootItemInterface[] 
        { 
            (LootItemInterface)HauntedCaveMainItems, 
            (LootItemInterface)CaveChestLootTable.potions, 
            (LootItemInterface)CaveChestLootTable.bars, 
            (LootItemInterface)CaveChestLootTable.extraItems 
        }
    );

    public static final RotationLootItem DeepHauntedCaveMainItems = RotationLootItem.presetRotation
    (
        new LootItemInterface[] 
        { 
            (LootItemInterface)new LootItem("magicfoci"), 
            (LootItemInterface)new LootItem("rangefoci"), 
            (LootItemInterface)new LootItem("meleefoci"), 
            (LootItemInterface)new LootItem("summonfoci") 
        }
    );

    public static final LootTable DeepHauntedCavesChest = new LootTable
    (
        new LootItemInterface[] 
        { 
            (LootItemInterface)DeepHauntedCaveMainItems, 
            (LootItemInterface)DeepCaveChestLootTable.potions, 
            (LootItemInterface)DeepCaveChestLootTable.basicBars, 
            (LootItemInterface)DeepCaveChestLootTable.extraItems 
        }
    );
}
