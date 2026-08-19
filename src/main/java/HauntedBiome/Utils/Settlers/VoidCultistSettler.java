package HauntedBiome.Utils.Settlers;

import java.util.function.Supplier;

import necesse.engine.localization.message.GameMessage;
import necesse.engine.localization.message.LocalMessage;
import necesse.engine.util.TicketSystemList;
import necesse.entity.mobs.friendly.human.HumanMob;
import necesse.gfx.HumanLook;
import necesse.gfx.drawOptions.human.HumanDrawOptions;
import necesse.inventory.InventoryItem;
import necesse.level.maps.levelData.settlementData.ServerSettlementData;
import necesse.level.maps.levelData.settlementData.settler.Settler;

public class VoidCultistSettler extends Settler {
  public VoidCultistSettler() {
    super("void_cultist_human");
  }
  
  public GameMessage getAcquireTip() {
    return (GameMessage)new LocalMessage("settlement", "haunted_biome_tip");
  }
  
  public void setDefaultArmor(HumanDrawOptions drawOptions, int settlerSeed, HumanLook look, boolean customLook) {
    drawOptions.helmet(new InventoryItem("void_cult_hood"));
    drawOptions.chestplate(new InventoryItem("void_cult_robe"));
    drawOptions.boots(new InventoryItem("void_cult_boots"));
    drawOptions.holdItem(new InventoryItem("demonicsword"));
  }
  
  public void addNewRecruitSettler(ServerSettlementData data, boolean isRandomEvent, TicketSystemList<Supplier<HumanMob>> ticketSystem) {
    if (isRandomEvent || !doesSettlementHaveThisSettler(data))
      ticketSystem.addObject(100, getNewRecruitMob(data)); 
  }
}