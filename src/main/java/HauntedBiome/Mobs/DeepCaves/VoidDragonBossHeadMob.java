package HauntedBiome.Mobs.DeepCaves;

import java.awt.Rectangle;
import java.awt.geom.Point2D;

import necesse.engine.DifficultyBasedGetter;
import necesse.engine.sound.PrimitiveSoundEmitter;
import necesse.engine.sound.SoundManager;
import necesse.engine.sound.SoundPlayer;
import necesse.engine.sound.SoundSettings;
import necesse.engine.sound.gameSound.GameSound;
import necesse.entity.mobs.MaxHealthGetter;
import necesse.entity.mobs.hostile.bosses.BossWormMobHead;
import necesse.gfx.GameResources;
import necesse.inventory.lootTable.LootTable;

public class VoidDragonBossHeadMob extends BossWormMobHead<VoidDragonBossBodyMob, VoidDragonBossHeadMob> 
{
    public GameSound theme;
    public GameSound roar;
    public static LootTable lootTable = new LootTable();
    public static float lengthPerBodyPart = 40.0F;
    public static float waveLength = 800.0F;
    public static final int totalBodyParts = 8;
    public static MaxHealthGetter MAX_HEALTH = new MaxHealthGetter(9000, 15000, 21000, 27000, 33000);
    public Point2D.Float centerPosition;
    public float circlingAngleOffset;
    protected SoundPlayer moveSoundPlayer;

    public VoidDragonBossHeadMob() 
    {
        super(8000, waveLength, 100f, totalBodyParts, 10.0F, -40.0F);
        this.difficultyChanges.setMaxHealth((DifficultyBasedGetter)MAX_HEALTH);
        this.moveAccuracy = 100;
        this.movementUpdateCooldown = 2000;
        this.movePosTolerance = 700.0F;
        setSpeed(125.0F);
        setArmor(20);
        this.accelerationMod = 1.0F;
        this.decelerationMod = 1.0F;
        this.collision = new Rectangle(-18, -15, 36, 30);
        this.hitBox = new Rectangle(-25, -20, 50, 40);
        this.selectBox = new Rectangle(-32, -80, 64, 84);
    }

    protected float getDistToBodyPart(VoidDragonBossBodyMob bodyPart, int index, float lastDistance) 
    {
    if (index == 1)
      return lengthPerBodyPart; 
    return lengthPerBodyPart;
    }

    protected VoidDragonBossBodyMob createNewBodyPart(int index) 
    {
        VoidDragonBossBodyMob bodyPart = new VoidDragonBossBodyMob();
        int tailParts = 3;
        if (index == 1) {
        bodyPart.spriteY = 1;
        } else if (index == 8 - tailParts - 1) {
        bodyPart.spriteY = 1;
        } else if (index >= 8 - tailParts) {
        int tailPart = Math.abs(8 - index - tailParts);
        bodyPart.spriteY = 3 + tailPart;
        } else {
        bodyPart.spriteY = 2;
        } 
        bodyPart.spawnsParticles = true;
        return bodyPart;
    }

    protected void playMoveSound() 
    {
        if (this.moveSoundPlayer == null || this.moveSoundPlayer.isDone())
        this.moveSoundPlayer = SoundManager.playSound((new SoundSettings(GameResources.wind2)).volume(0.2F).pitchVariance(0.0F).fallOffDistance(1400), (PrimitiveSoundEmitter)this); 
        if (this.moveSoundPlayer != null)
        this.moveSoundPlayer.refreshLooping(); 
    }
  
    protected SoundSettings getAmbientSound() 
    {
        return (new SoundSettings(GameResources.roar)).volume(0.7F);
    }
    
    protected SoundSettings getDeathSound() 
    {
        return new SoundSettings(GameResources.roar);
    }
    
    protected SoundSettings getHurtSound() 
    {
        return (new SoundSettings(GameResources.roar)).volume(0.6F).basePitch(2.0F);
    }
    
    public void dispose() 
    {
        if (this.moveSoundPlayer != null)
        this.moveSoundPlayer.stop(); 
        super.dispose();
    }
}
