package HauntedBiome.Buffs.Trinkets;

import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffEventSubscriber;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.mobs.buffs.staticBuffs.Buff;

public class VoidVesselStackUserDebuff extends Buff
{
    public VoidVesselStackUserDebuff() {
      this.isImportant = true;
      this.canCancel = false;
   }

   @Override
   public void init(ActiveBuff buff, BuffEventSubscriber eventSubscriber) 
   {
      buff.setModifier(BuffModifiers.INCOMING_DAMAGE_MOD, 1.01f);
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