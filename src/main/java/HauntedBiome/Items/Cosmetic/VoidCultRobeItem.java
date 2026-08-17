package HauntedBiome.Items.Cosmetic;

import necesse.inventory.item.Item;
import necesse.inventory.item.armorItem.ChestArmorItem;
import necesse.inventory.lootTable.presets.CosmeticArmorLootTable;

public class VoidCultRobeItem extends ChestArmorItem {
  public VoidCultRobeItem() {
    super(0, 0, Item.Rarity.UNCOMMON, "void_cult_robe", "void_cult_robe_arms", CosmeticArmorLootTable.cosmeticArmor);
  }
}