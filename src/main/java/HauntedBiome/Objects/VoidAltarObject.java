package HauntedBiome.Objects;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.List;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.localization.Localization;
import necesse.engine.registries.ContainerRegistry;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.objectEntity.DisplayStandObjectEntity;
import necesse.entity.objectEntity.ObjectEntity;
import necesse.entity.objectEntity.interfaces.OEInventory;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.DrawOptions;
import necesse.gfx.drawOptions.texture.TextureDrawOptionsEnd;
import necesse.gfx.drawables.LevelSortedDrawable;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.gfx.gameTexture.GameTexture;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.container.object.OEInventoryContainer;
import necesse.inventory.item.Item;
import necesse.inventory.item.toolItem.ToolType;
import necesse.level.gameObject.GameObject;
import necesse.level.gameObject.HappinessObject;
import necesse.level.gameObject.furniture.FurnitureObject;
import necesse.level.maps.Level;
import necesse.level.maps.light.GameLight;

public class VoidAltarObject extends FurnitureObject implements HappinessObject
{
   protected String textureName;
   public GameTexture texture;
   protected int itemHeight;

   public VoidAltarObject(String... category) 
   {
        super(new Rectangle(6, 10, 20, 20));
        this.rarity = Item.Rarity.RARE;
        this.textureName = "void_altar_display";
        this.toolType = ToolType.ALL;
        this.mapColor = new Color(128, 128, 128);
        this.itemHeight = 20;
        this.objectHealth = 50;
        this.isLightTransparent = true;
        this.furnitureType = "table";
        this.lightLevel = 50;
        this.lightSat = 1.0F;
        this.lightHue = 310f;
        this.setItemCategory(new String[]{"objects", "furniture"});
        this.setCraftingCategory(new String[]{"objects", "furniture"});
   }

   public VoidAltarObject() {}

   public void loadTextures() {
    super.loadTextures();
    this.texture = GameTexture.fromFile("objects/" + this.textureName);
  }
  
  public void addDrawables(List<LevelSortedDrawable> list, OrderableDrawables tileList, Level level, int tileX, int tileY, TickManager tickManager, GameCamera camera, PlayerMob perspective) {
    final DrawOptions item;
    GameLight light = level.getLightLevel(tileX, tileY);
    int drawX = camera.getTileDrawX(tileX);
    int drawY = camera.getTileDrawY(tileY);
    final TextureDrawOptionsEnd base = this.texture.initDraw().addObjectDamageOverlay(this, level, tileX, tileY).light(light).pos(drawX + 16 - this.texture.getWidth() / 2, drawY - this.texture.getHeight() + 32 + 4);
    ObjectEntity ent = level.entityManager.getObjectEntity(tileX, tileY);
    if (ent != null && ent.implementsOEInventory()) {
      InventoryItem invItem = ((OEInventory)ent).getInventory().getItem(0);
      item = (invItem != null) ? invItem.getWorldDrawOptions(perspective, drawX + 16, drawY + 32 - this.itemHeight, light, 0.0F, 32) : (() -> {
        
        });
    } else {
      item = (() -> {
        
        });
    } 
    list.add(new LevelSortedDrawable((GameObject)this, tileX, tileY) {
          public int getSortY() {
            return 16;
          }
          
          public void draw(TickManager tickManager) {
            base.draw();
            item.draw();
          }
        });
  }
  
  public void drawPreview(Level level, int tileX, int tileY, int rotation, float alpha, PlayerMob player, GameCamera camera) {
    int drawX = camera.getTileDrawX(tileX);
    int drawY = camera.getTileDrawY(tileY);
    this.texture.initDraw()
      .alpha(alpha)
      .draw(drawX + 16 - this.texture.getWidth() / 2, drawY - this.texture.getHeight() + 32 + 4);
  }
  
  public String getInteractTip(Level level, int x, int y, PlayerMob perspective, boolean debug) {
    return Localization.translate("controls", "opentip");
  }
  
  public boolean canInteract(Level level, int x, int y, PlayerMob player) {
    return true;
  }
  
  public void interact(Level level, int x, int y, PlayerMob player) {
    super.interact(level, x, y, player);
    if (level.isServer())
      OEInventoryContainer.openAndSendContainer(ContainerRegistry.OE_INVENTORY_CONTAINER, player.getServerClient(), level, x, y); 
  }
  
  public ObjectEntity getNewObjectEntity(Level level, int x, int y) {
    return (ObjectEntity)new DisplayStandObjectEntity(level, x, y);
  }
  
  public ListGameTooltips getItemTooltips(InventoryItem item, PlayerMob perspective) {
    ListGameTooltips tooltips = super.getItemTooltips(item, perspective);
    tooltips.add(Localization.translate("itemtooltip", "displaytip"));
    return tooltips;
  }
}