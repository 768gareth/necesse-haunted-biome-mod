package HauntedBiome.Mobs.Surface;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.network.server.Server;
import necesse.engine.network.server.ServerClient;
import necesse.engine.registries.MobRegistry;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.DeathMessageTable;
import necesse.entity.mobs.GameDamage;
import necesse.entity.mobs.HumanTexture;
import necesse.entity.mobs.MaskShaderOptions;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.MobDrawable;
import necesse.entity.mobs.MobSpawnLocation;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.ai.behaviourTree.AINode;
import necesse.entity.mobs.ai.behaviourTree.BehaviourTreeAI;
import necesse.entity.mobs.ai.behaviourTree.trees.ConfusedCollisionPlayerChaserWandererAI;
import necesse.entity.mobs.hostile.HostileMob;
import necesse.entity.particle.FleshParticle;
import necesse.entity.particle.Particle;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.DrawOptions;
import necesse.gfx.drawOptions.human.HumanDrawOptions;
import necesse.gfx.drawOptions.human.HumanDrawOptions.HumanDrawOptionsGetter;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.armorItem.ArmorItem;
import necesse.level.maps.Level;
import necesse.level.maps.light.GameLight;

public class UndeadCultist extends HostileMob
{
    public static HumanTexture texture;
    public InventoryItem helmet;
    public InventoryItem chest;
    public InventoryItem boots;

    public UndeadCultist()
    {
        super(150);
        this.setArmor(10);
        this.setSpeed(15F);
        this.collision = new Rectangle(-10, -7, 20, 14);
        this.hitBox = new Rectangle(-14, -12, 28, 24);
        this.selectBox = new Rectangle(-14, -41, 28, 48);
        this.swimMaskMove = 16;
        this.swimMaskOffset = -2;
        this.swimSinkOffset = -4;
        this.helmet = new InventoryItem("void_cult_hood");
        this.chest = new InventoryItem("void_cult_robe");
        this.boots = new InventoryItem("void_cult_boots");
    }

    public void init() {
    super.init();
    this.ai = new BehaviourTreeAI((Mob)this, (AINode)new ConfusedCollisionPlayerChaserWandererAI(null, 160, new GameDamage(30.0F), 100, 40000));
  }

    public void addDrawables(List<MobDrawable> list, OrderableDrawables tileList, OrderableDrawables topList, Level level, int x, int y, TickManager tickManager, GameCamera camera, PlayerMob perspective) 
    {
        super.addDrawables(list, tileList, topList, level, x, y, tickManager, camera, perspective);
        GameLight light = level.getLightLevel(x / 32, y / 32);
        int drawX = camera.getDrawX(x) - 22 - 10;
        int drawY = camera.getDrawY(y) - 44 - 7;
        int dir = getDir();
        Point sprite = getAnimSprite(x, y, dir);
        drawY += getBobbing(x, y);
        drawY += getLevel().getTile(x / 32, y / 32).getMobSinkingAmount((Mob)this);
        MaskShaderOptions swimMask = getSwimMaskShaderOptions(inLiquidFloat(x, y));
        HumanDrawOptions humanDrawOptions = (new HumanDrawOptions(level, this.texture)).sprite(sprite).dir(dir).mask(swimMask).light(light);
        if (this.helmet != null)
        {
            humanDrawOptions.helmet(this.helmet); 
            humanDrawOptions.hatTexture((HumanDrawOptionsGetter)null, ArmorItem.HairDrawMode.NO_HAIR);
        }
        if (this.chest != null) 
        {
            humanDrawOptions.chestplate(this.chest);
        } 
        if (this.boots != null) 
        {
            humanDrawOptions.boots(this.boots);
        } 
        final DrawOptions drawOptions = humanDrawOptions.pos(drawX, drawY);
        list.add
        (   new MobDrawable() 
            {
                public void draw(TickManager tickManager) 
                {
                    drawOptions.draw();
                }
            }
        );
        addShadowDrawables(tileList, level, x, y, light, camera);
    }
    
    public boolean isValidSpawnLocation(Server server, ServerClient client, int targetX, int targetY) 
    {
      MobSpawnLocation location = (new MobSpawnLocation((Mob)this, targetX, targetY)).checkMobSpawnLocation();
      if ((getLevel()).isCave) {
        location = location.checkLightThreshold(client);
      } else {
        location = location.checkMaxStaticLightThreshold(10);
      } 
      return location
        .validAndApply();
    }

    public int getRockSpeed() 
    {
      return 20;
    }

    public DeathMessageTable getDeathMessages() 
    {
      return getDeathMessages("skeleton", 3);
    }
  
    public void spawnDeathParticles(float knockbackX, float knockbackY) 
    {
      for (int i = 0; i < 4; i++)
        (getLevel()).entityManager.addParticle((Particle)new FleshParticle(getLevel(), MobRegistry.Textures.ancientSkeleton.body, GameRandom.globalRandom.nextInt(5), 8, 32, this.x, this.y, 20.0F, knockbackX, knockbackY), Particle.GType.IMPORTANT_COSMETIC); 
    }
}
