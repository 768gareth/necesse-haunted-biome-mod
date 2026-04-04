package HauntedBiome.Objects;

import java.awt.Color;
import java.util.List;
import java.util.Objects;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.PlayerMob;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.texture.TextureDrawOptionsEnd;
import necesse.gfx.drawables.LevelSortedDrawable;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.level.gameObject.DecorDrawOffset;
import necesse.level.gameObject.DecorationHolderInterface;
import necesse.level.gameObject.TableDecorationObject;
import necesse.level.maps.Level;
import necesse.level.maps.light.GameLight;

public class VoidFragmentSampleObject extends TableDecorationObject
{
    protected final GameRandom drawRandom;

    public VoidFragmentSampleObject() 
    {
        super("void_fragment_sample", new Color(221, 221, 221), 11, 14, 0, 4);
        this.drawRandom = new GameRandom();
        this.lightLevel = 70;
        this.lightHue = 255;
        this.holderDrawYOffset = -6;
    }

    public void addLayerDrawables(List<LevelSortedDrawable> list, OrderableDrawables tileList, Level level, int layerID, int tileX, int tileY, TickManager tickManager, GameCamera camera, PlayerMob perspective) 
    {
      int sprite;
      GameLight light = level.getLightLevel(tileX, tileY);
      int drawX = camera.getTileDrawX(tileX);
      int drawY = camera.getTileDrawY(tileY);
      synchronized (this.drawRandom) {
        sprite = this.drawRandom.seeded(getTileSeed(tileX, tileY)).nextInt(this.texture.getWidth() / 32);
      }
      DecorationHolderInterface holder = getDecorationHolder(level, tileX, tileY);
      if (holder != null) {
        DecorDrawOffset drawOffset = holder.getDecorationDrawOffset(level, tileX, tileY, this);
        drawX += drawOffset.xOffset + this.holderDrawXOffset;
        drawY += drawOffset.yOffset + this.holderDrawYOffset;
        if (!drawOffset.useShadowTexture)
          texture = this.texture_decor; 
      } 
      TextureDrawOptionsEnd textureDrawOptionsEnd = this.texture.initDraw().sprite(sprite, 0, 32, this.texture.getHeight()).addObjectDamageOverlay(this, level, layerID, tileX, tileY).light(light).pos(drawX, drawY - this.texture.getHeight() + 32);
      tileList.add(tm -> textureDrawOptionsEnd.draw());
      list.add(new LevelSortedDrawable(this, tileX, tileY) {
              public int getSortY() {
                  return 18;
              }

              public void draw(TickManager tickManager) {
                  Objects.requireNonNull(textureDrawOptionsEnd);
                  textureDrawOptionsEnd.draw();
              }
          });
    }
  
  public void drawPreview(Level level, int tileX, int tileY, int rotation, float alpha, PlayerMob player, GameCamera camera) {
    int sprite;
    GameLight light = level.getLightLevel(tileX, tileY);
    int drawX = camera.getTileDrawX(tileX);
    int drawY = camera.getTileDrawY(tileY);
    synchronized (this.drawRandom) {
      sprite = this.drawRandom.seeded(getTileSeed(tileX, tileY)).nextInt(this.texture.getWidth() / 32);
    }
    DecorationHolderInterface holder = getDecorationHolder(level, tileX, tileY);
    if (holder != null) {
      DecorDrawOffset drawOffset = holder.getDecorationDrawOffset(level, tileX, tileY, this);
      drawX += drawOffset.xOffset + this.holderDrawXOffset;
      drawY += drawOffset.yOffset + this.holderDrawYOffset;
      if (!drawOffset.useShadowTexture)
        texture = this.texture_decor; 
    } 
    this.texture.initDraw()
      .sprite(sprite, 0, 32, this.texture.getHeight())
      .light(light)
      .alpha(alpha)
      .draw(drawX, drawY - this.texture.getHeight() + 32);
  }

  public int getRandomYOffset(int tileX, int tileY) {
    synchronized (this.drawRandom) {
      return (int)((this.drawRandom.seeded(getTileSeed(tileX, tileY, 1)).nextFloat() * 2.0F - 1.0F) * 8.0F) - 4;
    } 
  }
}
