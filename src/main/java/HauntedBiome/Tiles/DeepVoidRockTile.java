package HauntedBiome.Tiles;

import java.awt.Color;
import java.awt.Point;

import necesse.engine.network.server.ServerClient;
import necesse.engine.util.GameMath;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.Attacker;
import necesse.gfx.gameTexture.GameTextureSection;
import necesse.level.gameTile.GrassTile;
import necesse.level.gameTile.SimpleTerrainTile;
import necesse.level.maps.Level;
import necesse.level.maps.regionSystem.SimulatePriorityList;

public class DeepVoidRockTile extends SimpleTerrainTile 
{
    public static double growChance = GameMath.getAverageSuccessRuns(1600.0D);
    private final GameRandom drawRandom;

  public DeepVoidRockTile() {
    super("deep_void_rock", new Color(125, 30, 175));
    this.canBeMined = true;
    this.isOrganic = true;
    this.drawRandom = new GameRandom();
  }
  
  public boolean onDamaged(Level level, int x, int y, int damage, Attacker attacker, ServerClient client, boolean showEffect, int mouseX, int mouseY) {
    if (!level.tileLayer.isPlayerPlaced(x, y))
      return false; 
    return super.onDamaged(level, x, y, damage, attacker, client, showEffect, mouseX, mouseY);
  }

  public void addSimulateLogic(Level level, int x, int y, long ticks, SimulatePriorityList list, boolean sendChanges) {
    if (level.isCave)
      GrassTile.addSimulateGrow(level, x, y, growChance, ticks, "void_grass", list, sendChanges); 
  }

  public Point getTerrainSprite(GameTextureSection terrainTexture, Level level, int tileX, int tileY) {
    int tile;
    synchronized (this.drawRandom) {
      tile = this.drawRandom.seeded(getTileSeed(tileX, tileY)).nextInt(terrainTexture.getHeight() / 32);
    } 
    return new Point(0, tile);
  }
  
  public int getTerrainPriority() {
    return 0;
  }
}
