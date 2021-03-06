package com.realmcoder.newrealmminecraft.Item.crafting;

import net.minecraft.item.ItemStack;

import com.realmcoder.newrealmminecraft.api.itemstack.OmniStack;
import com.realmcoder.newrealmminecraft.api.itemstack.OreStack;
import com.realmcoder.newrealmminecraft.helper.ItemStackHelper;


public class RecipeGrinder implements RecipeNRM{
    
    private ItemStack output;
    private int amountToOutputAtFullEfficiency;
    private OmniStack input;
    
    public RecipeGrinder(ItemStack output, int amountToOutputAtFullEfficiency, OmniStack input)
    {
        this.output = output;
        this.output.stackSize = 1;
        this.amountToOutputAtFullEfficiency = amountToOutputAtFullEfficiency;
        this.input = input;
    }
    
    public RecipeGrinder(ItemStack output, int amountToOutputAtFullEfficiency, ItemStack input)
    {
        this(output, amountToOutputAtFullEfficiency, new OmniStack(input));
    }
    
    public ItemStack getOutput()
    {
        return output;
    }
    
    public int getAmountToOutput(double percentage)
    {
        return (int) (percentage * (double) amountToOutputAtFullEfficiency);
    }
    
    public int getAmountToOutput(int percentage)
    {
        return (int) (((double)(percentage * amountToOutputAtFullEfficiency))/100D);
    }
    
    public boolean isValidInput(ItemStack input)
    {
        return this.input.equals(new OmniStack(input));
    }
    
    public boolean isValidInput(OmniStack omniStack)
    {
        return this.input.equals(omniStack);
    }
    
    private boolean matches(RecipeGrinder recipe)
    {
        return recipe.amountToOutputAtFullEfficiency == this.amountToOutputAtFullEfficiency && ItemStackHelper.areItemStacksAreEqualIgnoreSize(recipe.output, this.output) && this.isValidInput(recipe.input);
    }
    
    public boolean equals(Object obj)
    {
        if(obj instanceof RecipeGrinder)
        {
            return matches((RecipeGrinder)obj);
        }
        
        return false;
    }

    @Override
    public boolean isOneOfValidInputs(OmniStack omniStack)
    {
        return isValidInput(omniStack);
    }
    
}
