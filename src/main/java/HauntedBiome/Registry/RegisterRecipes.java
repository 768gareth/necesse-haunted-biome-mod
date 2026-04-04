package HauntedBiome.Registry;

import necesse.engine.registries.RecipeTechRegistry;
import necesse.inventory.recipe.Ingredient;
import necesse.inventory.recipe.Recipe;
import necesse.inventory.recipe.Recipes;

public class RegisterRecipes 
{
    public static void Register()
    {
        // Crafting Materials
        Recipes.registerModRecipe(new Recipe("demonic_ore", 3, RecipeTechRegistry.FORGE, new Ingredient[] { new Ingredient("demonicbar", 1)}));
        Recipes.registerModRecipe(new Recipe("voidshard", 1, RecipeTechRegistry.FORGE, new Ingredient[] { new Ingredient("void_fragment", 6)}));

        // Consumables
        Recipes.registerModRecipe(new Recipe("bloodberry_pudding", 1, RecipeTechRegistry.COOKING_POT, new Ingredient[] { new Ingredient("bloodberry", 4), new Ingredient("sugar", 3), new Ingredient("milk", 2), new Ingredient("lemon", 1)}));
        
        // Trinkets
        Recipes.registerModRecipe(new Recipe("ruinstone", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("demonicbar", 4), new Ingredient("void_fragment", 8)}));

        // Tiles
        Recipes.registerModRecipe(new Recipe("void_rock_tile", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("void_stone", 2)}));
        Recipes.registerModRecipe(new Recipe("void_stone_floor", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("void_stone", 2)}));
        Recipes.registerModRecipe(new Recipe("void_stone_path", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("void_stone", 2)}));
        Recipes.registerModRecipe(new Recipe("void_gravel_tile", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("void_stone", 3)}));
    
        // Objects
        Recipes.registerModRecipe(new Recipe("void_wall", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("void_stone", 2)}));
        Recipes.registerModRecipe(new Recipe("void_door", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("void_stone", 2)}));
        Recipes.registerModRecipe(new Recipe("void_column", 1, RecipeTechRegistry.DEMONIC_WORKSTATION, new Ingredient[] { new Ingredient("void_stone", 4)}));

        Recipes.registerModRecipe(new Recipe("void_wall_flame_trap", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("void_stone", 4), new Ingredient("firemone", 5), new Ingredient("wire", 5)}));

        Recipes.registerModRecipe(new Recipe("haunted_grass", 4, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("haunted_grass_seed", 1)}));
        Recipes.registerModRecipe(new Recipe("haunted_log_bench", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("haunted_log", 1)}));
        Recipes.registerModRecipe(new Recipe("void_fragment_cluster_small", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("void_fragment", 4)}));
        Recipes.registerModRecipe(new Recipe("void_fragment_cluster_large", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("void_fragment", 8)}));

        Recipes.registerModRecipe(new Recipe("haunted_hedge", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("haunted_sapling", 1)}));
        Recipes.registerModRecipe(new Recipe("haunted_hedge_gate", 1, RecipeTechRegistry.LANDSCAPING, new Ingredient[] { new Ingredient("haunted_sapling", 1), new Ingredient("haunted_log", 2)}));

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
