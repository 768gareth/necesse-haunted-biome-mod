package HauntedBiome.Mobs.Critters;

import java.awt.Color;

import necesse.engine.util.GameRandom;
import necesse.entity.mobs.HumanTexture;
import necesse.entity.mobs.friendly.critters.caveling.CavelingMob;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.LootItem;

public class DeepVoidCavelingMob extends CavelingMob 
{
   public static HumanTexture TextureTemp;

   public DeepVoidCavelingMob() 
   {
      super(400, 40);
   }

   @Override
   public void init() {
      super.init();
      this.texture = TextureTemp;
      this.popParticleColor = new Color(98, 29, 162);
      this.singleRockSmallStringID = "deep_void_rock_small";
      if (this.item == null) {
         if (GameRandom.globalRandom.getChance(0.02F)) {
            this.item = new InventoryItem("cavelingsfoot");
         } else {
            this.item = new InventoryItem("void_crystal", GameRandom.globalRandom.getIntBetween(3, 6));
         }
      }

   }

   @Override
   public LootTable getLootTable() {
      return super.getLootTable();
   }

   @Override
   public LootTable getCavelingDropsAsLootTable() {
      return new LootTable(new LootItemInterface[]{new LootItem("void_crystal", 1)});
   }
}
