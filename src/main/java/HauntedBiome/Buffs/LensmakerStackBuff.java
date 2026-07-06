package HauntedBiome.Buffs;

import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffEventSubscriber;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.mobs.buffs.staticBuffs.Buff;

public class LensmakerStackBuff extends Buff
{
    public LensmakerStackBuff() {
      this.isImportant = true;
      this.canCancel = false;
   }

    @Override
   public void init(ActiveBuff buff, BuffEventSubscriber eventSubscriber) {
   }

   @Override
   public void serverTick(ActiveBuff buff) 
   {
      buff.setModifier(BuffModifiers.CRIT_CHANCE, ((Float) 0.05f * buff.owner.buffManager.getStacks(this)));
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
