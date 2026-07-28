package HauntedBiome.Items.Armour;

import necesse.engine.modifiers.ModifierValue;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.Item;
import necesse.inventory.item.armorItem.ArmorModifiers;
import necesse.inventory.item.armorItem.BootsArmorItem;
import necesse.inventory.item.upgradeUtils.FloatUpgradeValue;
import necesse.inventory.lootTable.LootTablePresets;

public class AncientVoidCultBootsItem extends BootsArmorItem
{
    public FloatUpgradeValue speed = (new FloatUpgradeValue())
    .setBaseValue(0.20F)
    .setUpgradedValue(1.0F, 0.25F);

    public AncientVoidCultBootsItem() 
    {
        super(11, 350, "ancient_void_cult_boots", LootTablePresets.feetArmor);
        this.rarity = Item.Rarity.EPIC;
    }

    public ArmorModifiers getArmorModifiers(InventoryItem item, Mob mob) 
    {
        return new ArmorModifiers(new ModifierValue[] { new ModifierValue(BuffModifiers.SPEED, this.speed.getValue(getUpgradeTier(item))), new ModifierValue(BuffModifiers.MAX_MANA_FLAT, 20) });
    }
}