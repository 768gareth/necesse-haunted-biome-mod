package HauntedBiome.Items.Weapons;

import necesse.inventory.item.Item;
import necesse.inventory.item.toolItem.swordToolItem.SwordToolItem;
import necesse.inventory.lootTable.presets.CloseRangeWeaponsLootTable;
import necesse.level.maps.incursion.IncursionData;

public class SoulEaterSwordItem extends SwordToolItem 
{
    public SoulEaterSwordItem()
    {
        super(1450, CloseRangeWeaponsLootTable.closeRangeWeapons);
        this.rarity = Item.Rarity.RARE;
        this.attackAnimTime.setBaseValue(300);
        this.attackDamage.setBaseValue(62.0F).setUpgradedValue(1.0F, 110F);
        this.attackRange.setBaseValue(65);
        this.resilienceGain.setBaseValue(1.5F).setUpgradedValue(1.0F, 1.5F).setUpgradedValue(10.0F, 2.0F);
        this.knockback.setBaseValue(80);
        this.attackXOffset = 8;
        this.attackYOffset = 8;
        this.canBeUsedForRaids = true;
        this.maxRaidTier = IncursionData.ITEM_TIER_UPGRADE_CAP;
    }
}
