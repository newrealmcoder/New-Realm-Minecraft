package com.realmcoder.newrealmminecraft.recipe;

import java.util.ArrayList;


public class RecipeRegistry {
    
    private static RecipesNRM[] recipeLists;
    
    public static final int GRINDSTONE_RECIPES_ID = 0;
    public static final int MAX_CUR_RECIPE_ID     = 0;
    
    public static void init()
    {
        recipeLists = new RecipesNRM[MAX_CUR_RECIPE_ID+1];
        
        recipeLists[GRINDSTONE_RECIPES_ID] = RecipesGrinder.getInstance();
    }
    
    public static RecipesNRM getRecipeListUnderID(int id)
    {
        return recipeLists[id];
    }
    
}
