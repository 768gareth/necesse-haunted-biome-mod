package HauntedBiome.Registry;

import java.awt.Color;

import HauntedBiome.Objects.HauntedGrassObject;
import necesse.engine.registries.ObjectRegistry;
import static necesse.engine.registries.ObjectRegistry.getObject;
import necesse.inventory.item.toolItem.ToolType;
import necesse.level.gameObject.CustomWildFlowerObject;
import necesse.level.gameObject.FireChaliceObject;
import necesse.level.gameObject.GameObject;
import necesse.level.gameObject.RockObject;
import necesse.level.gameObject.RockOreObject;
import necesse.level.gameObject.SingleRockObject;
import necesse.level.gameObject.SingleRockSmall;
import necesse.level.gameObject.TreeObject;
import necesse.level.gameObject.TreeSaplingObject;
import necesse.level.gameObject.WallFlameTrapObject;
import necesse.level.gameObject.WallObject;
import necesse.level.gameObject.furniture.LogBenchObject;

public class RegisterObjects 
{
    public static void Register()
    {
        ObjectRegistry.registerObject("haunted_grass", (GameObject)new HauntedGrassObject(), 0.0F, false, false, true, new String[0]);
        ObjectRegistry.registerObject("haunted_tree", new TreeObject("haunted_tree", "haunted_log", "haunted_sapling", new Color(75, 65, 36), 32, 60, 120, "pineleaves"), 0.0F, false, false, true, new String[0]);
        ObjectRegistry.registerObject("haunted_sapling", (GameObject)new TreeSaplingObject("haunted_log", "haunted_tree", 1800, 2700, true), 5.0F, true);

        CustomWildFlowerObject CustomCaveglow = new CustomWildFlowerObject("wildcaveglow", 0, "caveglowsprout", "caveglow", 4, new Color(85, 182, 91), new String[]{"void_rock_tile"});
        CustomCaveglow.lightLevel = 50;
        ObjectRegistry.registerObject("haunted_caveglow", CustomCaveglow, 0.0F, true);
        
        int[] WallIDs = WallObject.registerWallObjects("void_", "void_wall", 0.0F, new Color(36, 12, 44), -1.0F, -1.0F);
        WallObject VoidWall = (WallObject)getObject(WallIDs[0]);
        ObjectRegistry.registerObject("void_wall_flame_trap", new WallFlameTrapObject(VoidWall), 50.0F, true);

        FireChaliceObject.registerFireChalice("void_chalice", "void_chalice", new Color(110, 81, 162), true, true, true);
        LogBenchObject.registerLogBench("haunted_log_bench", "haunted_log_bench", "haunted_log", ToolType.AXE, new Color(99, 52, 50), 8.0F);

        String[] genericRocksCategory = new String[]{"objects", "landscaping"};

        RockObject VoidRock;
        RockObject DeepVoidRock;
        ObjectRegistry.registerObject("void_rock", VoidRock = new RockObject("void_rock", new Color(50, 50, 150), "void_stone", genericRocksCategory), 0, true);
        ObjectRegistry.registerObject("deep_void_rock", DeepVoidRock = new RockObject("deep_void_rock", new Color(50, 50, 150), "void_stone", genericRocksCategory), 0, true);
        
        ObjectRegistry.registerObject("void_rock_small", new SingleRockSmall(VoidRock, "void_rock_small", new Color(70, 70, 152), genericRocksCategory), -1.0F, true);
        SingleRockObject.registerSurfaceRock(VoidRock, "void_rock_large", new Color(49, 142, 184), -1.0F, true, genericRocksCategory);

        ObjectRegistry.registerObject("iron_ore_void_rock", new RockOreObject(VoidRock, "oremask", "ironore", new Color(169, 128, 106), "ironore", genericRocksCategory), -1.0F, true);
        ObjectRegistry.registerObject("copper_ore_void_rock", new RockOreObject(VoidRock, "oremask", "copperore", new Color(161, 83, 42), "copperore", genericRocksCategory), -1.0F, true);
        ObjectRegistry.registerObject("gold_ore_void_rock", new RockOreObject(VoidRock, "oremask", "goldore", new Color(198, 145, 47), "goldore", genericRocksCategory), -1.0F, true);
        ObjectRegistry.registerObject("demonic_ore_void_rock", new RockOreObject(VoidRock, "oremask", "demonic_ore", new Color(88, 0, 108), "demonic_ore", genericRocksCategory), -1.0F, true);
       
        ObjectRegistry.registerObject("iron_ore_deep_void_rock", new RockOreObject(DeepVoidRock, "oremask", "ironore", new Color(169, 128, 106), "ironore", genericRocksCategory), -1.0F, true);
        ObjectRegistry.registerObject("copper_ore_deep_void_rock", new RockOreObject(DeepVoidRock, "oremask", "copperore", new Color(161, 83, 42), "copperore", genericRocksCategory), -1.0F, true);
        ObjectRegistry.registerObject("gold_ore_deep_void_rock", new RockOreObject(DeepVoidRock, "oremask", "goldore", new Color(198, 145, 47), "goldore", genericRocksCategory), -1.0F, true);
        ObjectRegistry.registerObject("tungsten_ore_deep_void_rock", new RockOreObject(DeepVoidRock, "oremask", "tungstenore", new Color(40, 49, 57), "tungstenore", genericRocksCategory), -1.0F, true);
        ObjectRegistry.registerObject("life_quartz_deep_void_rock", new RockOreObject(DeepVoidRock, "oremask", "lifequartzore", new Color(180, 50, 61), "lifequartz", 1, 1, 1, genericRocksCategory), -1.0F, true);
        ObjectRegistry.registerObject("demonic_ore_deep_void_rock", new RockOreObject(DeepVoidRock, "oremask", "demonic_ore", new Color(88, 0, 108), "demonic_ore", genericRocksCategory), -1.0F, true);
    }
}
