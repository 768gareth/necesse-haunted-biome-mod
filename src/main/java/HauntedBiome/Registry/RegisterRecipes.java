package HauntedBiome.Registry;

import necesse.engine.registries.RecipeTechRegistry;
import necesse.inventory.recipe.Ingredient;
import necesse.inventory.recipe.Recipe;
import necesse.inventory.recipe.Recipes;

public class RegisterRecipes 
{
    public static void Register()
    {
        // Weapons
        Recipes.registerModRecipe(new Recipe("soul_eater", 1, RecipeTechRegistry.TUNGSTEN_ANVIL, new Ingredient[] {new Ingredient("nightmare_bar", 14), new Ingredient("void_crystal", 4)}));
        Recipes.registerModRecipe(new Recipe("cursed_fire", 1, RecipeTechRegistry.TUNGSTEN_ANVIL, new Ingredient[] {new Ingredient("void_crystal", 16), new Ingredient("book", 1)}));
        Recipes.registerModRecipe(new Recipe("nightmare_bow", 1, RecipeTechRegistry.TUNGSTEN_ANVIL, new Ingredient[] {new Ingredient("nightmare_bar", 14), new Ingredient("void_crystal", 4)}));

        // Armour
        Recipes.registerModRecipe(new Recipe("void_sentinel_helmet", 1, RecipeTechRegistry.TUNGSTEN_ANVIL, new Ingredient[] {new Ingredient("nightmare_bar", 12), new Ingredient("void_crystal", 6)}));
        Recipes.registerModRecipe(new Recipe("void_sentinel_chestplate", 1, RecipeTechRegistry.TUNGSTEN_ANVIL, new Ingredient[] {new Ingredient("nightmare_bar", 18), new Ingredient("void_crystal", 4)}));
        Recipes.registerModRecipe(new Recipe("void_sentinel_boots", 1, RecipeTechRegistry.TUNGSTEN_ANVIL, new Ingredient[] {new Ingredient("nightmare_bar", 12), new Ingredient("void_crystal", 4)}));

        Recipes.registerModRecipe(new Recipe("ancient_void_cult_hood", 1, RecipeTechRegistry.TUNGSTEN_ANVIL, new Ingredient[] {new Ingredient("void_cult_hood", 1), new Ingredient("void_crystal", 18)}));
        Recipes.registerModRecipe(new Recipe("ancient_void_cult_robe", 1, RecipeTechRegistry.TUNGSTEN_ANVIL, new Ingredient[] {new Ingredient("void_cult_robe", 1), new Ingredient("void_crystal", 22)}));
        Recipes.registerModRecipe(new Recipe("ancient_void_cult_boots", 1, RecipeTechRegistry.TUNGSTEN_ANVIL, new Ingredient[] {new Ingredient("void_cult_boots", 1), new Ingredient("void_crystal", 16)}));

        // Tools
        Recipes.registerModRecipe(new Recipe("nightmare_pickaxe", 1, RecipeTechRegistry.TUNGSTEN_ANVIL, new Ingredient[] {new Ingredient("nightmare_bar", 16)}));
        Recipes.registerModRecipe(new Recipe("nightmare_axe", 1, RecipeTechRegistry.TUNGSTEN_ANVIL, new Ingredient[] {new Ingredient("nightmare_bar", 16)}));
        Recipes.registerModRecipe(new Recipe("nightmare_shovel", 1, RecipeTechRegistry.TUNGSTEN_ANVIL, new Ingredient[] {new Ingredient("nightmare_bar", 16)}));

        // Crafting Materials
        Recipes.registerModRecipe(new Recipe("demonic_ore", 3, RecipeTechRegistry.FORGE, new Ingredient[] { new Ingredient("demonicbar", 1)}));
        Recipes.registerModRecipe(new Recipe("nightmare_ore", 4, RecipeTechRegistry.FORGE, new Ingredient[] { new Ingredient("nightmare_bar", 1)}));
        Recipes.registerModRecipe(new Recipe("voidshard", 1, RecipeTechRegistry.FORGE, new Ingredient[] { new Ingredient("void_fragment", 4)}));

        // Consumables
        Recipes.registerModRecipe(new Recipe("bloodberry_jam", 1, RecipeTechRegistry.COOKING_POT, new Ingredient[] { new Ingredient("bloodberry", 2), new Ingredient("sugar", 1)}));
        Recipes.registerModRecipe(new Recipe("bloodberry_cake", 1, RecipeTechRegistry.COOKING_POT, new Ingredient[] { new Ingredient("bloodberry", 2), new Ingredient("sugar", 2), new Ingredient("milk", 2), new Ingredient("egg", 1)}));
        Recipes.registerModRecipe(new Recipe("bloodberry_sundae", 1, RecipeTechRegistry.COOKING_POT, new Ingredient[] { new Ingredient("bloodberry", 3), new Ingredient("milk", 2), new Ingredient("sugar", 2), new Ingredient("bloodberry_jam", 1)}));
        
        // Trinkets
        Recipes.registerModRecipe(new Recipe("ruinstone", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("void_fragment", 12), new Ingredient("demonicbar", 4)}));
        Recipes.registerModRecipe(new Recipe("void_vessel", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION, new Ingredient[] { new Ingredient("ruinstone", 1), new Ingredient("nightmare_bar", 8)}));

        // Tiles
        Recipes.registerModRecipe(new Recipe("void_rock_tile", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("void_stone", 1)}));
        Recipes.registerModRecipe(new Recipe("void_stone_floor", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("void_stone", 1)}));
        Recipes.registerModRecipe(new Recipe("void_stone_path", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("void_stone", 1)}));
        Recipes.registerModRecipe(new Recipe("void_gravel_tile", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("void_stone", 1)}));
    
        // Objects
        Recipes.registerModRecipe(new Recipe("void_wall", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("void_stone", 2)}));
        Recipes.registerModRecipe(new Recipe("void_door", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("void_stone", 2)}));
        Recipes.registerModRecipe(new Recipe("void_column", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("void_stone", 4)}));

        Recipes.registerModRecipe(new Recipe("void_wall_flame_trap", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("void_stone", 4), new Ingredient("firemone", 5), new Ingredient("wire", 5)}));

        Recipes.registerModRecipe(new Recipe("haunted_grass", 4, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("haunted_grass_seed", 1)}));
        Recipes.registerModRecipe(new Recipe("haunted_log_bench", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("haunted_log", 1)}));
        Recipes.registerModRecipe(new Recipe("void_fragment_cluster_small", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("void_fragment", 4)}));
        Recipes.registerModRecipe(new Recipe("void_fragment_cluster_large", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("void_fragment", 8)}));

        Recipes.registerModRecipe(new Recipe("haunted_hedge", 3, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("haunted_log", 1)}));
        Recipes.registerModRecipe(new Recipe("haunted_hedge_gate", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("haunted_log", 1)}));

        Recipes.registerModRecipe(new Recipe("void_rock", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("void_stone", 1)}));
        Recipes.registerModRecipe(new Recipe("iron_ore_void_rock", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("void_stone", 1), new Ingredient("ironore", 1)}));
        Recipes.registerModRecipe(new Recipe("copper_ore_void_rock", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("void_stone", 1), new Ingredient("copperore", 1)}));
        Recipes.registerModRecipe(new Recipe("gold_ore_void_rock", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("void_stone", 1), new Ingredient("goldore", 1)}));
        Recipes.registerModRecipe(new Recipe("demonic_ore_void_rock", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("void_stone", 1), new Ingredient("demonic_ore", 1)}));

        Recipes.registerModRecipe(new Recipe("deep_void_rock", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("void_stone", 1)}));
        Recipes.registerModRecipe(new Recipe("iron_ore_deep_void_rock", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("void_stone", 1), new Ingredient("ironore", 1)}));
        Recipes.registerModRecipe(new Recipe("copper_ore_deep_void_rock", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("void_stone", 1), new Ingredient("copperore", 1)}));
        Recipes.registerModRecipe(new Recipe("gold_ore_deep_void_rock", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("void_stone", 1), new Ingredient("goldore", 1)}));
        Recipes.registerModRecipe(new Recipe("tungsten_ore_deep_void_rock", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("void_stone", 1), new Ingredient("tungstenore", 1)}));
        Recipes.registerModRecipe(new Recipe("life_quartz_deep_void_rock", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("void_stone", 1), new Ingredient("lifequartz", 1)}));
        Recipes.registerModRecipe(new Recipe("demonic_ore_deep_void_rock", 1, RecipeTechRegistry.TUNGSTEN_LANDSCAPING, new Ingredient[] { new Ingredient("void_stone", 1), new Ingredient("demonicore", 1)}));
    }
}
