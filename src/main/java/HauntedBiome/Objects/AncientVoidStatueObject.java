package HauntedBiome.Objects;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.List;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.registries.ObjectRegistry;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.PlayerMob;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.DrawOptions;
import necesse.gfx.drawables.LevelSortedDrawable;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.gfx.gameTexture.GameSprite;
import necesse.inventory.item.Item;
import necesse.inventory.item.toolItem.ToolType;
import necesse.level.gameObject.StaticMultiObject;
import necesse.level.maps.Level;

public class AncientVoidStatueObject extends StaticMultiObject
{
    protected final GameRandom drawRandom;
  
  protected boolean showAnimation;
  
  protected AncientVoidStatueObject(String texturePath, int multiX, int multiY, int multiWidth, int multiHeight, int[] multiIDs, Rectangle fullCollision) {
    super(multiX, multiY, multiWidth, multiHeight, multiIDs, fullCollision, "statues/" + texturePath);
    this.stackSize = 1;
    this.rarity = Item.Rarity.UNCOMMON;
    this.mapColor = new Color(143, 143, 143);
    this.objectHealth = 100;
    this.toolType = ToolType.ALL;
    this.showsWire = true;
    this.isLightTransparent = true;
    this.hoverHitbox = new Rectangle(0, 0, 32, 32);
    setItemCategory(new String[] { "objects", "landscaping", "misc" });
    this.drawRandom = new GameRandom();
    this.lightLevel = 70;
    this.lightHue = 280f;
    this.lightSat = 1f;
    this.showAnimation = false;
  }
  
  public void addDrawables(List<LevelSortedDrawable> list, OrderableDrawables tileList, Level level, int tileX, int tileY, TickManager tickManager, GameCamera camera, PlayerMob perspective) {
    int spriteWidth = 64;
    GameSprite sprite = new GameSprite(this.texture, 0, 0, spriteWidth, 128, spriteWidth, 128);
    final DrawOptions options = getMultiTextureDrawOptions(sprite, level, tileX, tileY, camera);
    list.add(new LevelSortedDrawable(this, tileX, tileY) {
          public int getSortY() {
            return 16;
          }
          
          public void draw(TickManager tickManager) {
            options.draw();
          }
        });
  }
  
  public void drawPreview(Level level, int tileX, int tileY, int rotation, float alpha, PlayerMob player, GameCamera camera) {
    int spriteWidth = 64;
    GameSprite sprite = new GameSprite(this.texture, 0, 0, spriteWidth, 128, spriteWidth, 128);
    drawMultiTexturePreview(sprite, tileX, tileY, alpha, camera);
  }
  
  public static int[] registerAncientVoidStatue(String texturePath, boolean isObtainable) {
    int[] ids = new int[4];
    Rectangle collision = new Rectangle(0, 0, 64, 64);
    ids[0] = ObjectRegistry.registerObject(texturePath, new AncientVoidStatueObject(texturePath, 0, 0, 2, 2, ids, collision), 325.0F, isObtainable);
    ids[1] = ObjectRegistry.registerObject(texturePath + "1", new AncientVoidStatueObject(texturePath, 1, 0, 2, 2, ids, collision), 0.0F, false);
    ids[2] = ObjectRegistry.registerObject(texturePath + "2", new AncientVoidStatueObject(texturePath, 0, 1, 2, 2, ids, collision), 0.0F, false);
    ids[3] = ObjectRegistry.registerObject(texturePath + "3", new AncientVoidStatueObject(texturePath, 1, 1, 2, 2, ids, collision), 0.0F, false);
    return ids;
  }
}
