package HauntedBiome.Utils;

import necesse.gfx.forms.presets.PresetDebugPreviewForm;
import necesse.level.maps.presets.set.PresetSet;
import necesse.level.maps.presets.set.WallSet;

public class RegisterWallSets extends PresetSet<WallSet>
{
    public static final WallSet VoidWall = new WallSet("void_");

    static
    {
        PresetDebugPreviewForm.registerPresetSet(RegisterWallSets.class);
    }
}
