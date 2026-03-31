package HauntedBiome.World;

import java.awt.Dimension;
import java.awt.Point;

import necesse.engine.gameLoop.tickManager.PerformanceTimerManager;
import necesse.engine.registries.BiomeRegistry;
import necesse.engine.registries.ObjectRegistry;
import necesse.engine.registries.TileRegistry;
import necesse.engine.util.GameRandom;
import necesse.engine.world.biomeGenerator.BiomeGeneratorStack;
import necesse.engine.world.worldPresets.LevelPresetsRegion;
import necesse.engine.world.worldPresets.LinesGenerationWorldPreset;
import necesse.engine.world.worldPresets.WorldPreset;
import necesse.level.maps.Level;
import necesse.level.maps.generationModules.CellAutomaton;

public class VoidGravelRegionPreset extends WorldPreset 
{
  public int arms = 5;
  public int armsMinRange = 8;
  public int armsMaxRange = 15;
  public int armsMinWidth = 3;
  public int armsMaxWidth = 5;
  
  public VoidGravelRegionPreset() {}
  
  public boolean shouldAddToRegion(LevelPresetsRegion presetsRegion) {
    return presetsRegion.hasAnyOfBiome(BiomeRegistry.getBiomeID("haunted_biome"));
  }
  
  public boolean isValidPosition(int tileX, int tileY, int width, int height, LevelPresetsRegion presetsRegion, BiomeGeneratorStack generatorStack) {
    return !generatorStack.isCaveRiverOrLava(tileX + width / 2, tileY + height / 2);
  }
  
  // TODO: Add a special immobile invulnerable 'portal' mob at the centre of the biome, which spawns Void Golems or potentially something else?
  public void addToRegion(GameRandom random, final LevelPresetsRegion presetsRegion, final BiomeGeneratorStack generatorStack, PerformanceTimerManager performanceTimer) {
    int total = getTotalBiomePoints(random, presetsRegion, BiomeRegistry.getBiome("haunted_biome"), 0.025F);
    for (int i = 0; i < total; i++) {
      final int size = this.armsMaxRange + this.armsMaxWidth + this.armsMinRange;
      Dimension dimension = new Dimension(size, size);
      Point tile = findRandomBiomePresetTile(random, presetsRegion, generatorStack, BiomeRegistry.getBiome("haunted_biome"), 20, dimension, "minibiomes", new WorldPreset.ValidTilePredicate() {
            public boolean isValidPosition(int tileX, int tileY) 
            {
              return VoidGravelRegionPreset.this.isValidPosition(tileX, tileY, size, size, presetsRegion, generatorStack);
            }
          });
      if (tile != null) {
        final LinesGenerationWorldPreset lg = (new LinesGenerationWorldPreset(tile.x + size / 2, tile.y + size / 2)).addRandomArms(random, this.arms, this.armsMinRange, this.armsMaxRange, this.armsMinWidth, this.armsMaxWidth);
        if (lg.isWithinPresetRegionBounds(presetsRegion))
          presetsRegion.addPreset(this, lg.getOccupiedTileRectangle(), "minibiomes", new LevelPresetsRegion.WorldPresetPlaceFunction() {
                public void place(GameRandom random, Level level, PerformanceTimerManager timer) {
                  CellAutomaton ca = lg.doCellularAutomaton(random);
                  ca.forEachTile(level, (level2, tileX, tileY) -> {
                        level.setTile(tileX, tileY, TileRegistry.getTileID("void_gravel_tile"));
                        if (random.getChance(0.04F)) {
                          level.setObject(tileX, tileY, ObjectRegistry.getObjectID("void_fragment_cluster_small"));
                        } else {
                          level.setObject(tileX, tileY, 0);
                        } 
                      });
                }
              }).setRemoveIfWithinSpawnRegionRange(2); 
      } 
    } 
  }
}
