package HauntedBiome.Registry;

import HauntedBiome.World.VoidGravelRegionPreset;
import necesse.engine.registries.WorldPresetRegistry;

public class RegisterWorldPresets 
{
    // TODO: Evil's Protector Arena, Dungeon Entrance, Demonic Shrine
    public static void Register()
    {
        WorldPresetRegistry.registerPreset("void_gravel_region", new VoidGravelRegionPreset());
    }
}
