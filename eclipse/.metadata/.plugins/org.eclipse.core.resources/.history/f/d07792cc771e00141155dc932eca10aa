package com.realmcoder.newrealmminecraft.recipe;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.realmcoder.newrealmminecraft.Item.crafting.RecipeGrinder;
import com.realmcoder.newrealmminecraft.Item.crafting.RecipeNRM;

import net.minecraft.item.ItemStack;


public abstract class RecipesNRM {
    
    protected List<RecipeNRM> recipes;
    
    public void addRecipe(RecipeGrinder recipe)
    {
        recipes.add(recipe);
    }
    
    public ItemStack getResult(ItemStack input)
    {
        
        for(RecipeNRM recipe : recipes)
        {
            if(recipe.isValidInput(input))
                return recipe.getOutput();
        }
        
        return null;
    }
    
    public RecipeNRM getRecipe(ItemStack input)
    {
        for(RecipeNRM recipe : recipes)
        {
            if(recipe.isValidInput(input))
                return recipe;
        }
        
        return null;
    }
    
    public List<RecipeNRM> getRecipes()
    {
        return ImmutableList.copyOf(recipes);
    }

    public boolean isValidInput(ItemStack itemStack)
    {
        for(RecipeNRM recipe : recipes)
        {
            if(recipe.isValidInput(itemStack))
            {
                return true;
            }
        }
        return false;
    }
    
    public abstract int getRecipeListID();
    
}
