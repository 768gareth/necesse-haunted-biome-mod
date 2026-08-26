package HauntedBiome.Registry;

import java.awt.Color;

import HauntedBiome.Objects.AncientVoidStatueObject;
import HauntedBiome.Objects.HauntedGrassObject;
import HauntedBiome.Objects.LightingTableDecorationObject;
import HauntedBiome.Objects.VoidAltarObject;
import HauntedBiome.Objects.VoidBrazierObject;
import HauntedBiome.Objects.VoidFragmentSampleObject;
import HauntedBiome.Objects.VoidGrassObject;
import HauntedBiome.Objects.VoidMonolithObject;
import necesse.engine.registries.ObjectRegistry;
import static necesse.engine.registries.ObjectRegistry.getObject;
import static necesse.engine.registries.ObjectRegistry.registerObject;
import necesse.inventory.item.Item;
import necesse.inventory.item.toolItem.ToolType;
import necesse.level.gameObject.ColumnObject;
import necesse.level.gameObject.CrystalClusterObject;
import necesse.level.gameObject.CrystalClusterSmallObject;
import necesse.level.gameObject.DoubleStreetlampObject;
import necesse.level.gameObject.FenceGateObject;
import necesse.level.gameObject.FenceObject;
import necesse.level.gameObject.FruitBushObject;
import necesse.level.gameObject.GameObject;
import necesse.level.gameObject.LargePaintingObject;
import necesse.level.gameObject.ModularCarpetObject;
import necesse.level.gameObject.PaintingObject;
import necesse.level.gameObject.RandomVaseObject;
import necesse.level.gameObject.RockObject;
import necesse.level.gameObject.RockOreObject;
import necesse.level.gameObject.SingleRockObject;
import necesse.level.gameObject.SingleRockSmall;
import necesse.level.gameObject.StreetlampObject;
import necesse.level.gameObject.TableDecorationObject;
import necesse.level.gameObject.TorchObject;
import necesse.level.gameObject.TreeObject;
import necesse.level.gameObject.TreeSaplingObject;
import necesse.level.gameObject.WallArrowTrapObject;
import necesse.level.gameObject.WallCandleObject;
import necesse.level.gameObject.WallFlameTrapObject;
import necesse.level.gameObject.WallObject;
import necesse.level.gameObject.container.BookshelfObject;
import necesse.level.gameObject.container.CabinetObject;
import necesse.level.gameObject.container.DisplayStandObject;
import necesse.level.gameObject.furniture.BathtubObject;
import necesse.level.gameObject.furniture.BedObject;
import necesse.level.gameObject.furniture.BenchObject;
import necesse.level.gameObject.furniture.CandelabraObject;
import necesse.level.gameObject.furniture.CandlesObject;
import necesse.level.gameObject.furniture.ChairObject;
import necesse.level.gameObject.furniture.ClockObject;
import necesse.level.gameObject.furniture.DeskObject;
import necesse.level.gameObject.furniture.DinnerTableObject;
import necesse.level.gameObject.furniture.DresserObject;
import necesse.level.gameObject.furniture.LogBenchObject;
import necesse.level.gameObject.furniture.ModularTableObject;
import necesse.level.gameObject.furniture.ToiletObject;
import necesse.level.gameObject.furniture.doubleBed.DoubleBedBaseObject;

public class RegisterObjects 
{
    public static void Register()
    {
        // Categories
        String[] FurnitureCategory = { "objects", "furniture", };
        String[] RocksCategory = new String[]{"objects", "landscaping"};
        String[] CrystalClusterCategory = new String[]{"objects", "landscaping", "crystals"};
        String[] potsCategory = { "objects", "decorations", "pots" };
        Color HauntedColour = new Color(111, 28, 128);

        // Rocks and Ores
        RockObject VoidRock;
        RockObject DeepVoidRock;
        ObjectRegistry.registerObject("void_rock", VoidRock = new RockObject("void_rock", new Color(50, 50, 150), "void_stone", RocksCategory), 2.0F, true);
        ObjectRegistry.registerObject("deep_void_rock", DeepVoidRock = new RockObject("deep_void_rock", new Color(50, 50, 150), "deep_void_stone", RocksCategory), 2.0F, true);
        
        ObjectRegistry.registerObject("void_rock_small", new SingleRockSmall(VoidRock, "void_rock_small", new Color(70, 70, 152), RocksCategory), 2.0F, true);
        SingleRockObject.registerSurfaceRock(VoidRock, "void_rock_large", new Color(49, 142, 184), 2.0F, true, RocksCategory);
        ObjectRegistry.registerObject("deep_void_rock_small", new SingleRockSmall(DeepVoidRock, "deep_void_rock_small", new Color(70, 70, 152), RocksCategory), 2.0F, true);
        SingleRockObject.registerSurfaceRock(DeepVoidRock, "deep_void_rock_large", new Color(49, 142, 184), 2.0F, true, RocksCategory);

        ObjectRegistry.registerObject("iron_ore_void_rock", new RockOreObject(VoidRock, "oremask", "ironore", new Color(169, 128, 106), "ironore", RocksCategory), 2.0F, true);
        ObjectRegistry.registerObject("copper_ore_void_rock", new RockOreObject(VoidRock, "oremask", "copperore", new Color(161, 83, 42), "copperore", RocksCategory), 2.0F, true);
        ObjectRegistry.registerObject("gold_ore_void_rock", new RockOreObject(VoidRock, "oremask", "goldore", new Color(198, 145, 47), "goldore", RocksCategory), 2.0F, true);
        ObjectRegistry.registerObject("demonic_ore_void_rock", new RockOreObject(VoidRock, "oremask", "demonic_ore", new Color(88, 0, 108), "demonic_ore", RocksCategory), 2.0F, true);
       
        ObjectRegistry.registerObject("iron_ore_deep_void_rock", new RockOreObject(DeepVoidRock, "oremask", "ironore", new Color(169, 128, 106), "ironore", RocksCategory), 2.0F, true);
        ObjectRegistry.registerObject("copper_ore_deep_void_rock", new RockOreObject(DeepVoidRock, "oremask", "copperore", new Color(161, 83, 42), "copperore", RocksCategory), 2.0F, true);
        ObjectRegistry.registerObject("gold_ore_deep_void_rock", new RockOreObject(DeepVoidRock, "oremask", "goldore", new Color(198, 145, 47), "goldore", RocksCategory), 2.0F, true);
        ObjectRegistry.registerObject("tungsten_ore_deep_void_rock", new RockOreObject(DeepVoidRock, "oremask", "tungstenore", new Color(40, 49, 57), "tungstenore", RocksCategory), 2.0F, true);
        ObjectRegistry.registerObject("life_quartz_deep_void_rock", new RockOreObject(DeepVoidRock, "oremask", "lifequartzore", new Color(180, 50, 61), "lifequartz", 1, 1, 1, RocksCategory), 2.0F, true);
        ObjectRegistry.registerObject("demonic_ore_deep_void_rock", new RockOreObject(DeepVoidRock, "oremask", "demonic_ore", new Color(88, 0, 108), "demonic_ore", RocksCategory), 2.0F, true);
        ObjectRegistry.registerObject("nightmare_ore_deep_void_rock", new RockOreObject(DeepVoidRock, "oremask", "nightmare_ore", new Color(88, 0, 108), "nightmare_ore", RocksCategory), 2.0F, true);

        // Crystals
        ObjectRegistry.registerObject("void_fragment_cluster_small", new CrystalClusterSmallObject("void_fragment_cluster_small", new Color(97, 31, 127), 260.0F, "void_fragment", 0, 1, 1, CrystalClusterCategory), 10f, true);
        CrystalClusterObject.registerCrystalCluster("void_fragment_cluster_large", new Color(97, 31, 127), 260.0F, "void_fragment", 10.0F, true, CrystalClusterCategory);
        ObjectRegistry.registerObject("void_crystal_cluster_small", new CrystalClusterSmallObject("void_crystal_cluster_small", new Color(90, 30, 120), 230.0F, "void_crystal", 0, 1, 1, CrystalClusterCategory), 10f, true);
        CrystalClusterObject.registerCrystalCluster("void_crystal_cluster_large", new Color(90, 30, 120), 230.0F, "void_crystal", 10.0F, true, CrystalClusterCategory);

        // Nature
        ObjectRegistry.registerObject("haunted_grass", (GameObject)new HauntedGrassObject(), 2.0F, false, false, true, new String[0]);
        ObjectRegistry.registerObject("haunted_tree", new TreeObject("haunted_tree", "haunted_log", "haunted_sapling", new Color(75, 65, 36), 32, 60, 120, "pineleaves"), 2.0F, false, false, true, new String[0]);
        ObjectRegistry.registerObject("haunted_sapling", (GameObject)new TreeSaplingObject("haunted_log", new Color(128, 128, 128), "haunted_tree", 1800, 2700, true), 5.0F, true);
        ObjectRegistry.registerObject("bloodberry_bush", (new FruitBushObject("bloodberry_bush", "bloodberry_sapling", 900.0F, 1800.0F, "bloodberry", 1.0F, 2, new Color(135, 1, 1))).setDebrisColor(new Color(46, 99, 39)), 2.0F, false, false, true);
        LogBenchObject.registerLogBench("haunted_log_bench", "haunted_log_bench", "haunted_log", ToolType.ALL, new Color(99, 52, 50), 8.0F);
        ObjectRegistry.registerObject("void_grass", new VoidGrassObject(), 1f, true);
        
        // Walls, Doors, and Traps
        int[] VoidWallIDs = WallObject.registerWallObjects("void_", "void_wall", 0.0F, new Color(36, 12, 44), -1.0F, -1.0F);
        WallObject VoidWall = (WallObject)getObject(VoidWallIDs[0]);
        ObjectRegistry.registerObject("void_wall_flame_trap", new WallFlameTrapObject(VoidWall), 50.0F, true);
        ObjectRegistry.registerObject("void_wall_arrow_trap", new WallArrowTrapObject(VoidWall), 50.0F, true);

        int[] HauntedWallIDs = WallObject.registerWallObjects("haunted_", "haunted_wall", 0.0F, HauntedColour, -1.0F, -1.0F);
        WallObject HauntedWall = (WallObject)getObject(HauntedWallIDs[0]);
        ObjectRegistry.registerObject("haunted_wall_arrow_trap", new WallArrowTrapObject(HauntedWall), 50.0F, true);

        int[] DeepVoidWallIDs = WallObject.registerWallObjects("deep_void_", "deep_void_wall", 0.0F, new Color(36, 12, 44), -1.0F, -1.0F);
        WallObject DeepVoidWall = (WallObject)getObject(DeepVoidWallIDs[0]);
        ObjectRegistry.registerObject("deep_void_wall_flame_trap", new WallFlameTrapObject(DeepVoidWall), 50.0F, true);
        ObjectRegistry.registerObject("deep_void_wall_arrow_trap", new WallArrowTrapObject(DeepVoidWall), 50.0F, true);

        // Fences
        int HauntedHedgeFenceID = ObjectRegistry.registerObject("haunted_hedge", (GameObject)new FenceObject("haunted_hedge", new Color(74, 97, 69), 12, 10, -26), 2.0F, true);
        FenceGateObject.registerGatePair(HauntedHedgeFenceID, "haunted_hedge_gate", "haunted_hedge_gate", new Color(74, 97, 69), 12, 10, 4.0F);
        int HauntedFenceID = ObjectRegistry.registerObject("void_stone_fence", (GameObject)new FenceObject("void_stone_fence", new Color(38, 0, 66), 12, 10, -26), 2.0F, true);
        FenceGateObject.registerGatePair(HauntedFenceID, "void_stone_fence_gate", "void_stone_fence_gate", new Color(31, 0, 61), 12, 10, 4.0F);

        // Lighting
        ObjectRegistry.registerObject("void_candle", (new TorchObject("void_candle", ToolType.ALL, new Color(255, 255, 152), 245f, 0.6F, true, 4)).setWallPlaceObjectStringID("void_wall_candle"), 5.0F, true);
        ObjectRegistry.registerObject("void_wall_candle", (new WallCandleObject()).setItemDroppedStringID("void_candle"), 5.0F, false);
        ObjectRegistry.registerObject("demonic_street_lamp", new StreetlampObject(), 25f, true);
        DoubleStreetlampObject.registerDoubleStreetlamp("demonic_double_street_lamp", "demonic_double_street_lamp", ToolType.ALL, new Color(128, 128, 128), 50.0F);
        CandlesObject VoidCandles = new CandlesObject("void_candle_set", HauntedColour, 20.0F, 0.4F);
        VoidCandles.flameHue = 275f;
        VoidCandles.smokeHue = 250f;
        VoidCandles.lightHue = 250f;
        VoidCandles.lightSat = 0.7f;
        registerObject("void_candle_set", (GameObject)VoidCandles, 10.0F, true);
        CandelabraObject HauntedCandelabra = new CandelabraObject("haunted_candelabra", new Color(128, 128, 128), 270.0F, 0.4F, FurnitureCategory);
        HauntedCandelabra.flameHue = 255f;
        HauntedCandelabra.smokeHue = 245f;
        ObjectRegistry.registerObject("haunted_candelabra", (GameObject)HauntedCandelabra, 0.4F, true);
        ObjectRegistry.registerObject("void_brazier", new VoidBrazierObject(), 5f, true);

        // Furniture
        BedObject.registerBed("haunted_bed", "haunted_bed", HauntedColour, 50.0F, FurnitureCategory);
        DoubleBedBaseObject.registerDoubleBed("haunted_double_bed", "haunted_double_bed", HauntedColour, 100.0F, FurnitureCategory);
        ObjectRegistry.registerObject("haunted_modular_table", new ModularTableObject("haunted_modular_table", HauntedColour, FurnitureCategory), 10.0F, true);
        ObjectRegistry.registerObject("haunted_modular_counter", new ModularTableObject("haunted_modular_counter", HauntedColour, FurnitureCategory), 10.0F, true);
        ObjectRegistry.registerObject("haunted_chair", new ChairObject("haunted_chair", HauntedColour, FurnitureCategory), 5.0F, true);
        BenchObject.registerBench("haunted_bench", "haunted_bench", HauntedColour, 10.0F, FurnitureCategory);
        ObjectRegistry.registerObject("haunted_bookshelf", (GameObject)new BookshelfObject("haunted_bookshelf", HauntedColour, FurnitureCategory), 10.0F, true);
        ObjectRegistry.registerObject("haunted_cabinet", (GameObject)new CabinetObject("haunted_cabinet", HauntedColour, FurnitureCategory), 10.0F, true);
        ObjectRegistry.registerObject("haunted_display", (GameObject)new DisplayStandObject("haunted_display", HauntedColour, 20, FurnitureCategory), 10.0F, true);
        ObjectRegistry.registerObject("haunted_desk", new DeskObject("haunted_desk", HauntedColour, FurnitureCategory), 10f, true);
        ObjectRegistry.registerObject("haunted_clock", new ClockObject("haunted_clock", HauntedColour, FurnitureCategory), 10f, true);
        ObjectRegistry.registerObject("haunted_dresser", new DresserObject("haunted_dresser", HauntedColour, FurnitureCategory), 10f, true);
        ObjectRegistry.registerObject("void_column", (GameObject)new ColumnObject("void_column", new Color(111, 28, 128), ToolType.PICKAXE), 2.0F, true);
        BathtubObject.registerBathtub("haunted_bathtub", "haunted_bathtub", HauntedColour, 10.0F, FurnitureCategory);
        ObjectRegistry.registerObject("haunted_toilet", (GameObject)new ToiletObject("haunted_toilet", HauntedColour, FurnitureCategory), 5.0F, true);
        DinnerTableObject.registerDinnerTable("haunted_dinner_table", "haunted_dinner_table", HauntedColour, 10.0f, FurnitureCategory);

        // Decorations
        ObjectRegistry.registerObject("occult_carpet", (GameObject)new ModularCarpetObject("occult_carpet", new Color(78, 30, 122)), 25.0F, true);
        LargePaintingObject.registerLargePainting("visions_of_the_void_painting", Item.Rarity.RARE, 200.0F, true, false);
        ObjectRegistry.registerObject("corruption_painting", (GameObject)new PaintingObject(Item.Rarity.UNCOMMON), 80.0F, true, false, new String[0]);

        // Table Decorations
        ObjectRegistry.registerObject("occult_books_1", (GameObject)new TableDecorationObject("occult_books_1", new Color(50, 50, 50), 14, 14, 0, 2), 5.0F, true);
        ObjectRegistry.registerObject("occult_books_2", (GameObject)new TableDecorationObject("occult_books_2", new Color(50, 50, 50), 14, 14, 0, 2), 5.0F, true);
        ObjectRegistry.registerObject("haunted_flower_1", (new TableDecorationObject("haunted_flower_1", new Color(52, 110, 152), 14, 12)).setItemCategory(potsCategory).setCraftingCategory(potsCategory), 20.0F, true);
        ObjectRegistry.registerObject("cursed_skull", new LightingTableDecorationObject("cursed_skull", HauntedColour, 12, 16, 60, 275, 1.0f), 5.0f, true);
        ObjectRegistry.registerObject("void_fragment_sample", new VoidFragmentSampleObject(), 2.0F, true);
        ObjectRegistry.registerObject("occult_flask", new LightingTableDecorationObject("occult_flask", HauntedColour, 12, 16, 50, 255, 1.0f), 5.0f, true);

        // Misc
        ObjectRegistry.registerObject("void_vase", new RandomVaseObject("void_vase"), 5f, true);
        ObjectRegistry.registerObject("void_altar_display", new VoidAltarObject(FurnitureCategory), 100f, true);
        VoidMonolithObject.registerAncientPillar("void_monolith", true);
        AncientVoidStatueObject.registerAncientVoidStatue("ancient_void_statue", true);
    }
}