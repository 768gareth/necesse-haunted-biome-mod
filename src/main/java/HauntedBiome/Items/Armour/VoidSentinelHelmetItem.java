package HauntedBiome.Items.Armour;

import necesse.engine.modifiers.ModifierValue;
import necesse.engine.registries.DamageTypeRegistry;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.Item;
import necesse.inventory.item.armorItem.ArmorModifiers;
import necesse.inventory.item.armorItem.SetHelmetArmorItem;
import necesse.inventory.lootTable.presets.ArmorSetsLootTable;
import necesse.inventory.lootTable.presets.HeadArmorLootTable;

public class VoidSentinelHelmetItem extends SetHelmetArmorItem
{

    public VoidSentinelHelmetItem() 
    {
        super
        (
            26, 
            DamageTypeRegistry.MELEE, 
            1400, HeadArmorLootTable.headArmor, 
            ArmorSetsLootTable.armorSets, 
            Item.Rarity.EPIC, 
            "void_sentinel_helmet", 
            "void_sentinel_chestplate", 
            "void_sentinel_boots", 
            "void_sentinel_set_bonus"
        );
    }

    public ArmorModifiers getArmorModifiers(InventoryItem item, Mob mob) 
    {
        return new ArmorModifiers(new ModifierValue[] 
            { 
                new ModifierValue(BuffModifiers.CRIT_CHANCE, 0.10f),
                new ModifierValue(BuffModifiers.CRIT_DAMAGE, 0.10f),
            });
    }
}
