package HauntedBiome.Items.Armour;

import necesse.engine.modifiers.ModifierValue;
import necesse.engine.registries.DamageTypeRegistry;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.Item;
import necesse.inventory.item.armorItem.ArmorItem;
import necesse.inventory.item.armorItem.ArmorModifiers;
import necesse.inventory.item.armorItem.SetHelmetArmorItem;
import necesse.inventory.lootTable.presets.ArmorSetsLootTable;
import necesse.inventory.lootTable.presets.HeadArmorLootTable;

public class AncientVoidCultHoodItem extends SetHelmetArmorItem 
{
  public AncientVoidCultHoodItem() 
    {
        super
        (
            8, 
            DamageTypeRegistry.MAGIC, 
            1400, HeadArmorLootTable.headArmor, 
            ArmorSetsLootTable.armorSets, 
            Item.Rarity.EPIC, 
            "ancient_void_cult_hood", 
            "ancient_void_cult_robe", 
            "ancient_void_cult_boots", 
            "ancient_void_cult_set_bonus"
        );
        this.hairDrawOptions = ArmorItem.HairDrawMode.NO_HEAD;
    }

    public ArmorModifiers getArmorModifiers(InventoryItem item, Mob mob) 
    {
        return new ArmorModifiers(new ModifierValue[] 
            { 
                new ModifierValue(BuffModifiers.SUMMON_ATTACK_SPEED, 0.1f),
                new ModifierValue(BuffModifiers.MAGIC_ATTACK_SPEED, 0.1f),
            });
    }
}
