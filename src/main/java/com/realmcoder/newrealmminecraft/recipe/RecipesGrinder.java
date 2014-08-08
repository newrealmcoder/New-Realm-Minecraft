package com.realmcoder.newrealmminecraft.recipe;

import net.minecraft.item.ItemStack;

import com.realmcoder.newrealmminecraft.Item.crafting.RecipeGrinder;
import com.realmcoder.newrealmminecraft.api.itemstack.OmniStack;


public class RecipesGrinder extends RecipesNRM{
    
    private static RecipesGrinder grinderRegistry = null;
    
    public static RecipesGrinder getInstance()
    {
        if(grinderRegistry == null)
        {
            grinderRegistry = new RecipesGrinder();
        }
        
        return grinderRegistry;
    }
    
    public void addRecipe(ItemStack output, int highAmountPossible, OmniStack input)
    {
        recipes.add(new RecipeGrinder(output, highAmountPossible, input));
    }
    
    public void addRecipe(ItemStack output, int highAmountPossible, ItemStack input)
    {
        recipes.add(new RecipeGrinder(output, highAmountPossible, input));
    }

    @Override
    public int getRecipeListID()
    {
        return RecipeRegistry.GRINDSTONE_RECIPES_ID;
    }
}
