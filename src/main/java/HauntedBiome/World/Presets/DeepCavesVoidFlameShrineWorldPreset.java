package HauntedBiome.World.Presets;

import java.awt.Dimension;
import java.awt.Point;

import necesse.engine.gameLoop.tickManager.PerformanceTimerManager;
import necesse.engine.registries.BiomeRegistry;
import necesse.engine.util.GameRandom;
import necesse.engine.util.LevelIdentifier;
import necesse.engine.world.biomeGenerator.BiomeGeneratorStack;
import necesse.engine.world.worldPresets.LevelPresetsRegion;
import necesse.engine.world.worldPresets.LevelPresetsRegion.WorldPresetPlaceFunction;
import necesse.engine.world.worldPresets.WorldPreset;
import necesse.level.maps.Level;
import necesse.level.maps.presets.Preset;
import necesse.level.maps.presets.PresetUtils;

public class DeepCavesVoidFlameShrineWorldPreset extends WorldPreset
{
    protected Dimension size = new Dimension(7, 7);
    
    @Override
    public boolean shouldAddToRegion(LevelPresetsRegion presetsRegion) 
    {
        return (presetsRegion.identifier.equals(LevelIdentifier.DEEP_CAVE_IDENTIFIER) && presetsRegion.hasAnyOfBiome(BiomeRegistry.getBiomeID("haunted_biome")));
    }

    @SuppressWarnings("Convert2Lambda")
  @Override
  public void addToRegion(GameRandom random, LevelPresetsRegion presetsRegion, final BiomeGeneratorStack generatorStack, PerformanceTimerManager performanceTimer) {
    int total = getTotalBiomePoints(random, presetsRegion, BiomeRegistry.getBiome("haunted_biome"), 0.01F);
    for (int i = 0; i < total; i++) {
      final Point tile = findRandomBiomePresetTile(random, presetsRegion, generatorStack, BiomeRegistry.getBiome("haunted_biome"), 50, this.size, new String[] { "loot", "villages" }, new ValidTilePredicate() {
            @Override
            public boolean isValidPosition(int tileX, int tileY) {
              return (!generatorStack.isSurfaceExpensiveWater(tileX, tileY) && generatorStack
              .getLazyBiomeID(tileX, tileY) == BiomeRegistry.getBiome("haunted_biome").getID());
            }});
      if (tile != null)
        presetsRegion.addPreset(this, tile.x, tile.y, this.size, new String[] { "loot" }, new WorldPresetPlaceFunction() {
              @Override
              public void place(GameRandom random, Level level, PerformanceTimerManager timer) 
              {
                WorldPreset.ensureRegionsAreGenerated(level, tile.x, tile.y, 11, 9);
                DeepCavesVoidFlameShrinePreset preset = new DeepCavesVoidFlameShrinePreset();
                PresetUtils.clearMobsInPreset((Preset)preset, level, tile.x, tile.y);
                preset.applyToLevel(level, tile.x, tile.y);
              }
            }).setRemoveIfWithinSpawnRegionRange(1); 
    } 
  }
}
