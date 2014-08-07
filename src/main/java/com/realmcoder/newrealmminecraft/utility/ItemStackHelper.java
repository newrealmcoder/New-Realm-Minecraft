package com.realmcoder.newrealmminecraft.utility;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;


public class ItemStackHelper {
    
    /**
     * Checks all ItemStack components besides stackSize
     * @param itemStack1
     * @param itemStack2
     * @return
     */
    public static boolean areItemStacksEqualish(ItemStack itemStack1, ItemStack itemStack2)
    {
        if(itemStack1 != null)
        {
            if(itemStack2 != null)
            {
                if(itemStack1.getItem().getIdFromItem(itemStack1.getItem()) == itemStack2.getItem().getIdFromItem(itemStack2.getItem()))
                {
                    if (itemStack1.getItemDamage() == itemStack2.getItemDamage() || itemStack1.getItemDamage() == OreDictionary.WILDCARD_VALUE || itemStack2.getItemDamage() == OreDictionary.WILDCARD_VALUE)
                    {
                        if (itemStack1.hasTagCompound() && itemStack2.hasTagCompound())
                        {
                            if (itemStack1.getTagCompound().hashCode() == itemStack2.getTagCompound().hashCode())
                            {
                                return true;
                            }
                        }
                        else if (!itemStack1.hasTagCompound() && !itemStack2.hasTagCompound())
                        {
                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    /**
     * Checks for ItemStack size as well as all other ItemStack components
     * @param itemStack1
     * @param itemStack2
     * @return
     */
    public static boolean areItemStacksExactlyEqual(ItemStack itemStack1, ItemStack itemStack2)
    {
        if(itemStack1 != null)
        {
            if(itemStack2 != null)
            {
                if(itemStack1.getItem().getIdFromItem(itemStack1.getItem()) == itemStack2.getItem().getIdFromItem(itemStack2.getItem()))
                {
                    if (itemStack1.getItemDamage() == itemStack2.getItemDamage() || itemStack1.getItemDamage() == OreDictionary.WILDCARD_VALUE || itemStack2.getItemDamage() == OreDictionary.WILDCARD_VALUE)
                    {
                        if (itemStack1.hasTagCompound() && itemStack2.hasTagCompound())
                        {
                            if (itemStack1.getTagCompound().hashCode() == itemStack2.getTagCompound().hashCode())
                            {
                                return itemStack2.stackSize >= itemStack1.stackSize;
                            }
                        }
                        else if (!itemStack1.hasTagCompound() && !itemStack2.hasTagCompound())
                        {
                            return itemStack2.stackSize >= itemStack1.stackSize;
                        }
                    }
                }
            }
        }
        
        return false;
    }
}
