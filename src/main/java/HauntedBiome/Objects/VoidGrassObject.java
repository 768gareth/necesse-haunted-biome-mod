package HauntedBiome.Objects;

import java.awt.Color;

import necesse.engine.registries.ObjectLayerRegistry;
import necesse.engine.registries.TileRegistry;
import necesse.level.gameObject.GameObject;
import necesse.level.gameObject.GrassObject;
import necesse.level.maps.Level;

public class VoidGrassObject extends GrassObject 
{
    public VoidGrassObject() 
    {
      super("void_grass", 2);
      this.mapColor = new Color(75, 0, 99);
      this.lightLevel = 75;
      this.lightSat = 1.0F;
      this.lightHue = 310f;
    }
    
    @Override
    public boolean canPlaceOn(Level level, int layerID, int x, int y, GameObject other) 
    {
      return (other.getID() == 0 || !other.getValidObjectLayers().contains(ObjectLayerRegistry.TILE_LAYER));
    }
    
    @Override
    public String canPlace(Level level, int layerID, int x, int y, int rotation, boolean byPlayer, boolean ignoreOtherLayers) 
    {
      String error = super.canPlace(level, layerID, x, y, rotation, byPlayer, ignoreOtherLayers);
      if (error != null)
        return error; 
      if (level.getObjectID(ObjectLayerRegistry.TILE_LAYER, x, y) != 0)
        return "occupied"; 
      if (byPlayer && (level.getTile(x, y)).isOrganic)
        return null; 
      if (level.getTileID(x, y) != TileRegistry.getTileID("ascendedcorruption"))
        return "wrongtile"; 
      return null;
    }
    
    @Override
    public boolean isValid(Level level, int layerID, int x, int y) {
      if (!super.isValid(level, layerID, x, y))
        return false; 
      if (level.getObjectID(ObjectLayerRegistry.TILE_LAYER, x, y) != 0)
        return false; 
      if (level.objectLayer.isPlayerPlaced(layerID, x, y))
        return true; 
      return (level.getTileID(x, y) == TileRegistry.getTileID("ascendedcorruption"));
    }
  }
