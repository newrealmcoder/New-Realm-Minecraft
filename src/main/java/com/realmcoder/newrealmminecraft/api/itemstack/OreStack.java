package com.realmcoder.newrealmminecraft.api.itemstack;

import java.util.Comparator;
import java.util.List;

import com.realmcoder.newrealmminecraft.helper.ItemStackHelper;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by RealmCoder on 8/5/14.
 * Contributors:
 */
public class OreStack implements Comparable<OreStack>{
    
    private String oreName;
    private int stackSize;
    
    public static Comparator<OreStack> comparator = new Comparator<OreStack>()
    {
        @Override
        public int compare(OreStack oreStack1, OreStack oreStack2)
        {
            
            if(oreStack1 != null)
            {
                if(oreStack2 != null)
                {
                    if(oreStack1.oreName != null && oreStack2.oreName != null)
                    {
                        if(oreStack1.oreName.equalsIgnoreCase(oreStack2.oreName))
                        {
                            return oreStack1.stackSize - oreStack2.stackSize;
                        }
                        else
                        {
                            return oreStack1.oreName.compareToIgnoreCase(oreStack2.oreName);
                        }
                    }
                    else
                    {
                        return Integer.MIN_VALUE;
                    }
                }
                else
                {
                    return Integer.MIN_VALUE;
                }
            }
            else
            {
                if(oreStack2 != null)
                {
                    return Integer.MAX_VALUE;
                }
                else
                {
                    return Integer.MIN_VALUE;
                }
            }
        }
    };
    
    public OreStack(String oreName)
    {
        this.oreName = oreName;
        this.stackSize = 1;
    }
    
    public OreStack(String oreName, int stackSize)
    {
        this.oreName = oreName;
        this.stackSize = stackSize;
    }

    public OreStack(ItemStack itemStack)
    {
        if(itemStack != null && OreDictionary.getOreIDs(itemStack).length > 0)
        {
            oreName = OreDictionary.getOreName(OreDictionary.getOreIDs(itemStack)[0]);
            this.stackSize = itemStack.stackSize;
        }
        else
        {
            oreName = null;
            this.stackSize = -1;
        }
    }
    
    public String getName()
    {
        return oreName;
    }
    
    public int getStackSize()
    {
        return stackSize;
    }
    
    public boolean doesItemNameMatch(ItemStack itemStack)
    {
        if(itemStack == null)
            return false;
        
        for(int oreID : OreDictionary.getOreIDs(itemStack))
        {
            if(OreDictionary.getOreName(oreID).equalsIgnoreCase(oreName))
                return true;
        }
        
        return false;
    }
    
    @Override
    public int compareTo(OreStack o)
    {
        return comparator.compare(this, o);
    }

    public void setStackSize(int i)
    {
        this.stackSize = i;
    }
    
    public static OreStack getOreStackFromList(List<?> objectList)
    {
        for (Object listElement : objectList)
        {
            if (listElement instanceof ItemStack)
            {
                ItemStack stack = (ItemStack) listElement;

                if (OreDictionary.getOreIDs(stack).length > 0)
                {
                    return new OreStack(stack);
                }
            }
        }

        return null;
    }

    public OreStack copy()
    {
        return new OreStack(oreName, stackSize);
    }
}
