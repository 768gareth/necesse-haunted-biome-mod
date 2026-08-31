package HauntedBiome.Mobs.DeepCaves;

import java.awt.Color;
import java.awt.Rectangle;

import necesse.engine.gameLoop.tickManager.TicksPerSecond;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.hostile.bosses.BossWormMobBody;
import necesse.entity.particle.Particle;

public class VoidDragonBossBodyMob extends BossWormMobBody<VoidDragonBossHeadMob, VoidDragonBossBodyMob>
{
    public int shadowSprite = 0;
    public int spriteY;
    public boolean spawnsParticles;
    public TicksPerSecond particleSpawner = TicksPerSecond.ticksPerSecond(10);

    public VoidDragonBossBodyMob() 
    {
        super(1000);
        this.isSummoned = true;
        this.collision = new Rectangle(-18, -15, 36, 30);
        this.hitBox = new Rectangle(-25, -20, 50, 40);
        this.selectBox = new Rectangle(-32, -80, 64, 84);
    }

    public void clientTick() {
    super.clientTick();
    if (this.spawnsParticles && isVisible()) {
      this.particleSpawner.gameTick();
      while (this.particleSpawner.shouldTick())
        (getLevel()).entityManager.addParticle(this.x + GameRandom.globalRandom
            .floatGaussian() * 15.0F, this.y + GameRandom.globalRandom
            .floatGaussian() * 10.0F + 5.0F, Particle.GType.COSMETIC)
          
          .movesConstant(GameRandom.globalRandom
            .floatGaussian() * 6.0F, GameRandom.globalRandom
            .floatGaussian() * 3.0F)
          
          .sizeFades(15, 25)
          .color(new Color(51, 46, 59))
          
          .heightMoves(this.height + 10.0F, this.height + GameRandom.globalRandom.getFloatBetween(30.0F, 40.0F))
          .lifeTime(350); 
    } 
  }
  
  public int getFlyingHeight() {
    return 20;
  }
}
