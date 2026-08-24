package HauntedBiome.Mobs.Critters;

import java.awt.Point;
import java.util.List;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.registries.MobRegistry;
import necesse.engine.world.GameClock;
import necesse.entity.mobs.MaskShaderOptions;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.MobDrawable;
import necesse.entity.mobs.MobTexture;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.friendly.critters.SpiderCritterMob;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.texture.TextureDrawOptionsEnd;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.level.maps.Level;
import necesse.level.maps.light.GameLight;

public class VoidCrawlerMob extends SpiderCritterMob
{
    public static MobTexture texture;
    
    public VoidCrawlerMob()
    {
        super();
    }

    public void addDrawables(List<MobDrawable> list, OrderableDrawables tileList, OrderableDrawables topList, Level level, int x, int y, TickManager tickManager, GameCamera camera, PlayerMob perspective) {
    super.addDrawables(list, tileList, topList, level, x, y, tickManager, camera, perspective);
    GameLight light = level.getLightLevel(getTileCoordinate(x), getTileCoordinate(y));
    int drawX = camera.getDrawX(x) - 16;
    int drawY = camera.getDrawY(y) - 22;
    int dir = getDir();
    Point sprite = getAnimSprite(x, y, dir);
    drawY += getBobbing(x, y);
    drawY += level.getTile(getTileCoordinate(x), getTileCoordinate(y)).getMobSinkingAmount((Mob)this);
    final MaskShaderOptions swimMask = getSwimMaskShaderOptions(inLiquidFloat(x, y));
    final TextureDrawOptionsEnd options = ((TextureDrawOptionsEnd)this.texture.body.initDraw().sprite(sprite.x, sprite.y, 32).addMaskShader(swimMask).startGlowOptions((GameClock)level, getID()).light(light).applyEnemyTracker((Mob)this, perspective)).pos(drawX, drawY);
    list.add(new MobDrawable() {
          public void draw(TickManager tickManager) {
            swimMask.use();
            options.draw();
            swimMask.stop();
          }
        });
    TextureDrawOptionsEnd shadow = MobRegistry.Textures.spider.shadow.initDraw().sprite(0, dir, 32).light(light).pos(drawX, drawY);
    tileList.add(tm -> shadow.draw());
  }
}
