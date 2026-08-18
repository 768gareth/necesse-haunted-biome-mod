package HauntedBiome.Registry;

import HauntedBiome.Buffs.SetBonuses.VoidSentinelArmourSetBuff;
import HauntedBiome.Buffs.SetBonuses.VoidSentinelStackBuff;
import HauntedBiome.Buffs.Trinkets.RuinstoneBuff;
import HauntedBiome.Buffs.Trinkets.RuinstoneStackDebuff;
import HauntedBiome.Buffs.Trinkets.VoidVesselBuff;
import HauntedBiome.Buffs.Trinkets.VoidVesselStackDebuff;
import HauntedBiome.Buffs.Trinkets.VoidVesselStackUserDebuff;
import necesse.engine.modifiers.ModifierValue;
import necesse.engine.registries.BuffRegistry;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.mobs.buffs.staticBuffs.SimplePotionBuff;
import necesse.entity.mobs.buffs.staticBuffs.armorBuffs.trinketBuffs.SimpleTrinketBuff;

public class RegisterBuffs 
{
    public static void Register()
    {
        // Trinkets
        BuffRegistry.registerBuff("ruinstone_buff", new RuinstoneBuff());
        BuffRegistry.registerBuff("ruinstone_stack_debuff", new RuinstoneStackDebuff());
        BuffRegistry.registerBuff("amulet_of_corruption_buff", new SimpleTrinketBuff("amulet_of_corruption_tooltip", new ModifierValue[]{new ModifierValue(BuffModifiers.ALL_DAMAGE, 0.5F), new ModifierValue(BuffModifiers.INCOMING_DAMAGE_MOD, 1.5F)}));
        BuffRegistry.registerBuff("void_vessel_buff", new VoidVesselBuff());
        BuffRegistry.registerBuff("void_vessel_stack_debuff", new VoidVesselStackDebuff());
        BuffRegistry.registerBuff("void_vessel_user_stack_debuff", new VoidVesselStackUserDebuff());

        // Armour bonuses
        BuffRegistry.registerBuff("void_sentinel_set_bonus", new VoidSentinelArmourSetBuff());
        BuffRegistry.registerBuff("void_sentinel_stack_buff", new VoidSentinelStackBuff());

        // Misc buffs
        BuffRegistry.registerBuff("corruption_potion_buff", new SimplePotionBuff(false, new ModifierValue[]{new ModifierValue(BuffModifiers.ALL_DAMAGE, 0.5F), new ModifierValue(BuffModifiers.INCOMING_DAMAGE_MOD, 1.5F)}));


    }
}
