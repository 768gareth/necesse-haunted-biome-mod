package HauntedBiome.Items.Cosmetic;

import necesse.inventory.item.Item;
import necesse.inventory.item.armorItem.ArmorItem;
import necesse.inventory.item.armorItem.SetHelmetArmorItem;
import necesse.inventory.lootTable.presets.CosmeticArmorLootTable;
import necesse.inventory.lootTable.presets.CosmeticSetArmorLootTable;

public class VoidCultHoodItem extends SetHelmetArmorItem {
  public VoidCultHoodItem() 
  {
    super(0, null, 0, CosmeticArmorLootTable.cosmeticArmor, CosmeticSetArmorLootTable.cosmeticSetArmor, Item.Rarity.UNCOMMON, "void_cult_hood", "void_cult_robe", "void_cult_boots", null);
    this.facialFeatureDrawOptions = ArmorItem.FacialFeatureDrawMode.OVER_FACIAL_FEATURE;
    this.hairDrawOptions = ArmorItem.HairDrawMode.OVER_HAIR;
    this.hairMaskTextureName = "snowhood_leatherhood_hairmask";
  }
}
