package HauntedBiome.Utils;

import necesse.gfx.forms.presets.PresetDebugPreviewForm;
import necesse.level.maps.presets.set.ChestRoomSet;
import necesse.level.maps.presets.set.ColumnSet;
import necesse.level.maps.presets.set.PresetSet;

public class RegisterChestRoomSets extends PresetSet<ChestRoomSet>
{
    public static ChestRoomSet HauntedBiomeSet = new ChestRoomSet("void_stone_floor", "dungeonpressureplate", RegisterWallSets.VoidWall, ColumnSet.obsidian, "storagebox", new String[]{"void_wall_flame_trap",});

    static
    {
        PresetDebugPreviewForm.registerPresetSet(RegisterChestRoomSets.class);
    }
}
