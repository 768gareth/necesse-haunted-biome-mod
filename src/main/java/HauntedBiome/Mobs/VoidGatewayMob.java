package HauntedBiome.Mobs;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.List;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.registries.MobRegistry;
import necesse.engine.sound.SoundSettings;
import necesse.engine.util.GameRandom;
import necesse.engine.world.GameClock;
import necesse.entity.mobs.MaxHealthGetter;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.MobDrawable;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.ai.behaviourTree.AINode;
import necesse.entity.mobs.ai.behaviourTree.AINodeResult;
import necesse.entity.mobs.ai.behaviourTree.BehaviourTreeAI;
import necesse.entity.mobs.ai.behaviourTree.Blackboard;
import necesse.entity.mobs.hostile.bosses.BossMob;
import necesse.entity.particle.Particle;
import necesse.entity.particle.ParticleOption;
import necesse.entity.particle.SmokePuffParticle;
import necesse.gfx.GameResources;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.texture.TextureDrawOptionsEnd;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.level.maps.Level;
import necesse.level.maps.light.GameLight;

public class VoidGatewayMob extends BossMob
{
    public static MaxHealthGetter MAX_HEALTH_CAVES = new MaxHealthGetter(1500, 1750, 2000, 2250, 2500);
    public static MaxHealthGetter MAX_HEALTH_DEEP_CAVES = new MaxHealthGetter(4000, 4250, 4500, 4750, 5000);
    public int spawnedMobCount = 0;

    public VoidGatewayMob() 
    {
        super(2000);
        
        this.isSummoned = true;
        this.collision = new Rectangle(-10, -12, 20, 20);
        this.hitBox = new Rectangle(-15, -17, 30, 30);
        this.selectBox = new Rectangle(-18, -58, 36, 58);
        this.setSpeed(0f);
        setKnockbackModifier(0.0F);
    }

    public void init() 
    {
        super.init();
        this.ai = new BehaviourTreeAI((Mob)this, new GatewayBossAINode<>());
        if (this.getLevel().isDeepCaveLevel())
            {
                this.setMaxHealth(4000);
            }
            else if (this.getLevel().isBasicCaveLevel())
            {
                this.setMaxHealth(2000);
            }
    }

    protected SoundSettings getHitDeathSound() 
    {
        return new SoundSettings(GameResources.fadedeath3);
    }
  
    public void spawnDeathParticles(float knockbackX, float knockbackY) 
    {
        (getLevel()).entityManager.addParticle((ParticleOption)new SmokePuffParticle(getLevel(), getX(), getY(), new Color(50, 50, 50)), Particle.GType.CRITICAL);
    }

    public void addDrawables(List<MobDrawable> list, OrderableDrawables tileList, OrderableDrawables topList, Level level, int x, int y, TickManager tickManager, GameCamera camera, PlayerMob perspective) 
    {
    super.addDrawables(list, tileList, topList, level, x, y, tickManager, camera, perspective);
    GameLight light = level.getLightLevel(getTileCoordinate(x), getTileCoordinate(y));
    int drawX = camera.getDrawX(x) - 32;
    int drawY = camera.getDrawY(y) - 62;
    int offset = (int)(getWorldEntity().getTime() % 1600L) / 200;
    if (offset > 4)
      offset = 4 - offset % 4; 
    final TextureDrawOptionsEnd options = ((TextureDrawOptionsEnd)MobRegistry.Textures.evilsProtector2.initDraw().sprite(2, 0, 64).startGlowOptions((GameClock)level, getID()).light(light).applyEnemyTracker((Mob)this, perspective)).pos(drawX, drawY + offset);
    list.add(new MobDrawable() {
          public void draw(TickManager tickManager) {
            options.draw();
          }
        });
    addShadowDrawables(tileList, level, x, y, light, camera);
  }

  public class GatewayBossAINode<T extends Mob> extends AINode<T> 
  { 
    public void init(T mob, Blackboard<T> blackboard) {}
    
    public AINodeResult tick(T mob, Blackboard<T> blackboard) 
    {
        VoidGatewayMinionMob portalMob = (VoidGatewayMinionMob)MobRegistry.getMob("void_gateway_minion", VoidGatewayMob.this.getLevel());
        if (spawnedMobCount < 5 && GameRandom.globalRandom.getChance(0.1f))
        {
            portalMob.master = VoidGatewayMob.this;
            (VoidGatewayMob.this.getLevel()).entityManager.addMob(portalMob, (VoidGatewayMob.this.getX() + (int)(GameRandom.globalRandom.nextGaussian() * 3.0D)), (VoidGatewayMob.this.getY() + (int)(GameRandom.globalRandom.nextGaussian() * 3.0D)));
            VoidGatewayMob.this.spawnedMobCount = VoidGatewayMob.this.spawnedMobCount + 1;
        }
        return AINodeResult.SUCCESS;
    }

    @Override
    protected void onRootSet(AINode<T> arg0, T arg1, Blackboard<T> arg2) {}
  }
}
