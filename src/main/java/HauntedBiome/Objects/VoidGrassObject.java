package HauntedBiome.Objects;

import java.awt.Color;

import necesse.engine.registries.TileRegistry;
import necesse.level.gameObject.GrassObject;
import necesse.level.maps.Level;

public class VoidGrassObject extends GrassObject 
{

    public VoidGrassObject() 
    {
      super("void_grass", 2);
      this.mapColor = new Color(75, 0, 99);
      this.lightLevel = 50;
      this.lightSat = 1.0F;
      this.lightHue = 310f;
      this.grassValidTileIDs.add(TileRegistry.getTileID("deep_void_rock_tile"));
      this.objectTileLayerIgnored = true;
    }
    
    public String canPlace(Level level, int layerID, int x, int y, int rotation, boolean byPlayer, boolean ignoreOtherLayers) {
      if ((level.getTile(x, y).getStringID() == "deep_void_rock_tile") && (level.getObject(x, y).getID() == 0))
      {
        return null;
      }
      else
      {
        return "occupied";
      }
  }
  
  public boolean isValid(Level level, int layerID, int x, int y) 
  {
      return (level.getTile(x, y).getStringID() == "deep_void_rock_tile");
  }


}
