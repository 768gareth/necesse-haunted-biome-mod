package HauntedBiome.Items.Trinkets;

import necesse.engine.registries.BuffRegistry;
import necesse.entity.mobs.buffs.staticBuffs.armorBuffs.trinketBuffs.TrinketBuff;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.Item;
import necesse.inventory.item.trinketItem.TrinketItem;
import necesse.inventory.lootTable.presets.TrinketsLootTable;

public class VoidVesselItem extends TrinketItem
{
    public VoidVesselItem() 
    {
        super(Item.Rarity.UNCOMMON, 200, TrinketsLootTable.trinkets);
    }

    @Override
    public TrinketBuff[] getBuffs(InventoryItem item) 
    {
        return new TrinketBuff[] { (TrinketBuff)BuffRegistry.getBuff("void_vessel_buff") };
    }
  }
