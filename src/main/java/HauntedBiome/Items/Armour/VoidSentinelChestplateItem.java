package HauntedBiome.Items.Armour;

import necesse.engine.modifiers.ModifierValue;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.Item;
import necesse.inventory.item.armorItem.ArmorModifiers;
import necesse.inventory.item.armorItem.ChestArmorItem;
import necesse.inventory.lootTable.LootTablePresets;

public class VoidSentinelChestplateItem extends ChestArmorItem
{
    public VoidSentinelChestplateItem() 
    {
        super(28, 400, "void_sentinel_chestplate", "void_sentinel_arms", LootTablePresets.bodyArmor);
        this.rarity = Item.Rarity.EPIC;
    }

    public ArmorModifiers getArmorModifiers(InventoryItem item, Mob mob) 
    {
        return new ArmorModifiers(new ModifierValue[] 
            { 
                new ModifierValue(BuffModifiers.MAX_RESILIENCE_FLAT, 25),
                new ModifierValue(BuffModifiers.RESILIENCE_GAIN, 0.25f),
            });
    }
}
