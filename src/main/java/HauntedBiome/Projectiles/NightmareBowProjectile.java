package HauntedBiome.Projectiles;

import java.awt.Color;
import java.util.List;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.registries.BuffRegistry;
import necesse.engine.sound.SoundEffect;
import necesse.engine.sound.SoundManager;
import necesse.entity.mobs.Attacker;
import necesse.entity.mobs.GameDamage;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.particle.ParticleOption;
import necesse.entity.projectile.Projectile;
import necesse.entity.projectile.RicochetableProjectile;
import necesse.entity.trails.Trail;
import necesse.gfx.GameResources;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.texture.TextureDrawOptionsEnd;
import necesse.gfx.drawables.EntityDrawable;
import necesse.gfx.drawables.LevelSortedDrawable;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.level.maps.Level;
import necesse.level.maps.LevelObjectHit;
import necesse.level.maps.light.GameLight;

public class NightmareBowProjectile extends Projectile implements RicochetableProjectile
{
  public NightmareBowProjectile(Mob owner, float x, float y, float targetX, float targetY, float speed, int distance, GameDamage damage, int knockback) {
    setOwner(owner);
    this.x = x;
    this.y = y;
    setTarget(targetX, targetY);
    setDamage(damage);
    this.speed = speed;
    setDistance(distance);
    this.knockback = knockback;
  }

    public void init() {
    super.init();
    this.givesLight = true;
    this.height = 18.0F;
    this.heightBasedOnDistance = true;
    setWidth(8.0F);
  }
  
  public Color getParticleColor() {
    return new Color(57, 7, 82);
  }
  
  protected void modifySpinningParticle(ParticleOption particle) {
    particle.givesLight(240.0F, 0.5F).lifeTime(1000);
  }
  
  public Trail getTrail() {
    return new Trail(this, getLevel(), new Color(71, 90, 26), 12.0F, 250, getHeight());
  }
  
  public void doHitLogic(Mob mob, LevelObjectHit object, float x, float y) {
    super.doHitLogic(mob, object, x, y);
    if (!isServer())
      return; 
    if (mob != null) 
      {
      ActiveBuff ab = new ActiveBuff(BuffRegistry.getBuff("ruinstone_stack_debuff"), mob, (int) 5000.0F, (Attacker)getOwner());
      mob.addBuff(ab, true);
      if (this.modifier != null)
        this.modifier.doHitLogic(mob, object, x, y); 
    } 
  }
  
  public void addDrawables(List<LevelSortedDrawable> list, OrderableDrawables tileList, OrderableDrawables topList, OrderableDrawables overlayList, Level level, TickManager tickManager, GameCamera camera, PlayerMob perspective) {
    if (removed())
      return; 
    GameLight light = level.getLightLevel(this);
    int drawX = camera.getDrawX(this.x) - this.texture.getWidth() / 2;
    int drawY = camera.getDrawY(this.y);
    final TextureDrawOptionsEnd options = this.texture.initDraw().light(light).rotate(getAngle(), this.texture.getWidth() / 2, 0).pos(drawX, drawY - (int)getHeight());
    list.add(new EntityDrawable(this) {
          public void draw(TickManager tickManager) {
            options.draw();
          }
        });
    addShadowDrawables(tileList, drawX, drawY, light, getAngle(), 0);
  }
  
  protected void playHitSound(float x, float y) {
    SoundManager.playSound(GameResources.bowhit, (SoundEffect)SoundEffect.effect(x, y));
  }

  public NightmareBowProjectile(){}
}
