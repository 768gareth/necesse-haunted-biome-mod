package HauntedBiome.World;

import java.util.concurrent.atomic.AtomicInteger;

import HauntedBiome.Utils.HauntedLootTables;
import HauntedBiome.Utils.RegisterChestRoomSets;
import HauntedBiome.Utils.RegisterWallSets;
import necesse.engine.AbstractMusicList;
import necesse.engine.MusicList;
import necesse.engine.registries.MusicRegistry;
import necesse.engine.registries.ObjectRegistry;
import necesse.engine.registries.TileRegistry;
import necesse.engine.sound.SoundSettings;
import necesse.engine.sound.SoundSettingsRegistry;
import necesse.engine.util.GameRandom;
import necesse.engine.util.LevelIdentifier;
import necesse.engine.world.biomeGenerator.BiomeGeneratorStack;
import necesse.entity.mobs.PlayerMob;
import necesse.inventory.lootTable.LootTablePresets;
import necesse.level.gameTile.GameTile;
import necesse.level.maps.Level;
import necesse.level.maps.biomes.Biome;
import necesse.level.maps.biomes.FishingLootTable;
import necesse.level.maps.biomes.FishingSpot;
import necesse.level.maps.biomes.MobSpawnTable;
import necesse.level.maps.presets.RandomCaveChestRoom;
import necesse.level.maps.presets.caveRooms.CaveRuins;
import necesse.level.maps.presets.set.FurnitureSet;
import necesse.level.maps.presets.set.VillageSet;
import necesse.level.maps.regionSystem.Region;

public class HauntedBiome extends Biome {
    public static FishingLootTable SurfaceFish = new FishingLootTable().addAll(Biome.defaultSurfaceFish);
    public static FishingLootTable CaveFish = new FishingLootTable().addAll(Biome.defaultCaveFish);
    public static FishingLootTable DeepCaveFish = new FishingLootTable().addAll(Biome.defaultCaveFish);
    public static MobSpawnTable SurfaceMobs = new MobSpawnTable().add(80, "ghoul").add(20, "voidapprentice");
    public static MobSpawnTable CaveMobs = new MobSpawnTable().add(50, "ghoul").add(50, "bone_construct");
    public static MobSpawnTable DeepCaveMobs = new MobSpawnTable().add(25, "ancient_ghoul");
    public static MobSpawnTable SurfaceCritters = new MobSpawnTable().add(100, "spider").add(100, "mouse");
    public static MobSpawnTable CaveCritters = new MobSpawnTable().include(Biome.defaultCaveCritters).add(50,
            "void_caveling");
    public static MobSpawnTable DeepCaveCritters = new MobSpawnTable().include(Biome.defaultCaveCritters).add(50,
            "void_caveling");

    public HauntedBiome() {
    }

    @Override
    public boolean canRain(Level level) {
        return true;
    }

    @Override
    public FishingLootTable getFishingLootTable(FishingSpot Spot) 
    {
        if (Spot.tile.level.getIdentifier() == LevelIdentifier.DEEP_CAVE_IDENTIFIER) 
        {
            return DeepCaveFish;
        } 
        else if (Spot.tile.level.isCave) 
        {
            return CaveFish;
        } 
        else 
        {
            return SurfaceFish;
        }
    }

    @Override
    public MobSpawnTable getCritterSpawnTable(Level Level) 
    {
        if (Level.getIdentifier() == LevelIdentifier.DEEP_CAVE_IDENTIFIER) 
        {
            return DeepCaveCritters;
        } 
        else if (Level.isCave) 
        {
            return CaveCritters;
        } 
        else 
        {
            return SurfaceCritters;
        }
    }

    @Override
    public MobSpawnTable getMobSpawnTable(Level Level) {
        if (Level.getIdentifier() == LevelIdentifier.DEEP_CAVE_IDENTIFIER) {
            return DeepCaveMobs;
        } 
        else if (Level.isCave) 
        {
            return CaveMobs;
        } 
        else 
        {
            return SurfaceMobs;
        }
    }

    @Override
    public AbstractMusicList getLevelMusic(Level Level, PlayerMob perspective) {
        if (Level.getIdentifier() == LevelIdentifier.DEEP_CAVE_IDENTIFIER) {
            return new MusicList(MusicRegistry.GrindTheAlarms);
        } else if (Level.isCave) {
            return new MusicList(MusicRegistry.CaravanTusks);
        } else {
            return new MusicList(MusicRegistry.SilverLake);
        }
    }

    @Override
    public GameTile getUnderLiquidTile(Level level, int tileX, int tileY) {
        return TileRegistry.getTile(TileRegistry.dirtID);
    }

    @Override
    public int getGenerationWaterTileID() {

        return TileRegistry.waterID;
    }

    @Override
    public int getGenerationCaveLavaTileID() {
        return TileRegistry.lavaID;
    }

    @Override
    public int getGenerationDeepCaveLavaTileID() {
        return TileRegistry.lavaID;
    }

    @Override
    public int getGenerationTerrainTileID() {
        return TileRegistry.getTileID("haunted_grass_tile");
    }

    @Override
    public int getGenerationCaveRockObjectID() {
        return ObjectRegistry.getObjectID("void_rock");
    }

    @Override
    public int getGenerationCaveTileID() {
        return TileRegistry.getTileID("void_rock_tile");
    }

    @Override
    public int getGenerationDeepCaveTileID() {
        return TileRegistry.getTileID("void_rock_tile");
    }

    @Override
    public int getGenerationDeepCaveRockObjectID() {
        return ObjectRegistry.getObjectID("deep_void_rock");
    }

    @Override
    public int getGenerationBeachTileID() {
        return TileRegistry.sandID;
    }

    @Override
    public SoundSettings getWindSound(Level level) {
        return SoundSettingsRegistry.wind;
    }

    @Override
    public VillageSet[] getVillageSets() {
        return null;
    }

    @Override
    public void initializeGeneratorStack(BiomeGeneratorStack stack) {
        super.initializeGeneratorStack(stack);
        stack.addRandomSimplexVeinsBranch("hauntedTrees", 2.0F, 0.2F, 0.4F, 0);
        stack.addRandomSimplexVeinsBranch("hauntedMudPatches", 2.0F, 0.5F, 0.7F, 2);
        stack.addRandomVeinsBranch("hauntedBlackberries", 0.065F, 8, 10, 0.1F, 0, false);
        stack.addRandomVeinsBranch("hauntedReeds", 0.5F, 5, 7, 0.7F, 0, false);
        stack.addRandomVeinsBranch("hauntedClay", 0.9F, 5, 10, 0.4F, 2, false);
        stack.addRandomVeinsBranch("hauntedCopper", 0.72F, 3, 6, 0.4F, 2, false);
        stack.addRandomVeinsBranch("hauntedIron", 0.56F, 3, 6, 0.4F, 2, false);
        stack.addRandomVeinsBranch("hauntedGold", 0.16F, 3, 6, 0.4F, 2, false);
        stack.addRandomVeinsBranch("hauntedDemonic", 0.12F, 3, 6, 0.4F, 2, false);

        stack.addRandomVeinsBranch("hauntedGrass", 2F, 16, 32, 0.8F, 2, false);
        stack.addRandomVeinsBranch("hauntedWildCaveGlow", 0.32F, 4, 8, 0.4F, 2, false);
        stack.addRandomVeinsBranch("hauntedDeepCopper", 0.08F, 3, 6, 0.4F, 2, false);
        stack.addRandomVeinsBranch("hauntedDeepIron", 0.4F, 3, 6, 0.4F, 2, false);
        stack.addRandomVeinsBranch("hauntedDeepGold", 0.24F, 3, 6, 0.4F, 2, false);
        stack.addRandomVeinsBranch("hauntedDeepTungsten", 0.32F, 3, 6, 0.4F, 2, false);
        stack.addRandomVeinsBranch("hauntedDeepLifeQuartz", 0.08F, 3, 6, 0.4F, 2, false);
        stack.addRandomVeinsBranch("hauntedDeepObsidian", 0.4F, 5, 10, 0.4F, 2, false);
    }

    @Override
    public void generateRegionSurfaceTerrain(Region region, BiomeGeneratorStack stack, GameRandom random) {
        super.generateRegionSurfaceTerrain(region, stack, random);
        int GrassTile = TileRegistry.getTileID("haunted_grass_tile");
        stack.startPlaceOnVein(this, region, random, "hauntedMudPatches").onlyOnTile(GrassTile).chance(0.8)
                .placeTile(TileRegistry.mudID);
        stack.startPlaceOnVein(this, region, random, "hauntedTrees").onlyOnTile(GrassTile).chance(0.3)
                .placeObject("haunted_tree");
        stack.startPlace(this, region, random).onlyOnTile(GrassTile).chance(0.7).placeObject("haunted_grass");
        stack.startPlace(this, region, random).chance(0.004).placeObject("void_rock_small");
        stack.startPlace(this, region, random).chance(0.002).placeObject("void_rock_large");
        stack.startPlaceOnVein(this, region, random, "hauntedBlackberries").onlyOnTile(GrassTile)
                .placeObjectFruitGrower("blackberrybush");
        region.updateLiquidManager();
    }

    @Override
    public void generateRegionCaveTerrain(Region region, BiomeGeneratorStack stack, GameRandom random) {
        super.generateRegionCaveTerrain(region, stack, random);
        int RockID = ObjectRegistry.getObjectID("void_rock");
        stack.startPlaceOnVein(this, region, random, "hauntedClay").onlyOnObject(RockID).placeObjectForced("clayrock");
        stack.startPlaceOnVein(this, region, random, "hauntedCopper").onlyOnObject(RockID)
                .placeObjectForced("copper_ore_void_rock");
        stack.startPlaceOnVein(this, region, random, "hauntedIron").onlyOnObject(RockID)
                .placeObjectForced("iron_ore_void_rock");
        stack.startPlaceOnVein(this, region, random, "hauntedGold").onlyOnObject(RockID)
                .placeObjectForced("gold_ore_void_rock");
        stack.startPlaceOnVein(this, region, random, "hauntedDemonic").onlyOnObject(RockID)
                .placeObjectForced("demonic_ore_void_rock");
        stack.startPlace(this, region, random).chance(0.004).placeObject("void_rock_small");
        stack.startPlace(this, region, random).chance(0.002).placeObject("void_rock_large");
        stack.startPlace(this, region, random).chance(0.001).placeObject("void_fragment_cluster");
        stack.startPlace(this, region, random).chance(0.029999999329447746D).placeCrates(new String[] { "crate" });
        region.updateLiquidManager();
    }

    @Override
    public void generateRegionDeepCaveTerrain(Region region, BiomeGeneratorStack stack, GameRandom random) {
        super.generateRegionDeepCaveTerrain(region, stack, random);
        int RockID = ObjectRegistry.getObjectID("deep_void_rock");
        stack.startPlaceOnVein(this, region, random, "hauntedWildCaveGlow")
                .onlyOnTile(TileRegistry.getTileID("void_rock_tile")).chance(0.20000000298023224D)
                .placeObject("haunted_caveglow");
        stack.startPlaceOnVein(this, region, random, "hauntedDeepCopper").onlyOnObject(RockID)
                .placeObjectForced("copper_ore_deep_void_rock");
        stack.startPlaceOnVein(this, region, random, "hauntedDeepIron").onlyOnObject(RockID)
                .placeObjectForced("iron_ore_deep_void_rock");
        stack.startPlaceOnVein(this, region, random, "hauntedDeepGold").onlyOnObject(RockID)
                .placeObjectForced("gold_ore_deep_void_rock");
        stack.startPlaceOnVein(this, region, random, "hauntedDeepObsidian").onlyOnObject(RockID)
                .placeObjectForced("obsidianrock");
        stack.startPlaceOnVein(this, region, random, "hauntedDeepTungsten").onlyOnObject(RockID)
                .placeObjectForced("tungsten_ore_deep_void_rock");
        stack.startPlaceOnVein(this, region, random, "hauntedDeepLifeQuartz").onlyOnObject(RockID)
                .placeObjectForced("life_quartz_deep_void_rock");
        stack.startPlaceOnVein(this, region, random, "hauntedDemonic").onlyOnObject(RockID)
                .placeObjectForced("demonic_ore_deep_void_rock");
        stack.startPlace(this, region, random).chance(0.004).placeObject("void_rock_small");
        stack.startPlace(this, region, random).chance(0.003).placeObject("void_rock_large");
        stack.startPlace(this, region, random).chance(0.001).placeObject("void_fragment_cluster");
        stack.startPlace(this, region, random).chance(0.029999999329447746D).placeCrates(new String[] { "crate" });
        region.updateLiquidManager();
    }

    @Override
    public RandomCaveChestRoom getNewCaveChestRoomPreset(GameRandom random, AtomicInteger lootRotation) {
        RandomCaveChestRoom chestRoom = new RandomCaveChestRoom(random, HauntedLootTables.HauntedCavesChest,
                lootRotation, RegisterChestRoomSets.HauntedBiomeSet);
        chestRoom.replaceTile("stonefloor", "void_stone_floor");
        return chestRoom;
    }

    @Override
    public RandomCaveChestRoom getNewDeepCaveChestRoomPreset(GameRandom random, AtomicInteger lootRotation) {
        RandomCaveChestRoom chestRoom = new RandomCaveChestRoom(random, HauntedLootTables.DeepHauntedCavesChest,
                lootRotation, RegisterChestRoomSets.HauntedBiomeSet);
        chestRoom.replaceTile("stonefloor", "void_stone_floor");
        return chestRoom;
    }

    @Override
    public CaveRuins getNewCaveRuinsPreset(GameRandom random, AtomicInteger lootRotation) {
        FurnitureSet furnitureSet = FurnitureSet.dungeon;
        String floorStringID = "void_stone_floor";
        return ((CaveRuins.CaveRuinGetter) random.getOneOf(CaveRuins.caveRuinGetters))
                .get(random, RegisterWallSets.VoidWall, furnitureSet, floorStringID,
                        LootTablePresets.plainsCaveRuinsChest, lootRotation);
    }

    @Override
    public CaveRuins getNewDeepCaveRuinsPreset(GameRandom random, AtomicInteger lootRotation) {
        FurnitureSet furnitureSet = FurnitureSet.dungeon;
        String floorStringID = "void_stone_floor";
        return ((CaveRuins.CaveRuinGetter) random.getOneOf(CaveRuins.caveRuinGetters))
                .get(random, RegisterWallSets.VoidWall, furnitureSet, floorStringID,
                        LootTablePresets.plainsDeepCaveRuinsChest, lootRotation);
    }

    @Override
    public float getGenerationCaveRockObjectChance() {
        return 0.30F;
    }

    @Override
    public float getGenerationDeepCaveRockObjectChance() {
        return 0.32F;
    }
}