package HauntedBiome.Tiles;

import java.awt.Color;
import java.awt.Point;

import necesse.engine.util.GameMath;
import necesse.engine.util.GameRandom;
import necesse.gfx.gameTexture.GameTextureSection;
import necesse.level.gameTile.TerrainSplatterTile;
import necesse.level.maps.Level;

public class VoidRockTile extends TerrainSplatterTile {
   public static double growChance = GameMath.getAverageSuccessRuns(12000.0D);

   private final GameRandom drawRandom;

   public VoidRockTile() {
      super(false, "void_rock");
      this.mapColor = new Color(25, 25, 180);
      this.canBeMined = true;
      this.drawRandom = new GameRandom();
   }

   @Override
   public Point getTerrainSprite(GameTextureSection terrainTexture, Level level, int tileX, int tileY) {
      int tile;
      synchronized (this.drawRandom) {
         tile = this.drawRandom.seeded(getTileSeed(tileX, tileY)).nextInt(terrainTexture.getHeight() / 32);
      }

      return new Point(0, tile);
   }

   @Override
   public int getTerrainPriority() {
      return 0;
   }
}
