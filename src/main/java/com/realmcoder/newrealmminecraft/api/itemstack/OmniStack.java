package com.realmcoder.newrealmminecraft.api.itemstack;

import java.util.Comparator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import com.realmcoder.newrealmminecraft.helper.FluidHelper;
import com.realmcoder.newrealmminecraft.helper.ItemStackHelper;

/**
 * Created by RealmCoder on 8/5/14.
 * Contributors: Pahimar (looking for things that I never would have)
 */
public class OmniStack {
    
    private final Object stack;
    
    public static Comparator<OmniStack> comparator = new Comparator<OmniStack>()
    {

        /**
         * @param omniStack1, omniStack2
         * @return 0 --> Are Equal, Integer.MIN_VALUE --> incomparable on side of omniStack1, Integer.MIN_VALUE -->
         * incomparable on side of omniStack2, any other value shows the comparisons of the two stacks
         */
        @Override
        public int compare(OmniStack omniStack1, OmniStack omniStack2)
        {
            if(omniStack1.stack instanceof ItemStack)
            {
                if(omniStack2.stack instanceof ItemStack)
                {
                    return ItemStackHelper.comparator.compare((ItemStack)omniStack1.stack, (ItemStack)omniStack2.stack);
                }
                else
                {
                    return Integer.MAX_VALUE;
                }
            }
            else if(omniStack1.stack instanceof OreStack)
            {
                if(omniStack2.stack instanceof OreStack)
                {
                    return OreStack.comparator.compare((OreStack)omniStack1.stack, (OreStack)omniStack2.stack);
                }
                else if(omniStack2.stack instanceof ItemStack)
                {
                    return OreStack.comparator.compare((OreStack)omniStack1.stack, new OreStack((ItemStack)omniStack2.stack));
                }
                else
                {
                    return Integer.MAX_VALUE;
                }
            }
            else if(omniStack1.stack instanceof FluidStack)
            {
                if(omniStack2.stack instanceof FluidStack)
                {
                    return FluidHelper.comparator.compare((FluidStack)omniStack1.stack, (FluidStack)omniStack2.stack);
                }
                else
                {
                    return Integer.MAX_VALUE;
                }
            }
            return Integer.MIN_VALUE;
        }
    };
    
    private int stackSize;
    private int imposedLimit = -1;
    
    /**
     * Creates an empty stack
     */
    public OmniStack()
    {
        stackSize = 1;
        stack = null;
    }
    
    public OmniStack(OmniStack omniStack)
    {
        stackSize = omniStack.stackSize;
        stack = omniStack.stack;
    }
    
    public OmniStack(Object obj)
    {
        if(obj instanceof Item)
        {
            obj = new ItemStack((Item) obj);
        }
        if(obj instanceof Block)
        {
            obj = new ItemStack((Block) obj);
        }
        if(obj instanceof Fluid)
        {
            obj = new FluidStack((Fluid) obj, 1000);
        }
        if(obj instanceof List)
        {
            List<?> list = (List<?>)obj;
            
            obj = OreStack.getOreStackFromList(list);
        }
        
        if(obj instanceof ItemStack)
        {
            ItemStack itemStack = (ItemStack) obj;
            
            stackSize = itemStack.stackSize;
            itemStack.stackSize = 1;
            stack = itemStack;
        }
        else if(obj instanceof OreStack)
        {
            OreStack oreStack = (OreStack) obj;
            
            stackSize = oreStack.getStackSize();
            oreStack.setStackSize(1);
            stack = oreStack;
        }
        else if(obj instanceof FluidStack)
        {
            FluidStack fluidStack = ((FluidStack) obj).copy();
            
            stackSize = fluidStack.amount;
            fluidStack.amount = 1;
            stack = fluidStack;
        }
        else if(obj instanceof OmniStack)
        {
            OmniStack omniStack = (OmniStack) obj;
            
            if (omniStack.getOmniStack() != null)
            {
                this.stackSize = omniStack.stackSize;
                this.stack = omniStack.stack;
            }
            else
            {
                stackSize = -1;
                stack = null;
            }
        }
        else
        {
            stackSize = -1;
            stack = null;
        }
    }
    
    public OmniStack(Object obj, int amount)
    {
        if(obj instanceof Item)
        {
            obj = new ItemStack((Item) obj);
        }
        if(obj instanceof Block)
        {
            obj = new ItemStack((Block) obj);
        }
        if(obj instanceof Fluid)
        {
            obj = new FluidStack((Fluid) obj, 1000);
        }
        if(obj instanceof List)
        {
            List<?> list = (List<?>)obj;
            
            obj = OreStack.getOreStackFromList(list);
        }
        
        if(obj instanceof ItemStack)
        {
            ItemStack itemStack = ((ItemStack)obj).copy();
            
            stackSize = amount;
            itemStack.stackSize = 1;
            stack = itemStack;
        }
        else if(obj instanceof OreStack)
        {
            OreStack oreStack = ((OreStack) obj).copy();
            
            stackSize = amount;
            oreStack.setStackSize(1);
            stack = oreStack;
        }
        else if(obj instanceof FluidStack)
        {
            FluidStack fluidStack = ((FluidStack) obj).copy();
            
            stackSize = amount;
            fluidStack.amount = 1;
            stack = fluidStack;
        }
        else if(obj instanceof OmniStack)
        {
            OmniStack omniStack = (OmniStack) obj;
            
            if (omniStack.getOmniStack() != null)
            {
                this.stackSize = amount;
                this.stack = omniStack.stack;
            }
            else
            {
                stackSize = -1;
                stack = null;
            }
        }
        else
        {
            stackSize = -1;
            stack = null;
        }
    }

    public Object getOmniStack()
    {
        return stack;
    }
    
    public int getStackAmount()
    {
        return stackSize;
    }
    
    public void setStackAmount(int amount)
    {
        stackSize = amount;
    }

    public boolean equals(Object obj)
    {
        return obj instanceof OmniStack && this.compareTo((OmniStack)obj) == 0;
    }
    
    public boolean sameType(OmniStack omniStack)
    {
        if(omniStack.stack instanceof ItemStack && stack instanceof ItemStack)
            return ItemStackHelper.areItemStacksAreEqualIgnoreSize((ItemStack)omniStack.stack, (ItemStack)stack);
        if(omniStack.stack instanceof OreStack && stack instanceof OreStack)
            return ((OreStack)omniStack.stack).getName().equalsIgnoreCase(((OreStack)stack).getName());
        if(omniStack.stack instanceof FluidStack && stack instanceof FluidStack)
            return ((FluidStack)omniStack.stack).fluidID == ((FluidStack)stack).fluidID && ((FluidStack)omniStack.stack).tag.hashCode() == ((FluidStack)stack).tag.hashCode();
        return false;
    }
    
    public int compareTo(OmniStack input)
    {
        return comparator.compare(this, input);
    }
    
    public int hashcode()
    {
        int hashcode = stackSize;
        
        if(stack instanceof ItemStack)
        {
            hashcode += Item.getIdFromItem(((ItemStack)stack).getItem()) * 67;
            hashcode += ((ItemStack)stack).getItemDamage() * 69;
        }
        if(stack instanceof OreStack)
        {
            hashcode += ((OreStack)stack).getName().hashCode() * 83;
        }
        if(stack instanceof FluidStack)
        {
            hashcode += ((FluidStack)stack).hashCode() * 91;
        }
        
        return hashcode;
    }
    
    /**
     * Returns true if the given stack has been emptied
     * @param stack
     */
    public boolean combineStacks(OmniStack omniStack)
    {
        if(this.sameType(omniStack))
        {
            int stackLim = 64;
            if(imposedLimit == -1)
            {
                if(stack instanceof ItemStack)
                {
                    stackLim = ((ItemStack)stack).getMaxStackSize();
                }
                else if(stack instanceof FluidStack)
                {
                    stackLim = Integer.MAX_VALUE;
                }
            }
            else
            {
                stackLim = imposedLimit;
            }

            int transferAmount = Math.min(stackLim - stackSize, omniStack.stackSize);
            this.stackSize += transferAmount;
            omniStack.stackSize -= transferAmount;
        }
        return omniStack.isEmpty();
    }
    
    /**
     * Returns true if the given stack has been emptied
     * @param stack
     */
    public boolean combineStacks(OmniStack omniStack, int stackLim)
    {
        if(this.sameType(omniStack))
        {
            if(imposedLimit != -1)
            {
                stackLim = imposedLimit;
            }

            int transferAmount = Math.min(stackLim - stackSize, omniStack.stackSize);
            this.stackSize += transferAmount;
            omniStack.stackSize -= transferAmount;
        }
        return omniStack.isEmpty();
    }
    
    public boolean isEmpty()
    {
        return stackSize < 1;
    }
    
    public OmniStack clone()
    {
        return new OmniStack(this);
    }
    
}