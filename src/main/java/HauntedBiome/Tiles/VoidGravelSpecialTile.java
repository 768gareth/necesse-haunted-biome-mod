package HauntedBiome.Tiles;

import java.awt.Color;
import java.awt.Point;

import necesse.gfx.gameTexture.GameTextureSection;
import necesse.level.gameTile.TerrainSplatterTile;
import necesse.level.maps.Level;
import necesse.level.maps.TilePosition;
import necesse.level.maps.biomes.MobSpawnTable;

public class VoidGravelSpecialTile extends TerrainSplatterTile 
{
    public static MobSpawnTable VoidGravelSpawns = new MobSpawnTable().add(20, "void_construct").add(10, "void_caveling");
  public VoidGravelSpecialTile() 
  {
    super(false, "void_gravel_tile", "splattingmaskwide");
    this.mapColor = new Color(86, 31, 97);
    this.canBeMined = true;
  }
  
  public Point getTerrainSprite(GameTextureSection terrainTexture, Level level, int tileX, int tileY) 
  {
    return new Point(Math.floorMod(tileX, 4), Math.floorMod(tileY, 4));
  }
  
  public int getTerrainPriority() {
    return 100;
  }

  public MobSpawnTable getMobSpawnTable(TilePosition pos, MobSpawnTable defaultTable) {
    if (pos.objectID() == 0 && !(pos.level instanceof necesse.level.maps.IncursionLevel))
      return VoidGravelSpawns; 
    return super.getMobSpawnTable(pos, defaultTable);
  }
}