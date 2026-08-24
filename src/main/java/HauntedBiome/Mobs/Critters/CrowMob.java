package HauntedBiome.Mobs.Critters;

import necesse.entity.mobs.friendly.critters.BirdMob;
import necesse.gfx.gameTexture.GameTexture;
import necesse.inventory.lootTable.LootTable;

public class CrowMob extends BirdMob 
{
    public static GameTexture texture;

    protected GameTexture getTexture() 
    {
        return texture;
    }
  
    public LootTable getLootTable() {
        return super.getLootTable();
    }
}