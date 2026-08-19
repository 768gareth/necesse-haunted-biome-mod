package HauntedBiome.Registry;

import necesse.gfx.forms.presets.PresetDebugPreviewForm;
import necesse.level.maps.presets.set.FurnitureSet;
import necesse.level.maps.presets.set.PresetSet;

public class RegisterFurnitureSets extends PresetSet<FurnitureSet>
{
    public static FurnitureSet hauntedFurnitureSet = (new FurnitureSet("haunted_"));

    static 
    {
        PresetDebugPreviewForm.registerPresetSet(RegisterFurnitureSets.class);
    }
}
