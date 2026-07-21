package HauntedBiome.Buffs;

import necesse.engine.localization.Localization;
import necesse.engine.registries.DamageTypeRegistry;
import necesse.engine.util.GameBlackboard;
import necesse.entity.mobs.MobWasHitEvent;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffEventSubscriber;
import necesse.entity.mobs.buffs.staticBuffs.armorBuffs.setBonusBuffs.SetBonusBuff;
import necesse.gfx.gameTooltips.ListGameTooltips;

public class VoidSentinelArmourSetBuff extends SetBonusBuff 
{
  public void init(ActiveBuff buff, BuffEventSubscriber eventSubscriber) {}
  
  public void onHasAttacked(ActiveBuff buff, MobWasHitEvent event) 
  {
    super.onHasAttacked(buff, event);
    if (event.isCrit && event.damageType == DamageTypeRegistry.MELEE)
    {
        event.target.buffManager.addBuff(new ActiveBuff("void_sentinel_stack_buff", buff.owner, 10f, buff.owner), true);
    }
  }
  
  public ListGameTooltips getTooltip(ActiveBuff ab, GameBlackboard blackboard) {
    ListGameTooltips tooltips = super.getTooltip(ab, blackboard);
    tooltips.add(Localization.translate("itemtooltip", "void_sentinel_buff_tooltip"));
    return tooltips;
  }
}