package HauntedBiome.Registry;

import HauntedBiome.Buffs.RuinDebuff;
import HauntedBiome.Buffs.RuinstoneBuff;
import necesse.engine.registries.BuffRegistry;

public class RegisterBuffs 
{
    public static void Register()
    {
        BuffRegistry.registerBuff("ruinstone_buff", new RuinstoneBuff());
        BuffRegistry.registerBuff("ruin_debuff", new RuinDebuff());
    }
}
