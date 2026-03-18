package HauntedBiome.Registry;

import HauntedBiome.Items.RuinstoneItem;
import necesse.engine.modifiers.ModifierValue;
import necesse.engine.registries.ItemRegistry;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.inventory.item.Item;
import necesse.inventory.item.Item.Rarity;
import necesse.inventory.item.matItem.FishItem;
import necesse.inventory.item.matItem.MatItem;
import necesse.inventory.item.placeableItem.StonePlaceableItem;
import necesse.inventory.item.placeableItem.consumableItem.food.FoodConsumableItem;
import necesse.inventory.item.placeableItem.tileItem.GrassSeedItem;
import necesse.level.maps.levelData.settlementData.settler.Settler;

public class RegisterItems 
{
    public static void Register()
    {
        // Trinkets
        ItemRegistry.registerItem("ruinstone", new RuinstoneItem(), 200f, true);

        // Crafting Materials
        ItemRegistry.registerItem("demonic_ore", (new MatItem(500, Item.Rarity.COMMON, new String[0])).setItemCategory(new String[] { "materials", "ore" }), 4.0F, true);
        ItemRegistry.registerItem("void_fragment", (new MatItem(500, Rarity.UNCOMMON, new String[0])).setItemCategory(new String[]{"materials", "mobdrops"}), 10.0F, true);
        ItemRegistry.registerItem("void_stone", new StonePlaceableItem(999), 0.1F, true);
        ItemRegistry.registerItem("haunted_log", (new MatItem(500, new String[] { "anylog" })).setItemCategory(new String[] { "materials", "logs" }), 2.0F, true);
        ItemRegistry.registerItem("demonfish", (new FishItem(250, Rarity.UNCOMMON, new String[0])).setItemCategory(new String[]{"materials", "specialfish"}), 18.0F, true);
        ItemRegistry.registerItem("bloodberry", (new FoodConsumableItem(250, Rarity.NORMAL, Settler.FOOD_SIMPLE, 10, 240, new ModifierValue[]{new ModifierValue(BuffModifiers.MANA_USAGE, 0.05f)})).spoilDuration(480).addGlobalIngredient(new String[]{"anycompostable", "anyfruit"}).setItemCategory(new String[]{"consumable", "rawfood"}), 4.0F, true);
        
        // Miscellaneous
        ItemRegistry.registerItem("haunted_grass_seed", new GrassSeedItem("haunted_grass_tile"), 2.0F, true);
    }
}
