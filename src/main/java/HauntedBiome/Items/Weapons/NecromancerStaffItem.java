package HauntedBiome.Items.Weapons;

import necesse.engine.localization.Localization;
import necesse.engine.util.GameBlackboard;
import necesse.entity.mobs.PlayerMob;
import necesse.gfx.drawOptions.itemAttack.ItemAttackDrawOptions;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.Item;
import necesse.inventory.item.toolItem.projectileToolItem.magicProjectileToolItem.MagicProjectileToolItem;
import necesse.inventory.lootTable.LootTablePresets;

public class NecromancerStaffItem extends MagicProjectileToolItem 
{
    public NecromancerStaffItem()
    {
        super(1500, LootTablePresets.magicWeapons);
        this.rarity = Item.Rarity.RARE;
        this.attackAnimTime.setBaseValue(300);
        this.attackDamage.setBaseValue(80.0F).setUpgradedValue(1.0F, 120F);
        this.velocity.setBaseValue(120);
        this.attackXOffset = 8;
        this.attackYOffset = 10;
        this.attackCooldownTime.setBaseValue(500);
        this.attackRange.setBaseValue(1000);
        this.manaCost.setBaseValue(1.25F).setUpgradedValue(1.0F, 2.0F);
        this.resilienceGain.setBaseValue(1.0F);
        this.itemAttackerProjectileCanHitWidth = 5.0F;
        this.itemAttackerPredictionDistanceOffset = -20.0F;
        this.canBeUsedForRaids = true;
    }

    public void setDrawAttackRotation(InventoryItem item, ItemAttackDrawOptions drawOptions, float attackDirX, float attackDirY, float attackProgress) 
    {
        if (getAnimInverted(item)) 
        {
            drawOptions.swingRotationInv(attackProgress);
        } 
        else 
        {
            drawOptions.swingRotation(attackProgress);
        } 
    }

    public ListGameTooltips getPreEnchantmentTooltips(InventoryItem item, PlayerMob perspective, GameBlackboard blackboard) 
    {
        ListGameTooltips tooltips = super.getPreEnchantmentTooltips(item, perspective, blackboard);
        tooltips.add(Localization.translate("itemtooltip", "necromancer_staff_tooltip"));
        return tooltips;
    }
}
