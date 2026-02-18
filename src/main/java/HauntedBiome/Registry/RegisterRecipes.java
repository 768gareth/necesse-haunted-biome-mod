package HauntedBiome.Registry;

import necesse.engine.registries.RecipeTechRegistry;
import necesse.inventory.recipe.Ingredient;
import necesse.inventory.recipe.Recipe;
import necesse.inventory.recipe.Recipes;

public class RegisterRecipes 
{
    public static void Register()
    {
        Recipes.registerModRecipe(new Recipe("demonic_ore", 3, RecipeTechRegistry.FORGE, new Ingredient[] { new Ingredient("demonicbar", 1)}));
    }
}
