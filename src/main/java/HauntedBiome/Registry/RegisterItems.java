package HauntedBiome.Registry;

import HauntedBiome.Items.Armour.AncientVoidCultBootsItem;
import HauntedBiome.Items.Armour.AncientVoidCultHoodItem;
import HauntedBiome.Items.Armour.AncientVoidCultRobeItem;
import HauntedBiome.Items.Armour.VoidSentinelBootsItem;
import HauntedBiome.Items.Armour.VoidSentinelChestplateItem;
import HauntedBiome.Items.Armour.VoidSentinelHelmetItem;
import HauntedBiome.Items.Cosmetic.VoidCultBootsItem;
import HauntedBiome.Items.Cosmetic.VoidCultHoodItem;
import HauntedBiome.Items.Cosmetic.VoidCultRobeItem;
import HauntedBiome.Items.Trinkets.RuinstoneItem;
import HauntedBiome.Items.Trinkets.VoidVesselItem;
import HauntedBiome.Items.Weapons.CursedFireMagicItem;
import HauntedBiome.Items.Weapons.NightmareBowItem;
import HauntedBiome.Items.Weapons.SoulEaterSwordItem;
import necesse.engine.localization.Localization;
import necesse.engine.modifiers.ModifierValue;
import necesse.engine.registries.ItemRegistry;
import necesse.engine.util.GameBlackboard;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.Item;
import necesse.inventory.item.Item.Rarity;
import necesse.inventory.item.matItem.FishItem;
import necesse.inventory.item.matItem.MatItem;
import necesse.inventory.item.placeableItem.StonePlaceableItem;
import necesse.inventory.item.placeableItem.consumableItem.food.FoodConsumableItem;
import necesse.inventory.item.placeableItem.consumableItem.potionConsumableItem.SimplePotionItem;
import necesse.inventory.item.placeableItem.tileItem.GrassSeedItem;
import necesse.inventory.item.toolItem.axeToolItem.CustomAxeToolItem;
import necesse.inventory.item.toolItem.pickaxeToolItem.CustomPickaxeToolItem;
import necesse.inventory.item.toolItem.shovelToolItem.CustomShovelToolItem;
import necesse.inventory.item.trinketItem.SimpleTrinketItem;
import necesse.inventory.lootTable.LootTablePresets;
import necesse.inventory.lootTable.presets.ToolsLootTable;
import necesse.level.maps.levelData.settlementData.settler.Settler;

public class RegisterItems 
{
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void Register()
    {
        // Weapons
        ItemRegistry.registerItem("soul_eater", new SoulEaterSwordItem(), 150f, true);
        ItemRegistry.registerItem("cursed_fire", new CursedFireMagicItem(), 150f, true);
        ItemRegistry.registerItem("nightmare_bow", new NightmareBowItem(), 150f, true);

        // Tools
        ItemRegistry.registerItem("nightmare_pickaxe", new CustomPickaxeToolItem(400, 200, 7.0F, 30, 50, 50, 900, ToolsLootTable.tools, Item.Rarity.UNCOMMON) 
        {
          public ListGameTooltips getPreEnchantmentTooltips(InventoryItem item, PlayerMob perspective, GameBlackboard blackboard) {
            ListGameTooltips tooltips = super.getPreEnchantmentTooltips(item, perspective, blackboard);
            tooltips.add(Localization.translate("itemtooltip", "nightmare_pickaxe_tooltip"), 350);
            return tooltips;
          }
        }, 160f, true);
        ItemRegistry.registerItem("nightmare_axe", (Item)new CustomAxeToolItem(400, 200, 7.0F, 24, 50, 50, 1100, ToolsLootTable.tools, Item.Rarity.UNCOMMON), 160.0F, true);
        ItemRegistry.registerItem("nightmare_shovel", (Item)new CustomShovelToolItem(400, 200, 7.0F, 24, 50, 50, 1100, Item.Rarity.UNCOMMON), 160.0F, true);

        // Armour
        ItemRegistry.registerItem("void_sentinel_helmet", new VoidSentinelHelmetItem(), 100f, true);
        ItemRegistry.registerItem("void_sentinel_chestplate", new VoidSentinelChestplateItem(), 150f, true);
        ItemRegistry.registerItem("void_sentinel_boots", new VoidSentinelBootsItem(), 100f, true);

        ItemRegistry.registerItem("ancient_void_cult_hood", new AncientVoidCultHoodItem(), 100f, true);
        ItemRegistry.registerItem("ancient_void_cult_robe", new AncientVoidCultRobeItem(), 125f, true);
        ItemRegistry.registerItem("ancient_void_cult_boots", new AncientVoidCultBootsItem(), 100f, true);

        // Cosmetics
        ItemRegistry.registerItem("void_cult_hood", new VoidCultHoodItem(), 10f, true);
        ItemRegistry.registerItem("void_cult_robe", new VoidCultRobeItem(), 10f, true);
        ItemRegistry.registerItem("void_cult_boots", new VoidCultBootsItem(), 10f, true);

        // Consumables
        ItemRegistry.registerItem("corruption_potion", new SimplePotionItem(99, Item.Rarity.UNCOMMON, "corruption_potion_buff", 300, "corruption_potion_tooltip"), 20f, true);
        ItemRegistry.registerItem("bloodberry", (new FoodConsumableItem(250, Rarity.NORMAL, Settler.FOOD_SIMPLE, 10, 240, new ModifierValue[]{new ModifierValue(BuffModifiers.MANA_USAGE, -0.05f)})).spoilDuration(480).addGlobalIngredient(new String[]{"anycompostable", "anyfruit"}).setItemCategory(new String[]{"consumable", "rawfood"}), 4.0F, true);
        ItemRegistry.registerItem("bloodberry_jam", (new FoodConsumableItem(250, Rarity.UNCOMMON, Settler.FOOD_FINE, 15, 240, new ModifierValue[]{new ModifierValue(BuffModifiers.MANA_USAGE, -0.10f)})).spoilDuration(360).addGlobalIngredient(new String[]{"anycompostable"}).setItemCategory(new String[]{"consumable"}), 8.0F, true);
        ItemRegistry.registerItem("bloodberry_sundae", (new FoodConsumableItem(250, Rarity.RARE, Settler.FOOD_GOURMET, 25, 600, new ModifierValue[]{new ModifierValue(BuffModifiers.MANA_USAGE, -0.25f)})).spoilDuration(240).addGlobalIngredient(new String[]{"anycompostable"}).setItemCategory(new String[]{"consumable"}), 10.0F, true);
        ItemRegistry.registerItem("bloodberry_cake", (new FoodConsumableItem(250, Rarity.RARE, Settler.FOOD_GOURMET, 25, 480, new ModifierValue[]{new ModifierValue(BuffModifiers.MAX_MANA_FLAT, 50), new ModifierValue(BuffModifiers.MAGIC_CRIT_CHANCE, 0.10f)})).spoilDuration(240).addGlobalIngredient(new String[]{"anycompostable"}).setItemCategory(new String[]{"consumable"}), 10.0F, true);

        // Trinkets
        ItemRegistry.registerItem("amulet_of_corruption", new SimpleTrinketItem(Item.Rarity.RARE, "amulet_of_corruption_buff", 300, LootTablePresets.trinkets), 100f, true);
        ItemRegistry.registerItem("ruinstone", new RuinstoneItem(), 250f, true);
        ItemRegistry.registerItem("void_vessel", new VoidVesselItem(), 300f, true);

        // Crafting Materials
        ItemRegistry.registerItem("demonic_ore", (new MatItem(500, Item.Rarity.COMMON, "demonic_ore_tooltip")).setItemCategory(new String[] { "materials", "ore" }), 4.0F, true);
        ItemRegistry.registerItem("void_fragment", (new MatItem(500, Rarity.UNCOMMON, "void_fragment_tooltip")).setItemCategory(new String[]{"materials", "mobdrops"}), 10.0F, true);
        ItemRegistry.registerItem("nightmare_ore", (new MatItem(500, Item.Rarity.UNCOMMON, "nightmare_ore_tooltip")).setItemCategory(new String[] { "materials", "ore" }), 6.0F, true);
        ItemRegistry.registerItem("nightmare_bar", (new MatItem(500, Item.Rarity.UNCOMMON, "nightmare_bar_tooltip")).setItemCategory(new String[] { "materials" }), 12.0F, true);
        ItemRegistry.registerItem("void_stone", new StonePlaceableItem(999), 0.1F, true);
        ItemRegistry.registerItem("deep_void_stone", new StonePlaceableItem(999), 0.1F, true);
        ItemRegistry.registerItem("haunted_log", (new MatItem(500, new String[] { "anylog" })).setItemCategory(new String[] { "materials", "logs" }), 2.0F, true);
        ItemRegistry.registerItem("demonfish", (new FishItem(250, Rarity.UNCOMMON, new String[0])).setItemCategory(new String[]{"materials", "specialfish"}), 18.0F, true);
        
        // Miscellaneous
        ItemRegistry.registerItem("haunted_grass_seed", new GrassSeedItem("haunted_grass_tile"), 2.0F, true);
    }
}
