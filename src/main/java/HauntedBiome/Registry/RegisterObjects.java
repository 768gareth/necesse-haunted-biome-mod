package HauntedBiome.Registry;

import java.awt.Color;

import HauntedBiome.Objects.HauntedGrassObject;
import HauntedBiome.Objects.VoidBrazierObject;
import HauntedBiome.Objects.VoidFragmentSampleObject;
import necesse.engine.registries.ObjectRegistry;
import static necesse.engine.registries.ObjectRegistry.getObject;
import necesse.inventory.item.Item;
import necesse.inventory.item.toolItem.ToolType;
import necesse.level.gameObject.ColumnObject;
import necesse.level.gameObject.CrystalClusterObject;
import necesse.level.gameObject.CrystalClusterSmallObject;
import necesse.level.gameObject.CustomWildFlowerObject;
import necesse.level.gameObject.FenceGateObject;
import necesse.level.gameObject.FenceObject;
import necesse.level.gameObject.FruitBushObject;
import necesse.level.gameObject.GameObject;
import necesse.level.gameObject.PaintingObject;
import necesse.level.gameObject.RockObject;
import necesse.level.gameObject.RockOreObject;
import necesse.level.gameObject.SingleRockObject;
import necesse.level.gameObject.SingleRockSmall;
import necesse.level.gameObject.TreeObject;
import necesse.level.gameObject.TreeSaplingObject;
import necesse.level.gameObject.WallFlameTrapObject;
import necesse.level.gameObject.WallObject;
import necesse.level.gameObject.furniture.CandelabraObject;
import necesse.level.gameObject.furniture.LogBenchObject;

public class RegisterObjects 
{
    public static void Register()
    {
        String[] FurnitureCategory = { "objects", "furniture", };
        String[] RocksCategory = new String[]{"objects", "landscaping"};
        String[] CrystalClusterCategory = new String[]{"objects", "landscaping", "crystals"};

        ObjectRegistry.registerObject("haunted_grass", (GameObject)new HauntedGrassObject(), 2.0F, false, false, true, new String[0]);
        ObjectRegistry.registerObject("haunted_tree", new TreeObject("haunted_tree", "haunted_log", "haunted_sapling", new Color(75, 65, 36), 32, 60, 120, "pineleaves"), 2.0F, false, false, true, new String[0]);
        ObjectRegistry.registerObject("haunted_sapling", (GameObject)new TreeSaplingObject("haunted_log", new Color(128, 128, 128), "haunted_tree", 1800, 2700, true), 5.0F, true);
        ObjectRegistry.registerObject("bloodberry_bush", (new FruitBushObject("bloodberry_bush", "bloodberry_sapling", 900.0F, 1800.0F, "bloodberry", 1.0F, 2, new Color(135, 1, 1))).setDebrisColor(new Color(46, 99, 39)), 2.0F, false, false, true);
        LogBenchObject.registerLogBench("haunted_log_bench", "haunted_log_bench", "haunted_log", ToolType.AXE, new Color(99, 52, 50), 8.0F);
        CustomWildFlowerObject CustomCaveglow = new CustomWildFlowerObject("wildcaveglow", 0, "caveglowsprout", 2, "caveglow", 4, new Color(85, 182, 91), new String[]{"void_rock_tile"});
        CustomCaveglow.lightLevel = 50;
        ObjectRegistry.registerObject("haunted_caveglow", CustomCaveglow, 2.0F, true);
        int HauntedHedgeFenceID = ObjectRegistry.registerObject("haunted_hedge", (GameObject)new FenceObject("haunted_hedge", new Color(74, 97, 69), 12, 10, -26), 2.0F, true);
        FenceGateObject.registerGatePair(HauntedHedgeFenceID, "haunted_hedge_gate", "haunted_hedge_gate", new Color(74, 97, 69), 12, 10, 4.0F);
        int HauntedFenceID = ObjectRegistry.registerObject("void_stone_fence", (GameObject)new FenceObject("void_stone_fence", new Color(38, 0, 66), 12, 10, -26), 2.0F, true);
        FenceGateObject.registerGatePair(HauntedFenceID, "void_stone_fence_gate", "void_stone_fence_gate", new Color(31, 0, 61), 12, 10, 4.0F);
        int[] WallIDs = WallObject.registerWallObjects("void_", "void_wall", 0.0F, new Color(36, 12, 44), -1.0F, -1.0F);
        WallObject VoidWall = (WallObject)getObject(WallIDs[0]);
        ObjectRegistry.registerObject("void_wall_flame_trap", new WallFlameTrapObject(VoidWall), 50.0F, true);
        ObjectRegistry.registerObject("void_column", (GameObject)new ColumnObject("void_column", new Color(111, 28, 128), ToolType.PICKAXE), 2.0F, true);
        ObjectRegistry.registerObject("painting_eye_of_the_void", (GameObject)new PaintingObject(Item.Rarity.UNCOMMON), 80.0F, true, false, new String[0]);
        ObjectRegistry.registerObject("void_fragment_sample", new VoidFragmentSampleObject(), 2.0F, true);
        CandelabraObject HauntedCandelabra = new CandelabraObject("haunted_candelabra", new Color(128, 128, 128), 270.0F, 0.4F, FurnitureCategory);
        HauntedCandelabra.flameHue = 255f;
        HauntedCandelabra.smokeHue = 245f;
        ObjectRegistry.registerObject("haunted_candelabra", (GameObject)HauntedCandelabra, 0.4F, true);
        ObjectRegistry.registerObject("void_brazier", new VoidBrazierObject(), 5f, true);

        
        ObjectRegistry.registerObject("void_fragment_cluster_small", new CrystalClusterSmallObject("void_fragment_cluster_small", new Color(97, 31, 127), 240.0F, "void_fragment", 0, 1, 1, CrystalClusterCategory), 5f, true);
        CrystalClusterObject.registerCrystalCluster("void_fragment_cluster_large", new Color(97, 31, 127), 247.0F, "void_fragment", 10.0F, true, CrystalClusterCategory);

        RockObject VoidRock;
        RockObject DeepVoidRock;
        ObjectRegistry.registerObject("void_rock", VoidRock = new RockObject("void_rock", new Color(50, 50, 150), "void_stone", RocksCategory), 2.0F, true);
        ObjectRegistry.registerObject("deep_void_rock", DeepVoidRock = new RockObject("deep_void_rock", new Color(50, 50, 150), "void_stone", RocksCategory), 2.0F, true);
        
        ObjectRegistry.registerObject("void_rock_small", new SingleRockSmall(VoidRock, "void_rock_small", new Color(70, 70, 152), RocksCategory), 2.0F, true);
        SingleRockObject.registerSurfaceRock(VoidRock, "void_rock_large", new Color(49, 142, 184), 2.0F, true, RocksCategory);

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
    }
}
