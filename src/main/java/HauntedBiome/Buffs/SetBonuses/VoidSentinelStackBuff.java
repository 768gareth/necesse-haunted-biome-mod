package HauntedBiome.Buffs.SetBonuses;

import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffEventSubscriber;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.mobs.buffs.staticBuffs.Buff;

public class VoidSentinelStackBuff extends Buff
{
   public VoidSentinelStackBuff() 
   {
      this.isImportant = true;
      this.canCancel = false;
   }

    @Override
   public void init(ActiveBuff buff, BuffEventSubscriber eventSubscriber) 
   { 
      buff.setModifier(BuffModifiers.ARMOR_FLAT, 2); 
   }

    @Override
   public int getStackSize(ActiveBuff buff) 
   {
      return 5;
   }

   @Override
   public boolean overridesStackDuration() {
      return true;
   }

   @Override
   public boolean showsFirstStackDurationText() {
      return super.showsFirstStackDurationText();
   }
}
