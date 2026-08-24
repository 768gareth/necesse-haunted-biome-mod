package HauntedBiome.Mobs.DeepCaves;

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
import necesse.gfx.gameTexture.GameTexture;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.inventory.lootTable.lootItem.OneOfLootItems;
import necesse.level.maps.Level;
import necesse.level.maps.light.GameLight;

public class DeepVoidGatewayMob extends BossMob {
    public static MaxHealthGetter MAX_HEALTH = new MaxHealthGetter(1500, 1750, 2000, 2250, 2500);
    public int spawnedMobCount = 0;
    public static GameTexture texture;

    public DeepVoidGatewayMob() {
        super(4000);

        this.isSummoned = true;
        this.collision = new Rectangle(-10, -12, 20, 20);
        this.hitBox = new Rectangle(-15, -17, 30, 30);
        this.selectBox = new Rectangle(-18, -58, 36, 58);
        this.setSpeed(0f);
        setKnockbackModifier(0.0F);
    }

    public void init() {
        super.init();
        this.ai = new BehaviourTreeAI((Mob) this, new GatewayBossAINode<>());
    }

    public boolean canPushMob(Mob other) {
        return false;
    }

    public boolean canBePushed(Mob other) {
        return false;
    }

    public LootTable getLootTable() {
        return new LootTable
        (
            new LootItemInterface[] 
            {
                new OneOfLootItems(new LootItem("egg"), new LootItem("egg"), new LootItem("egg"))
            }
        );
    }

    protected SoundSettings getHitDeathSound() {
        return new SoundSettings(GameResources.fadedeath3);
    }

    public void spawnDeathParticles(float knockbackX, float knockbackY) {
        (getLevel()).entityManager.addParticle(
                (ParticleOption) new SmokePuffParticle(getLevel(), getX(), getY(), new Color(50, 50, 50)),
                Particle.GType.CRITICAL);
    }

    public void addDrawables(List<MobDrawable> list, OrderableDrawables tileList, OrderableDrawables topList,
            Level level, int x, int y, TickManager tickManager, GameCamera camera, PlayerMob perspective) {
        super.addDrawables(list, tileList, topList, level, x, y, tickManager, camera, perspective);
        int drawX = camera.getDrawX(x);
        int drawY = camera.getDrawY(y);
        GameLight light = level.getLightLevel(getTileCoordinate(x), getTileCoordinate(y));
        final TextureDrawOptionsEnd options = ((TextureDrawOptionsEnd) texture.initDraw().sprite(0, 0, 64)
                .startGlowOptions((GameClock) level, getID()).light(light).applyEnemyTracker((Mob) this, perspective))
                .pos(drawX - 32, drawY - 32);
        list.add(new MobDrawable() {
            public void draw(TickManager tickManager) {
                options.draw();
            }
        });
        addShadowDrawables(tileList, level, x, y, light, camera);
    }

    public class GatewayBossAINode<T extends Mob> extends AINode<T> {
        public void init(T mob, Blackboard<T> blackboard) {
        }

        public AINodeResult tick(T mob, Blackboard<T> blackboard) {
            DeepVoidGatewayMinionMob portalMob = (DeepVoidGatewayMinionMob) MobRegistry
                    .getMob("deep_void_gateway_minion", DeepVoidGatewayMob.this.getLevel());
            if (spawnedMobCount < 5 && GameRandom.globalRandom.getChance(0.1f)) {
                portalMob.master = DeepVoidGatewayMob.this;
                (DeepVoidGatewayMob.this.getLevel()).entityManager.addMob(portalMob,
                        (DeepVoidGatewayMob.this.getX() + (int) (GameRandom.globalRandom.nextGaussian() * 3.0D)),
                        (DeepVoidGatewayMob.this.getY() + (int) (GameRandom.globalRandom.nextGaussian() * 3.0D)));
                DeepVoidGatewayMob.this.spawnedMobCount = DeepVoidGatewayMob.this.spawnedMobCount + 1;
            }
            return AINodeResult.SUCCESS;
        }

        @Override
        protected void onRootSet(AINode<T> arg0, T arg1, Blackboard<T> arg2) {
        }
    }
}
