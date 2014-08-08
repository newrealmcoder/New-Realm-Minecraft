package com.realmcoder.newrealmminecraft.Item.crafting;

import net.minecraft.item.ItemStack;

import com.realmcoder.newrealmminecraft.api.itemstack.OmniStack;
import com.realmcoder.newrealmminecraft.api.itemstack.OreStack;


public interface RecipeNRM {
    
    public ItemStack getOutput();
    
    public boolean isValidInput(ItemStack itemStack);
    public boolean isValidInput(OmniStack omniStack);
    public boolean isOneOfValidInputs(OmniStack omniStack);
    
}
