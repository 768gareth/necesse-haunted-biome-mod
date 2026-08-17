package HauntedBiome.Items.Cosmetic;

import necesse.inventory.item.Item;
import necesse.inventory.item.armorItem.BootsArmorItem;
import necesse.inventory.lootTable.presets.CosmeticArmorLootTable;

public class VoidCultBootsItem extends BootsArmorItem {
  public VoidCultBootsItem() {
    super(0, 0, Item.Rarity.UNCOMMON, "void_cult_boots", CosmeticArmorLootTable.cosmeticArmor);
  }
}