package HauntedBiome.Mobs;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.network.server.Server;
import necesse.engine.network.server.ServerClient;
import necesse.engine.sound.SoundSettings;
import necesse.engine.sound.gameSound.GameSound;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.DeathMessageTable;
import necesse.entity.mobs.GameDamage;
import necesse.entity.mobs.HumanTexture;
import necesse.entity.mobs.MaskShaderOptions;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.MobDrawable;
import necesse.entity.mobs.MobSpawnLocation;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.ai.behaviourTree.BehaviourTreeAI;
import necesse.entity.mobs.ai.behaviourTree.trees.ConfusedCollisionPlayerChaserWandererAI;
import necesse.entity.mobs.hostile.HostileMob;
import necesse.entity.particle.FleshParticle;
import necesse.entity.particle.Particle;
import necesse.gfx.GameResources;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.DrawOptions;
import necesse.gfx.drawOptions.human.HumanDrawOptions;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;
import necesse.level.maps.Level;
import necesse.level.maps.light.GameLight;

public class AncientGhoulMob extends HostileMob
{
  public static LootTable LootTable = new LootTable(new LootItemInterface[] { new ChanceLootItem(0.2f, "void_fragment") });
  public static HumanTexture Texture;

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public AncientGhoulMob()
  {
      super(350);
      this.setArmor(10);
      this.setSpeed(20F);
      this.setFriction(3.0F);
      this.collision = new Rectangle(-10, -7, 20, 14);
      this.hitBox = new Rectangle(-14, -12, 28, 24);
      this.selectBox = new Rectangle(-14, -41, 28, 48);
      this.swimMaskMove = 16;
      this.swimMaskOffset = -2;
      this.swimSinkOffset = -4;
      this.ai = new BehaviourTreeAI(this, new ConfusedCollisionPlayerChaserWandererAI((java.util.function.Supplier)null, 512, new GameDamage(55f), 100, 40000));
  }

  @Override
  public DeathMessageTable getDeathMessages() 
  {
    return getDeathMessages("ghoul", 2);
  }
  
  @Override
  public void spawnDeathParticles(float knockbackX, float knockbackY) 
  {
    for (int i = 0; i < 4; i++)
      (getLevel()).entityManager.addParticle((Particle)new FleshParticle(getLevel(), AncientGhoulMob.Texture.body, GameRandom.globalRandom.nextInt(5), 8, 32, this.x, this.y, 20.0F, knockbackX, knockbackY), Particle.GType.IMPORTANT_COSMETIC); 
  }

  @Override
  public LootTable getLootTable() 
  {
    return LootTable;
  }

  @Override
  public boolean isValidSpawnLocation(Server server, ServerClient client, int targetX, int targetY) {
    MobSpawnLocation location = (new MobSpawnLocation((Mob)this, targetX, targetY)).checkMobSpawnLocation();
    if ((getLevel()).isCave) {
      location = location.checkLightThreshold(client);
    } else {
      location = location.checkMaxStaticLightThreshold(10);
    } 
    return location
      .validAndApply();
  }
  
  @Override
  public void addDrawables(List<MobDrawable> list, OrderableDrawables tileList, OrderableDrawables topList, Level level, int x, int y, TickManager tickManager, GameCamera camera, PlayerMob perspective) {
    super.addDrawables(list, tileList, topList, level, x, y, tickManager, camera, perspective);
    GameLight light = level.getLightLevel(getTileCoordinate(x), getTileCoordinate(y));
    int drawX = camera.getDrawX(x) - 22 - 10;
    int drawY = camera.getDrawY(y) - 44 - 7;
    int dir = getDir();
    Point sprite = getAnimSprite(x, y, dir);
    drawY += getBobbing(x, y);
    drawY += level.getTile(getTileCoordinate(x), getTileCoordinate(y)).getMobSinkingAmount((Mob)this);
    MaskShaderOptions swimMask = getSwimMaskShaderOptions(inLiquidFloat(x, y));
    HumanDrawOptions humanDrawOptions = (new HumanDrawOptions(level, AncientGhoulMob.Texture)).sprite(sprite).dir(dir).mask(swimMask).light(light);
    final DrawOptions drawOptions = humanDrawOptions.pos(drawX, drawY);
    list.add(new MobDrawable() {
      @Override
          public void draw(TickManager tickManager) {
            drawOptions.draw();
          }
        });
    addShadowDrawables(tileList, level, x, y, light, camera);
  }
  
  @Override
  public int getRockSpeed() {
    return 20;
  }
  
  @Override
  protected SoundSettings getAmbientSound() {
    return (new SoundSettings(GameResources.zombieGroans[GameRandom.globalRandom.getIntBetween(10, 14)])).volume(0.85F).basePitch(0.5f);
  }
  
  @Override
  protected SoundSettings getDeathSound() {
    return (new SoundSettings(GameResources.zombieGroans[6], new GameSound[] { GameResources.zombieGroans[7], GameResources.zombieGroans[13], GameResources.zombieGroans[18] })).volume(0.8F).basePitch(0.5f);
  }
}
