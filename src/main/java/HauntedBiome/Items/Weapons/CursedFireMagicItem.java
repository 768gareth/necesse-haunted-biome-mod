package HauntedBiome.Items.Weapons;

import HauntedBiome.Projectiles.CursedFireProjectile;
import necesse.engine.localization.Localization;
import necesse.engine.network.gameNetworkData.GNDItemMap;
import necesse.engine.sound.SoundEffect;
import necesse.engine.sound.SoundManager;
import necesse.engine.util.GameBlackboard;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.itemAttacker.ItemAttackSlot;
import necesse.entity.mobs.itemAttacker.ItemAttackerMob;
import necesse.entity.projectile.Projectile;
import necesse.entity.projectile.modifiers.ResilienceOnHitProjectileModifier;
import necesse.gfx.GameResources;
import necesse.gfx.drawOptions.itemAttack.ItemAttackDrawOptions;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.toolItem.projectileToolItem.magicProjectileToolItem.MagicProjectileToolItem;
import necesse.inventory.lootTable.presets.MagicWeaponsLootTable;
import necesse.level.maps.Level;

public class CursedFireMagicItem extends MagicProjectileToolItem 
{
    public CursedFireMagicItem()
    {
        super(300, MagicWeaponsLootTable.magicWeapons);
        this.rarity = Rarity.UNCOMMON;
        this.attackAnimTime.setBaseValue(200);
        this.attackDamage.setBaseValue(24.0F).setUpgradedValue(1.0F, 48.0F);
        this.velocity.setBaseValue(100);
        this.attackXOffset = 14;
        this.attackYOffset = 4;
        this.attackRange.setBaseValue(300);
        this.manaCost.setBaseValue(1.5F).setUpgradedValue(1.0F, 2.0F);
        this.resilienceGain.setBaseValue(0.5F);
        this.itemAttackerProjectileCanHitWidth = 25.0F;
        this.itemAttackerPredictionDistanceOffset = -20.0F;
        this.canBeUsedForRaids = false;
    }

    @Override
    public ListGameTooltips getPreEnchantmentTooltips(InventoryItem item, PlayerMob perspective, GameBlackboard blackboard) 
    {
        ListGameTooltips tooltips = super.getPreEnchantmentTooltips(item, perspective, blackboard);
        tooltips.add(Localization.translate("itemtooltip", "cursed_fire_tooltip"));
        return tooltips;
    }

    public void setDrawAttackRotation(InventoryItem item, ItemAttackDrawOptions drawOptions, float attackDirX, float attackDirY, float attackProgress) 
    {
      drawOptions.pointRotation(attackDirX, attackDirY).forEachItemSprite((i) -> { i.itemRotateOffset(45.0F); });
    }

    @Override
    public void showAttack(Level level, int x, int y, ItemAttackerMob attackerMob, int attackHeight, InventoryItem item, int animAttack, int seed, GNDItemMap mapContent) 
    {
      if (level.isClient()) 
      {
         SoundManager.playSound(GameResources.magicbolt2, SoundEffect.effect(attackerMob).volume(0.4F).pitch(GameRandom.globalRandom.getFloatBetween(0.8F, 0.9F)));
      }
    }

    public InventoryItem onAttack(Level level, int x, int y, ItemAttackerMob attackerMob, int attackHeight, InventoryItem item, ItemAttackSlot slot, int animAttack, int seed, GNDItemMap mapContent) {
      Projectile projectile = new CursedFireProjectile(level, attackerMob.x, attackerMob.y, (float)x, (float)y, this.getAttackRange(item), this.getAttackDamage(item), attackerMob);
      projectile.setModifier(new ResilienceOnHitProjectileModifier(this.getResilienceGain(item)));
      projectile.resetUniqueID(new GameRandom((long)seed));
      attackerMob.addAndSendAttackerProjectile(projectile, 20);
      this.consumeMana(attackerMob, item);
      return item;
   }

    public void consumeMana(ItemAttackerMob attackerMob, InventoryItem item) {
      consumeMana(getManaCost(item), attackerMob);
    }
}
