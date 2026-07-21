package HauntedBiome.Items.Armour;

import necesse.engine.modifiers.ModifierValue;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.armorItem.ArmorModifiers;
import necesse.inventory.item.armorItem.BootsArmorItem;
import necesse.inventory.item.upgradeUtils.FloatUpgradeValue;
import necesse.inventory.lootTable.LootTablePresets;

public class VoidSentinelBootsItem extends BootsArmorItem
{
    public FloatUpgradeValue speed = (new FloatUpgradeValue())
    .setBaseValue(0.10F)
    .setUpgradedValue(1.0F, 0.15F);

    public VoidSentinelBootsItem() 
    {
        super(18, 350, "void_sentinel_boots", LootTablePresets.feetArmor);
    }

    public ArmorModifiers getArmorModifiers(InventoryItem item, Mob mob) 
    {
        return new ArmorModifiers(new ModifierValue[] { new ModifierValue(BuffModifiers.SPEED, this.speed.getValue(getUpgradeTier(item))) });
    }
}
