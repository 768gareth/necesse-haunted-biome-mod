package HauntedBiome.Registry;

import HauntedBiome.Utils.Settlers.VoidCultistSettler;
import necesse.engine.registries.SettlerPersonalityRegistry;
import necesse.engine.registries.SettlerRegistry;
import necesse.level.maps.levelData.settlementData.settler.Settler;
import necesse.level.maps.levelData.settlementData.settler.personalities.FurnitureSetPreferenceSettlerPersonalityConstructor;
import necesse.level.maps.levelData.settlementData.settler.personalities.SettlerPersonalityConstructor;
import necesse.level.maps.levelData.settlementData.settler.personalities.SettlerPersonalityFilter;
import necesse.level.maps.levelData.settlementData.settler.personalities.SimplePersonalityFilter;
import necesse.level.maps.levelData.settlementData.settler.personalities.WallSetPreferenceSettlerPersonalityConstructor;

public class RegisterSettlers 
{
    public static void Register()
    {
        SettlerRegistry.registerSettler("void_cultist_settler", (Settler)new VoidCultistSettler());

        SettlerPersonalityRegistry.registerSettlerPersonality("haunted_architect", (SettlerPersonalityConstructor)new WallSetPreferenceSettlerPersonalityConstructor(RegisterWallSets.HauntedWall), (SettlerPersonalityFilter)new SimplePersonalityFilter(10), false); 
        SettlerPersonalityRegistry.registerSettlerPersonality("void_architect", (SettlerPersonalityConstructor)new WallSetPreferenceSettlerPersonalityConstructor(RegisterWallSets.VoidWall), (SettlerPersonalityFilter)new SimplePersonalityFilter(10), false); 
        SettlerPersonalityRegistry.registerSettlerPersonality("deep_void_architect", (SettlerPersonalityConstructor)new WallSetPreferenceSettlerPersonalityConstructor(RegisterWallSets.DeepVoidWall), (SettlerPersonalityFilter)new SimplePersonalityFilter(20), false);
        SettlerPersonalityRegistry.registerSettlerPersonality("haunted_enthusiast", (SettlerPersonalityConstructor)new FurnitureSetPreferenceSettlerPersonalityConstructor(RegisterFurnitureSets.hauntedFurnitureSet), (SettlerPersonalityFilter)new SimplePersonalityFilter(10), false); 
    }
}
