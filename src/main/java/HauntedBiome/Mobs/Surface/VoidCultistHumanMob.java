package HauntedBiome.Mobs.Surface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import necesse.engine.localization.message.GameMessage;
import necesse.engine.network.server.ServerClient;
import necesse.engine.registries.SettlerPersonalityRegistry;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.friendly.human.humanShop.BuyingShopItem;
import necesse.entity.mobs.friendly.human.humanShop.HumanShop;
import necesse.entity.mobs.friendly.human.humanShop.SellingShopItem;
import necesse.gfx.HumanGender;
import necesse.inventory.InventoryItem;
import necesse.inventory.lootTable.LootTable;

public class VoidCultistHumanMob extends HumanShop {
  public VoidCultistHumanMob() 
  {
    super(500, 200, "void_cultist_human");
    this.equipmentInventory.setItem(6, new InventoryItem("demonicsword"));
    this.equipmentInventory.setItem(0, new InventoryItem("void_cult_hood"));
    this.equipmentInventory.setItem(1, new InventoryItem("void_cult_robe"));
    this.equipmentInventory.setItem(2, new InventoryItem("void_cult_boots"));

    this.getPersonalities().clear();
    this.getPersonalities().add(SettlerPersonalityRegistry.getNewSettlerPersonality(GameRandom.globalRandom.getOneOf("void_architect", "deep_void_architect", "haunted_architect"), this));
    this.getPersonalities().add(SettlerPersonalityRegistry.getNewSettlerPersonality("haunted_enthusiast", this));

    this.shop.addSellingItem("amulet_of_corruption", new SellingShopItem()).setStaticPriceBasedOnHappiness(300, 400, 10);

    this.shop.addBuyingItem("void_fragment", new BuyingShopItem()).setPriceBasedOnHappiness(15, 5, 0);
    this.shop.addBuyingItem("void_crystal", new BuyingShopItem()).setPriceBasedOnHappiness(30, 15, 0);

    this.gender = HumanGender.NEUTRAL;
    this.settlerName = getRandomName(new GameRandom(this.settlerSeed));
  }
  
  public LootTable getLootTable() {
    return super.getLootTable();
  }
  
  protected ArrayList<GameMessage> getMessages(ServerClient client) 
  {
    return getLocalMessages("void_cultist", 2);
  }
  
  public List<InventoryItem> getRecruitItems(ServerClient client) 
  {
    GameRandom random = new GameRandom(getSettlerSeed() * 83L);
    return Collections.singletonList(new InventoryItem("void_fragment", random.getIntBetween(8, 12))); 
  }
}