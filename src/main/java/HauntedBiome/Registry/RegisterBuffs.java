package HauntedBiome.Registry;

import HauntedBiome.Buffs.LensmakerBuff;
import HauntedBiome.Buffs.LensmakerStackBuff;
import HauntedBiome.Buffs.RuinstoneBuff;
import HauntedBiome.Buffs.RuinstoneStackDebuff;
import HauntedBiome.Buffs.VoidSentinelArmourSetBuff;
import HauntedBiome.Buffs.VoidSentinelStackBuff;
import necesse.engine.registries.BuffRegistry;

public class RegisterBuffs 
{
    public static void Register()
    {
        // Trinkets
        BuffRegistry.registerBuff("ruinstone_buff", new RuinstoneBuff());
        BuffRegistry.registerBuff("ruinstone_stack_debuff", new RuinstoneStackDebuff());
        BuffRegistry.registerBuff("lensmaker_buff", new LensmakerBuff());
        BuffRegistry.registerBuff("lensmaker_stack_buff", new LensmakerStackBuff());

        // Armour bonuses
        BuffRegistry.registerBuff("void_sentinel_set_bonus", new VoidSentinelArmourSetBuff());
        BuffRegistry.registerBuff("void_sentinel_stack_buff", new VoidSentinelStackBuff());


    }
}
