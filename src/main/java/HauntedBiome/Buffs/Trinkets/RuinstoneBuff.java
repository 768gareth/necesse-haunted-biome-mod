package HauntedBiome.Buffs.Trinkets;

import necesse.engine.localization.Localization;
import necesse.entity.mobs.MobWasHitEvent;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffEventSubscriber;
import necesse.entity.mobs.buffs.staticBuffs.armorBuffs.trinketBuffs.TrinketBuff;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.trinketItem.TrinketItem;

public class RuinstoneBuff extends TrinketBuff
{
    @Override
    public void init(ActiveBuff buff, BuffEventSubscriber eventSubscriber) {}

    @Override
    public void onHasAttacked(ActiveBuff buff, MobWasHitEvent event) 
    {
        if (event.isCrit)
        {
            event.target.buffManager.addBuff(new ActiveBuff("ruinstone_stack_debuff", buff.owner, 5f, buff.owner), true);
        }
    }

    @Override
    public ListGameTooltips getTrinketTooltip(TrinketItem trinketItem, InventoryItem item, PlayerMob perspective) 
    {
        ListGameTooltips tooltips = super.getTrinketTooltip(trinketItem, item, perspective);
        tooltips.add(Localization.translate("itemtooltip", "ruinstone_tooltip"));
        return tooltips;
    }
}
