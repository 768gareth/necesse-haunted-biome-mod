package HauntedBiome.World;

import java.awt.Point;
import java.awt.geom.Point2D;

import necesse.engine.localization.message.GameMessage;
import necesse.engine.localization.message.LocalMessage;
import necesse.engine.network.server.ServerClient;
import necesse.engine.registries.BiomeRegistry;
import necesse.engine.registries.ObjectRegistry;
import necesse.engine.registries.TileRegistry;
import necesse.engine.util.GameMath;
import necesse.engine.util.GameRandom;
import necesse.engine.util.LevelIdentifier;
import necesse.engine.world.WorldEntity;
import necesse.level.gameObject.GameObject;
import necesse.level.maps.Level;

public class VoidDragonArenaLevel extends Level {
  public static final int ARENA_SIZE = 40;
  public static final int EDGE_SIZE = 40;
  private static final int TOTAL_SIZE = 100;

  public VoidDragonArenaLevel(LevelIdentifier identifier, WorldEntity worldEntity) {
    super(identifier, 100, 100, worldEntity);
    this.baseBiome = BiomeRegistry.getBiome("haunted_biome");
    this.isCave = true;
  }

  public void onLoadingComplete() {
    super.onLoadingComplete();
    this.baseBiome = BiomeRegistry.getBiome("haunted_biome");
  }

  public GameMessage getSetSpawnError(int x, int y, ServerClient client) {
    return (GameMessage) new LocalMessage("misc", "failed_to_spawn_dragon_arena");
  }

  public void generateLevel() 
  {
    GameRandom random = new GameRandom(getSeed());
    int lighting = ObjectRegistry.getObjectID("void_candle_set");
    
    int centerX = this.tileWidth / 2;
    int centerY = this.tileHeight / 2;
    for (int i = 0; i < this.tileWidth; i++) {
      for (int y = 0; y < this.tileHeight; y++) {
        double dist = (new Point2D.Float(centerX, centerY)).distance(i, y);
        if (dist <= 20.5D) 
        {
          setTile(i, y, TileRegistry.getTileID("deep_void_stone_floor"));
          setObject(i, y, 0);
        } 
        else
        {
          setObject(i, y, 0);
          setTile(i, y, TileRegistry.getTileID("void_rift_tile"));
        }
      }
    }
    placeObjectAngle(centerX, centerY, 14.0F, -90.0F, lighting, 0, 0.0F, 0.0F);
    placeObjectAngle(centerX, centerY, 14.0F, 45.0F, lighting, 0, 0.0F, 0.0F);
    placeObjectAngle(centerX, centerY, 14.0F, -45.0F, lighting, 0, 0.0F, 0.0F);
    placeObjectAngle(centerX, centerY, 14.0F, 0.0F, lighting, 0, 0.0F, 0.0F);
    placeObjectAngle(centerX, centerY, 14.0F, 180.0F, lighting, 0, -1.0F, 0.0F);
    placeObjectAngle(centerX, centerY, 14.0F, 135.0F, lighting, 0, 0.0F, 0.0F);
    placeObjectAngle(centerX, centerY, 14.0F, -135.0F, lighting, 0, 0.0F, 0.0F);
    Point exitPosition = getExitPosition();
    GameObject exitObject = ObjectRegistry.getObject("templeexit");
    exitObject.placeObject(this, exitPosition.x, exitPosition.y, 0, false);
  }

  private void placeObjectAngle(int centerX, int centerY, float radius, float angle, int objectID, int rotation,
      float xOffset, float yOffset) {
    GameObject object = ObjectRegistry.getObject(objectID);
    Point2D.Float dir = GameMath.getAngleDir(angle);
    object.placeObject(this, (int) (centerX + dir.x * radius + xOffset), (int) (centerY + dir.y * radius + yOffset),
        rotation, false);
  }

  public static Point getExitPosition() {
    return new Point(66, 82);
  }

  public static Point2D.Float getBossPosition() {
    return new Point2D.Float(2160.0F, 2160.0F);
  }
}