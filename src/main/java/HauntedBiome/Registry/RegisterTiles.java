package HauntedBiome.Registry;

import java.awt.Color;

import HauntedBiome.Tiles.HauntedGrassTile;
import HauntedBiome.Tiles.MudSandTile;
import HauntedBiome.Tiles.VoidGravelSpecialTile;
import HauntedBiome.Tiles.VoidRiftTile;
import HauntedBiome.Tiles.VoidRockTile;
import necesse.engine.registries.TileRegistry;
import necesse.level.gameTile.GameTile;
import necesse.level.gameTile.PathTiledTile;
import necesse.level.gameTile.SimpleFloorTile;
import necesse.level.gameTile.SimpleTiledFloorTile;

public class RegisterTiles 
{
    public static void Register()
    {
        TileRegistry.registerTile("haunted_grass_tile", (GameTile) new HauntedGrassTile(), 0.0F, true);
        TileRegistry.registerTile("void_rock_tile", (GameTile) new VoidRockTile(), 0, true);
        TileRegistry.registerTile("void_stone_floor", (GameTile) new SimpleFloorTile("void_stone_floor", new Color(45, 0, 68)), -1.0F, true);
        TileRegistry.registerTile("void_stone_path", new PathTiledTile("void_stone_path", new Color(72, 7, 99)), -1.0F, true);
        TileRegistry.registerTile("void_gravel_tile", (GameTile) new VoidGravelSpecialTile(), 0.0F, true);
        TileRegistry.registerTile("haunted_floor", (GameTile)new SimpleTiledFloorTile("haunted_floor", new Color(50, 53, 43)), -1.0F, true);
        TileRegistry.registerTile("mud_sand", (GameTile)new MudSandTile(), 0.0F, true);
        TileRegistry.registerTile("void_rift", (GameTile)new VoidRiftTile(), 1f, true);
        // TODO: TileRegistry.registerTile("pale_water", (GameTile)new WaterTile(), 20.0F, true);
    }
}
