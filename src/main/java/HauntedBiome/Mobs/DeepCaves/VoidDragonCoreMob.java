package HauntedBiome.Mobs.DeepCaves;

import necesse.engine.sound.gameSound.GameSound;
import necesse.entity.mobs.MaxHealthGetter;
import necesse.entity.mobs.hostile.bosses.BossMob;

public class VoidDragonCoreMob extends BossMob
{
    public GameSound shatterSound;
    public static MaxHealthGetter MAX_HEALTH = new MaxHealthGetter(5000, 10000, 12000, 15000, 17000);

    public VoidDragonCoreMob(int health) 
    {
        super(health);
        //TODO Auto-generated constructor stub
    }

    
}
