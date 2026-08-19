package HauntedBiome.Registry;

import necesse.gfx.forms.presets.PresetDebugPreviewForm;
import necesse.level.maps.presets.set.PresetSet;
import necesse.level.maps.presets.set.WallSet;

public class RegisterWallSets extends PresetSet<WallSet>
{
    public static final WallSet HauntedWall = new WallSet("haunted_");
    public static final WallSet VoidWall = new WallSet("void_");
    public static final WallSet DeepVoidWall = new WallSet("deep_void_");

    static
    {
        PresetDebugPreviewForm.registerPresetSet(RegisterWallSets.class);
    }
}
