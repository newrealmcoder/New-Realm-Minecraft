package com.realmcoder.newrealmminecraft.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.realmcoder.newrealmminecraft.recipe.RecipeRegistry;

/**
 * Created by RealmCoder on 8/5/14.
 * Contributors:
 */
public class SlotGearSlot extends Slot{
    
    public SlotGearSlot(IInventory inventory, int slotIndex, int x, int y, int recipeType)
    {
        super(inventory, slotIndex, x ,y);
    }
    
    @Override
    public boolean isItemValid(ItemStack itemStack)
    {
        
        return false;
    }
    
}
