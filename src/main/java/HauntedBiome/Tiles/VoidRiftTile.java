package HauntedBiome.Tiles;

import java.awt.Color;
import java.awt.Point;
import java.util.List;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.localization.Localization;
import necesse.engine.localization.message.GameMessage;
import necesse.engine.localization.message.LocalMessage;
import necesse.engine.network.server.ServerClient;
import necesse.engine.registries.BuffRegistry;
import necesse.engine.registries.DamageTypeRegistry;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.Attacker;
import necesse.entity.mobs.DeathMessageTable;
import necesse.entity.mobs.GameDamage;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.particle.Particle;
import necesse.entity.particle.SmokePuffParticle;
import necesse.gfx.GameResources;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.texture.ShaderSprite;
import necesse.gfx.drawOptions.texture.ShaderSpriteAbstract;
import necesse.gfx.drawOptions.texture.SharedTextureDrawOptions;
import necesse.gfx.drawables.LevelSortedDrawable;
import necesse.gfx.drawables.LevelTileLiquidDrawOptions;
import necesse.gfx.drawables.LevelTileTerrainDrawOptions;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.gfx.gameTexture.GameTexture;
import necesse.gfx.gameTexture.GameTextureSection;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.Item;
import necesse.level.gameTile.TerrainSplatterTile;
import necesse.level.maps.Level;
import necesse.level.maps.splattingManager.SplattingOptions;

public class VoidRiftTile extends TerrainSplatterTile {

  public static Attacker VOID_RIFT_ATTACKER = new Attacker() {
      public GameMessage getAttackerName() {
        return (GameMessage)new LocalMessage("deaths", "void_rift_name");
      }
      
      public DeathMessageTable getDeathMessages() {
        return getDeathMessages("void_rift", 1);
      }
      
      public Mob getFirstAttackOwner() {
        return null;
      }
    };

  private final GameRandom drawRandom;
  
  private GameTextureSection swirls;
  
  private GameTextureSection fog;

  private GameTextureSection grime;
  
  public VoidRiftTile() {
    super(false, "ascendedvoid");
    this.mapColor = new Color(0, 20, 70);
    this.canBeMined = false;
    this.drawRandom = new GameRandom();
    this.rarity = Item.Rarity.EPIC;
    this.lightHue = 260f;
    this.lightLevel = 100;
    this.lightSat = 0.5f;
    this.canBeMined = false;
  }

  public void tick(Mob mob, Level level, int x, int y) {
    if (mob.canLevelInteract() && !mob.isFlying() && !mob.isWaterWalking() && level.inLiquid(mob.getX(), mob.getY()) && 
      level.isServer() && mob.canTakeDamage() && !mob.isLavaImmune() && !mob.isOnGenericCooldown("lavadamage")) {
      int maxHealth = mob.getMaxHealth();
      float damage = Math.max((float)Math.pow(maxHealth, 0.5D) + maxHealth / 20.0F, 20.0F);
      damage *= ((Float)mob.buffManager.getModifier(BuffModifiers.FIRE_DAMAGE)).floatValue();
      if (damage != 0.0F) {
        mob.isServerHit(new GameDamage(DamageTypeRegistry.TRUE, damage), 0.0F, 0.0F, 0.0F, VOID_RIFT_ATTACKER);
      } else if (mob.isPlayer) {
        PlayerMob player = (PlayerMob)mob;
        if (player.isServerClient()) {
          ServerClient client = player.getServerClient();
          if (client.achievementsLoaded())
            (client.achievements()).HOT_TUB.markCompleted(client); 
        } 
      } 
      mob.startGenericCooldown("lavadamage", 500L);
      mob.addBuff(new ActiveBuff(BuffRegistry.Debuffs.ON_FIRE, mob, 10.0F, null), true);
    } 
  }
  
  protected void loadTextures() {
    super.loadTextures();
    this.swirls = loadTexture("tiles/ascendedvoid_swirls");
    this.fog = loadTexture("tiles/ascendedvoid_fog");
    this.grime = loadTexture("tiles/ascendedvoid_grime");
  }
  
  public ListGameTooltips getItemTooltips(InventoryItem item, PlayerMob perspective) {
    ListGameTooltips itemTooltips = super.getItemTooltips(item, perspective);
    itemTooltips.add(Localization.translate("itemtooltip", "void_rift_tip"), 400);
    return itemTooltips;
  }
  
  protected GameTextureSection loadTexture(String path) {
    GameTexture texture = GameTexture.fromFile(path);
    GameTexture paddingTexture = new GameTexture(path + "_padding", texture.getWidth() + 2, texture.getHeight() + 2);
    paddingTexture.copy(texture, 1, 1);
    paddingTexture.copy(texture, 0, 0, 0, 1, texture.getWidth(), 1);
    paddingTexture.copy(texture, 0, paddingTexture.getHeight() - 1, 0, texture.getHeight() - 1, texture.getWidth(), 1);
    paddingTexture.copy(texture, 0, 0, 1, 0, 1, texture.getHeight());
    paddingTexture.copy(texture, paddingTexture.getWidth() - 1, 0, texture.getWidth() - 1, 0, 1, texture.getHeight());
    paddingTexture.makeFinal();
    texture.makeFinal();
    return tileTextures.addTexture(paddingTexture);
  }

  public double getPathCost(Level level, int tileX, int tileY, Mob mob) {
    return 1000D;
  }
  
  public void tickEffect(Level level, int x, int y) {
    super.tickEffect(level, x, y);
    GameRandom random = GameRandom.globalRandom;
    if (random.getChance(0.005F)) {
      int posX = x * 32 + random.nextInt(32);
      int posY = y * 32 + random.nextInt(32);
      level.entityManager.addParticle(new SmokePuffParticle(level, posX, posY, new Color(0, 0, 0)), Particle.GType.COSMETIC);
    } 
  }
  
  public Point getTerrainSprite(GameTextureSection terrainTexture, Level level, int tileX, int tileY) {
    int tile;
    synchronized (this.drawRandom) {
      tile = this.drawRandom.seeded(getTileSeed(tileX, tileY)).nextInt(terrainTexture.getHeight() / 32);
    } 
    return new Point(0, tile);
  }
  
  public int getTerrainPriority() {
    return 501;
  }
  
  public float getParallaxOffset(int value, float divisor) {
    float offset = value % divisor / divisor;
    if (offset < 0.0F)
      offset++; 
    return offset;
  }
  
  public void addDrawables(LevelTileTerrainDrawOptions underLiquidList, LevelTileLiquidDrawOptions liquidList, LevelTileTerrainDrawOptions overLiquidList, OrderableDrawables objectTileList, List<LevelSortedDrawable> sortedList, Level level, int tileX, int tileY, GameCamera camera, TickManager tickManager) {
    SplattingOptions splat = level.regionManager.getSplatTiles(tileX, tileY);
    if (splat != null) {
      splat.addTileDrawables(underLiquidList, liquidList, overLiquidList, objectTileList, sortedList, this, level, tileX, tileY, camera, tickManager);
    } else {
      int drawX = camera.getTileDrawX(tileX);
      int drawY = camera.getTileDrawY(tileY);
      GameTextureSection terrainTexture = getTerrainTexture(level, tileX, tileY);
      underLiquidList.add(terrainTexture).pos(drawX, drawY);
      addParallaxDrawOptions(underLiquidList, terrainTexture, camera, tileX, tileY, drawX, drawY);
    } 
  }
  
  public void addParallaxDrawOptions(LevelTileTerrainDrawOptions list, GameTextureSection terrainSection, GameCamera camera, int tileX, int tileY, int drawX, int drawY) {
    addParallaxDrawOptions(list, "swirls", 0, terrainSection, this.swirls, camera, tileX, tileY, 3000.0F, 3000.0F, drawX, drawY);
    addParallaxDrawOptions(list, "grime", 1, terrainSection, this.grime, camera, tileX, tileY, 2000.0F, 2000.0F, drawX, drawY);
    addParallaxDrawOptions(list, "fog", 2, terrainSection, this.fog, camera, tileX, tileY, 1000.0F, 1000.0F, drawX, drawY);
  }
  
  public void addParallaxDrawOptions(LevelTileTerrainDrawOptions list, String stringID, int priority, GameTextureSection terrainSection, GameTextureSection parallaxTexture, GameCamera camera, int tileX, int tileY, float xDivisor, float yDivisor, int drawX, int drawY) {
    GameTextureSection parallaxSprite = parallaxTexture.section(1, parallaxTexture.getWidth() - 1, 1, parallaxTexture.getHeight() - 1);
    SharedTextureDrawOptions draws = list.specialDrawables.getOrCreate(stringID, priority, () -> {
          float textureStartX = parallaxSprite.getStartXFloat();
          float textureStartY = parallaxSprite.getStartYFloat();
          float textureEndX = parallaxSprite.getEndXFloat();
          float textureEndY = parallaxSprite.getEndYFloat();
          float textureSizeX = textureEndX - textureStartX;
          float textureSizeY = textureEndY - textureStartY;
          float parallaxXOffset2 = getParallaxOffset(camera.getX(), xDivisor) * textureSizeX;
          float parallaxYOffset2 = getParallaxOffset(camera.getY(), yDivisor) * textureSizeY;
          SharedTextureDrawOptions options = new SharedTextureDrawOptions(generatedTileTexture) {
              public void draw(int maxDrawsPerCall) {
                GameResources.ascendedVoidShader.use();
                GameResources.ascendedVoidShader.passOffset(textureStartX, textureStartY, textureSizeX, textureSizeY, parallaxXOffset2, parallaxYOffset2);
                super.draw(maxDrawsPerCall);
                GameResources.ascendedVoidShader.stop();
              }
            };
          options.addShaderBind(1, parallaxSprite.getTexture());
          return options;
        });
    int parallaxSpriteWidth = parallaxSprite.getWidth() / 32;
    int parallaxSpriteHeight = parallaxSprite.getHeight() / 32;
    int parallaxSpriteX = Math.floorMod(tileX, parallaxSpriteWidth);
    int parallaxSpriteY = Math.floorMod(tileY, parallaxSpriteHeight);
    GameTextureSection spriteSection = parallaxSprite.sprite(parallaxSpriteX, parallaxSpriteY, 32);
    draws.add(terrainSection)
      .addShaderSprite((ShaderSpriteAbstract)new ShaderSprite(1, spriteSection))
      .pos(drawX, drawY);
  }
  
  public void addSplatDrawables(LevelTileTerrainDrawOptions underLiquidList, LevelTileLiquidDrawOptions liquidList, LevelTileTerrainDrawOptions overLiquidList, OrderableDrawables objectTileList, List<LevelSortedDrawable> sortedList, Level level, int tileX, int tileY, GameCamera camera, TickManager tickManager, int spriteX, int spriteY, int drawX, int drawY) {
    super.addSplatDrawables(underLiquidList, liquidList, overLiquidList, objectTileList, sortedList, level, tileX, tileY, camera, tickManager, spriteX, spriteY, drawX, drawY);
    GameTextureSection sprite = getSplattingTexture(level, tileX, tileY).sprite(spriteX, spriteY, 32);
    addParallaxDrawOptions(underLiquidList, sprite, camera, tileX, tileY, drawX, drawY);
  }
}
