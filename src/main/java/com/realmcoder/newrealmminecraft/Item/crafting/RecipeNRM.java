package com.realmcoder.newrealmminecraft.Item.crafting;

import net.minecraft.item.ItemStack;

import com.realmcoder.newrealmminecraft.utility.OreStack;


public interface RecipeNRM {
    
    public ItemStack getOutput();
    
    public boolean isValidInput(ItemStack itemStack);
    public boolean isValidInput(OreStack oreStack);
    public boolean isOneOfValidInputs(OreStack oreStack);
    
}