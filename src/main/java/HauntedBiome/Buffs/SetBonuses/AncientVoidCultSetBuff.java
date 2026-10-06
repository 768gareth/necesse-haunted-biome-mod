package HauntedBiome.Buffs.SetBonuses;

import necesse.engine.localization.Localization;
import necesse.engine.util.GameBlackboard;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffEventSubscriber;
import necesse.entity.mobs.buffs.staticBuffs.armorBuffs.setBonusBuffs.SetBonusBuff;
import necesse.gfx.gameTooltips.ListGameTooltips;

public class AncientVoidCultSetBuff extends SetBonusBuff 
{
  public void init(ActiveBuff buff, BuffEventSubscriber eventSubscriber) {}
  
  public ListGameTooltips getTooltip(ActiveBuff ab, GameBlackboard blackboard) {
    ListGameTooltips tooltips = super.getTooltip(ab, blackboard);
    tooltips.add(Localization.translate("itemtooltip", "ancient_void_cult_set_tooltip"));
    return tooltips;
  }
}