package HauntedBiome.Projectiles;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.List;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.util.GameMath;
import necesse.engine.util.GameRandom;
import necesse.entity.ParticleTypeSwitcher;
import necesse.entity.mobs.GameDamage;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.particle.Particle;
import necesse.entity.particle.ParticleOption;
import necesse.entity.projectile.Projectile;
import necesse.entity.trails.Trail;
import necesse.gfx.GameResources;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawables.LevelSortedDrawable;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.level.maps.Level;
import necesse.level.maps.LevelObjectHit;


public class CursedFireProjectile extends Projectile
{
      private boolean hitMob = false;

    public CursedFireProjectile(Level level, float x, float y, float targetX, float targetY, int distance, GameDamage damage, Mob owner)
    {
      super();
      setLevel(level);
      this.x = x;
      this.y = y;
      setTarget(targetX, targetY);
      this.speed = distance * 1.1F;
      setDamage(damage);
      setOwner(owner);
      setDistance(distance);
    }

    public CursedFireProjectile() {}

    public void init() {
    super.init();
    this.height = 8.0F;
    this.piercing = 2;
    setWidth(25.0F);
    this.canBounce = false;
    if (isClient()) {
      int amount = this.distance / 8;
      spawnSprayParticles(amount);
    } 
  }

   public void onMoveTick(Point2D.Float startPos, double movedDist) {
    super.onMoveTick(startPos, movedDist);
    float progress = this.traveledDistance / this.distance;
    this.speed = GameMath.lerp(progress, this.distance * 1.1F, 5.0F);
  }

    public void doHitLogic(Mob mob, LevelObjectHit object, float x, float y) 
    {
      super.doHitLogic(mob, object, x, y);
      if (this.isServer() && mob != null) {
         ActiveBuff ab = new ActiveBuff("ablaze", mob, 5.0F, this.getOwner());
         mob.addBuff(ab, true);
      }
   }

   public void spawnSprayParticles(int amount) {
    ParticleTypeSwitcher particleTypeSwitcher = new ParticleTypeSwitcher(new Particle.GType[] { Particle.GType.CRITICAL, Particle.GType.IMPORTANT_COSMETIC, Particle.GType.COSMETIC });
    for (int i = 0; i < amount; i++) {
      float posX = this.x + GameRandom.globalRandom.floatGaussian() * 4.0F;
      float posY = this.y + GameRandom.globalRandom.floatGaussian() * 4.0F;
      float projectileHeight = getHeight();
      float startHeight = GameRandom.globalRandom.getFloatBetween(projectileHeight - 2.0F, projectileHeight + 4.0F);
      float startHeightSpeed = GameRandom.globalRandom.getFloatBetween(0.0F, 60.0F);
      float endHeight = GameRandom.globalRandom.getFloatBetween(-10.0F, -5.0F);
      float gravity = GameRandom.globalRandom.getFloatBetween(8.0F, 20.0F);
      float distanceLeft = this.distance - this.traveledDistance;
      float floatPower = GameRandom.globalRandom.getFloatBetween(0.2F, 1.0F);
      float power = floatPower * (distanceLeft + 50.0F);
      float friction = 1.0F;
      int lifeAdded = (int)(250.0F * floatPower);
      int timeToLive = GameRandom.globalRandom.getIntBetween(250 + lifeAdded, 750 + lifeAdded);
      int timeToFadeOut = GameRandom.globalRandom.getIntBetween(500, 1000);
      int totalTime = timeToLive + timeToFadeOut;
      ParticleOption.HeightMover heightMover = new ParticleOption.HeightMover(startHeight, startHeightSpeed, gravity, 2.0F, endHeight, 0.0F);
      ParticleOption.FrictionMover frictionMover = new ParticleOption.FrictionMover(this.dx * power, this.dy * power, friction);
      ParticleOption.CollisionMover mover = new ParticleOption.CollisionMover(getLevel(), (ParticleOption.Mover)frictionMover);
      (getLevel()).entityManager.addParticle(posX, posY, particleTypeSwitcher.next())
        .fadesAlphaTime(0, timeToFadeOut)
        .color(new Color(144, 0, 227))
        .sizeFadesInAndOut(15, 20, 100, 0)
        .height((ParticleOption.HeightGetter)heightMover)
        .rotates()
        .moves((pos, delta, lifeTime, timeAlive, lifePercent) -> {
            if (heightMover.currentHeight > endHeight && (!removed() || !this.hitMob))
              mover.tick(pos, delta, lifeTime, timeAlive, lifePercent); 
          }).sprite(GameResources.magicSparkParticles.sprite(GameRandom.globalRandom.nextInt(4), 0, 22))
        .givesLight(200.0F, 0.7F)
        .lifeTime(totalTime);
    } 
  }

  public Color getParticleColor() {
    return null;
  }
  
  public Trail getTrail() {
    return null;
  }
  
  protected Color getWallHitColor() {
    return null;
  }
  
  public void addDrawables(List<LevelSortedDrawable> list, OrderableDrawables tileList, OrderableDrawables topList, OrderableDrawables overlayList, Level level, TickManager tickManager, GameCamera camera, PlayerMob perspective) {}
}