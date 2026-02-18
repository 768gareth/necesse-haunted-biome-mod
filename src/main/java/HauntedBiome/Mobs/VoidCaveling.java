package HauntedBiome.Mobs;

import java.awt.Color;

import necesse.engine.registries.MobRegistry;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.friendly.critters.caveling.CavelingMob;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.LootItem;

public class VoidCaveling extends CavelingMob 
{
   public VoidCaveling() 
   {
      super(280, 35);
   }

   public void init() {
      super.init();
      this.texture = MobRegistry.Textures.stoneCaveling;
      this.popParticleColor = new Color(98, 29, 162);
      this.singleRockSmallStringID = "void_rock_small";
      if (this.item == null) {
         if (GameRandom.globalRandom.getChance(0.02F)) {
            this.item = new InventoryItem("cavelingsfoot");
         } else {
            this.item = new InventoryItem("voidshard", GameRandom.globalRandom.getIntBetween(3, 6));
         }
      }

   }

   public LootTable getLootTable() {
      return super.getLootTable();
   }

   public LootTable getCavelingDropsAsLootTable() {
      return new LootTable(new LootItemInterface[]{new LootItem("voidshard", 1)});
   }
}
