package HauntedBiome.Items.Armour;

import necesse.engine.modifiers.ModifierValue;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.Item;
import necesse.inventory.item.armorItem.ArmorModifiers;
import necesse.inventory.item.armorItem.ChestArmorItem;
import necesse.inventory.lootTable.LootTablePresets;

public class AncientVoidCultRobeItem extends ChestArmorItem
{
    public AncientVoidCultRobeItem() 
    {
        super(14, 400, "ancient_void_cult_robe", "ancient_void_cult_robe_arms", LootTablePresets.bodyArmor);
        this.rarity = Item.Rarity.EPIC;
    }

    public ArmorModifiers getArmorModifiers(InventoryItem item, Mob mob) 
    {
        return new ArmorModifiers(new ModifierValue[] 
            { 
                new ModifierValue(BuffModifiers.MAX_SUMMONS, 1),
                new ModifierValue(BuffModifiers.MAX_MANA_FLAT, 30),
            });
    }
}