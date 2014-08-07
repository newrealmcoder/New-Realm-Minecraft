package com.realmcoder.newrealmminecraft.inventory;

import com.realmcoder.newrealmminecraft.recipe.RecipeRegistry;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;


public class SlotRecipeAffiliated extends Slot {

    private int recipeType;
    
    public SlotRecipeAffiliated(IInventory inventory, int slotIndex, int x, int y, int recipeType)
    {
        super(inventory, slotIndex, x ,y);
        this.recipeType = recipeType;
    }
    
    @Override
    public boolean isItemValid(ItemStack itemStack)
    {
        return RecipeRegistry.getRecipeListUnderID(recipeType).isValidInput(itemStack);
    }
    
}
